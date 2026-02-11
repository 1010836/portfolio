# AWS Terraform Migration: The Iterative Guide (LocalStack Edition)

**Target Audience:** AI Software Engineer
**Goal:** Port Azure Infrastructure to AWS Terraform
**Environment:** LocalStack (Local Mocking)

---

## 0. Prerequisites & Setup
Before writing code, we must configure Terraform to talk to your local machine instead of real AWS.

### 0.1 Install Tools
1.  **Docker:** Required to run LocalStack.
2.  **LocalStack:** `pip install localstack` then `localstack start -d`
3.  **Terraform:** Installed on your machine.
4.  **AWS CLI:** `pip install awscli-local` (provides `awslocal` command).

### 0.2 The Provider Configuration (`provider.tf`)
*Create this file first. It tells Terraform to use localhost.*

```hcl
terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.0"
    }
  }
}

provider "aws" {
  region                      = "us-east-1"
  access_key                  = "test"
  secret_key                  = "test"
  skip_credentials_validation = true
  skip_metadata_api_check     = true
  skip_requesting_account_id  = true

  # Redirects all AWS calls to LocalStack container
  endpoints {
    ec2             = "http://localhost:4566"
    eks             = "http://localhost:4566"
    elasticache     = "http://localhost:4566"
    iam             = "http://localhost:4566"
    secretsmanager  = "http://localhost:4566"
    sts             = "http://localhost:4566"
  }
}
```

---

## Step 1: The Network Foundation
*We cannot build servers without a network. This step mimics your Azure VNet setup.*

### 1.1 Terraform Code (`network.tf`)
```hcl
# 1. The VPC (Virtual Network)
resource "aws_vpc" "main" {
  cidr_block           = "10.0.0.0/16"
  enable_dns_hostnames = true
  tags = { Name = "pulseos-vpc" }
}

# 2. Public Subnet (For NAT Gateway / Load Balancer)
resource "aws_subnet" "public" {
  vpc_id                  = aws_vpc.main.id
  cidr_block              = "10.0.1.0/24"
  map_public_ip_on_launch = true
  availability_zone       = "us-east-1a"
  tags = { Name = "pulseos-public-subnet" }
}

# 3. Private Subnet (For Workers & Redis)
resource "aws_subnet" "private" {
  vpc_id            = aws_vpc.main.id
  cidr_block        = "10.0.2.0/24"
  availability_zone = "us-east-1a"
  tags = { Name = "pulseos-private-subnet" }
}

# 4. Internet Gateway (To let the Public Subnet talk to the web)
resource "aws_internet_gateway" "gw" {
  vpc_id = aws_vpc.main.id
}
```

### 1.2 Explanation
* **VPC:** The equivalent of `azurerm_virtual_network`.
* **Subnets:** We explicitly separate Public (Ingress) from Private (Workloads).
* **Internet Gateway:** Azure creates this implicitly; AWS requires you to create it explicitly.

### 1.3 Execution
Run these commands in your terminal:
```bash
terraform init
terraform plan -out=step1.tfplan
terraform apply "step1.tfplan"
```

### 1.4 Verification (Test)
Run this command to check if LocalStack created the network:
```bash
awslocal ec2 describe-vpcs --filters "Name=tag:Name,Values=pulseos-vpc"
# Success if: You see a JSON output with "State": "available"
```

---

## Step 2: Security & Identity
*Before Compute or Data, we need permissions. This replaces Azure Managed Identities.*

### 2.1 Terraform Code (`security.tf`)
```hcl
# 1. IAM Role for EKS Cluster (Control Plane)
resource "aws_iam_role" "eks_cluster_role" {
  name = "pulseos-eks-cluster-role"

  assume_role_policy = jsonencode({
    Version = "2012-10-17"
    Statement = [{
      Action = "sts:AssumeRole"
      Effect = "Allow"
      Principal = { Service = "eks.amazonaws.com" }
    }]
  })
}

# 2. Attach Policies to Cluster Role
resource "aws_iam_role_policy_attachment" "eks_cluster_policy" {
  policy_arn = "arn:aws:iam::aws:policy/AmazonEKSClusterPolicy"
  role       = aws_iam_role.eks_cluster_role.name
}

# 3. Secrets Manager (Replaces Azure KeyVault)
resource "aws_secretsmanager_secret" "api_secrets" {
  name = "pulseos/worker/secrets"
}

resource "aws_secretsmanager_secret_version" "api_secrets_val" {
  secret_id     = aws_secretsmanager_secret.api_secrets.id
  secret_string = jsonencode({
    "BROKER_PASSWORD" = "fake-password-for-local"
  })
}
```

