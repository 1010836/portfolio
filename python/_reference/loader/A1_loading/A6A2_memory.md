# 1. Getting Data Values

## 1.1 frame object

    1. when your profile function is called (`__profile_function(frame, event, arg)`), 

    2. the `frame` object it receives is a snapshot of a specific function's execution stack at that exact moment
    
    3. It is the single most important tool for introspection

    4. A `frame` object contains everything you need:
    
*   4.1 **`frame.f_locals`**: 
  
        1. a dictionary containing all **local variables**
            1.1 in the function's scope 
            1.2 at that moment 
            
*   4.2 **`frame.f_globals`**: 

        1. a dictionary containing the **global variables**
            1.1 from the module 
            1.2 where the function is defined.

*   4.3 **`frame.f_code.co_name`**: 

        1. the name of the function being executed

*   4.4 **`frame.f_code.co_filename`**: 
    
        1. The file where the code is located.

## 1.2 example: A Profiler that Inspects Local Variables**

```python
import sys
import time

class SimpleStateProfiler:
    def __init__(self):
        self._original_profile_func = sys.getprofile()

    def __enter__(self):
        sys.setprofile(self._profile_function)

    def __exit__(self, exc_type, exc_val, exc_tb):
        sys.setprofile(self._original_profile_func)

    def _profile_function(self, frame, event, arg):
        # We only care about 'line' events
        if event == 'line':
            func_name = frame.f_code.co_name
            line_no = frame.f_lineno
            local_vars = frame.f_locals

            print(f"--- Line {line_no} in `{func_name}` ---")
            if local_vars:
                print("  Local variables:")
                for name, value in local_vars.items():
                    # Let's get the size of the object too!
                    size = sys.getsizeof(value)
                    print(f"    - {name} = {repr(value)} (size: {size} bytes)")
            else:
                print("  No local variables yet.")

# --- Function to be profiled ---
def process_data(items):
    processed = []
    for i, item in enumerate(items):
        new_item = {
            "id": i,
            "value": item * 10
        }
        processed.append(new_item)
        time.sleep(0.1) # slow it down so we can read the output
    return processed

# --- Run the profiler ---
with SimpleStateProfiler():
    data_to_process = ["a", "b"]
    result = process_data(data_to_process)

print("\nFinal result:", result)
```

### 1.2.1 description
    1. when you run this, 
    2. you will see a detailed, line-by-line trace of how the local variables (`processed`, `i`, `item`, `new_item`) 
    
        2.1 come into existence 
        2.2 what their values 
        2.3 sizes 

# 2. summary

| What do you want to do? | Which Tool Should You Use? |
| :--- | :--- |
| Find all objects of a certain type in memory. | `gc.get_objects()` |
| Debug a memory leak or find what's keeping an object alive. | `gc.get_referrers()` |
| See the reference count or base memory size of a specific object. | `sys.getrefcount()`, `sys.getsizeof()` |
| **Get the values of variables during a function's execution (for a profiler).** | **The `frame.f_locals` and `frame.f_globals` attributes of the `frame` object.** |
| Get metadata about how a module was imported. | The module's `__spec__` attribute. (Not for runtime state) |
