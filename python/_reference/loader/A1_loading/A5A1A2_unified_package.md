# 1. different installs

    1. we need to run `pip install` three separate times,
        1.1 once for each wheel
    2. to install the complete `c0dice` package

```bash
# In your clean consumer environment...

# 1. Install the first part
pip install ../c0dice-namespace-project/c0dice-first/dist/c0dice_first-0.1.0-py3-none-any.whl

# 2. Install the second part
pip install ../c0dice-namespace-project/c0dice-second/dist/c0dice_second-0.1.0-py3-none-any.whl

# 3. Install the third part
pip install ../c0dice-namespace-project/c0dice-third/dist/c0dice_third-0.1.0-py3-none-any.whl
```

    3. after these three commands, 
        3.1 the `c0dice` namespace in your environment would be fully populated
    4. you could import `c0dice.first`, `c0dice.second`, and `c0dice.third`

# 2. group

## 2.1 what

    1. installing each wheel 
        1.1 it's not a great experience for users
    2. to solve this 
        2.1 create a fourth package 
        2.2 that acts as a "meta-package" or "umbrella package"

    3. this package might contain no code at all
    
    4. its only job is to declare the other three packages as its dependencies

    5. let's call this package `c0dice`

    6. a user would then only need to install this one package,
        6.1 `pip` would automatically find and install all the required pieces

## 2.1 how

### **2.1.1 new project:**

```bash
# In your c0dice-namespace-project directory
cd c0dice-namespace-project

mkdir c0dice-meta
cd c0dice-meta
pdm init --non-interactive -p 3.8
```

### **2.1.2 add dependencies:**

    1. edit `c0dice/pyproject.toml` 
    2. add the `[project.dependencies]` section:

```toml
[project]
name = "c0dice"  # Or "c0dice-all"
version = "0.1.0"
description = "The complete c0dice namespace package."
authors = [{ name = "Your Name", email = "you@example.com" }]
requires-python = ">=3.8"

# --- ADD THIS SECTION ---
dependencies = [
    "c0dice-first @ file:///${PROJECT_ROOT}/../c0dice-first",
    "c0dice-second @ file:///${PROJECT_ROOT}/../c0dice-second",
    "c0dice-third @ file:///${PROJECT_ROOT}/../c0dice-third",
]
# -------------------------

[tool.pdm]
# PDM configuration...
```

### **2.1.3 build:**

```bash
# (You are still inside the c0dice-meta directory)
pdm build
```

## 2.2 result

### **2.2.1 fresh environment:**

```bash
cd ../../consumer-test  # Or wherever you created it
rm -rf venv               # Delete the old one
python -m venv venv
source venv/bin/activate
```

### **2.2.2 install:**

```bash
pip install ../c0dice-namespace-project/c0dice-meta/dist/c0dice-0.1.0-py3-none-any.whl
```

    1. `pip` automatically install 
        1.1 `c0dice-first`, `c0dice-second`, and `c0dice-third` 
            1.1.1 as dependencies 
        1.2 before installing `c0dice` itself.

### **2.2.3 verify:**

```python
# python
from c0dice import first, second, third

first.hello_first()
second.hello_second()
third.hello_third()

# All three imports now work from a single installation!
```

# 3. summary 

| Method | How it Works | Pros | Cons |
| :--- | :--- | :--- | :--- |
| **Installing Individual Wheels** | `pip install <wheel1>`, `pip install <wheel2>`, ... | User only installs what they need, saving space and reducing dependencies. | Requires the user to know which specific pieces they need. Can be tedious. |
| **Installing a Meta-Package** | `pip install <meta_package_wheel>` | **Simple for the user (one command).** Defines a "standard" or "full" installation. The primary way large libraries are distributed. | Installs everything, which might be more than a user strictly needs. |
