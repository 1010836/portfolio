Below is a practical, cite-rich primer on building client-side micro-frontends with an orchestration **library/framework** (option 3).
I first compare the popular choices and explain why **Single-SPA** is usually the fastest free way to start; then I walk you through a vanilla-JS “Hello-MFE” that you can clone and run in minutes.  Every step ends with a short “Concept check” so you see *why* you’re doing it.

---

## 1  Choosing a framework/library

| Criterion               | Single-SPA                                                               | Qiankun                                                                   | Piral                                                | Luigi                                                            |
| ----------------------- | ------------------------------------------------------------------------ | ------------------------------------------------------------------------- | ---------------------------------------------------- | ---------------------------------------------------------------- |
| Licence                 | MIT (free) ([github.com][1])                                             | MIT (free) ([github.com][2])                                              | MIT (free) ([github.com][3])                         | Apache-2.0 (free) ([luigi-project.io][4])                        |
| Install size, first run | ≈ 8 kB core; CLI scaffolds root/app in < 30 s ([single-spa.js.org][5])   | Adds sandbox & prefetching → larger bundle ([qiankun.umijs.org][6])       | Runtime + “pilet” tooling, heavier ([github.com][3]) | Focused on SAP apps, opinionated routing ([luigi-project.io][4]) |
| Learning curve          | Low—single *root-config* + app lifecycles                                | Very similar (built on Single-SPA) but more APIs ([qiankun.umijs.org][7]) | Additional conventions (pilets/feeds)                | Admin-UI oriented                                                |
| Vanilla-JS support      | `single-spa-html` helper ([github.com][8])                               | “purehtml” example ([qiankun.umijs.org][9])                               | Possible but undocumented                            | Limited                                                          |
| Community / docs        | Large, 8 years, many plugins ([single-spa.js.org][10], [github.com][11]) | Enterprise-backed by Ant Group ([qiankun.umijs.org][7])                   | Active but smaller                                   | Niche                                                            |

**Recommendation:**
Pick **Single-SPA** for the simplest, framework-agnostic, completely free starting point; you can still migrate to Qiankun later because Qiankun re-uses Single-SPA lifecycles ([qiankun.umijs.org][7]).

---

## 2  Step-by-step: build a working micro-frontend with Single-SPA

### 2.0  Prerequisites

* **Node ≥ 18** and **npm / pnpm / yarn**
* Git (optional for cloning)
* Ports **9000** (root) and **9001…** (micro-apps) free

---

### 2.1  Scaffold the *root-config*

```bash
# inside an empty folder
npx create-single-spa --moduleType root-config
cd <your-org>-root-config
npm start        # dev server on http://localhost:9000
```

*Concept check* – The **root-config** is the *orchestrator*.
It hosts an *import-map* (ESM URLs) and registers apps via `registerApplication` so Single-SPA can mount/unmount them when routes change ([single-spa.js.org][5]).

---

### 2.2  Create a *vanilla JS* micro-app

```bash
# back in your workspace root
npx create-single-spa --moduleType app-parcel \
     --framework none \
     --orgName demo --projectName navbar
cd navbar
npm start        # serves on http://localhost:9001
```

> **Why “none”?** The generator supports `--framework none`, which produces a minimal HTML + JS parcel that relies only on the helper package `single-spa-html` for lifecycle glue ([github.com][8]).

*Example code (`src/navbar.js`)*

```js
import singleSpaHtml from 'single-spa-html';

const htmlLifecycles = singleSpaHtml({
  template: () => `<nav><a href="/">Home</a> | <a href="/about">About</a></nav>`
});

export const { bootstrap, mount, unmount } = htmlLifecycles;
```

*Concept check* – `single-spa-html` wraps a plain template string into the **bootstrap / mount / unmount** functions that Single-SPA expects. No React/Vue/Angular required.

---

### 2.3  Wire the micro-app into the root-config

Edit `root-config/src/root-config.js`:

```js
import { registerApplication, start } from 'single-spa';

registerApplication({
  name: '@demo/navbar',
  app: () => System.import('@demo/navbar'),
  activeWhen: ['/']          // show on every route
});

start();   // important: starts the Single-SPA runtime
```

Add the URL to the import-map (`root-config/src/index.ejs`):

```json
"imports": {
  "@demo/navbar": "//localhost:9001/navbar.js"
}
```

*Concept check* –  **Import maps** let the browser resolve bare module names; Single-SPA just calls `System.import()` to fetch each micro-bundle lazily ([single-spa.js.org][5]).

---

### 2.4  Run everything together

```bash
# two terminals
cd <your-org>-root-config && npm start   # ⬅ root on :9000
cd navbar && npm start                   # ⬅ micro-app on :9001
```

