# Kubernetes Worker Deployment Analysis

## 1. Deployment Overview
**Kind:** `Deployment`
**Name:** `worker`
**Namespace:** Configurable via `.Values.workers.namespace` (Default: `workers-blue`)
**Replicas:** 3 (High availability setup)

## 2. Scheduling & Infrastructure
The deployment is designed to run on specific infrastructure within Azure Kubernetes Service (AKS).

* **Target Node Pool:** Uses `nodeSelector` to strictly target nodes labeled `kubernetes.azure.com/agentpool: workers`.
* **Spot Instances (Optional):**
    * Controlled by `.Values.workers.spot.enabled`.
    * **Tolerations:** Allows the pod to run on nodes with the "Spot" taint.
    * **Affinity:** "Hard" affinity (`requiredDuringSchedulingIgnoredDuringExecution`) forces scheduling onto Spot nodes if enabled. This is a cost-saving strategy for processing workers.

## 3. Identity & Security (Workload Identity)
This is a modern passwordless authentication setup.

* **Service Account:** `sa-workers-workloadidentity`
* **Federated Credential:** The pod label `azure.workload.identity/use: "true"` tells the AKS Workload Identity webhook to inject the Azure token exchange logic.
* **Security Context:**
    * Runs as non-root user (UID 1000).
    * `allowPrivilegeEscalation: false` prevents the process from gaining root privileges.

## 4. Application Lifecycle
* **Command:** Runs a Celery worker using the `prefork` pool.
    * Queue is dynamic: `$(BROKER_REQUESTS_QUEUE)`.
    * Events enabled: `--events` (for monitoring like Flower).
* **Graceful Shutdown:** `terminationGracePeriodSeconds: 120`. This allows the Celery worker 2 minutes to finish current tasks before being forcibly killed (SIGKILL).

## 5. Observability (Probes)
Custom Python scripts are used instead of simple HTTP checks, likely verifying queue connectivity or internal worker state.

* **Readiness:** `worker_readiness.py` (Delays traffic until ready).
* **Liveness:** `worker_liveness.py` (Restarts pod if stuck).
* **Timings:** Both have a slow start (`initialDelaySeconds: 60`), indicating a heavy initialization process.

## 6. Configuration & Resources
* **Config Source:**
    * `configmap-api-workers`: Non-sensitive env vars.
    * `secret-api-workers`: Sensitive keys.
    * *Note:* The user info mentions `azconfig.io/v1` (Azure App Config provider), which likely syncs values into these Kubernetes ConfigMaps/Secrets automatically.
* **Compute Resources:**
    * **Requests:** 100m CPU / 850Mi RAM (Guaranteed minimum).
    * **Limits:** 200m CPU / 1Gi RAM (Hard ceiling).
    * *Analysis:* The tight gap between requests and limits suggests a memory-bound workload where OOMKills are strictly avoided.
