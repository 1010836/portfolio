# 1. `__dict__` attribute

## 1.1 what

    1. is a **dictionary**
    
    2. that acts as the module's **namespace**

    3. a namespace is
        3.1 a system that has a unique name for each and every object
        3.2 a map where 
            3.2.1 **keys** are the names of your variables, functions, and classes (as strings), 
            3.2.2 **values** are the actual objects in memory that those names refer to

    4. when write a Python file (a module), 
        4.1 every 
            4.1.1 global variable, function, and class 
        4.2 defined 
            4.2.2 is added as an entry to that module's `__dict__`.

## 1.2 example

### 1.2.1 test module

```python
# my_module.py

print("This module is being loaded!")

PI = 3.14159
_internal_version = "1.0"

def calculate_area(radius):
    return PI * (radius ** 2)

class Circle:
    def __init__(self, radius):
        self.radius = radius
```

### 1.2.2 inspect

```python
import my_module
import pprint

# The __dict__ contains everything defined at the global level in my_module.py
pprint.pprint(my_module.__dict__)
```

### 1.2.3 output

```
{'Circle': <class 'my_module.Circle'>,
 'PI': 3.14159,
 '__builtins__': { ... },
 '__cached__': '.../__pycache__/my_module.cpython-39.pyc',
 '__doc__': None,
 '__file__': '/path/to/my_module.py',
 '__loader__': <...>,
 '__name__': 'my_module',
 '__package__': '',
 '__spec__': ModuleSpec(...),
 '_internal_version': '1.0',
 'calculate_area': <function my_module.calculate_area at 0x...>}
```

    1. `PI`, `_internal_version`, `calculate_area`, and `Circle` 
        1.1 are all keys in this dictionary
        1.2 their values are the float, string, function, and class objects respectively
    2. the other `__` attributes are the standard ones Python adds to every module

## 1.2 get `__dict__` at Runtime

### Method 1: Dot Notation

```python
import my_module

# Python's user-friendly way to access the namespace
radius = 10
area = my_module.calculate_area(radius)

print(f"The value of PI is: {my_module.PI}")
print(f"The area of a circle with radius {radius} is: {area}")
```

### Method 2: Direct Dictionary Access

```python
import my_module

attribute_name_as_string = "PI"
function_name_as_string = "calculate_area"

# Accessing the values by treating the namespace as a dictionary
pi_value = my_module.__dict__[attribute_name_as_string]
area_function = my_module.__dict__[function_name_as_string]

print(f"The value of '{attribute_name_as_string}' is: {pi_value}")

# We can even call the function we retrieved
area = area_function(10)
print(f"The result of calling '{function_name_as_string}' is: {area}")
```

---