Open **[http://localhost:9000](http://localhost:9000)** – the navbar appears and stays mounted while you navigate (route prefix `/`) because Single-SPA’s router watches `popstate` and hash events ([single-spa.js.org][10]).

---

### 2.5  Add more micro-frontends (repeat)

* Scaffold `npx create-single-spa --moduleType app-parcel --framework none --projectName footer`
* Register it with `activeWhen: ['/about']` so it only shows on the “/about” page
* Optionally share common libraries (e.g., React) via the root import-map to avoid duplicate code ([single-spa.js.org][5]).

---

### 2.6  Build for production

```bash
cd navbar && npm run build
cd ../<root-config> && npm run build
# deploy the two dist/ folders to your static host or CDN
```

Because each micro-app ships as an independent bundle, teams can deploy on their own cadence – the essence of micro-frontends ([martinfowler.com][12]).

---

## 3  Related concepts at each step

| Step | Term                                             | Meaning & relevance                                                                                                                     |
| ---- | ------------------------------------------------ | --------------------------------------------------------------------------------------------------------------------------------------- |
| 2.1  | **Root-config**                                  | Boots Single-SPA, owns global routing and import-map.                                                                                   |
| 2.2  | **Parcel**                                       | A lightweight micro-app that does *not* have its own router; perfect for vanilla components ([single-spa.js.org][5]).                   |
| 2.3  | **Lifecycles** (`bootstrap`, `mount`, `unmount`) | Clear contract so different technologies can coexist safely ([qiankun.umijs.org][9]).                                                   |
| 2.4  | **In-browser module resolution**                 | Uses SystemJS & import-maps; avoids rebuilds when adding an app ([single-spa.js.org][5]).                                               |
| 2.5  | **Independent deployment**                       | Each repo → its own CI/CD → versioned URL; the root just updates the import-map – the core promise of MFEs ([microfrontends.info][13]). |
| 2.6  | **Shared dependencies**                          | Prevents duplicate React/Vue copies; controlled centrally to keep bundle size small ([single-spa.js.org][5]).                           |

---

## 4  Can I do this with “just HTML + CSS + JS”?

**Yes.**
*Single-SPA* ships `single-spa-html`, and Qiankun maintains a “pure-html” example; both mount a fragment created with template strings or Web Components – zero UI frameworks required ([github.com][8], [qiankun.umijs.org][9]).

You still need a **tiny** orchestration runtime (Single-SPA or Qiankun) because browsers alone do not provide lifecycle management across multiple independent bundles.

---

## 5  Where to go next

* **Playground** – experiment live at *single-spa-playground.org* ([github.com][14])
* **Qiankun** – switch to a richer sandbox/prefetch layer later (just replace `registerApplication` calls with `registerMicroApps`) ([qiankun.umijs.org][9])
* **Community articles** – updated lists of frameworks and trade-offs for 2024 ([dev.to][15], [linkedin.com][16])

With these steps you now own a fully working, vanilla-JS micro-frontend skeleton that you can extend one micro-app at a time. Happy decoupling!

[1]: https://github.com/single-spa/create-single-spa/blob/main/LICENSE?utm_source=chatgpt.com "create-single-spa/LICENSE at main - GitHub"
[2]: https://github.com/umijs/qiankun/blob/master/LICENSE?utm_source=chatgpt.com "qiankun/LICENSE at master - GitHub"
[3]: https://github.com/smapiot/piral "GitHub - smapiot/piral:  Framework for next generation web apps using micro frontends. ⭐️ Star to support our work!"
[4]: https://luigi-project.io/?utm_source=chatgpt.com "Luigi - The Enterprise-Ready Micro Frontend Framework"
[5]: https://single-spa.js.org/docs/getting-started-overview/ "Getting Started with single-spa | single-spa"
[6]: https://qiankun.umijs.org/?utm_source=chatgpt.com "qiankun - qiankun"
[7]: https://qiankun.umijs.org/guide "Introduction - qiankun"
[8]: https://github.com/single-spa/single-spa-html "GitHub - single-spa/single-spa-html: A helper library for single-spa and vanilla html / web components"
[9]: https://qiankun.umijs.org/guide/getting-started "Getting Started - qiankun"
[10]: https://single-spa.js.org/docs/microfrontends-concept/?utm_source=chatgpt.com "Microfrontends Overview - Single SPA"
[11]: https://github.com/single-spa/single-spa-preact?utm_source=chatgpt.com "a single-spa plugin for preact applications - GitHub"
[12]: https://martinfowler.com/articles/micro-frontends.html?utm_source=chatgpt.com "Micro Frontends - Martin Fowler"
[13]: https://microfrontends.info/?utm_source=chatgpt.com "Microfrontends"
[14]: https://github.com/single-spa/single-spa-playground?utm_source=chatgpt.com "A website that helps you set up single-spa - GitHub"
[15]: https://dev.to/lakincoder/micro-frontend-frameworks-in-2024-265f "Micro frontend frameworks in 2024 - DEV Community"
[16]: https://www.linkedin.com/pulse/best-5-micro-front-end-frameworks-every-developer-should-adnan-i2qbc "Best 5 Micro Front-end Frameworks Every Developer Should Know"
