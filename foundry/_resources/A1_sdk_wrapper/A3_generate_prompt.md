Generate the perfect prompt for me to get the best results possible from CHATGPT DEEP RESEARCH feature to do this:

"I need to implement a wrapper to all the azure AI foundry and Microsoft Semantic Kernel to provide to my clients all this functionality using my own custom python library. Please generate a detail report that analyses this problem and all the available resources  in the web and the generates a step by step strategy with code and details so I can do this during this weekend."

Here’s an optimized prompt you can feed into **ChatGPT Deep Research** to get precise, well-structured guidance:

---

**🧠 PROMPT FOR DEEP RESEARCH**

```
I’m building a **Python wrapper** library over **Azure AI Foundry + Microsoft Semantic Kernel**, unifying functionalities (model deployment, chat, embeddings, agents, tools, RAG, plugins, multi-agent orchestration, security and scanning, tests) into a single client SDK for my users.

🧩 **Objective:** Provide an end-to-end, detailed report with:
1. Overview of the APIs and SDKs: Azure AI Foundry SDK (`azure-ai-projects`, `azure-ai-agents`), Semantic Kernel Python (`semantic-kernel[azure]`).
2. List and analysis of relevant Microsoft docs, tutorials, blog posts, GitHub repos.
3. For each key feature (model/chat, embeddings, agents, tools, RAG), give:
   • API calls/code samples (Python)
   • Required environment variables, authentication
   • Dependency versions & installation instructions
4. Outline multi-agent/config use cases with step‑by‑step code (using AzureAIAgent, plugins, OpenAPI tools).
5. Include a weekend-accelerated implementation plan:
   • Day‑by‑day milestones (e.g., env setup, clients, core modules, plugin layer, tests)
   • CI/CD recommendations, testing strategies, error handling.
6. Summary of pitfalls and best practices (e.g. tool naming, thread lifecycle, async usage).

Format:
- Use headings, numbered steps and code blocks
- Provide external references (links, citations)
- Aim for a thorough, runnable weekend plan

```

---

### Why this works

* **Clear scope & goals:** You define precisely what you want wrapped and unified.
* **Resource-aware:** Requests discovery and compilation of real-world docs, blogs, and repos.
* **Feature breakdown:** Guides the system through each critical SDK capability.
* **Weekend-ready:** The output will be actionable for a fast implementation.
* **Structured output:** Encourages headings, code, ref‑links—making the research usable.

---

### Supporting context from the latest MS resources

* **Azure AI Foundry + Semantic Kernel** overview and Python examples are outlined in the Microsoft documentation:

  * Shows how to install `semantic‑kernel[azure]`, connect to Foundry endpoints, and perform chat with Azure AI Foundry models ([learn.microsoft.com][1]).
* The **AzureAIAgent** class in Semantic Kernel supports multi-agent orchestration, tool integration, conversation threads in Python ([learn.microsoft.com][2]).
* The **Azure AI Projects Python SDK** (`azure‑ai‑projects`, `azure‑ai‑agents`) provides a unified interface for Foundry projects and agents ([learn.microsoft.com][3]).
* Best practices for multi-agent function-calling, plugins, A2A integration, and error handling are detailed in Microsoft Dev Blogs ([devblogs.microsoft.com][4]).

---

### How to use

Copy the prompt above into ChatGPT Deep Research. Once you get the draft, feel free to share it here—I can help you refine it to perfection.

[1]: https://learn.microsoft.com/en-us/azure/ai-foundry/how-to/develop/semantic-kernel?utm_source=chatgpt.com "Develop applications with Semantic Kernel and Azure AI Foundry"
[2]: https://learn.microsoft.com/en-us/semantic-kernel/frameworks/agent/agent-types/azure-ai-agent?utm_source=chatgpt.com "Exploring the Semantic Kernel Azure AI Agent Agent - Learn Microsoft"
[3]: https://learn.microsoft.com/en-us/azure/ai-studio/how-to/develop/sdk-overview?utm_source=chatgpt.com "How to get started with Azure AI Foundry SDK - Learn Microsoft"
[4]: https://devblogs.microsoft.com/foundry/semantic-kernel-a2a-integration/?utm_source=chatgpt.com "Integrating Semantic Kernel Python with Google's A2A Protocol"
