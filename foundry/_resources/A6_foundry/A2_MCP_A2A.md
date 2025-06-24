# 1. MCP and A2A?

can I use MCP servers and A2A in AI foundry?

Yes — **Azure AI Foundry now supports both MCP and A2A protocols**, enabling advanced interoperability with external systems and agent ecosystems:

---

## 🔄 Model Context Protocol (MCP)

* Foundry Agent Service includes **turnkey MCP-server integration**, letting agents dynamically connect to MCP-capable clients via a unified protocol ([techcommunity.microsoft.com][1]).
* You can **build your own MCP server** using Python (e.g. via `mcp[cli]`, `azure‑ai‑projects`, etc.), connect Agent Service to clients like Claude, VS Code, Semantic Kernel, or OpenAI Agents SDK ([devblogs.microsoft.com][2]).
* The MCP server exposes tools, web grounding, private data retrieval, evaluation, and more in a standardized way ([devblogs.microsoft.com][3]).

---

## 🤝 Agent-to-Agent (A2A)

* **A2A support is now available (GA/Preview)** in Foundry Agent Service and Copilot Studio ([techcommunity.microsoft.com][4]).
* Enables seamless multi-turn communication between agents—e.g. passing context, invoking tasks—across different platforms (Azure, AWS, Google, on-prem, open-source like AutoGen, LangChain, Semantic Kernel) ([microsoft.com][5]).
* Built-in governance with mutual TLS, Azure AD auth, audit logs, and enterprise-grade security ([microsoft.com][5]).

---

## ✅ What This Means for You

1. **MCP**: Use Foundry’s Python-based MCP server or integrate with the open protocol to connect your agents to diverse data sources and LLM workflows seamlessly.
2. **A2A**: Orchestrate multi-agent ecosystems—Foundry agents can talk to other agents and platforms via A2A API head, enabling task delegation, context-hand-over, and collaboration.
3. **Combined Use**: Build multi-agent, tool-integrated systems that share both tasks and context, with full enterprise security and observability.

---

## 👨‍💻 Next Steps

1. Choose your integration pattern:

   * Use **Python-based MCP server** (via Foundry SDK).
   * Or connect via **Semantic Kernel** for MCP/A2A integration.
2. Explore **MCP Python samples** and **A2A orchestration support** in the Agent Service.
3. Extend Foundry's orchestration with **AutoGen, LangChain**, or **open-source orchestrators**.
4. Deploy and secure interactions using Azure identity, TLS, audit logging.

---

Let me know if you'd like a sample project—like a basic MCP server template or A2A-driven multi-agent workflow—to get started quickly!

### [1]: https://techcommunity.microsoft.com/blog/azure-ai-services-blog/ai-automation-in-azure-foundry-through-turnkey-mcp-integration-and-computer-use-/4424098?utm_source=chatgpt.com "AI Automation in Azure Foundry through turnkey MCP Integration ..."
### [2]: https://devblogs.microsoft.com/foundry/integrating-azure-ai-agents-mcp/?utm_source=chatgpt.com "Introducing Model Context Protocol (MCP) in Azure AI Foundry"
### [3]: https://devblogs.microsoft.com/foundry/azure-ai-foundry-mcp-server-may-2025/?utm_source=chatgpt.com "Azure AI Foundry MCP Server May 2025 Update: Adding Models ..."
### [4]: https://techcommunity.microsoft.com/blog/azure-ai-services-blog/building-a-digital-workforce-with-multi-agents-in-azure-ai-foundry-agent-service/4414671?utm_source=chatgpt.com "Building a Digital Workforce with Multi-Agents in Azure AI Foundry ..."
### [5]: https://www.microsoft.com/en-us/microsoft-cloud/blog/2025/05/07/empowering-multi-agent-apps-with-the-open-agent2agent-a2a-protocol/?utm_source=chatgpt.com "Empowering multi-agent apps with the open Agent2Agent (A2A ..."
