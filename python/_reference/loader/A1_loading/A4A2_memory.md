# 1. Python Memory Management Process

    1. is automatic

    2. designed to be transparent to the programmer

    3. it's handled by the **Python Memory Manager**
        3.1 uses a private heap to store all your objects
        
# 2. techniques:

## 2.1 Reference Counting

1.  **Everything is an Object:** 
    
        1. every value in Python, from a number (`5`) to a string (`"hello"`) to a function, 
        2. is an object stored in memory.

2.  **Variables are Pointers:** 

        1. a variable (like `x`) is not a box that contains a value
        2. it's a **name** or a **pointer** that refers to an object

3.  **The Count:** 
    
        1. every object in memory keeps track of how many variables (names) 
        2. are pointing to it. This is its "reference count"

4.  **Counting Rules:**

        1. when you assign a variable to an object (`x = my_object`)
            1.1 its reference count increases by 1

        2. when you create another reference (`y = x`)
           2.1 the object's reference count increases by 1 again.
        
        3. when a variable goes out of scope 
            3.1 a function finishes
            3.2 or is reassigned (`x = None`)
            3.3 the reference count of the object it was pointing to decreases by 1

5.  **Deallocation:** 

        As soon as an object's reference count drops to **zero**, it means nothing in your program can access it anymore. Python's Memory Manager immediately frees the memory that object was using.

## 2.2 garbage collector

### 2.2.1 why
    
    Reference counting is fast and efficient, but it has one critical weakness: **circular references**. This happens when objects refer to each other.

### 2.2.2 Example:

```python
obj_a = {}
obj_b = {}

# Create a circular reference
obj_a['b_ref'] = obj_b
obj_b['a_ref'] = obj_a

# Now, let's remove the original names
del obj_a
del obj_b
```

        In this case, the reference counts for `obj_a` and `obj_b` 
        will never drop to zero because they are still pointing to each other, 
        even though they are completely inaccessible from the rest of the program
        This would cause a memory leak.

        This is where the **Garbage Collector** comes in
        It's a separate process that runs periodically. 
        Its specific job is to detect these unreachable "islands" of objects (cycles)
        and clean them up

---
