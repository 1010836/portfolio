import os
os.system('cls' if os.name == 'nt' else 'clear')

# 1. demonstrate all python variable types
print(f"1. demonstrate all python variable types\n")

#   1.1 int
int_var = 98762345098709872345000
print(f"  1.1 Integer: {int_var}, type: {type(int_var)}")
int_var = int('100')
print(f"    1.1.1 int('100') : {int_var}, type: {type(int_var)}\n")
is_int = isinstance(int_var, int)
print(f"    1.1.2 isinstance(int_var, int) : {is_int}, type: {type(is_int)}\n")

#   1.2 float
float_var = 20.5
print(f"  1.2 Float: {float_var}, type: {type(float_var)}")
float_var = int(2.3)
print(f"    1.2.1 int(2.3): {float_var}, type: {type(float_var)}\n")

#   1.3 string
string_var = "Hello, World!"
print(f"  1.3 String: {string_var}, type: {type(string_var)}")
string_var = str(200)
print(f"    1.3.1 str(200): {string_var}, type: {type(string_var)}\n")

#   1.4 list
list_var = [1, 2, 3, 4, 5]
print(f"  1.4 List: {list_var}, type: {type(list_var)}\n")

#   1.5 tuple
tuple_var = (6, 7, 8)
print(f"  1.5 Tuple: {tuple_var}, type: {type(tuple_var)}\n")

#   1.6 tuple
dict_var = {"key1": "value1", "key2": "value2", "key3": "value3"}
print(f"  1.6 Dictionary: {dict_var}, type: {type(dict_var)}\n")

#   1.7 set
set_var = {9, 10, 11}
print(f"  1.7 Set: {set_var}, type: {type(set_var)}\n")

#   1.8 frozenset
frozenset_var = frozenset([12, 13, 14])
print(f"  1.8 Frozenset: {frozenset_var}, type: {type(frozenset_var)}\n")








