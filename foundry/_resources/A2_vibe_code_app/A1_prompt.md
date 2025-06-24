# 1. generate prompt

Generate the best prompt possible to get the perfect response from CHATGPT deep search feature, using my text:
"
I need to create an App do do Vibe code. I need it to allow for the creation of a project with this structure: analyze the GitHub project I give you in sources. D:. ├───.commands ├───.docker ├───.pipelines ├───.settings ├───.vscode ├───agent_skills └───src     └───cegid_pos_cpa         ├───CPA         │   ├───invoices         │   │   └───random siren         │   └───resources         └───pulse_os             ├───dtos             ├───infrastructure             ├───probes             ├───services             └───utils inside the forder CPA  will be created all the generated code everything else is scaffolding. inside this CPA folder will be created a file called engine.cpa that implements class CPAEngine(IEngine) IEngine interface. what is the best way to do this? should I clone the openai codex project from github and create my own version? should I create an vsCode github copilot extension (I have a license to use it)? should I analyse projects like cursor or windsurf and implement something like them? other other choice? create a report analyzing all the possibilities (State of the ART) then select the best choice and justify the create a step by step procedure for me to implement this selected solution, add code and good details."

## 2. answer

To craft a prompt that taps into ChatGPT’s **Deep Research** mode and drives out a top-tier, multi-step implementation plan for your Vibe‑code App project, here’s a refined version:

---

**🎯 Deep Research Prompt — Vibe‑Code App Project**

---

```
You are ChatGPT’s Deep Research agent (o3 model).  
Goal: Provide a thorough, multi-step action plan for creating a Vibe‑code App as described below:

1. **Analyze**: Review the GitHub project I will provide, including its folder structure:
   D:.
   ├── .commands  
   ├── .docker  
   ├── .pipelines  
   ├── .settings  
   ├── .vscode  
   ├── agent_skills  
   └── src  
       └── cegid_pos_cpa  
           ├── CPA  
           │   ├── invoices  
           │   │   └── random siren  
           │   └── resources  
           └── pulse_os  
               ├── dtos  
               ├── infrastructure  
               ├── probes  
               ├── services  
               └── utils  

   - Everything inside `CPA/` is generated code.  
   - `engine.cpa` (in `CPA/`) implements `class CPAEngine(IEngine)`.

2. **Survey alternatives**: Evaluate these implementation options:
   - Fork or clone and adapt OpenAI’s Codex project
   - Build a VS Code + GitHub Copilot plugin
   - Study and replicate patterns from Cursor, Windsurf, or similar code-gen tools
   - Propose any other valid solution path

3. **State‑of‑the‑Art report**: For each option, provide:
   - Description
   - Pros, cons, complexity & cost
   - Feasibility, tools, ecosystem fit

4. **Decision**: Recommend the best path, with justification based on:
   - Your project’s structure + goals
   - Trade‑offs in performance, maintainability, scalability, dev experience

5. **Implementation Blueprint**:
   - Step‑by‑step roadmap (dev environ, code scaffolding, CI/CD, testing, deployment, GitHub integration)
   - Code snippets for critical components:
     - `engine.cpa` implementation of `CPAEngine(IEngine)`
     - VS Code extension or CLI hooks (if applicable)
     - GitHub pipeline automation
   - Advice on iterative validation, unit/integration tests, and best practices

6. **Citations & Sources**:
   - Use web-based backing—links with citations for each factual claim.
   - Include comparisons with similar open-source projects or plugins.

7. **Format**: Structure your output with:
   - **Executive Summary**
   - **Option Matrix** (table)
   - **Selected Strategy**
   - **Implementation Plan**
   - **Next Steps Checklist** with timelines

---

Whenever you're ready, ask me for the GitHub repo URL, then walk me through the investigation plan before starting the research.

---

**Why this prompt works:**

- 🎯 **Clear goal** aligned with Deep Research’s strengths :contentReference[oaicite:1]{index=1}  
- 🧠 **Multi-step structure**, with explicit milestones & deliverables :contentReference[oaicite:2]{index=2}  
- 📚 **Context and bounds** provided: file layout, code conventions, desired autonomy  
- 🛠 **Requests for citations**, comparisons, feasibility—leveraging O3’s web-crawling and reasoning :contentReference[oaicite:3]{index=3}  
- 📐 **Guided output format** ensures structured, usable plan :contentReference[oaicite:4]{index=4}  

---

When using it:

1. Switch to **Deep Research** mode.  
2. Paste the refined prompt.  
3. Provide the repo link when asked.  
4. Ask follow-ups like: “Now find examples of Copilot-like plugins generating code in VS Code.”  
5. Refine iteratively based on interim summaries.

This will prompt an agentic, deeply grounded investigation—yielding a high-confidence, implementable solution. Let me know when you're ready, and I’ll prep the repo search!
::contentReference[oaicite:5]{index=5}
```