### 2.2 Explanation
* **IAM Roles:** AWS uses Roles instead of User Assigned Identities. The EKS service needs permission to manage resources on your behalf.
* **Secrets Manager:** Stores the sensitive config. We create a placeholder secret here.

### 2.3 Execution
```bash
terraform plan -out=step2.tfplan
terraform apply "step2.tfplan"
```

### 2.4 Verification (Test)
```bash
awslocal iam get-role --role-name pulseos-eks-cluster-role
awslocal secretsmanager list-secrets
# Success if: You see the Role ARN and the Secret Metadata.
```

---

## Step 3: Data Layer (Redis)
*Now we deploy the broker for your Celery workers.*

### 3.1 Terraform Code (`data.tf`)
```hcl
# 1. Security Group for Redis (Firewall)
resource "aws_security_group" "redis_sg" {
  name        = "pulseos-redis-sg"
  description = "Allow inbound Redis traffic"
  vpc_id      = aws_vpc.main.id

  ingress {
    from_port   = 6379
    to_port     = 6379
    protocol    = "tcp"
    cidr_blocks = ["10.0.0.0/16"] # Allow internal VPC traffic
  }
}

# 2. Redis Subnet Group
resource "aws_elasticache_subnet_group" "main" {
  name       = "pulseos-redis-subnet-group"
  subnet_ids = [aws_subnet.private.id]
}

# 3. The Redis Cluster
resource "aws_elasticache_cluster" "redis" {
  cluster_id           = "pulseos-redis"
  engine               = "redis"
  node_type            = "cache.t3.micro"
  num_cache_nodes      = 1
  parameter_group_name = "default.redis7"
  port                 = 6379
  subnet_group_name    = aws_elasticache_subnet_group.main.name
  security_group_ids   = [aws_security_group.redis_sg.id]
}
```

### 3.2 Explanation
* **Security Group:** Acts like an Azure NSG (Network Security Group). We strictly allow port 6379.
* **ElastiCache:** The AWS Managed Redis service.

### 3.3 Execution & Verification
```bash
terraform apply -auto-approve
awslocal elasticache describe-cache-clusters --cache-cluster-id pulseos-redis
# Success if: "CacheClusterStatus": "available" (or "creating")
```

---

## Step 4: Compute (EKS Cluster)
*The final piece: The Kubernetes Cluster.*

### 4.1 Terraform Code (`compute.tf`)
```hcl
resource "aws_eks_cluster" "main" {
  name     = "pulseos-cluster"
  role_arn = aws_iam_role.eks_cluster_role.arn

  vpc_config {
    subnet_ids = [aws_subnet.public.id, aws_subnet.private.id]
  }

  depends_on = [
    aws_iam_role_policy_attachment.eks_cluster_policy
  ]
}

# Node Group (The Workers)
resource "aws_eks_node_group" "workers" {
  cluster_name    = aws_eks_cluster.main.name
  node_group_name = "worker-group-1"
  node_role_arn   = aws_iam_role.eks_cluster_role.arn # Note: Usually requires a separate Node Role
  subnet_ids      = [aws_subnet.private.id]

  scaling_config {
    desired_size = 2
    max_size     = 3
    min_size     = 1
  }
}
```

### 4.2 Explanation
* **aws_eks_cluster:** Creates the control plane.
* **aws_eks_node_group:** Creates the EC2 instances that will run your Pods.

### 4.3 Execution & Verification
```bash
terraform apply -auto-approve
awslocal eks describe-cluster --name pulseos-cluster
# Success if: You receive a JSON description of the cluster.
# Note: In LocalStack Community, this verifies the API call succeeded, but pods won't actually schedule.
```

---

## 5. Documentation Sources
* [Terraform AWS Provider](https://registry.terraform.io/providers/hashicorp/aws/latest/docs)
* [LocalStack Documentation](https://docs.localstack.cloud/)
* [AWS CLI Reference](https://docs.aws.amazon.com/cli/latest/reference/)
