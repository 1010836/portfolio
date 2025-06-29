Below is a **from-scratch, framework-free recipe** for implementing a micro-frontend architecture in which **each feature ship is a Web Component**.
Follow the steps in order and you will end up with a working demo that you can serve locally (or deploy behind any static-site host) without needing React, Angular, or any orchestration library.

---

## 0. Prerequisites & Core Ideas

| Concept                | Why it matters                                                   | Key spec / reference                         |
| ---------------------- | ---------------------------------------------------------------- | -------------------------------------------- |
| **Custom Elements v1** | lets you register new HTML tags (`customElements.define`)        | ([developer.mozilla.org][1])                 |
| **Shadow DOM**         | provides style & markup encapsulation for each micro-frontend    | ([developer.mozilla.org][2])                 |
| **HTML `<template>`**  | reusable markup blueprint you can stamp into a shadow tree       | ([developer.mozilla.org][3])                 |
| **ES Modules**         | every micro-frontend ships as a self-contained JavaScript module | ([microfrontend.dev][4])                     |
| **Custom Events**      | lightweight pub/sub channel between isolated components          | ([blog.bitsrc.io][5], [thoughtworks.com][6]) |

You only need a recent evergreen browser and **Node 18+** (for the dev server).

---

## 1. Scaffold the Workspace

```bash
mkdir microfe-wc && cd microfe-wc
mkdir container mfe-header mfe-products mfe-cart
npm init -y                    # creates a package.json in root
npm install --save-dev http-server
```

> `http-server` is a zero-config static server handy for demos. ([npmjs.com][7])

Directory layout:

```
microfe-wc/
  container/index.html
  mfe-header/header.js
  mfe-products/products.js
  mfe-cart/cart.js
```

---

## 2. Build the **Header** Micro-frontend (`<mf-header>`)

### 2.1 Create the Web Component

`mfe-header/header.js`

