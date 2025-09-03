# 1. Load model as file

| Step | Loading a `.py` from a file path | Loading a module by name |
| :--- | :--- | :--- |
| **1. Get Spec** | `spec = spec_from_file_location(name, path)` | `spec = find_spec(name)` |
| **2. Create Module** | `module = module_from_spec(spec)` | `module = module_from_spec(spec)` |
| **3. Cache Module** | `sys.modules[name] = module` | `sys.modules[name] = module` |
| **4. Execute Module** | `spec.loader.exec_module(module)` | `spec.loader.exec_module(module)` |
