# 1. **namespace package**

## 1.1 what
    1. allows to split a single logical package
        1.1 across multiple, separate directories
    2. regular package
        2.1 is contained within a single directory 
        2.2 defined by an `__init__.py` file
    3. a namespace package 
        3.1 has no `__init__.py`
        3.2 can be composed of parts 
            3.2.1 that are installed and distributed independently

### 1.1.1 differences

| Feature | Regular Package | Namespace Package |
| :--- | :--- | :--- |
| **`__init__.py` file** | **Required**. Its presence defines the directory as a package. | **Absent**. The lack of an `__init__.py` file signals to Python that it's a namespace package. |
| **Directory Structure** | Contained in a single, continuous directory tree. | Can be split across multiple, physically separate directories. |
| **`__path__` attribute** | A list containing a single string: the path to the package's directory. | An iterable containing the paths to all the directories that contribute to the namespace. |
| **Primary Use Case** | Self-contained, monolithic libraries. | Large collections of related libraries, plugins, or components that can be installed independently. |

## 1.2 why

    1. primary motivation: 
        1.1 allow large-scale projects and libraries 
        1.2 to be modular and independently distributable

### 1.2.1 benefits:

    1. **Modular Architecture:** 
        1. Large projects can be broken down into smaller, independently installable pieces
        2. A team can work on one part of the package without needing the source code for the other parts.

    2. **Extensible Packages (Plugins):**
        1. are perfect for creating a core application that can be extended with plugins
        2. each plugin can install itself into the application's namespace

    3. **Large Company Libraries:** 
        1. a company can group all its internal libraries under a common namespace 
            1.1 e.g., `company_name.`
            1.2 even if the libraries are developed by different teams 
            1.3 and released on different schedules 
        2. the Microsoft Azure SDK (`azure.`) is a prominent real-world example

    4. **Avoiding Name Collisions:** 
        1. multiple independent distributions 
        2. can share a common top-level package name 
        3, without conflicting

## 1.3 how

    1. Imagine a company, "c0dice," 
    2. that produces two separate data analysis tools: 
        1. one for handling web logs (`c0dice-webtraffic`)
        2. another for database logs (`c0dice-dbstats`)
    3. they want users to be able to import both under the same `c0dice` namespace

### **1.3.1 directory dtructure**

    1. instead of one giant repository,
        1.1 they have two separate projects
    2. notice the **absence** of an `__init__.py` file in the `c0dice` directories

#### **1.3.1.1 project 1: `c0dice-webtraffic`**

```
c0dice-webtraffic/
├── setup.py
└── src/
    └── c0dice/
        └── webtraffic/
            ├── __init__.py
            └── analyzer.py
```

#### **1.3.1.2 project 2: `c0dice-dbstats`**

```
c0dice-dbstats/
├── setup.py
└── src/
    └── c0dice/
        └── dbstats/
            ├── __init__.py
            └── querier.py
```

### **1.3.2 installation**

    1. can choose to install one or both of packages:

```bash
pip install c0dice-webtraffic
pip install c0dice-dbstats
```

    2. when these are installed, 
        2.1 Python's packaging tools 
            2.1.1 place them in the `site-packages` directory
        2.2 both projects will contribute 
            2.2.1 to the same `c0dice` namespace directory

### **1.3.3 usage**

    1. after installation, 
        1.1 the Python interpreter sees 
        1.2 both packages as part of the same `c0dice` namespace
    2. the user can import from them seamlessly:

```python
# This works because c0dice-webtraffic was installed
from c0dice.webtraffic import analyzer

# This works because c0dice-dbstats was installed
from c0dice.dbstats import querier

# You can now use code from both independent packages
analyzer.process_logs()
querier.run_query()
```

### **1.3.4 internal**

    1. Python's import system 
        1.1 scans `sys.path`
        1.2 combines all directories named `c0dice` 
            1.2.1 that lack an `__init__.py` file 
            1.2.2 into a single virtual package
    2. this mechanism
        2.1 defined in PEP 420
        2.2 known as an "implicit namespace package"
        2.3 is the standard way 
            2.3.1 to create them in Python 3.3 and later
