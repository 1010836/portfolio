# 1. introduction
I need to learn about micro-frontend in 10 minutes. 
Create a very objective report for-me to grasp an overview.

[Quick Evaluation PDF](A1A1_quick_evaluation.pdf)

# 2. implementation

There isn’t a “one‐true” way to build micro‑frontends—they’re an architectural pattern that can be implemented using different techniques depending on your needs. Here’s a high-level comparison of the main approaches:

---

### 1. Iframe-Based Integration

**How It Works:**
Each micro‑frontend runs in its own isolated iframe. The container (shell) loads the appropriate iframe based on routing.

**Pros:**
• **Strong Isolation:** CSS, JavaScript, and DOM are completely separated, reducing conflicts.
• **Legacy Support:** Can integrate older or very different applications without much rework.

**Cons:**
• **Performance Overhead:** Each iframe has its own browser context, leading to duplicated resource loads.
• **Communication Challenges:** Sharing data (e.g., authentication, state) between the shell and the iframe requires extra messaging (like postMessage), which can be cumbersome.
• **Limited Integration:** Seamless user experience (like shared navigation or animations) can be harder to achieve.

---

### 2. Client-Side Composition

This is the most common modern approach. The container application loads micro‑frontends dynamically into a single-page application.

There are several variations:

#### a. Using JavaScript Orchestration

• **Method:** The container loads micro‑frontend bundles (via `<script>` tags) and calls global functions (e.g., `window.renderX`) to mount each part into designated DOM nodes.
• **Pros:**
 – Easy to develop and test micro‑frontends independently (each can also run standalone).
 – More control over when and how components are mounted.
• **Cons:**
 – The container must know the entry-point contracts, which requires coordination.

#### b. Using Web Components

• **Method:** Each micro‑frontend is encapsulated as a custom element (using the Web Components spec). The container simply instantiates these elements.
• **Pros:**
 – Native encapsulation (Shadow DOM) helps prevent CSS and script conflicts.
 – The shell doesn’t need to know about the internal implementation details.
• **Cons:**
 – Browser support for advanced features (or polyfills) may be required.
 – Communication between components is still needed for cross-cutting concerns.

#### c. Using Frameworks and Libraries (e.g., Single‑SPA, Qiankun)

• **Method:** Dedicated orchestration frameworks help register, mount, and unmount micro‑frontends.
• **Pros:**
 – Provides standardized routing, lifecycle management, and communication patterns.
 – Allows teams to work with different frameworks within the same container.
• **Cons:**
 – There is a learning curve and potential configuration overhead.
 – Debugging cross-framework issues can be challenging.

#### d. Using Module Federation (Webpack 5)

• **Method:** Module Federation enables dynamically loading remote modules at runtime while sharing common libraries (like React).
• **Pros:**
 – Reduces duplicate dependencies by sharing libraries across micro‑frontends.
 – Supports independent deployments with runtime integration.
• **Cons:**
 – Requires careful version management and bundler configuration.
 – Tightly couples the container’s expectations with the exposed API of the micro‑frontend.

---

### 3. Server-Side Composition

**How It Works:**
The server aggregates HTML fragments or renders the complete page by calling individual micro‑frontend services before sending it to the browser.

**Pros:**
• **SEO & Initial Load:** Pre-rendered content can be faster to display and better for SEO.
• **Consistent Experience:** Provides a cohesive experience since everything is stitched together before reaching the client.

**Cons:**
• **Increased Complexity:** Requires orchestration logic on the server and often tight coupling with server infrastructure.
• **Deployment Overhead:** Independent deployments can be more challenging as the server must coordinate versioning and integration.

---

### 4. Edge-Side Composition

**How It Works:**
Similar to server-side composition, but the aggregation happens at the CDN or edge (using technologies like AWS Lambda\@Edge or Cloudflare Workers).

**Pros:**
• **Performance:** Can reduce latency by composing pages closer to the user.
• **Scalability:** Offloads processing from your origin servers.

**Cons:**
• **Tooling Maturity:** Edge-side composition is still evolving and might lack robust tooling.
• **Complexity:** Managing deployments and debugging can be more difficult when using edge services.

---

### In Summary

* **Iframes** give excellent isolation but at the cost of performance and integration complexity.
* **Client-side approaches** (whether via plain JS orchestration, web components, dedicated frameworks, or module federation) offer a more seamless user experience and allow independent deployment, but they require thoughtful contracts (for mounting, communication, and shared dependencies).
* **Server- and Edge-side compositions** can improve initial load and SEO, but they bring their own challenges in orchestration and deployment.

Choosing the right implementation depends on factors like team structure, performance needs, and how much integration (or isolation) you require between different parts of your application.

([medium.com][1]) ([martinfowler.com][2])

[1]: https://medium.com/%40deepanshurtiwari/exploring-the-different-ways-to-implement-a-micro-frontend-architecture-from-iframes-to-api-b68b00d909d1 "Exploring the Different Ways to Implement a Micro Frontend ..."
[2]: https://martinfowler.com/articles/micro-frontends.html "Micro Frontends - Martin Fowler"
