# 1. Loading process

## 1.1 direct loading - file

### 1.  `spec = importlib.util.spec_from_file_location(name, path)`

        1.1 creates "specification"/metadata   
            1.1.1 name
            1.1.2 path
            1.1.3 loader
            
### 2.  `module = importlib.util.module_from_spec(spec)`

        2.1 creates empty module object
        2.2 object exists in memory
        2.3 contains no code or variables

### 3.  `sys.modules["dynamic_module"] = module`
        
        3.1 caching step
        3.2 python uses the `sys.modules` dictionary to
            3.2.1 track all loaded modules
        3.3 preventing infinite loop or duplicate loading

### 4.  `spec.loader.exec_module(module)`
        
        4.1 reads the python code 
        4.2 executes it
        4.3 module.__dict__
            4.3.1 module namespace
            4.3.2 functions, classes, and variables
        434 the module is ready to use

## 1.2 module discovery - module

### 1.   **`importlib.import_module('my_module')`**: 
    
        1. high-level function
        2. entire import machinery
        3. find and then load a module

### 2. searches:
        
        1.  module cache/`sys.modules`: module has already been imported
        2.  "finders" on `sys.meta_path`
            2.1 finders locate modules: `sys.path` 
                2.1.1 current directory, standard library folders, site-packages, etc.
        3.  finder locates the module
        4. returns a "spec" and a "loader" 
