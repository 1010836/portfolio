# 1. executables

## 1.1 core concept

        1. treat executable as a data file
        2. gets included in the the wheel
        3. when the wheel is installed, 
            3.1 the executable is placed 
                3.1.1 inside the site-packages directory
                3.1.2 alongside with Python code
                3.1.3 making it a discoverable package resource

---

## 1.2 Step 1: project structure

```
your_project/
├── src/
│   └── your_package/
│       ├── __init__.py
│       ├── main.py
│       └── bin/
│           └── your_executable.exe
├── tests/
│   └── ...
└── pyproject.toml
```

## 1.3 Step 2: configure `pyproject.toml`

```toml
[project]
name = "your_project_name"

...

[tool.pdm]
# This section is for PDM's dependency management and tool settings.

[tool.pdm.build]
# This is the crucial part for including files.
# The paths are relative to the project root.
includes = ["src/your_package/bin/"]
```

### 1.3.1 Explanation:

*   **`[project]`**: 
    
    This table contains standard PEP 621 metadata about your package.

*   **`[tool.pdm.build]`**: 

    This table configures PDM's build process.

*   **`includes = ["src/your_package/bin/"]`**: 
    
    This tells the build backend to explicitly include the specified directory and all files within it
    in the final wheel. 
    You could also specify the exact file path: `includes = ["src/your_package/bin/your_executable.exe"]`.

## 1.4 Step 3: build 

```bash
pdm build
```

        1. this command will generate a `dist/` folder 
            1.1 containing both a wheel (`.whl`) file 
            1.2 and a source distribution (`.tar.gz`)

        2.  the wheel file is now a self-contained package 
            2.1 with your Python code and the executable bundled inside

## 1.5 Step 4: executable

        1. once a user installs your package
            1.1 `pip install your_project_name-0.1.0-py3-none-any.whl`
            1.2 your code needs a reliable way to locate and execute the bundled `.exe`
        2. the standard, modern approach is to use the `importlib.resources` module

```python
import subprocess
import sys

# For Python 3.9+
from importlib.resources import files

def get_executable_path():
    """Gets the path to the bundled executable."""
    # For Python versions before 3.9, use the backport.
    # You would need to add `importlib_resources` to your dependencies in pyproject.toml
    # if sys.version_info < (3, 9):
    #     from importlib_resources import files
    
    # 'your_package' is the name of your package's directory in src/
    executable_path = files('your_package').joinpath('bin', 'your_executable.exe')
    return str(executable_path)

def run_executable(args=None):
    """Runs the bundled executable with optional arguments."""
    if args is None:
        args = []
    
    executable_path = get_executable_path()
    
    try:
        # The first item in the command list must be the path to the executable.
        command = [executable_path] + args
        result = subprocess.run(command, capture_output=True, text=True, check=True)
        print("Executable output:")
        print(result.stdout)
    except FileNotFoundError:
        print(f"Error: Executable not found at {executable_path}")
    except subprocess.CalledProcessError as e:
        print(f"Error running executable: {e}")
        print(f"Stderr: {e.stderr}")

if __name__ == '__main__':
    # Example of running the executable with an argument
    run_executable(['--version'])
```

### 1.5.1 Explanation

*   `importlib.resources.files('your_package')`: 
    
    This function returns a special object that represents the contents of your installed package.

*   `.joinpath('bin', 'your_executable.exe')`: 
    
    This navigates through the package's internal structure to locate the executable. 
    This method works correctly whether the package is installed as a regular folder or as a zipped archive.

*   `subprocess.run()`:
    This is the standard way to run external commands. 
    Using `check=True` ensures that an error is raised if the executable returns a non-zero exit code.

---

## 1.6 PDM vs. Setuptools

| Feature | Setuptools | PDM (and modern standards) |
| :--- | :--- | :--- |
| **Including Arbitrary Binaries (.exe)** | Yes, using `package_data` or `data_files` in `setup.py`/`setup.cfg`. | Yes, using `includes` in the `[tool.pdm.build]` section of `pyproject.toml`. |
| **Creating Command Wrappers for Python Functions** | Yes, using `[project.scripts]` (e.g., `console_scripts`) which generates a wrapper executable (like `.exe` on Windows) that calls a specified Python function. | Yes, using the standard `[project.scripts]` table in `pyproject.toml`. This functions identically to the setuptools implementation and creates command-line wrappers for Python functions. |
| **Creating GUI-specific Wrappers** | Yes, via the `gui_scripts` entry point. On Windows, this creates a wrapper that runs without a console window. | No direct equivalent. This is a `setuptools`-specific feature. The standard `[project.scripts]` does not differentiate between console and GUI applications. |
| **Creating a Direct Command from a Bundled .exe** | Discouraged, but possible with the legacy `scripts` keyword. This attempts to place the raw script/executable directly on the PATH, but is not portable and has limitations. | No, PDM does not have a direct mechanism for this. The standard and recommended approach is to create a Python wrapper function (defined in `[project.scripts]`) that uses `importlib.resources` to find and then execute the bundled `.exe` using `subprocess`. This is more explicit, robust, and platform-independent. |
