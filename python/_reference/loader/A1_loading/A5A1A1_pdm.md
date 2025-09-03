# 1. Namespace Packages with PDM

    1. the key principle is **convention over configuration**
    2. don't need to explicitly declare a namespace package in your `pyproject.toml` file
    3. PDM infers it from your project's directory structure

## 1.2 guide 

### Step 1: initialize project

    1. `c0dice-webtraffic`

```bash
mkdir c0dice-webtraffic
cd c0dice-webtraffic
pdm init
```

    2. creates `pyproject.toml`

### Step 2: create directory structure

    1. to create a namespace package
        1.1 structure directories correctly 
        1.2 **omit the `__init__.py` file** from 
            1.2.1 the top-level namespace directory

    2. structure uses a `src` layout:

```
c0dice-webtraffic/
├── pyproject.toml
└── src/
    └── c0dice/  <-- This is the namespace package directory
        │
        └── webtraffic/ <-- This is a regular package inside the namespace
            ├── __init__.py
            └── analyzer.py
```

    3. explanation

* **3.1 `src/c0dice/`**: 

        3.1.1 this directory will become the `c0dice` namespace
        3.1.2 because it **does not** contain an `__init__.py` file
        3.1.3 PDM and Python's import system recognize it as a PEP 420 namespace package

*  **3.2 `src/c0dice/webtraffic/`**: 

        3.2.1 this is a regular package that lives *inside* the `c0dice` namespace
        3.2.2 it **does** contain an `__init__.py` file

### Step 3: Configure `pyproject.toml` (Optional - PDM Auto-discovery)

    1. the best part is that you don't need any special configuration in `pyproject.toml`
    
    2. PDM will automatically discover your packages

    3. Your `pyproject.toml` will look something like this:

```toml
[project]
name = "c0dice-webtraffic"
version = "0.1.0"
description = "Tools for analyzing web traffic."
authors = [{ name = "Your Name", email = "you@example.com" }]
requires-python = ">=3.8"

[tool.pdm.build]
includes = ["src/c0dice"]
```

    4. PDM is smart enough to find the `src/c0dice` directory 
        4.1 and package it correctly
    5. It understands that `c0dice` is a namespace portion because it lacks an `__init__.py`

### Step 4: Build and Install

```bash
# Build the distributable files (wheel and sdist)
pdm build

# Install the package into your PDM-managed environment
pdm install
```

    1. when another user do the same 
        1.1 for the `c0dice-dbstats` package, 
    2. both installations will contribute their sub-packages 
        2.1 to the same `c0dice` namespace,

## 1.3 summary

    1. with PDM
    2. creating a namespace package is as simple as 
        2.1 omitting the `__init__.py` file from the directory 
        2.2 that you intend to be the shared namespace
    3. the tooling handles the rest
