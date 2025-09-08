### Where the Message is Addressed (The Handler)

In the code example, the message posted by `EnterEmailScreen` is handled in the main `MyApp` class.

Here is the sending code from `EnterEmailScreen`:
```python
# In screens/email_screen.py

class EnterEmailScreen(Screen):
    # This is the message "envelope"
    class Next(Message):
        def __init__(self, email: str):
            self.email = email
            super().__init__()

    def on_button_pressed(self, event: Button.Pressed):
        # ...
        # This sends the message
        self.post_message(self.Next(email_input.value))
```

And here is the **receiving code** in the `App` class that "catches" this specific message:
```python
# In main.py

class MyApp(App):
    # ... other methods ...

    # THIS IS THE HANDLER
    def on_enter_email_screen_next(self, message: EnterEmailScreen.Next) -> None:
        """Handles the Next message from the EnterEmailScreen."""
        print(f"The App received the email: {message.email}")
        if isinstance(self.current_action, RegistrationAction):
            self.current_action.process_email(message.email)
```

The magic is in the **naming convention of the handler method**.

#### The Automatic Naming Convention

When a message is posted, Textual automatically looks for a handler method on the parent widgets (all the way up to the `App`) that follows this pattern:

`on_` + `[NameOfWidgetClassInSnakeCase]` + `_` + `[NameOfMessageClassInSnakeCase]`

Let's break it down for our example:

1.  **Prefix:** It always starts with `on_`.
2.  **Widget Class Name:** The widget that sent the message is `EnterEmailScreen`. Converted to snake\_case, this becomes `enter_email_screen`.
3.  **Message Class Name:** The message class itself is named `Next`. Converted to snake\_case, this is just `next`.

Combine them: `on_` + `enter_email_screen` + `_` + `next`  =>  **`on_enter_email_screen_next`**

Because the `MyApp` class has a method with this exact name, Textual knows to call it when it "hears" a `Next` message coming from an `EnterEmailScreen`. The `message` parameter of the handler will be the actual `Next` object you created, which is why you can access its data with `message.email`.

---

### How Textual Implements This Feature (The Mechanism)

Textual's event system is one of its most powerful features. It is built on two core concepts: an **event queue** and the **bubbling process**.

Here is a step-by-step explanation of what happens under the hood when you call `self.post_message()`:

#### Step 1: A Message is Created and Posted
When your code runs `self.post_message(self.Next(email_input.value))`, it does two things:
*   Creates an instance of your custom `Next` message object.
*   Places this message object onto a central **event queue** that the `App` is constantly monitoring.

#### Step 2: The Main Event Loop
Your entire Textual application runs inside an event loop (this is what `app.run()` starts). This loop continuously pulls the next event or message off the queue to be processed.

#### Step 3: The Dispatch and Bubbling Process
Once the loop pulls your `Next` message from the queue, the "dispatch" process begins. This is where Textual decides who should handle the message.

1.  **Identify the Source:** Textual knows the message originated from the `EnterEmailScreen` widget instance.

2.  **Start the Bubble:** The "bubble" is the journey the message takes up the widget tree. The journey starts at the source.

3.  **Check the Source for a Handler:** Textual first checks the `EnterEmailScreen` widget itself. "Does this object have a method named `on_enter_email_screen_next`?" In our example, it does not, so the journey continues.

4.  **Move to the Parent:** The message "bubbles up" to the parent of the `EnterEmailScreen`. In a simple multi-screen app, the direct parent is often the `App` itself.

5.  **Check the Parent for a Handler:** Now Textual checks the `MyApp` instance. "Does this object have a method named `on_enter_email_screen_next`?" **Yes, it does!**

6.  **Execute the Handler:** Textual immediately calls the `on_enter_email_screen_next` method, passing the `Next` message object as the argument. Your logic inside this method is now executed.

7.  **Stop the Bubble:** By default, once a handler is found and executed, the event is considered "handled," and the bubbling process stops. The message does not continue traveling up to any higher-level containers (if there were any).

This entire system is designed to promote **decoupling**. The `EnterEmailScreen` doesn't need to know who is listening or what will happen next. It just announces what happened. The `App` class, acting as the main controller, can listen for these announcements from any screen and decide what complex action to perform in response.
