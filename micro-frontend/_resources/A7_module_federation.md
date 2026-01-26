Below is a **framework-agnostic, vanilla-JS walk-through** that will take you from an empty folder to two independently-deployable micro-frontends (a **host / shell** on port 3000 and a **remote** on port 3001) composed at run-time with **Webpack 5 Module Federation**.
When you finish the last command you will see a button rendered in the shell that actually lives in the remote bundle—proof that the micro-frontend is working.

---

## Why Module Federation?

* **Module Federation** is a high-level Webpack plug-in that lets **separate builds act like one application** by downloading remote bundles at run-time instead of build-time([webpack.js.org][1], [dev.to][2]).
* The pattern introduces clear roles: a **host/container**, one or more **remotes**, the **exposes** list (what a remote makes public) and the **remotes** list (what the host consumes)([medium.com][3]).
* Because everything is standard JavaScript, you can use it with **plain HTML + CSS + JS**—no React, Angular or Single-SPA required([github.com][4], [singhdheerendra.medium.com][5]).

---

## Project layout & prerequisites

```text
microfed-demo/
 ├─ shell/          # host application (port 3000)
 │   ├─ src/
 │   └─ webpack.shell.config.js
 └─ remote/         # micro-frontend (port 3001)
     ├─ src/
     └─ webpack.remote.config.js
```

> **Requirements**
>
> * Node ≥ 18 & npm
> * No global webpack install – we’ll use local dev-deps
> * Any static HTTP server for production deploys (optional)

---

## Step-by-step guide

### 1 – Scaffold both apps

```bash
mkdir microfed-demo && cd microfed-demo
mkdir shell remote
npm init -y
npm i -D webpack webpack-cli webpack-dev-server html-webpack-plugin
```

Each micro-frontend is a **separate build** so they will share the dev dependencies but keep **individual webpack configs** and **dev-server ports**([github.com][4]).

---

### 2 – Write the remote’s feature code

`remote/src/button.js`

```js
export default function renderButton(targetId) {
  const btn = document.createElement('button');
  btn.textContent = 'Remote Button';
  btn.onclick = () => alert('Hello from the remote MFE!');
  document.getElementById(targetId).appendChild(btn);
}
```

`remote/src/index.js`

```js
// give the host a stable API
import renderButton from './button.js';
window.renderRemoteButton = renderButton;
```

The remote **exports a normal ES module**; Module Federation will later expose it under an alias([dev.to][2]).

---

### 3 – Configure webpack for the remote (port 3001)

`remote/webpack.remote.config.js`

```js
const HtmlWebpackPlugin = require('html-webpack-plugin');
const { ModuleFederationPlugin } = require('webpack').container;

module.exports = {
  mode: 'development',
  entry: './src/index.js',
  devServer: { port: 3001, static: false },
  output: {
    publicPath: 'auto',         // lets webpack figure it out at runtime
    uniqueName: 'remote',       // prevents runtime collisions:contentReference[oaicite:5]{index=5}
  },
  plugins: [
    new ModuleFederationPlugin({
      name: 'remote',                // global var in remoteEntry.js
      filename: 'remoteEntry.js',    // the file the host will load
      exposes: {
        './renderButton': './src/button.js',  // key = public path
      },
      shared: {},                    // nothing to share in pure JS
    }),
    new HtmlWebpackPlugin({ template: './public/index.html' }),
  ],
};
```

*`publicPath:"auto"` is the simplest way to ensure assets load correctly regardless of host URL([webpack.js.org][1]).*

---

### 4 – Configure webpack for the shell (port 3000)

`shell/webpack.shell.config.js`

```js
const HtmlWebpackPlugin = require('html-webpack-plugin');
const { ModuleFederationPlugin } = require('webpack').container;

module.exports = {
  mode: 'development',
  entry: './src/index.js',
  devServer: { port: 3000, static: false },
  output: { publicPath: 'auto', uniqueName: 'shell' },
  plugins: [
    new ModuleFederationPlugin({
      name: 'shell',
      remotes: {
        // localAlias : globalName@url
        remote: 'remote@http://localhost:3001/remoteEntry.js',
      },                                              // :contentReference[oaicite:7]{index=7}
      shared: {},
    }),
    new HtmlWebpackPlugin({ template: './public/index.html' }),
  ],
};
```

The `remotes` string follows the `localName: "remoteGlobal@url"` syntax explained in the StackOverflow answer([stackoverflow.com][6]).

---

### 5 – Add shell source code + async “bootstrap” boundary

`shell/src/index.js`

```js
// Async boundary keeps initial chunk small – recommended by webpack docs
import('./bootstrap');
```

`shell/src/bootstrap.js`

