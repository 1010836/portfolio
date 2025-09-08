# MVC

## 1. model:

    1.1 holds the application's 
        1.1.1 data
        1.1.2 business logic
    
    1.2 is completely independent of the user interface
    
    1.3 it could be a class that manages:
        1.3.1 a list of tasks, handles file operations, or communicates with an API

    1.4 it knows nothing about screens or widgets

## 2. view:

    2.1 In Textual, the "View" is represented by `Screen` and `Widget` classes
    
    2.2 Their sole responsibility is to:
        2.2.1 display the data from the Model
        2.2.2 capture user input

    2.3 they should contain minimal logic
        2.3.1 primarily focused on presentation

    2.4 for styling, Textual encourages separating presentation from logic 
        2.4.1 by using its own CSS-like syntax 
        2.4.2 `.tcss` files

## 3. controller:

    1. is the intermediary 
        1.1 that connects the Model and the View

    2. in a Textual app, the controller logic often resides within your `App` class
        2.1 the event handlers (`on_*` methods) 
            2.1.1 within your `Screen` and `Widget` classes
    
    3. the controller's job is to:
        3.1 respond to user input events from the View 
            3.1.1 e.g., `on_button_pressed`
        3.2 interact with the Model
            3.1.2 to update the application's state

        3.2 tell the View 
            3.2.1 based on changes in the Model
                3.2.1.1 which screen to display
                3.2.1.2 which widgets to update

### A Practical Pattern for Multi-Screen Apps

Let's refine MVC into a concrete structure for your project. This pattern emphasizes decoupling your application's core logic from its presentation.

#### 1. Separate Your Business Logic (The Model)

Create a dedicated Python module (e.g., `logic.py` or a `core` package) for your application's state and business logic.

**Example: `logic.py`**
```python
# logic.py

class AppState:
    """
    Manages the application's data and business logic. (The Model)
    """
    def __init__(self):
        self.user_name = "Guest"
        self.item_list = ["Apple", "Banana", "Cherry"]

    def set_user_name(self, name: str):
        if name:
            self.user_name = name

    def add_item(self, item: str):
        if item:
            self.item_list.append(item)
            self.item_list.sort()
```

#### 2. Create Your Screens (The Views)

Define your screens in a separate module (e.g., `screens.py`). These screens should be as "dumb" as possible. Their main role is to display widgets and emit messages when the user interacts with them.

**Example: `screens.py`**
```python
# screens.py

from textual.app import ComposeResult
from textual.screen import Screen
from textual.widgets import Header, Footer, Button, Static, Input

class MainScreen(Screen):
    """The main screen of the application. (A View)"""

    def compose(self) -> ComposeResult:
        yield Header()
        yield Static(f"Welcome, {self.app.state.user_name}", id="welcome-message")
        yield Button("Go to Settings", id="to_settings")
        yield Footer()

class SettingsScreen(Screen):
    """The settings screen. (A View)"""

    def compose(self) -> ComposeResult:
        yield Header()
        yield Input(placeholder="Enter your name", id="name-input")
        yield Button("Save and Go Back", id="save_and_back")
        yield Footer()
```

#### 3. Connect Everything in Your App (The Controller)

Your main application file (e.g., `main.py`) will host the `App` class. This class will instantiate your model and handle the controller logic, such as managing the screen stack and orchestrating updates between the model and the views.

**Example: `main.py`**
```python
# main.py

from textual.app import App
from textual.widgets import Button

from logic import AppState
from screens import MainScreen, SettingsScreen

class MultiScreenApp(App):
    """A Textual app with multiple screens and separated logic."""

    CSS_PATH = "style.tcss"  # Keep styles separate

    def __init__(self):
        super().__init__()
        self.state = AppState()  # Instantiate the Model

    def on_mount(self) -> None:
        """Set up the initial screen."""
        self.push_screen(MainScreen())

    # --- Controller Logic ---

    def on_button_pressed(self, event: Button.Pressed) -> None:
        """Handle button presses from any screen."""
        if event.button.id == "to_settings":
            self.push_screen(SettingsScreen())
        elif event.button.id == "save_and_back":
            # 1. Get data from the View
            name_input = self.query_one("#name-input", Input)
            new_name = name_input.value

            # 2. Update the Model
            self.state.set_user_name(new_name)

            # 3. Update the View and switch back
            self.pop_screen()
            main_screen = self.query_one(MainScreen)
            welcome_message = main_screen.query_one("#welcome-message")
            welcome_message.update(f"Welcome, {self.state.user_name}")

if __name__ == "__main__":
    app = MultiScreenApp()
    app.run()
```

### Why This Pattern is a Good Practice

*   **Separation of Concerns**: Your UI code (`screens.py`) is cleanly separated from your application's data and logic (`logic.py`). This makes your codebase easier to understand and navigate.
*   **Maintainability**: If you need to change the business logic (e.g., how data is stored), you only need to modify the model. If you want to redesign a screen, you can work on the view and CSS files without touching the core logic.
*   **Testability**: You can write unit tests for your model (`AppState`) completely independently of the user interface, leading to more robust and reliable code.
*   **Reusability**: Well-defined screens and widgets can be more easily reused across different parts of your application or even in other projects.
*   **Scalability**: As your application grows, this organized structure prevents it from becoming a tangled mess, making it easier to add new screens and features.
