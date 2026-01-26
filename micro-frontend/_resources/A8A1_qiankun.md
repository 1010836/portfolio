Qiankun is a thin wrapper around **single-spa** that hides most of the boilerplate you would otherwise write yourself.
Internally it still relies on the familiar `bootstrap → mount → unmount` lifecycle, but it adds production-quality niceties such as HTML-entry loading, JS sand-boxing, pre-fetching, style isolation and error handling.([qiankun.umijs.org][1], [qiankun.umijs.org][1])
Below is a **from-scratch guide** that ends with a working micro-frontend system using only **HTML 5 / CSS / vanilla JS** for each micro-app (no React/Vue/Angular), driven by the **Qiankun** library.

---

## 0  Prerequisites & concept map

| Item                      | Why it matters                            | Source                      |
| ------------------------- | ----------------------------------------- | --------------------------- |
| `single-spa` lifecycle    | Qiankun delegates to it                   | ([single-spa.js.org][2])    |
| Qiankun core (`qiankun`)  | Orchestrator we install                   | ([v1.qiankun.umijs.org][3]) |
| HTML Entry loader         | Lets Qiankun treat any URL as a micro-app | ([medium.com][4])           |
| Sandbox & style isolation | Prevents globals/CSS bleeding             | ([qiankun.umijs.org][5])    |

> **Folder layout used in the tutorial**

```
micro-frontends/
├─ master/          ← container app
├─ purehtml-app/    ← micro-app #1 (static HTML/JS)
└─ another-app/     ← (optional) extra micro-app
```

---

## 1  Create the master container

### 1.1 Install Qiankun

```bash
cd master
npm init -y
npm i qiankun --save
```

Qiankun can be added with Yarn or npm; it is framework-agnostic.([v1.qiankun.umijs.org][3])

### 1.2 Add a root HTML page

```html
<!-- master/index.html -->
<!DOCTYPE html>
<html lang="en">
<head><meta charset="UTF-8"><title>Qiankun-Master</title></head>
<body>
  <nav>
    <a href="#/purehtml">Pure HTML</a>
    <a href="#/another">Another</a>
  </nav>
  <div id="subapp-container"></div>

  <script type="module" src="./master.js"></script>
</body>
</html>
```

### 1.3 Register micro-apps & start Qiankun

```js
// master/master.js
import { registerMicroApps, start } from 'qiankun';

/* helper to decide when a sub-app is active */
const genActiveRule = (hash) => (location) => location.hash.startsWith(hash);

registerMicroApps([
  {
    name: 'purehtml',
    entry: '//localhost:7101',      // served by the micro-app
    container: '#subapp-container',
    activeRule: genActiveRule('#/purehtml'),
  },
  {
    name: 'another',
    entry: '//localhost:7102',
    container: '#subapp-container',
    activeRule: genActiveRule('#/another'),
  },
]);

start({
  prefetch: true,      // idle-time asset prefetching
  sandbox: { strictStyleIsolation: true }, // Shadow DOM per app
});
```

The snippet matches the official “Getting Started” guide.([v1.qiankun.umijs.org][3], [qiankun.umijs.org][5])
`start()` boots the router & sandbox; `prefetch` uses browser idle time to cache unopened apps.([qiankun.umijs.org][1])

---

## 2  Build a **vanilla-JS micro-app** (no bundler)

Qiankun’s *pure-html* recipe lets you use plain script files and still participate in the lifecycle.([qiankun.umijs.org][6], [github.com][7])

### 2.1 Static HTML shell

```html
<!-- purehtml-app/index.html served at http://localhost:7101 -->
<!DOCTYPE html>
<html lang="en">
<head><meta charset="UTF-8"><title>Pure HTML App</title></head>
<body>
  <div id="purehtml-container">Loading…</div>

  <!-- Qiankun will treat this as the “entry.js” -->
  <script src="./entry.js" entry></script>
</body>
</html>
```

The `entry` attribute tells Qiankun which script to evaluate first.([qiankun.umijs.org][6])

### 2.2 Expose lifecycle hooks

```js
// purehtml-app/entry.js
const render = (el) => {
  el.innerHTML = `
    <h2>Pure HTML Micro-App</h2>
    <p>The time is ${new Date().toLocaleTimeString()}</p>
  `;
  return Promise.resolve();
};

/* Qiankun looks for a global named after the app */
window['purehtml'] = {
  bootstrap: () => Promise.resolve(),        // called once
  mount:     () => render(document.getElementById('purehtml-container')),
  unmount:   () => {
    document.getElementById('purehtml-container').innerHTML = '';
    return Promise.resolve();
  },
};
```

