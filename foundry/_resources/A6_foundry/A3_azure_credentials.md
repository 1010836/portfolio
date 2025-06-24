# 1. how to setup?

my python app runs this code:
    def get_azure_credential(self) -> DefaultAzureCredential:

        if self.__client_id:
            os.environ["AZURE_CLIENT_ID"] = self.__client_id
        if self.__client_secret:
            os.environ["AZURE_CLIENT_SECRET"] = self.__client_secret
        if self.__tenant_id:
            os.environ["AZURE_TENANT_ID"] = self.__tenant_id
        result = DefaultAzureCredential()

        return result
how can I setup in azure this credentials: AZURE_CLIENT_ID, AZURE_CLIENT_SECRET, AZURE_TENANT_ID
explain step by step inside azure dashboard

Below is a practical “click-through” guide you can follow directly in the Azure portal ( portal.azure.com ).
The first two parts show how to **create the service-principal credentials** (Client ID, Secret, Tenant ID).
The last part shows **where to paste each value** as environment variables so `DefaultAzureCredential()` can find them at runtime.

---

## 1  Create an application (service principal) in Microsoft Entra ID

| What to do in the portal                                                                                                                                               | Why                                                                                                  |
| ---------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- |
| 1. In the left-hand search box type **“Microsoft Entra ID”** and open it.                                                                                              | Entra ID (formerly Azure AD) is where service principals live.([learn.microsoft.com][1])             |
| 2. Select **App registrations ➜ New registration**.                                                                                                                    | Creates a new identity your code can log in as.([learn.microsoft.com][1], [learn.microsoft.com][2])  |
| 3. Enter a **Name** and leave **Supported account types → Accounts in this organizational directory only** (single-tenant) unless you really need multi-tenant access. | Single-tenant is simplest and safest.([learn.microsoft.com][2])                                      |
| 4. Click **Register**.                                                                                                                                                 | Azure now issues an *Application (client) ID* and links it to your tenant.([learn.microsoft.com][1]) |

### Grab the IDs

* On the app’s **Overview** blade copy

  * **Application (client) ID** → `AZURE_CLIENT_ID`
  * **Directory (tenant) ID**   → `AZURE_TENANT_ID`([learn.microsoft.com][1], [learn.microsoft.com][3])

(You can also find the Tenant ID under *Entra ID ➜ Overview* if you ever lose it.([learn.microsoft.com][3]))

---

## 2  Generate a client secret

| What to click                                                                                                                                      | Notes                                                                 |
| -------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------- |
| 1. Inside the same app registration, open **Certificates & secrets**.                                                                              |                                                                       |
| 2. Choose **Client secrets ➜ New client secret**. Give it a description and expiry (6–12 months is common).                                        | Azure shows the secret **value only once**.([learn.microsoft.com][1]) |
| 3. Copy the **Secret value** (not the Secret ID) immediately → `AZURE_CLIENT_SECRET`. Store it somewhere safe (Key Vault, password manager, etc.). |                                                                       |

---

## 3  Give the service principal access to your Azure resources

Without a role assignment the principal can’t do anything.

| Scope                                    | How to assign                                                                                                                                                                                                                                                                                                                                |
| ---------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Subscription-wide or resource-group-only | 1. Browse to the subscription or resource group.<br>2. **Access control (IAM) ➜ + Add ➜ Add role assignment**.<br>3. Pick a role (e.g., **Contributor** or a narrower built-in role).<br>4. On **Members**, switch to **Service principal**, search for your app registration name, select, ➜ **Review + assign**.([learn.microsoft.com][4]) |

---

## 4  Inject the three variables into your Azure runtime

`DefaultAzureCredential` looks for `AZURE_CLIENT_ID`, `AZURE_CLIENT_SECRET`, `AZURE_TENANT_ID` automatically.([learn.microsoft.com][5], [learn.microsoft.com][6])

### A. Azure App Service / Web App

1. Open your Web App → **Settings ➜ Configuration ➜ Environment variables (“App settings” tab)**.
2. Click **+ Add** three times and enter:

| Name                  | Value               |
| --------------------- | ------------------- |
| `AZURE_CLIENT_ID`     | *your Client ID*    |
| `AZURE_CLIENT_SECRET` | *your Secret value* |
| `AZURE_TENANT_ID`     | *your Tenant ID*    |

3. **Save ➜ Continue**; the site restarts and the vars are injected at startup.([learn.microsoft.com][7], [learn.microsoft.com][8])

### B. Azure Functions

1. Function App → **Settings ➜ Environment variables ➜ App settings**.
2. **+ Add** the same three key–value pairs, then **Apply**.([learn.microsoft.com][9], [learn.microsoft.com][10])

### C. Containers / AKS / Container Apps

* Pass the variables in your deployment YAML or portal UI (for Container Instances use **Environment variables** under *Container settings*).
* If you’re building a Docker image **don’t bake the secrets into the image**—inject at run time.

---

## 5  Run and verify

When your code starts in Azure, `DefaultAzureCredential()` will read those three environment variables first and authenticate as the service principal you just created.([learn.microsoft.com][5])

You can confirm by hitting an Azure SDK call (e.g., list Storage accounts) and checking the **Activity log**; the caller should show as the app registration name.

---

### Tips & good practices

* Rotate the client secret on a schedule and update the App Settings without redeploying your code.
* Prefer **Azure Key Vault references** in App Settings for production—App Service can pull the secret directly from Key Vault so you never type it in the portal.([learn.microsoft.com][7])
* For resources that support **managed identity**, consider using that instead of service-principal secrets to avoid secret rotation entirely.

You now have all three values securely stored in Azure, and your Python code will authenticate cleanly whether you run it locally (with the variables in your shell) or in the cloud via `DefaultAzureCredential()`.

### [1]: https://learn.microsoft.com/en-us/azure/healthcare-apis/register-application "Register a client application in Microsoft Entra ID for the Azure Health Data Services | Microsoft Learn"
### [2]: https://learn.microsoft.com/en-us/entra/identity-platform/quickstart-register-app "How to register an app in Microsoft Entra ID - Microsoft identity platform | Microsoft Learn"
### [3]: https://learn.microsoft.com/en-us/azure/azure-portal/get-subscription-tenant-id "Get subscription and tenant IDs in the Azure portal - Azure portal | Microsoft Learn"
### [4]: https://learn.microsoft.com/en-us/azure/role-based-access-control/role-assignments-portal "Assign Azure roles using the Azure portal - Azure RBAC | Microsoft Learn"
### [5]: https://learn.microsoft.com/en-us/azure/developer/java/sdk/authentication/azure-hosted-apps "Authenticate Azure-hosted Java applications - Azure SDK for Java | Microsoft Learn"
### [6]: https://learn.microsoft.com/en-us/java/api/com.azure.identity.defaultazurecredential?view=azure-java-stable "DefaultAzureCredential Class | Microsoft Learn"
### [7]: https://learn.microsoft.com/en-us/azure/app-service/configure-common "Configure an App Service App - Azure App Service | Microsoft Learn"
### [8]: https://learn.microsoft.com/en-us/azure/app-service/reference-app-settings "Environment Variables and App Settings Reference - Azure App Service | Microsoft Learn"
### [9]: https://learn.microsoft.com/en-us/azure/azure-functions/functions-how-to-use-azure-function-app-settings "Configure function app settings in Azure Functions | Microsoft Learn"
### [10]: https://learn.microsoft.com/en-us/azure/azure-functions/functions-app-settings "App settings reference for Azure Functions | Microsoft Learn"
