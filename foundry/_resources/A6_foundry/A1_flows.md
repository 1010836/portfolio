# 1. how?

how do I programmatically with python can work with foundry prompt flows?

To programmatically work with Azure AI Foundry Prompt Flows using Python, you'll leverage the **Prompt Flow SDK** and **Azure AI Foundry Python client libraries**. Here's how to get started:

---

## 🧰 1. Install the Required Packages

```bash
pip install promptflow azure-ai-projects azure-identity
```

* `promptflow` — SDK for building and managing Prompt Flow assets locally ([tomaztsql.wordpress.com][1])
* `azure-ai-projects` — Azure Foundry client for interacting with projects, deploying flows, and agents&#x20;

---

## ⚙️ 2. Define Prompt Flow Locally

Create a `.prompty` YAML file to define your flow. For example:

```yaml
---
name: greeting_flow
model:
  api: chat
  configuration:
    type: azure_openai
    azure_deployment: gpt-4o
    azure_endpoint: ${env:AZURE_OPENAI_ENDPOINT}
    api_key: ${env:AZURE_OPENAI_API_KEY}
    api_version: ${env:AZURE_OPENAI_API_VERSION}
  parameters:
    temperature: 0.2
inputs:
  name:
    type: string
sample:
  name: "Alice"
nodes:
- name: greet
  type: python
  source:
    type: code
    code: |
      from promptflow import tool
      @tool
      def greet(name: str) -> str:
          return f"Hello, {name}!"
  inputs:
    name: ${inputs.name}
  outputs:
    greeting: str
outputs:
  message:
    type: string
    reference: ${greet.outputs.greeting}
    is_chat_output: true
```

This defines:

1. An LLM call node.
2. A Python tool node using `@tool` decorator ([learn.microsoft.com][2], [medium.com][3]).

---

## 🚀 3. Run & Deploy Locally

### Run flow locally:

```bash
promptflow run greeting_flow.prompty --input name="Bob"
```

### Deploy as API endpoint:

```bash
promptflow deploy greeting_flow.prompty --name greetingFlowApi
```

This publishes the flow as a REST endpoint you can call from your Python chatbot app.

---

## 🤖 4. Call Deployed Flow from Python

Use the Azure Foundry client to invoke your deployed flow:

```python
from azure.ai.projects import AIProjectClient
from azure.identity import DefaultAzureCredential

# Replace with your actual endpoint
endpoint = "https://<your-foundry-resource>.services.ai.azure.com/api/projects/<project>"
project = AIProjectClient(endpoint=endpoint, credential=DefaultAzureCredential())

# Call your Prompt Flow as an inference client
flow = project.inference.get_flow_client("greetingFlowApi")
result = flow.invoke(inputs={"name": "Charlie"})
print(result)  # {"message": "Hello, Charlie!"}
```

This example demonstrates how to run your canvas flow from within a Python application using the Azure SDK ([learn.microsoft.com][4]).

---

## 🔧 5. Summary: Full Workflow

| Step                      | Description                                         |
| ------------------------- | --------------------------------------------------- |
| **Install SDKs**          | `promptflow`, `azure-ai-projects`, `azure-identity` |
| **Define flow locally**   | Use `.prompty` with LLM and Python tool nodes       |
| **Run & iterate locally** | `promptflow run` for debug                          |
| **Deploy flow endpoint**  | `promptflow deploy` to expose as API                |
| **Call from Python**      | Use Azure Foundry SDK to invoke `get_flow_client()` |

---

## ✅ Final Thoughts

Using this approach, you can seamlessly:

* **Build** using visual/low-code + inline Python
* **Test** workflows locally
* **Deploy** flows as service endpoints
* **Integrate** into your chatbot backend via REST/SDK

Let me know if you'd like a complete sample repo or more advanced patterns!

### [1]: https://tomaztsql.wordpress.com/2024/12/22/advent-of-2024-day-22-microsoft-azure-ai-prompt-flow-using-vs-code-and-python/?utm_source=chatgpt.com "Microsoft Azure AI – Prompt flow using VS Code and Python"
### [2]: https://learn.microsoft.com/en-us/azure/ai-foundry/how-to/prompt-flow-tools/python-tool?utm_source=chatgpt.com "Python tool for flows in Azure AI Foundry portal - Learn Microsoft"
### [3]: https://medium.com/%40danushidk507/promptflow-in-azure-ai-foundry-a4a60fc8aea7?utm_source=chatgpt.com "Promptflow in Azure AI Foundry - Medium"
### [4]: https://learn.microsoft.com/en-us/azure/ai-foundry/quickstarts/get-started-code?utm_source=chatgpt.com "Quickstart: Get started with Azure AI Foundry - Learn Microsoft"
