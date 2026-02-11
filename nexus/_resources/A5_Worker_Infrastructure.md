# Worker Infrastructure Deep Dive
**Project:** PulseOS Worker Deployment
**Generated for:** AI Software Engineer
**Context:** Understanding the Terraform <-> Helm Relationship

---

## 1. Introduction: The Builder and The Mover
Since you are new to Terraform, think of your deployment in two parts:

1.  **Terraform (The Builder):** It builds the house. It constructs the Azure resources (Databases, Node Pools, Identities) and sets up the security system (RBAC roles).
2.  **Helm (The Mover):** It moves the furniture (your Application Containers) into the house.

**The most important concept:**
Your Helm chart is almost empty of credentials. It doesn't have passwords for Redis or Cosmos. Instead, it relies on **Identity**. Terraform creates an Identity, gives it permission, and Helm simply says "I am using that Identity."

---

## 2. Component Deep Dive

### Compute (AKS Node Pool)

#### 2.1 The Concept
Terraform creates the physical "servers" (VMs). Helm tells your app which server to sit on.

#### 2.2 Terraform Configuration (The Builder)
**File:** `aks_variables.tf`
**What it does:** Creates the resource and assigns permissions.

```hcl
    workers = {
      name    = "workers" # The Pool Name
      vm_size = "Standard_E4s_v5" 
      # ...
      priority = "Regular" # or "Spot"
    }
```
[Read Official Documentation](https://learn.microsoft.com/en-us/azure/aks/use-system-pools?tabs=azure-cli)

#### 2.3 The Helm Connection (The Bridge)
**Mechanism:** Label Matching
Terraform creates a node pool named "workers". AKS automatically labels these nodes with `kubernetes.azure.com/agentpool: workers`. Your Helm chart targets this exact label.

**Relevant Helm Snippet:**
```yaml
nodeSelector:
  kubernetes.azure.com/agentpool: workers
```

---

### Identity (Workload Identity)

#### 2.1 The Concept
Terraform creates an ID card (MSI) for Azure. Helm attaches that ID card to your running Pod.

#### 2.2 Terraform Configuration (The Builder)
**File:** `user_identity.tf`
**What it does:** Creates the resource and assigns permissions.

```hcl
resource "azurerm_user_assigned_identity" "msi-workers" { ... }

resource "azurerm_federated_identity_credential" "federated_credential_workers" {
  parent_id = azurerm_user_assigned_identity.msi-workers.id
  # Binds Azure ID to K8s Service Account
  subject   = "system:serviceaccount:workers-blue:sa-workers-workloadidentity"
}
```
[Read Official Documentation](https://learn.microsoft.com/en-us/azure/aks/workload-identity-overview)

#### 2.3 The Helm Connection (The Bridge)
**Mechanism:** Service Account Binding
The critical link is the "Subject" line in Terraform. It must match the namespace and ServiceAccount name defined in your Helm values.

**Relevant Helm Snippet:**
```yaml
serviceAccountName: sa-workers-workloadidentity
labels:
  azure.workload.identity/use: "true"
```

---

### Redis (Message Broker)

#### 2.1 The Concept
Terraform builds the Redis server and grants permission. Helm just needs the address.

#### 2.2 Terraform Configuration (The Builder)
**File:** `redis-cache.tf`
**What it does:** Creates the resource and assigns permissions.

```hcl
resource "azurerm_redis_cache" "main" { ... }

# Grants the "worker" identity permission to read/write data
resource "azurerm_redis_cache_access_policy_assignment" "policy_assignment_workers" {
  access_policy_name = "Data Contributor"
  object_id          = azurerm_user_assigned_identity.msi-workers.principal_id
}
```
[Read Official Documentation](https://learn.microsoft.com/en-us/azure/azure-cache-for-redis/cache-configure#access-policies)

#### 2.3 The Helm Connection (The Bridge)
**Mechanism:** RBAC (Role Based Access Control)
Your Helm chart does NOT need a password. Because Terraform granted the "Data Contributor" role to the Worker Identity, the app connects automatically using its Azure Identity.

**Relevant Helm Snippet:**
```yaml
# No password secret needed in Helm!
command: ["celery", ..., "-Q", "$(BROKER_REQUESTS_QUEUE)"]
```

---

### CosmosDB (Database)

#### 2.1 The Concept
Terraform provisions the database and strictly controls who can touch the data.

#### 2.2 Terraform Configuration (The Builder)
**File:** `cosmos_mongodb.tf`
**What it does:** Creates the resource and assigns permissions.

```hcl
resource "azurerm_cosmosdb_account" "cosmos" { ... }

resource "azurerm_role_assignment" "msi_workers_cosmos_access" {
  role_definition_name = "Cosmos DB Operator"
  principal_id         = azurerm_user_assigned_identity.msi-workers.principal_id
}
```
[Read Official Documentation](https://learn.microsoft.com/en-us/azure/cosmos-db/mongodb/how-to-setup-rbac)

#### 2.3 The Helm Connection (The Bridge)
**Mechanism:** RBAC Access
Similar to Redis, the connection is secured via Azure RBAC. Terraform authorizes the specific Worker Managed Identity to access this specific Cosmos DB account.

**Relevant Helm Snippet:**
```yaml
# App code uses DefaultAzureCredential()
# No connection string secrets required
```

---

### App Configuration

#### 2.1 The Concept
Terraform creates the store for variables. A K8s operator (installed via Helm) syncs them to ConfigMaps.

#### 2.2 Terraform Configuration (The Builder)
**File:** `app_configuration.tf`
**What it does:** Creates the resource and assigns permissions.

```hcl
resource "azurerm_app_configuration" "common" { ... }

# Allow worker to READ config
resource "azurerm_role_assignment" "app_config_workers" {
  role_definition_name = "App Configuration Data Reader"
  principal_id         = azurerm_user_assigned_identity.msi-workers.principal_id
}
```
[Read Official Documentation](https://learn.microsoft.com/en-us/azure/azure-app-configuration/quickstart-azure-kubernetes-service)

#### 2.3 The Helm Connection (The Bridge)
**Mechanism:** Sync Provider
Terraform creates the App Config resource. Your cluster has a "Provider" that pulls these values into a Kubernetes ConfigMap, which Helm then mounts.

**Relevant Helm Snippet:**
```yaml
envFrom:
  - configMapRef:
      name: configmap-api-workers
```

---

### OpenAI Service

#### 2.1 The Concept
Terraform enables the AI features and permits the worker to call the API.

#### 2.2 Terraform Configuration (The Builder)
**File:** `openai.tf`
**What it does:** Creates the resource and assigns permissions.

```hcl
resource "azurerm_cognitive_account" "openai" { ... }

resource "azurerm_role_assignment" "msi_apps_openia_access" {
  role_definition_name = "Cognitive Services OpenAI Contributor"
  principal_id         = azurerm_user_assigned_identity.msi-workers.principal_id
}
```
[Read Official Documentation](https://learn.microsoft.com/en-us/azure/ai-services/openai/how-to/managed-identity)

#### 2.3 The Helm Connection (The Bridge)
**Mechanism:** API Permission
The application uses the Azure SDK to call OpenAI. Terraform ensures the Worker Identity has the "Contributor" role on the Cognitive Account.

**Relevant Helm Snippet:**
```yaml
# Python code: 
client = AzureOpenAI(
  azure_ad_token_provider=...
)
```

---

### KeyVault

#### 2.1 The Concept
Terraform creates the safe. It gives the worker the combination code (Access Policy).

#### 2.2 Terraform Configuration (The Builder)
**File:** `keyvault.tf`
**What it does:** Creates the resource and assigns permissions.

```hcl
resource "azurerm_key_vault" "kv-cluster" { ... }

resource "azurerm_role_assignment" "ra_kvt_worker" {
  role_definition_name = "Key Vault Secrets User"
  principal_id         = azurerm_user_assigned_identity.msi-workers.principal_id
}
```
[Read Official Documentation](https://learn.microsoft.com/en-us/azure/key-vault/general/rbac-guide)

#### 2.3 The Helm Connection (The Bridge)
**Mechanism:** Secret Access
If the app needs a raw secret (that isn't using Identity), it fetches it from KeyVault. Terraform guarantees the worker has permission to "Get" secrets.

**Relevant Helm Snippet:**
```yaml
envFrom:
  - secretRef:
      name: secret-api-workers
```

---
