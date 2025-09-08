# standalone executables

## 1. PyInstaller

    1. is the most widely used and mature tool 
        1.1 for packaging Python applications
    2. analyzes your script to find all dependencies
    3. bundles them into a single package
    4. broad compatibility with major Python packages

### 1.1 How it works: 
    
    1. bundles your app and its dependencies 
        1.1. with a pre-compiled Python interpreter 
    2. when you run the `.exe`
        2.1 unpacks necessary files 
            2.1.1 into a temporary folder
        2.2 runs the app

### 1.2 key command:

`pyinstaller --onefile your_script.py`

    1. the `--onefile` flag creates a single executable

    2. for GUI or console applications like Textual
        2.1 that shouldn't open a *second* console window on Windows
        2.1 you might use the `--windowed` or `--noconsole` flag

### 1.3 why 
    
    1. tt's the easiest to get started with 
    2. has excellent community support
    3. generally "just works" with complex libraries like Textual

### 1.4 how

```bash
# 1. Install PyInstaller
pip install pyinstaller

# 2. Navigate to your project directory
cd /path/to/your_project

# 3. Run PyInstaller on your main script
#    --onefile creates a single .exe
#    --name sets the name of the final executable
pyinstaller --onefile --name my_textual_app main.py

# 4. Find your executable in the 'dist' folder
ls dist/
# Output: my_textual_app.exe (on Windows) or my_textual_app (on Linux)
```

## 2. Nuitka

    1. translates your Python code into C language 
    2. compiles into an executable using a native C compiler
    3. significant performance improvements
    4. smaller executables
    
### 2.1 command:

`python -m nuitka --standalone your_script.py`

    1. the `--standalone` flag is required to bundle 
    2. all dependencies and the Python runtime

### 2.2 why

    1. performance-critical sections
    2. source code harder to decompile
    
### 2.3 how

```bash
# 1. Install Nuitka
pip install nuitka

# 2. Make sure you have a C compiler
#    - On Windows: Install Visual Studio with C++ support.
#    - On Linux: sudo apt-get install build-essential (or equivalent)

# 3. Run Nuitka on your main script
python -m nuitka --standalone --onefile main.py

# 4. Find your executable in the 'main.dist' folder
ls main.dist/
# Output: main.exe (on Windows) or main.bin (on Linux)
```

## 3. PyOxidizer

    1. more recent tool
    2. focuses on producing high-quality, self-contained binaries
    3. embedding a Python interpreter 
        3.1 directly within a Rust application harness

### 3.1 what 

    1. fine-grained control on built 
    2. can load Python modules directly from memory
        2.1 lead to very fast startup times

### 3.2 why

    1. highly optimized, portable binaries
    2. can be more complex to configure than PyInstaller
        2.1 especially if your project has many C-based dependencies

---

## 4. conclusion

    1. start with PyInstaller

    2. is the most straightforward tool 

    3. has the highest probability of successfully packaging
    
    4. without extensive configuration
    
    5. once you have a working executable
    
        5.1 can then explore Nuitka 

        5.2 if you need better performance or a smaller file size

## 5. cross-compilation

    1. these tools **do not cross-compile**
    
    2. to create a Windows `.exe`
        2.1 must run the packaging tool on a Windows machine

    3. to create a Linux executable
        2.1 must run it on Linux

    4. the standard way to handle this is by using virtual machines or CI/CD services
