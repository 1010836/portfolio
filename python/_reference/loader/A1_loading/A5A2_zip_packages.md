# 1.zip packages


    1. **Wheels** 
        1.1 are for installing a *library* into a Python environment's `site-packages`
        1.2 so it can be imported by other code
    2. **Zipapps** 
        2.1 are for packaging a complete *application* into a single file
        2.2 that can be run directly

---

# 2. why

    1. **portability and simple distribution**
    2. bundle your entire Python application
    3. including its entry point script 
        3.1 and all its internal modules
    4. into a single executable archive file

## 2.1 advantages

1.  **Simple Distribution:** Instead of sending someone a folder full of `.py` files and telling them which one to run, you can send them a single `myapp.pyz` file. This is cleaner and less error-prone.
2.  **Simplified Deployment:** Deploying a web application or a script to a server becomes as simple as copying one file. This is often faster and more "atomic" than syncing thousands of small files.
3.  **Creating Standalone Executables:** This is the foundation for how many Python application bundlers work. The Python interpreter can execute a zip file directly, making it a natural format for creating runnable programs.
4.  **Bundling Dependencies (Vendoring):** You can even include your application's dependencies inside the zip file, creating a completely self-contained application that doesn't need a virtual environment on the target machine (though this can have its own complications).

---

# 3. how

The mechanism is clever and relies on two key principles: Python's ability to run a zip archive directly and a special importer called `zipimport`.

**1. The `__main__.py` Convention**
For a zip archive to be directly executable, it must contain a `__main__.py` file in its root. When you tell the Python interpreter to run the zip file, it will automatically look for and execute the code inside this `__main__.py`.

```bash
# If myapp.zip contains a __main__.py, this command will run it
python myapp.zip
```

**2. The `zipimport` Module**
When Python's import machinery encounters a path on `sys.path` that points to a `.zip` file, it uses a special "finder" and "loader" provided by the `zipimport` module.

Here's the step-by-step process:

1.  **Add to `sys.path`**: The path to the zip archive is added to `sys.path`. This can happen automatically if you run `python myapp.zip`, or you can do it manually in your code.
2.  **Finder Recognizes the Zip**: As Python tries to resolve an `import` statement, its import machinery checks each path in `sys.path`. The `zipimport` finder recognizes the `.zip` extension.
3.  **Search Inside the Archive**: Instead of looking on the filesystem, this finder searches for modules *inside the zip archive's internal directory structure*.
4.  **Loader Reads from Memory**: If it finds `module.py` inside the zip, the `zipimport` loader reads its content directly from the archive *into memory*. **Crucially, it does not need to extract the file to disk.**
5.  **Module Execution**: The loader then executes the module's code from memory, creating the module object just like a normal import.

# 4. example

Let's create a simple, runnable zipapp.

**1. Create the Application Files**
Create a directory for your application source.

```
myapp_src/
├── myapp/
│   ├── __init__.py
│   └── utils.py
└── __main__.py
```

*   **`myapp/utils.py`:**
    ```python
    def helper_function():
        return "This is a helper from inside the zip!"
    ```*   **`__main__.py`:** (This is the entry point)
    ```python
    from myapp import utils

    def run_app():
        print("Application is starting...")
        message = utils.helper_function()
        print(message)
        print("Application finished.")

    if __name__ == "__main__":
        run_app()
    ```

**2. Create the Zip Archive**
Navigate into the `myapp_src` directory and create the zip file. It's important to run the command from *inside* this directory so the paths in the archive are correct (i.e., `__main__.py` is at the root).

```bash
cd myapp_src
zip -r ../myapp.zip .
cd ..
```*   This creates `myapp.zip` in the parent directory.

**3. Run the Zipapp!**
You can now execute your entire application with a single command:

```bash
python myapp.zip
```

**Expected Output:**```
Application is starting...
This is a helper from inside the zip!
Application finished.
```This works because the Python interpreter automatically adds `myapp.zip` to the beginning of `sys.path`, allowing the `from myapp import utils` statement inside `__main__.py` to be resolved by the `zipimport` machinery.
