# Pulse-OS Kubernetes Helm Chart – Research & Analysis

## TL;DR
- This folder is a Helm application chart deploying the two FastAPI surfaces (Execution and Management), Celery workers, an optional DataHub exporter CronJob, Gateway API routing, Azure ALB for Containers health checks, and Azure App Configuration sync via the Kubernetes Provider.
- It targets AKS with Microsoft Entra Workload Identity, split node pools (`apps` and `workers`) and assumes existing ConfigMaps/Secrets for app settings.
- Key CRDs required: Gateway API (`gateway.networking.k8s.io`), Azure ALB for Containers (`alb.networking.azure.io`), Azure App Configuration Provider (`azconfig.io`).

---

## Chart Structure
- Chart meta: [\.ci-cd/infrastructure/kubernetes/Chart.yaml](.ci-cd/infrastructure/kubernetes/Chart.yaml)
- Values: [\.ci-cd/infrastructure/kubernetes/values.yaml](.ci-cd/infrastructure/kubernetes/values.yaml)
- Templates: [\.ci-cd/infrastructure/kubernetes/templates](.ci-cd/infrastructure/kubernetes/templates)
  - Deployments: [api-deployment.yaml](.ci-cd/infrastructure/kubernetes/templates/api-deployment.yaml), [workers-deployment.yaml](.ci-cd/infrastructure/kubernetes/templates/workers-deployment.yaml)
  - Services: [api-service.yaml](.ci-cd/infrastructure/kubernetes/templates/api-service.yaml)
  - Gateway API: [api-http-route.yaml](.ci-cd/infrastructure/kubernetes/templates/api-http-route.yaml)
  - Azure ALB Health: [api-health-check-policy.yaml](.ci-cd/infrastructure/kubernetes/templates/api-health-check-policy.yaml)
  - Azure App Config Provider: [custom-engine-configuration-provider.yaml](.ci-cd/infrastructure/kubernetes/templates/custom-engine-configuration-provider.yaml)
  - Exporter Cron: [exporter.yaml](.ci-cd/infrastructure/kubernetes/templates/exporter.yaml)

---

## What the templates deploy
- APIs (FastAPI via `uvicorn`)
  - Single Deployment with two containers:
    - `execution-api` on port 8989 (`main_execution:api`) – readiness/liveness at `/execution/api/v1/status`.
    - `management-api` on port 8888 (`main_management:api`) – readiness/liveness at `/management/api/v1/status`.
  - Labels include `azure.workload.identity/use: "true"`; runs as `sa-apps-workloadidentity`; `nodeSelector` targets pool `apps`.
  - Config via `configmap-api-workers` and `secret-api-workers`.
  - Resources are modestly set with requests/limits.

- Services
  - `execution-api` (ClusterIP, port 80 → 8989)
  - `management-api` (ClusterIP, port 8080 → 8888)

- Gateway API routing
  - `HTTPRoute` binds to `https-gateway` in namespace `ingress`.
  - Routes hostnames from `.Values.hostname` with two `PathPrefix` rules: `/execution` → `execution-api:80`, `/management` → `management-api:8080`.

- Azure ALB for Containers health checks
  - Two `HealthCheckPolicy` resources (`alb.networking.azure.io/v1`) target the Services and define HTTP health probes (interval, timeout, thresholds).

- Celery Workers
  - Separate Deployment in `.Values.workers.namespace` (default `workers-blue`).
  - Command uses prefork pool and queue env `$(BROKER_REQUESTS_QUEUE)`; probes execute Python scripts (`worker_readiness.py`, `worker_liveness.py`).
  - Uses workload identity (`sa-workers-workloadidentity`), optional spot tolerations/affinity, and worker node pool `workers`.

- Exporter CronJob (optional)
  - If `.Values.exporter.enabled`, schedules `main_export.py` with arguments sourced from ConfigMap/Secret; runs under `sa-exporter-workloadidentity` on `apps` pool.

- Azure App Configuration Provider
  - `AzureAppConfigurationProvider` (`azconfig.io/v1`) in workers namespace syncs keys labeled `custom-engine-workers` to `configmap-custom-engine-workers` and `secret-custom-engine-workers` using Workload Identity.

---

## Values you must set
- `azure_container_registry.endpoint` and `image`; `version` (chart tags images as `<endpoint>/<image>:<version>`)
- `hostname` for Gateway routing
- `app_configuration.endpoint` for Azure App Config Provider
- Optionally `exporter.enabled` and `exporter.namespace`
- If using spot for workers: `workers.spot.enabled: true`

---

## Azure/AKS integrations
- Workload Identity
  - Pods labeled `azure.workload.identity/use: "true"` run under dedicated ServiceAccounts (`sa-*-workloadidentity`). Ensure federated identity credentials map these SAs to a user-assigned managed identity.
  - Docs: AKS Workload Identity overview and setup
    - https://learn.microsoft.com/azure/aks/workload-identity-overview
    - https://learn.microsoft.com/azure/aks/workload-identity-deploy-cluster

- Gateway API + Azure ALB for Containers
  - HTTPRoute (`gateway.networking.k8s.io/v1`) uses `parentRefs` to an `ingress/https-gateway`, `hostnames`, and path rules.
  - Cross-namespace attachments may require `allowedRoutes` on the Gateway and `ReferenceGrant` when backendRefs cross namespaces.
  - Docs:
    - Gateway API concepts: https://kubernetes.io/docs/concepts/services-networking/gateway/
    - Multi-namespace guidance: https://gateway-api.sigs.k8s.io/guides/multiple-ns/

