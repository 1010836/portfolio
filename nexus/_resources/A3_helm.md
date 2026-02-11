# Is Helm Only for Kubernetes?

## Executive Summary
Technically, **Helm is a package manager for Kubernetes**. Its core architecture is designed to manage Kubernetes manifests and interact with the Kubernetes API. However, through the use of **Custom Resource Definitions (CRDs)** and **Controllers**, Helm's reach has been extended to manage external cloud infrastructure and general-purpose configurations.

## 1. Primary Use: The Kubernetes Standard
At its core, Helm templates YAML files for Kubernetes objects (Pods, Services, Ingress). It manages "releases," which are specific installations of a chart within a cluster.
- **Source:** [Official Helm Documentation](https://helm.sh/docs/)

## 2. Extending to Infrastructure (Crossplane & ACK)
One of the most common ways to "use Helm for other things" is by utilizing Kubernetes as a control plane for cloud resources.
- **Crossplane:** Allows you to define cloud infrastructure (S3 buckets, SQL databases) as Kubernetes objects.
- **AWS Controllers for Kubernetes (ACK):** Similar to Crossplane, but specific to AWS resources.
- **Source:** [Managing Cloud Infrastructure with Helm and Crossplane (OneUptime)](https://oneuptime.com/blog/post/2026-01-17-helm-crossplane-infrastructure-management/view)

## 3. General Purpose Templating Engine
Because Helm uses the Go Template engine and the Sprig library, some developers use `helm template` as a standalone CLI tool.
- **Source:** [Helm Chart Development Tips and Tricks](https://helm.sh/docs/howto/charts_tips_and_tricks/)

## 4. Comparison with Other Tools
| Tool | Focus | Best Use Case |
| :--- | :--- | :--- |
| **Terraform** | Infrastructure | Provisioning VMs, Networks, and Managed Services. |
| **Ansible** | Configuration | Setting up OS-level software and security on Bare Metal. |
| **Helm** | Application | Managing containerized apps and K8s-native infrastructure. |

- **Source:** [Helm vs. Terraform - Spacelift](https://spacelift.io/blog/helm-vs-terraform)