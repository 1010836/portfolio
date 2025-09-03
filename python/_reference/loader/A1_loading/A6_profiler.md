You have hit on a critical and foundational concept in software development and testing: **process isolation**. Your intuition is exactly right, and your implementation using `subprocess` is the correct, standard, and most robust way to achieve your goal.

Let's break everything down in detail.

---

### Part 1: Why `subprocess` is the Best Way

Your reasoning is spot on: **"inside my python session I cannot create an empty python session and then in this empty session load a new environment, right?"**

This is correct. Once a Python interpreter starts, its process space is configured. This includes:
*   `sys.path`: The list of directories where Python looks for modules.
*   `sys.modules`: A cache of all modules that have already been imported.
*   Loaded C extensions and other in-memory state.

Trying to "unload" modules or purely switch `sys.path` to point to a new environment is unreliable and dangerous. You would run into countless problems:
*   **Version Conflicts:** If your loader uses `requests==2.25.0` and the target environment uses `requests==2.31.0`, which one wins? If the older version is already in `sys.modules`, a simple `import requests` in the target code will grab the already-imported module, completely ignoring the target environment's version and leading to subtle bugs.
*   **Dependency Hell:** The dependencies of your loader library could conflict with the dependencies of the code you're trying to run.
*   **State Bleeding:** Global state from one module could leak and affect the execution of the other.

A **new process**, created by `subprocess`, is the only way to get a truly clean slate. It gets its own separate memory space, its own `sys.path` (determined by the Python executable you launch it with), and its own clean `sys.modules` cache. This guarantees the target script runs exactly as it would if the user had typed `pdm run python your_script.py` in their own terminal.

---

### Part 2: Detailed Explanation of Your `subprocess` Code

Your code is a perfect, textbook example of how to use `subprocess` correctly and safely. Let's analyze each part.

```python
cmd = [str(self.__python_path), str(self.__shared.normalized_path)]
```
This is the command to be executed. By passing it as a **list of strings**, you avoid a security risk called "Shell Injection." `subprocess` ensures each item is passed as a distinct argument to the operating system.
*   `self.__python_path`: This is the **most important** part. You are not just running `python`, you are running the specific Python executable from the target PDM environment (e.g., `/path/to/target/project/.venv/bin/python`). This executable is pre-configured to know about its own `site-packages` and environment.
*   `self.__shared.normalized_path`: This is the first argument to the Python interpreter—the script you want it to run.

```python
result = subprocess.run(
    cmd,
    capture_output=True, # (1)
    text=True,           # (2)
    cwd=str(self.__project_root) # (3)
)
```
*   **(1) `capture_output=True`**: This tells `subprocess` to intercept the standard output (stdout) and standard error (stderr) streams of the new process. Instead of printing them directly to your console, it saves them.
*   **(2) `text=True`**: This works with `capture_output`. It automatically decodes the captured stdout and stderr bytes into strings using your system's default encoding (usually UTF-8). This is why `result.stdout` is a nice readable string and not `b'some byte string'`.
*   **(3) `cwd=str(self.__project_root)`**: `cwd` stands for **Current Working Directory**. This is critical. It makes the subprocess execute *as if* it were started from that directory. Any relative file paths inside the target script (like `open('config.json')`) will be resolved relative to the target project's root, not your loader library's location.

The `subprocess.run()` function waits for the command to complete and then returns a `CompletedProcess` object, which you've named `result`. This object contains:
*   `result.returncode`: The exit code of the process. `0` is the universal signal for success. Any non-zero value indicates an error.
*   `result.stdout`: The string containing everything the script printed to standard output.
*   `result.stderr`: The string containing all error messages.

---

### Part 3: The Impact on Your Profiler

This is the most crucial part of your question.

> I cannot profile the code I run in another python session/subprocess?

**Correct. Your profiler, based on `sys.setprofile`, cannot see inside the subprocess.**

`sys.setprofile()` registers a hook *within the current Python process*. When you launch a subprocess, you are creating a completely new, independent Python process. It has its own `sys` module, its own memory, and its own (empty) profile hook. Your loader process and the subprocess are like two separate houses; you can't see what's happening in your neighbor's house from your own living room.

Your loader's profiler will see the call to `subprocess.run()`, treat it as a single function call, wait for it to finish, and then continue. It has zero visibility into the lines of code being executed by the *other* Python interpreter.

### Part 4: How Can You Profile the Subprocess?

While your current profiler can't do it directly, you can still profile the code by changing *how you run the code in the subprocess*. This involves a strategy of **code injection** or **instrumentation**.

The goal is to make the subprocess run *your profiler*, which in turn runs the target script.

#### The Wrapper Script Approach

This is the most flexible method. You dynamically create a temporary Python script that acts as a launcher.

1.  **Your loader library creates a temporary file**, let's call it `_profile_wrapper.py`.
2.  **The wrapper script's content would look like this:**
    ```python
    # _profile_wrapper.py
    import sys
    import runpy # A great tool for running other scripts

    # You need to make your profiler library available to the target env.
    # Easiest way is to add its path to sys.path.
    path_to_your_profiler_library = "..." # Your loader will inject this path
    sys.path.insert(0, path_to_your_profiler_library)

    from your_profiler_module import SimpleStateProfiler # Or whatever it's called

    # The actual script we want to run
    target_script_path = "..." # Your loader will inject this path

    # Now, run the target script *inside* your profiler's context
    with SimpleStateProfiler():
        # runpy.run_path executes a script as if it were the main module
        runpy.run_path(target_script_path, run_name='__main__')
    ```
3.  **Modify your `subprocess` command** to execute this wrapper script instead of the original script.
    ```python
    # Instead of this:
    # cmd = [str(self.__python_path), str(self.__shared.normalized_path)]
    # You do this:
    cmd = [str(self.__python_path), "/path/to/_profile_wrapper.py"]

    result = subprocess.run(...) # Run it as before
    # The result.stdout will now contain the detailed output from YOUR profiler!
    print(result.stdout)

    # Don't forget to clean up the temporary wrapper script afterwards.
    ```

This approach gives you the full power of your line-by-line state profiler, but correctly applies it *inside the isolated target environment*. The only prerequisite is that your profiler code itself must be compatible with the target's Python version.
