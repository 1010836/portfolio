# 1. type of packages/modules

| Type | Description |
| --- | --- |
| **Regular Module** | This is the most common type of import. It involves importing a single `.py` file that is found in one of the directories listed in `sys.path`. |
| **Regular Package** | A directory that contains an `__init__.py` file. When you import a package, the `__init__.py` file is executed, and you can then access the modules (Python files) within that directory. |
| **Namespace Package** | A package that can be split across multiple directories. Unlike regular packages, namespace packages do not contain an `__init__.py` file. This allows different parts of a package to be distributed and installed separately, yet still be accessed under the same package namespace. |
| **Direct File Path** | You can load a module directly from a `.py` file using its full file system path. This is done programmatically using the `importlib` library and is useful for loading plugins or scripts from locations not on `sys.path`. |
| **Zip Archive** | Python can import modules and packages directly from a `.zip` file. The `.zip` archive must be added to `sys.path`, and Python's `zipimport` mechanism will handle loading the code from within the archive. |
| **Built-in Module** | A module that is compiled directly into the Python interpreter. These modules are written in C and provide access to core functionalities. Examples include `sys`, `time`, and `builtins`. They are always available. |
| **C Extension Module** | A module written in C or C++ that can be imported and used just like a regular Python module. These are often used for performance-critical code or to interface with existing C libraries. They are compiled into shared library files (e.g., `.so` on Linux, `.pyd` on Windows). |
