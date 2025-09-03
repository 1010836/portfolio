import importlib.util
import sys

# The name of the module we want to load
# This module must be findable on sys.path (like 'json', 'numpy', 'os', etc.)
module_name = "json"

# --- For Demonstration: Clear the module if it's already loaded ---
# This ensures we are loading it from scratch
if module_name in sys.modules:
    print(
        f"'{module_name}' is already loaded. Removing it from cache for this demo."
    )
    del sys.modules[module_name]
# ---------------------------------------------------------------

print(f"--- Starting manual load of '{module_name}' ---")

# 1. Find the spec for the module.
# This is the main difference from your file-loading method.
# find_spec() uses the finders in sys.meta_path to locate the module.
spec = importlib.util.find_spec(module_name)

if spec is None:
    print(f"Error: Could not find a spec for '{module_name}'")
else:
    print(f"1. Spec found: {spec.name}")
    print(f"   Loader: {spec.loader.__class__.__name__}")
    print(f"   Location: {spec.origin}")  # .origin is the file path

    # 2. Create a new, empty module object from the spec.
    module = importlib.util.module_from_spec(spec)
    print(f"2. Empty module object created: {module}")

    # 3. Add the module to sys.modules BEFORE execution.
    # This is critical for handling imports within the module itself.
    sys.modules[module_name] = module
    print(f"3. Module added to sys.modules['{module_name}']")

    # 4. Execute the module's code.
    # The loader reads the code from spec.origin, executes it,
    # and populates the 'module' object's namespace.
    try:
        assert spec.loader is not None, "Loader is None"
        spec.loader.exec_module(module)
        print(f"4. Module code executed. Load complete.")

        # --- Verification ---
        print("\n--- Verification ---")
        # Check that the module is in the cache
        print(
            f"Is '{module_name}' in sys.modules? {module_name in sys.modules}"
        )

        # Use the module to prove it's loaded
        my_data = module.loads('{"hello": "world"}')
        print(f"Successfully used module to parse: {my_data}")

    except Exception as e:
        print(f"4. ERROR during module execution: {e}")
        # If loading fails, remove it from the cache
        if module_name in sys.modules:
            del sys.modules[module_name]
