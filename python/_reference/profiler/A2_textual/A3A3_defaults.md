You are absolutely correct. Your understanding is spot on.

Every widget in Textual, from simple ones like `Label` to complex containers like `Vertical` or `Horizontal`, comes with a set of default TCSS styles. These defaults are crucial because they ensure that widgets are functional and visually sensible "out of the box" without you needing to style every single property from scratch.

This is similar to how an unstyled `<button>` in a web browser still looks and acts like a button. Textual provides these foundational styles in a "user-agent stylesheet" that is always loaded first.

### The Source of Default Styles

The default styles for each widget are defined in a special class variable called `DEFAULT_CSS` within the widget's source code. When Textual renders a widget, it applies the styles from `DEFAULT_CSS` first. Then, it layers any styles from your custom stylesheet (`CSS_PATH`) on top, which can override the defaults.

### Explanation of Common Default Settings

Let's explore the default styles for some of the most common widgets.

#### 1. Container Widgets (`Vertical`, `Horizontal`, `Container`, `Screen`)

These widgets are designed to hold and arrange other widgets. Their defaults are all about layout.

*   **`Vertical` / `VerticalScroll` / `Screen`**:
    *   `layout: vertical;` This is their most important default. It makes them stack their children one on top of another.
    *   `overflow-y: auto;` (for `VerticalScroll` and `Screen`): This automatically adds a vertical scrollbar if the content inside grows taller than the container.
    *   `width: 100%; height: 100%;` (for `Screen`): Ensures the screen fills the entire available space.

*   **`Horizontal` / `HorizontalScroll`**:
    *   `layout: horizontal;` This makes them arrange their children side-by-side.
    *   `width: 100%; height: auto;`: By default, a horizontal container will span the full width available and its height will adjust to fit the tallest child widget.
    *   `overflow-x: auto;` (for `HorizontalScroll`): Adds a horizontal scrollbar if the children are wider than the container.

#### 2. Basic Content Widgets (`Label`, `Static`)

These are the simplest widgets for displaying text.

*   **`Label`**:
    *   `width: auto; height: 1;`: A `Label`'s width will shrink to fit its text content, and it will occupy a single line (one terminal cell high).
    *   `content-align: left middle;`: The text inside the label is aligned to the left and vertically centered within its single-line height.

*   **`Static`**:
    *   Very similar to `Label`, but often used for multi-line text blocks.
    *   `height: auto;`: The height will grow to accommodate the number of lines in its text.

#### 3. Interactive Widgets (`Button`, `Input`)

These widgets have more complex styles, including pseudo-classes for different states (`:hover`, `:focus`).

*   **`Button`**:
    *   `width: auto; height: 1;`: Like a `Label`, a button's width defaults to fitting its label text.
    *   `padding: 0 1;`: Adds one cell of padding on the left and right of the button's label, giving it some breathing room.
    *   `content-align: center middle;`: The button's label text is centered both horizontally and vertically.
    *   **Pseudo-classes**: It has default styles for `:hover` to change the background/text color when the mouse is over it, making it feel interactive.

*   **`Input`**:
    *   `height: 1;`: An input is a single-line widget by default.
    *   `padding: 0 1;`: Adds padding so the text you type doesn't touch the edges.
    *   `background: ...; color: ...;`: Has default colors to distinguish it from the background.
    *   **Pseudo-classes**: Has a distinct style for `:focus` (when your cursor is inside it) to visually indicate that it's active. This often involves changing the background color or adding an outline.

### Summary Table of Key Defaults

| Widget | Key Default TCSS Properties | Purpose & Explanation |
| :--- | :--- | :--- |
| **`Screen`** | `layout: vertical;`<br>`overflow-y: auto;`<br>`width: 100%; height: 100%;` | The base of your app. Stacks content vertically, scrolls if needed, and fills the whole screen. |
| **`Vertical`** | `layout: vertical;` | Stacks its children one below the other. |
| **`Horizontal`** | `layout: horizontal;`<br>`height: auto;` | Arranges children side-by-side. Its height grows to fit the tallest child. |
| **`Label`** | `width: auto;`<br>`height: 1;` | A non-expanding, single-line text widget. |
| **`Static`** | `width: auto;`<br>`height: auto;` | A text widget that can expand vertically for multiple lines. |
| **`Button`** | `width: auto; height: 1;`<br>`padding: 0 1;`<br>`content-align: center middle;` | A self-sizing, single-line button with centered text and horizontal padding. |
| **`Input`** | `height: 1;`<br>`padding: 0 1;` | A single-line text entry field with internal padding. |


### 1. Official Textual Documentation (Most Important)

These are the primary resources you should use. They explain the concepts and document the available widgets and CSS properties.

*   **Textual Widgets Documentation**: This is the main reference for all built-in widgets. Each widget page (e.g., Button, Input, etc.) describes its purpose and often implies its default behavior through the explanation of its features.
    *   **Direct Link:** [https://textual.textualize.io/widgets/](https://textual.textualize.io/widgets/)

*   **Styling Guide**: This section of the documentation is crucial. It explains how the styling system works, covering the box model (margin, padding, border), layout, and dimensions. Understanding these principles helps you infer how an unstyled widget will behave.
    *   **Direct Link:** [https://textual.textualize.io/guide/styles/](https://textual.textualize.io/guide/styles/)

*   **Textual CSS Reference**: This page explains the `DEFAULT_CSS` concept directly. It states that built-in widgets bundle their CSS this way, which is why they are styled without you needing to write any initial CSS.
    *   **Direct Link:** [https://textual.textualize.io/guide/css/](https://textual.textualize.io/guide/css/)

### 2. The Definitive Source: Textual's GitHub Repository

For the absolute ground truth, you can look directly at the source code. Every widget's default styles are defined in a class variable called `DEFAULT_CSS`.

*   **How to Find Default Styles:**
    1.  Go to the Textual GitHub repository: [https://github.com/Textualize/textual](https://github.com/Textualize/textual)
    2.  Navigate to the `src/textual/widgets/` directory.
    3.  Open the Python file for the widget you're interested in (e.g., `_button.py` for the Button widget).
    4.  Look for the `DEFAULT_CSS` class variable near the top of the class definition.

*   **Direct Links to Common Widget `DEFAULT_CSS` Definitions:**
    *   **Button (`_button.py`):** Shows defaults for padding, width/height (`auto`), content alignment (`center`), and `:hover` pseudo-class.
        *   **Link:** [https://github.com/Textualize/textual/blob/main/src/textual/widgets/_button.py](https://github.com/Textualize/textual/blob/main/src/textual/widgets/_button.py)
    *   **Input (`_input.py`):** Shows defaults for padding, height (`1`), and colors for the normal and `:focus` states.
        *   **Link:** [https://github.com/Textualize/textual/blob/main/src/textual/widgets/_input.py](https://github.com/Textualize/textual/blob/main/src/textual/widgets/_input.py)
    *   **Label (`_label.py`):** Shows that its default `height` and `width` are `auto`.
        *   **Link:** [https://github.com/Textualize/textual/blob/main/src/textual/widgets/_label.py](https://github.com/Textualize/textual/blob/main/src/textual/widgets/_label.py)
    *   **Container Widgets (`containers.py`):** This is a great file to see the layout defaults for `Vertical`, `Horizontal`, `VerticalScroll`, etc. For example, you can confirm here that `Vertical` has `layout: vertical;`.
        *   **Link:** [https://github.com/Textualize/textual/blob/main/src/textual/containers.py](https://github.com/Textualize/textual/blob/main/src/textual/containers.py)