Lifecycle names and calling order are inherited from single-spa.([single-spa.js.org][8], [single-spa.js.org][2])

### 2.3 Serve the micro-app

```bash
cd purehtml-app
npx serve -l 7101 .
```

Any static server that supports CORS works. Qiankun requires the micro-app’s assets to be CORS-accessible.([qiankun.umijs.org][6])

---

## 3  Run everything

1. **Start the master** (port 8080, for example):
   `npx serve -l 8080 master`
2. Open `http://localhost:8080` in the browser.
3. Navigate via the nav links; Qiankun will:

   * download each `entry.html`,
   * execute `entry.js` inside an *isolated JS sandbox*,
   * insert the app into the provided `container`.([qiankun.umijs.org][1])

At any moment only the active micro-app’s DOM is present because `unmount()` cleans up after route changes.

---

## 4  Concepts explained along the way

| Concept                 | Where you used it             | Explanation                                                                                                                                                                    |
| ----------------------- | ----------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **HTML Entry loader**   | `entry` attr in `index.html`  | Qiankun parses the HTML, inserts all `<script>`/`<link>` tags and rewrites URLs just like an iframe, then caches them for subsequent mounts.([medium.com][4])                  |
| **JS Sandbox**          | `start({sandbox:{…}})`        | Qiankun proxies `window` with `Proxy` to stop globals from leaking across apps; strict mode optionally wraps each app in Shadow DOM for CSS isolation.([qiankun.umijs.org][5]) |
| **Prefetch**            | `prefetch:true`               | Idle-time download of sub-app assets to speed up first mount.([qiankun.umijs.org][1])                                                                                          |
| **Active Rule**         | `genActiveRule('#/purehtml')` | A function that returns `true` if the URL matches; Qiankun then boots or tears down the app.([qiankun.umijs.org][6])                                                           |
| **Lifecycle functions** | `bootstrap / mount / unmount` | Required by single-spa; Qiankun just calls them for you.([single-spa.js.org][2])                                                                                               |

---

## 5  Can you really do this **without any framework?** ( Answer to 7.1 )

Yes.
Qiankun treats vanilla JS like any other sub-app as long as you:

1. Export the three lifecycle callbacks (either via `module.exports` in UMD or by attaching them to `window`).([qiankun.umijs.org][6])
2. Serve a valid HTML entry file that **uses absolute URLs or enables CORS** for its assets.([qiankun.umijs.org][6], [qiankun.umijs.org][9])

The official docs even provide an example called **purehtml** that relies on jQuery but could just as well be zero-dependency JavaScript.([github.com][7])
What you *lose* by forgoing a bundler is tree-shaking, automatic UMD output and convenient asset hashing—nothing intrinsic to Qiankun itself.

---

## 6  Next steps & production hardening

* **Bundle optimisation** – if size matters, bundle micro-apps with Rollup or esbuild and output `umd`; Qiankun will still load them.([qiankun.umijs.org][6])
* **Shared dependencies** – avoid it when possible, but you can externalise libraries in each sub-app and load them once in the master.([qiankun.umijs.org][9])
* **Shadow DOM vs. CSS prefixes** – strict isolation (`strictStyleIsolation:true`) costs \~3 ms extra per mount; experimental selector rewriting is faster but limited (no `@keyframes`).([qiankun.umijs.org][5])

With these steps you now have a running micro-frontend architecture powered by Qiankun and **zero UI frameworks**—ready to be extended with as many independently deployed HTML/JS slices as you need.

[1]: https://qiankun.umijs.org/guide?utm_source=chatgpt.com "Introduction - qiankun - UmiJS"
[2]: https://single-spa.js.org/docs/building-applications/?utm_source=chatgpt.com "Building single-spa applications"
[3]: https://v1.qiankun.umijs.org/guide/getting-started.html "Getting Started | qiankun"
[4]: https://medium.com/%40haiou-a/unveiling-the-secrets-of-micro-frontends-the-power-of-import-html-entry-c08570ccf874?utm_source=chatgpt.com "Unveiling the Secrets of Micro-Frontends: The Power of import-html ..."
[5]: https://qiankun.umijs.org/api?utm_source=chatgpt.com "API - qiankun"
[6]: https://qiankun.umijs.org/guide/tutorial "project practise - qiankun"
[7]: https://github.com/mowatermelon/test-qiankun-pureHtml?utm_source=chatgpt.com "mowatermelon/test-qiankun-pureHtml: 测试在乾坤项目中 ... - GitHub"
[8]: https://single-spa.js.org/docs/configuration/?utm_source=chatgpt.com "Configuring single-spa"
[9]: https://qiankun.umijs.org/faq?utm_source=chatgpt.com "FAQ - qiankun - UmiJS"