```js
const template = document.createElement('template');
template.innerHTML = /*html*/`
  <style>
    :host{display:block;background:#0d6efd;color:#fff;font:600 1rem/1.2 sans-serif;padding:1rem}
    h1{margin:0;font-size:1.25rem}
  </style>
  <h1>🛍️ My Shop</h1>
`;

class MfHeader extends HTMLElement {
  constructor(){
    super();
    this.attachShadow({mode:'open'}).append(template.content.cloneNode(true));
  }
}
customElements.define('mf-header', MfHeader); // Custom Element registry
```

* **Custom Elements** provide the lifecycle & registry. ([developer.mozilla.org][1])
* **Shadow DOM** keeps styles from leaking out or in. ([developer.mozilla.org][2])

---

## 3. Build the **Product List** Micro-frontend (`<mf-products>`)

`mfe-products/products.js`

```js
const tpl = document.createElement('template');
tpl.innerHTML = /*html*/`
  <style>
    :host{display:block;padding:1rem;font-family:sans-serif}
    ul{display:grid;gap:.5rem;padding:0;list-style:none}
    li{border:1px solid #ccc;padding:.5rem;border-radius:.25rem}
    button{margin-top:.25rem}
  </style>
  <h2>Products</h2>
  <ul id="list"></ul>
`;

class MfProducts extends HTMLElement {
  #items = [
    {id:1,name:'T-Shirt',price:19.9},
    {id:2,name:'Cap',price:9.9},
    {id:3,name:'Shoes',price:49.9}
  ];
  constructor(){
    super();
    const root = this.attachShadow({mode:'open'});
    root.append(tpl.content.cloneNode(true));
    const ul = root.getElementById('list');
    this.#items.forEach(p=>{
      const li=document.createElement('li');
      li.innerHTML = `
        <strong>${p.name}</strong> – €${p.price}
        <br><button>Add to cart</button>`;
      li.querySelector('button')
        .addEventListener('click',()=>this.#add(p));
      ul.append(li);
    });
  }
  #add(product){
    // Bubble a Custom Event so any ancestor (container or another MFE) can listen
    this.dispatchEvent(new CustomEvent('add-to-cart',{
      detail:product,bubbles:true,composed:true
    }));
  }
}
customElements.define('mf-products', MfProducts);
```

* The **template API** avoids string-concatenation quirks and boosts perf. ([developer.mozilla.org][3], [developer.mozilla.org][8])
* `{bubbles:true, composed:true}` lets the event escape the shadow boundary. ([blog.bitsrc.io][5], [thoughtworks.com][6])

---

## 4. Build the **Cart** Micro-frontend (`<mf-cart>`)

`mfe-cart/cart.js`

```js
const tpl = document.createElement('template');
tpl.innerHTML = /*html*/`
  <style>
    :host{display:block;padding:1rem;background:#f5f5f5;font-family:sans-serif}
    li{margin:.25rem 0}
  </style>
  <h2>Cart (<span id="count">0</span>)</h2>
  <ul id="items"></ul>
`;

class MfCart extends HTMLElement{
  #items=[];
  constructor(){
    super();
    const root=this.attachShadow({mode:'open'});
    root.append(tpl.content.cloneNode(true));
    this.counter=root.getElementById('count');
    this.list=root.getElementById('items');
  }
  /** listens for Custom Events coming from siblings */
  connectedCallback(){
    window.addEventListener('add-to-cart',e=>this.#onAdd(e.detail));
  }
  #onAdd(item){
    this.#items.push(item);
    this.counter.textContent=this.#items.length;
    const li=document.createElement('li');
    li.textContent=`${item.name} – €${item.price}`;
    this.list.append(li);
  }
}
customElements.define('mf-cart', MfCart);
```

* **Decentralised event bus**: any component, regardless of framework, can throw a DOM event; others can subscribe. ([raz-levy.medium.com][9], [thoughtworks.com][6])

---

## 5. Compose in the **Container Shell**

`container/index.html`

```html
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Micro-FE (Web Components)</title>
</head>
<body>
  <!-- 1️⃣  Import each remote bundle -->
  <script type="module" src="../mfe-header/header.js"></script>
  <script type="module" src="../mfe-products/products.js"></script>
  <script type="module" src="../mfe-cart/cart.js"></script>

  <!-- 2️⃣  Drop custom elements just like native tags -->
  <mf-header></mf-header>
  <mf-products></mf-products>
  <mf-cart></mf-cart>

  <!-- 3️⃣  Optional global listener for analytics or SSR -->
  <script>
    document.addEventListener('add-to-cart',e=>{
      console.log('Analytics: added',e.detail);
    });
  </script>
</body>
</html>
```

* The shell’s job is **only integration**—no inner knowledge of each micro-frontend. That isolation is the essence of micro-frontends. ([microfrontend.dev][4], [microfrontend.dev][4])

---

## 6. Run the Demo

```bash
# from the root (microfe-wc)
npx http-server -p 8080
```

Open `http://localhost:8080/container/` and test:
click **Add to cart**; the cart counter updates, and a console log appears.

---

## 7. Going Further

| Enhancement                             | How                                                                           | Reference                            |
| --------------------------------------- | ----------------------------------------------------------------------------- | ------------------------------------ |
| **Style hooks**                         | expose internals via `::part()` selectors for design-system theming           | ([developer.mozilla.org][10])        |
| **Lazy loading per micro-frontend**     | use `<script type="module" src>` + `import()` to load on demand               | ([eduardo-ottaviani.medium.com][11]) |
| **Independent deployment**              | host each `/mfe-*` folder on different origins; shell points to absolute URLs | ([xenonstack.com][12])               |
| **Polyfills for legacy browsers**       | load `@webcomponents/custom-elements` only where needed                       | ([blog.pixelfreestudio.com][13])     |
| **Native Module Federation** (optional) | combine with `import-maps` or WICG `scope` for shared deps                    | ([medium.com][14])                   |

---

### Why Web Components fit Micro-Frontends

* **Framework-agnostic**: a Vue team, a Lit team, and a “vanilla” team can all deliver `<mf-*>` tags the shell understands. ([microfrontend.dev][4])
* **True runtime isolation** (styles & DOM) without iframes. ([developer.mozilla.org][2], [medium.com][14])
* **Native browser APIs**—no heavy orchestration bundle, so first-paint stays fast. ([developer.mozilla.org][15])

Follow the steps above, and you have a **production-readable, standards-only micro-frontend**—ready for CI/CD and team autonomy. Happy modularizing!

[1]: https://developer.mozilla.org/en-US/docs/Web/API/Web_components/Using_custom_elements?utm_source=chatgpt.com "Using custom elements - Web APIs | MDN"
[2]: https://developer.mozilla.org/en-US/docs/Web/API/Web_components/Using_shadow_DOM?utm_source=chatgpt.com "Using shadow DOM - Web APIs | MDN"
[3]: https://developer.mozilla.org/en-US/docs/Web/HTML/Reference/Elements/template?utm_source=chatgpt.com "The Content Template element - HTML - MDN Web Docs - Mozilla"
[4]: https://www.microfrontend.dev/web-standards/micro-frontends-web-components/?utm_source=chatgpt.com "Micro-frontends and Web Components"
[5]: https://blog.bitsrc.io/sharing-data-between-web-components-using-custom-events-7eff301625d2?utm_source=chatgpt.com "Sharing Data Between Web Components Using Custom Events"
[6]: https://www.thoughtworks.com/en-us/insights/blog/architecture/cross-micro-frontend-communication?utm_source=chatgpt.com "Techniques for cross micro frontend communication - Thoughtworks"
[7]: https://www.npmjs.com/package/http-server?utm_source=chatgpt.com "http-server - NPM"
[8]: https://developer.mozilla.org/en-US/docs/Web/API/HTMLTemplateElement?utm_source=chatgpt.com "HTMLTemplateElement - Web APIs | MDN"
[9]: https://raz-levy.medium.com/communicating-between-micro-frontends-using-custom-events-in-react-js-e3dab0571edb?utm_source=chatgpt.com "Communicating between Micro Frontends using Custom Events in ..."
[10]: https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_shadow_parts?utm_source=chatgpt.com "CSS shadow parts - MDN Web Docs"
[11]: https://eduardo-ottaviani.medium.com/web-components-a-practical-perspective-using-custom-elements-7523a6462387?utm_source=chatgpt.com "Web Components — A Practical Perspective Using Custom Elements"
[12]: https://www.xenonstack.com/insights/micro-frontend-architecture?utm_source=chatgpt.com "Micro Frontend Architecture and Best Practices - XenonStack"
[13]: https://blog.pixelfreestudio.com/the-role-of-web-components-in-micro-frontends/?utm_source=chatgpt.com "The Role of Web Components in Micro Frontends"
[14]: https://medium.com/%40mmeraj/mastering-micro-frontends-a-web-component-adventure-and-the-lessons-learned-e2584a67dc1f?utm_source=chatgpt.com "Mastering Micro Frontends: A Web-Component Adventure and the ..."
[15]: https://developer.mozilla.org/en-US/docs/Web/API/Web_components?utm_source=chatgpt.com "Web Components - Web APIs - MDN Web Docs - Mozilla"