- ALB HealthCheckPolicy CRD
  - `alb.networking.azure.io/v1` `HealthCheckPolicy` attaches to a Service via `spec.targetRef` and defines `default.http.path`, `port`, `interval`, `timeout`, and thresholds.
  - Docs:
    - Custom health probes: https://learn.microsoft.com/azure/application-gateway/for-containers/custom-health-probe
    - CRD spec: https://learn.microsoft.com/azure/application-gateway/for-containers/api-specification-kubernetes#alb.networking.azure.io/v1.HealthCheckPolicy

- Azure App Configuration Provider CRD
  - `azconfig.io/v1` `AzureAppConfigurationProvider` with `spec.endpoint`, `configuration.selectors`, refresh intervals; targets `configMapName` and Secrets; authenticates via Workload Identity.
  - Docs:
    - Reference: https://learn.microsoft.com/azure/azure-app-configuration/reference-kubernetes-provider
    - GitHub: https://github.com/Azure/AppConfiguration-KubernetesProvider

---

## Probes and health checking
- API containers use HTTP readiness/liveness endpoints inside the Pod.
- ALB `HealthCheckPolicy` probes Services directly.
- Important: The policy paths currently use `/api/v1/status`, while Pod probes use `/execution/api/v1/status` and `/management/api/v1/status`. Unless there’s path rewriting, align ALB paths with the actual container endpoints to avoid 5xx/unhealthy backends.

---

## Scaling, scheduling, and resilience
- Horizontal scale via `replicas` in Deployments; consider HPA/KEDA for API and Celery workers.
- Workers set `terminationGracePeriodSeconds: 120` to allow task drain; ensure Celery SIGTERM handling and consider `--max-tasks-per-child`.
- Consider adding PodDisruptionBudgets for APIs and workers, and topology spread constraints for AZ/zone resilience.

---

## Security and runtime
- Containers run as UID 1000 with `allowPrivilegeEscalation: false`; consider `runAsNonRoot: true`, `seccompProfile: RuntimeDefault`, and dropping capabilities.
- Ensure Secrets do not duplicate sensitive data already projected by Azure App Config/Key Vault references; rotate via App Config refresh.

---

## Observability
- Chart does not include Prometheus/OTel exporters; the app code uses OpenTelemetry. Optionally add `ServiceMonitor` (if Prometheus Operator present) and expose metrics endpoints.

---

## Prerequisites
- AKS cluster with:
  - Gateway API and Azure ALB for Containers installed/configured with `https-gateway` in namespace `ingress`.
  - Azure App Configuration Kubernetes Provider installed (CRDs present cluster-wide).
  - Workload Identity enabled and federated identities bound to `sa-apps-workloadidentity`, `sa-workers-workloadidentity`, `sa-exporter-workloadidentity`.
- Pre-created ConfigMaps/Secrets referenced by the chart:
  - `configmap-api-workers`, `secret-api-workers`
  - If exporter enabled: `configmap-datahub-exporter`, `secret-datahub-exporter`

---

## Deploying the chart
```bash
# Set required values
helm upgrade --install pulse-os-api \
  .ci-cd/infrastructure/kubernetes \
  --namespace apps \
  --create-namespace \
  --set azure_container_registry.endpoint="<registry>.azurecr.io" \
  --set azure_container_registry.image="pulseos" \
  --set version="<image-tag>" \
  --set hostname="<api.example.com>" \
  --set app_configuration.endpoint="https://<appconfig>.azconfig.io" \
  --set workers.namespace="workers-blue" \
  --set exporter.enabled=false
```

---

## Helm considerations and recommendations
- Follow Helm best practices: keep one resource per template file, prefer helper templates for names/labels, parameterize replicas/resources/affinity/annotations.
  - Docs: https://helm.sh/docs/chart_best_practices/ and https://helm.sh/docs/chart_best_practices/templates/
- Suggested improvements in this chart:
  - Add `_helpers.tpl` for names/labels/annotations.
  - Expose `replicas`, `resources`, and ports in `values.yaml`.
  - Add HPAs (or KEDA ScaledObjects) for APIs and workers.
  - Add PDBs and topology spread constraints.
  - Align `HealthCheckPolicy` paths with container health endpoints.
  - Add `imagePullPolicy`, `runAsNonRoot`, `seccompProfile`, and `fsGroup` if needed.

---

## FastAPI and Celery on Kubernetes – key notes
- FastAPI
  - Prefer one Uvicorn process per Pod; scale via replicas or use Gunicorn+Uvicorn if you need multiple workers per Pod.
  - Ensure clean shutdown hooks for graceful termination and align `initialDelaySeconds` with app startup time.
  - Docs: https://fastapi.tiangolo.com/deployment/

- Celery
  - Run prefork workers with explicit `--queues` and consider `--max-tasks-per-child` to cap memory growth.
  - Probes should validate broker connectivity and worker event loop; ensure enough `terminationGracePeriodSeconds` for task drain.
  - Docs: https://docs.celeryq.dev/en/stable/userguide/workers.html

---

## Known pitfalls (Gateway API + ALB)
- Missing `ReferenceGrant` or restrictive Gateway `allowedRoutes` can prevent `HTTPRoute` attachment; check Gateway/Route status conditions.
- HealthCheckPolicy misconfig (wrong path/port or status ranges) yields constant unhealthy targets.
- Namespace boundaries: ensure Services/Routes/Gateway relationships are permitted across namespaces.
- Troubleshooting:
  - ALB for Containers: https://learn.microsoft.com/azure/application-gateway/for-containers/troubleshooting-guide
  - Gateway API multi-namespace: https://gateway-api.sigs.k8s.io/guides/multiple-ns/