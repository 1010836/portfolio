# 1. Modules Imported by Default in an Empty Program

    1. completely empty `.py`
    2. lots of modules are present: `sys.modules`
    3. modules Python needs to:
        3.1 function
        3.2 set up its own import machinery

---

## 1.1 categories:

### **1. Core:**

    1. `sys`: 
        1.1 provides access to interpreter-level variables and functions 
            `sys.modules`, `sys.path`, `sys.argv`, etc.
        1.3 must exist for almost anything to work

    2. `builtins`: 
        2.1 the most fundamental module
        2.2 contains:
            2.2.1 built-in functions 
                `print()`, `len()`, `str()`, etc.
            2.2.2 exceptions
                `ValueError`, `TypeError`, etc.
        2.3 it's always available

### **2. Import:**

    1. import system is written in Python 
    2. to `import` to work:
       2.1 import modules that implement `import`

#### 2.1 `_frozen_importlib`: 

    1. A "frozen" version of the `importlib` library, 
    2. written in C
    3. starting point for the entire import system

#### 2.2 `_frozen_importlib_external`: 

    1. knows how to find modules in the filesystem

#### 2.3 `_imp`: 
    1. low-level access to the import mechanics

#### 2.4 `marshal`: 
    1. read and write `.pyc` (compiled Python) 

### **3. Encodings and I/O:**

#### `codecs`: 
    1. implements the codec registry and base classes

#### `encodings`, `encodings.aliases`, `encodings.utf_8` (and possibly others): 
    1. machinery for handling text.
    2. `utf-8` is loaded because it's the default source file encoding

#### `io`: 
    1. The core tools for handling I/O streams

### **4. Site-Specific:**

    1. python tries to be helpful 
    2. automatically importing the `site` module

#### 4.1 responsibilities        

    1. adding installed package directories
        1.1 `site-packages` to `sys.path`
        1.1. so you can import libraries installed by `pip`

    2. enabling user-friendly features in
        2.1 the interactive console

    3. importing `site` 
        3.1 pulls in a cascade of other common modules it depends on:
            3.1.1 `os`: 
                For interacting with the operating system (e.g., to find paths).
            3.1.2 `posix` (on Linux/macOS) or `nt` (on Windows): 
                The OS-specific implementation of the `os` module.
            3.1.3 `_stat`: 
                To interpret file status information from `os.stat()`.

    4. several others...

---

## 1.2 minimal:

    1. telling Python **not to import the `site` module**

    2. This is done with the `-S` command-line flag

```bash
# Run python with the -S flag to disable the site module
python -S -c "import sys; print(sorted(sys.modules.keys()))"
```

    3. get the smallest possible set of modules required for the interpreter to run

    4. consist almost entirely of the "Core", "Import Machinery", and "Encodings"
    
    5. includes:

        `sys`
        `builtins`
        `_frozen_importlib`
        `_frozen_importlib_external`
        `_imp`
        `marshal`
        `codecs` and the core `encodings` modules
        `io`

    6. is able to 
        6.1 execute code 
        6.2 use `import` statement
        
    7. without the `site` module
        7.1 won't automatically know where your `pip`-installed packages are
        7.2 `import numpy` would fail 
            7.2.1 unless you manually manipulated `sys.path`