```js
(async () => {
  // Dynamic import pulls the exposed module from the remote
  const { default: renderButton } = await import('remote/renderButton');
  renderButton('host-root');
})();
```

Using an **asynchronous boundary** (`import('./bootstrap')`) is a best practice to avoid the “shared module is not available for eager consumption” error([webpack.js.org][1]).

---

### 6 – Minimal HTML templates

`remote/public/index.html` and `shell/public/index.html` are identical except for titles:

```html
<!doctype html>
<html>
  <head><meta charset="utf-8"><title>Shell</title></head>
  <body>
    <h1>Shell host (port 3000)</h1>
    <div id="host-root"></div>
  </body>
</html>
```

Webpack injects the correct `<script>` tags for you.

---

### 7 – Run everything

Add convenience scripts to **root** `package.json`:

```jsonc
"scripts": {
  "start:shell": "webpack serve --config shell/webpack.shell.config.js",
  "start:remote": "webpack serve --config remote/webpack.remote.config.js"
}
```

Now start both terminals:

```bash
npm run start:remote   # first terminal – port 3001
npm run start:shell    # second terminal – port 3000
```

Navigate to **[http://localhost:3000](http://localhost:3000)**; the button from the remote appears and functions.
The host downloaded `remoteEntry.js`, executed it, and lazily imported `renderButton` at run-time—exactly how Module Federation composes micro-frontends([webpack.js.org][1], [medium.com][3], [webpack.js.org][1]).

---

### 8 – (Optionally) build for production

```bash
npx webpack --config remote/webpack.remote.config.js
npx webpack --config shell/webpack.shell.config.js
```

Deploy the two `/dist` folders behind **any CDN or static server**; as long as the shell’s `remotes` URL points to the remote’s `remoteEntry.js`, the composition works in production([angulararchitects.io][7], [dev.to][2]).

---

## Concept recap

| Term                 | Meaning                                                                                                                                    |
| -------------------- | ------------------------------------------------------------------------------------------------------------------------------------------ |
| **Host / container** | The currently running build that *consumes* remotes([medium.com][3])                                                                       |
| **Remote**           | A separately compiled build that *exposes* modules to others([medium.com][3])                                                              |
| **remoteEntry.js**   | Auto-generated bundle that registers the remote at run-time([webpack.js.org][1])                                                           |
| **exposes**          | Map of *public* modules a remote makes available([dev.to][2])                                                                              |
| **remotes**          | Map of remote names and URLs the host can import from([stackoverflow.com][6])                                                              |
| **Shared**           | (Optional) list of libraries that should be singletons across MFEs; not needed in vanilla JS but vital for React/Angular etc.([dev.to][2]) |

---

## Next steps

* **Share common utilities** by putting them in the `shared` section so they download once.
* Use **dynamic remote URLs** (promise syntax) if your remotes are versioned or live in different environments([webpack.js.org][1]).
* Combine Module Federation with **Custom Elements** to get framework-independent, self-contained DOM components for even cleaner integration([github.com][4], [singhdheerendra.medium.com][5]).

With these fundamentals you now have a working, extensible micro-frontend architecture powered purely by HTML 5, CSS and vanilla JavaScript—no heavy frameworks required.

[1]: https://webpack.js.org/concepts/module-federation/ "Module Federation | webpack"
[2]: https://dev.to/bitovi/how-to-build-a-micro-frontend-with-webpacks-module-federation-plugin-n41 "How to Build a Micro Frontend with Webpack's Module Federation Plugin - DEV Community"
[3]: https://medium.com/walmartglobaltech/module-federation-using-webpack-5-the-micro-frontend-journey-719688c5d73b "Module Federation using Webpack 5. The Micro-frontend journey. | by Priya Lakshman | Walmart Global Tech Blog | Medium"
[4]: https://github.com/jolares/example-vanilla-custom-elements-module-federation "GitHub - jolares/example-vanilla-custom-elements-module-federation: Lazy load multiple vanilla custom-element micro-frontend (MFEs) applications within a shell/host application using the Module Federation concept."
[5]: https://singhdheerendra.medium.com/implementing-multi-framework-in-vanilla-js-with-native-federation-d7580f571a7d "Implementing Multi-Framework in Vanilla JS with Native Federation | by Dheerendra Singh | Medium"
[6]: https://stackoverflow.com/questions/66557565/modulefederationplugins-remote-property-syntax "webpack module federation - ModuleFederationPlugin's remote property syntax - Stack Overflow"
[7]: https://www.angulararchitects.io/blog/the-microfrontend-revolution-module-federation-in-webpack-5/?utm_source=chatgpt.com "The Microfrontend Revolution: Module Federation in Webpack 5"
