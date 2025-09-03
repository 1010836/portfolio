# 1. Accessing the Memory Manager at Runtime

## 1.1 what

    1. directly accessing the "Python Memory Manager" itself is not possible
        1.1 in the way you might access a regular object
    
    2. it's part of the C-level core of the interpreter

    3. however, Python provides two powerful built-in modules,
        3.1 `gc` and `sys`, 
        3.2 that serve as a public API 
            3.2 to interact with and introspect the memory management process
            3.2 specifically the garbage collector and object metadata

## 1.2 The `gc` Module (Garbage Collector Interface)

### 1.2.1 what

*   **`gc.get_objects()`**: Returns a list of **all objects currently tracked by the garbage collector**. This is incredibly powerful. It won't include simple things like small integers or strings that are often cached, but it includes most custom objects, lists, dicts, functions, classes, etc.
*   **`gc.get_referrers(*objs)`**: Shows you what other objects are pointing *to* your object. This is essential for debugging memory leaks and circular references.
*   **`gc.get_referents(*objs)`**: The opposite. Shows you what objects your object is pointing *to*.

### 1.2.2 example: Finding a Circular Reference**

```python
import gc

def create_cycle():
    # Create two objects that refer to each other
    my_list = [1, 2, 3]
    my_list.append(my_list) # The list now refers to itself
    return my_list

# Create the cycle and then lose the only reference to it
cycle = create_cycle()
del cycle

# Manually run the garbage collector to find and clean up unreachable cycles
# The number returned is the number of objects collected.
collected_count = gc.collect()
print(f"Garbage collector collected {collected_count} objects.")

# Let's find out what objects are holding a specific type
all_lists = [obj for obj in gc.get_objects() if isinstance(obj, list)]
print(f"\nFound {len(all_lists)} list objects still in memory.")

# Let's inspect an object's referrers
a = {"key": "value"}
b = [a]

# Get the objects referring to 'a'
referrers = gc.get_referrers(a)
print(f"\nObject 'a' is being referred to by {len(referrers)} other objects.")
# The first referrer is often the list 'b', the second might be the frame's locals, etc.
```

## 1.3 The `sys` Module

    1. This module provides more specific, low-level information about individual objects.

    2. **`sys.getrefcount(object)`**:
    
        2.1 returns the reference count of an object.
        2.2 **Warning:** The number will always be at least one higher than you expect, 
        2.3 because calling the function itself creates a temporary reference 
        2.4 to the object from the function's argument.

    3. **`sys.getsizeof(object)`**:

        3.1 Returns the size of an object in bytes. 
        3.2 This only includes the memory consumed by the object itself,
        3.3 not the objects it might contain 
        3.4 for a list, it's the size of the list's internal pointer array,
        3.5 not the size of the objects *in* the list

**Example: Inspecting an Object's Size and References**
```python
import sys

my_list = [1, 2, 3, 4]
my_other_list = my_list # Create another reference

# Note: The 'real' refcount is 2 (my_list, my_other_list).
# The function call adds a temporary 3rd reference.
print(f"Reference count of list: {sys.getrefcount(my_list)}")

# Get the base size of the list object
print(f"Size of the list object itself: {sys.getsizeof(my_list)} bytes")

# The size doesn't include the integers it points to
print(f"Size of an integer: {sys.getsizeof(1)} bytes")
```

---

# 2. Summary

| What do you want to do? | Which Tool Should You Use? |
| :--- | :--- |
| Find all objects of a certain type in memory. | `gc.get_objects()` |
| Debug a memory leak or find what's keeping an object alive. | `gc.get_referrers()` |
| See the reference count or base memory size of a specific object. | `sys.getrefcount()`, `sys.getsizeof()` |
| **Get the values of variables during a function's execution (for a profiler).** | **The `frame.f_locals` and `frame.f_globals` attributes of the `frame` object.** |
| Get metadata about how a module was imported. | The module's `__spec__` attribute. (Not for runtime state) |
