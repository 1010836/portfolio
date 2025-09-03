# 1. Spec

    1. holds the import-related metadata for a module
    2. "blueprint" used by the import machinery to load the module
    3. can get one using `importlib.util.find_spec('module_name')`

| Attribute | Description |
|---|---|
| `name` | A string for the fully-qualified name of the module (e.g., `'numpy.linalg'`). This value will become the module's `__name__` attribute. |
| `loader` | The loader object that will execute the module's code (e.g., `_frozen_importlib_external.SourceFileLoader`). This is responsible for the actual loading process. |
| `origin` | The path to the file from which the module is loaded (e.g., `'/path/to/lib/python3.9/os.py'`). For built-in modules, this might be the string `'builtin'`. |
| `submodule_search_locations` | A list of paths where submodules should be searched. This is only set for packages (i.e., directories with an `__init__.py`) and its value is assigned to the package's `__path__` attribute. For regular modules, this is `None`. |
| `cached` | The path to the compiled bytecode file (e.g., a `.pyc` file). It can be `None` if not applicable. |
| `parent` | The fully-qualified name of the parent package for a submodule (e.g., the parent of `'numpy.linalg'` is `'numpy'`). For top-level modules, this is an empty string. |
| `has_location` | A boolean that is `True` if the `origin` is a recognizable file path, indicating the module can be loaded from a specific location. |

---

# 2. Module 

    1. created when a `.py` file is imported
    2. acts as a namespace for all the code 
        2.1 functions, classes, variables
    3. attributes are accessible
        3.1 on the module object itself
        3.2 after it has been imported 
        3.3 `import os; print(os.__name__)`

| Attribute/Method | Description |
|---|---|
| `__name__` | The name of the module as a string. When you run a script directly, its `__name__` is set to `'__main__'`. Otherwise, it's the file name (without `.py`). |
| `__file__` | The file path from which the module was loaded. This attribute may not exist for certain types of modules, like those built directly into the interpreter. |
| `__doc__` | The module's docstring. This is the first string literal at the very top of the module's source file. It's `None` if no docstring is present. |
| `__dict__` | A dictionary that stores the module's namespace. All global variables, functions, and classes defined in the module are keys in this dictionary. This is the symbol table of the module. |
| `__spec__` | A reference back to the `ModuleSpec` that was used to create and load this module. This is the modern way (Python 3.4+) to access a module's import metadata. |
| `__loader__` | The loader object that was used to load the module. This is now considered legacy, and it's recommended to use `__spec__.loader` instead. |
| `__package__` | The package to which the module belongs. For submodules, this is the parent package's name. For top-level modules, it's an empty string. |
| `__path__` | For package modules only, this is a list containing the path(s) to the directory (or directories) that make up the package. It tells Python where to look for submodules. |
| `__cached__` | The path to the compiled bytecode file (`.pyc`). It is recommended to use `__spec__.cached` instead. |
