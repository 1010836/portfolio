import datetime
from typing import Optional

class Debug:
    
    indent: int = 0
    
    @classmethod
    def inc(cls):
        cls.indent += 2

    @classmethod
    def dec(cls):
        cls.indent -= 2

    @classmethod
    def print(cls, object: object, title: Optional[str] = None, indent: int = 2):
        if title:
            cls._print_title(title, indent)

        cls._serialize(object, indent)

    @classmethod
    def _print_title(cls, title: str, indent: int):
        """Displays the debug title."""

        # region 1. center title

        title_length = len(title)
        available_space = 78 - title_length
        left_margin = available_space // 2

        reminder = available_space % 2
        right_margin = left_margin + reminder

        title_line = f"|{' ' * left_margin}{title}{' ' * right_margin}|"

        # endregion

        # region 2. empty line
        print("")
        # endregion

        # region 3. print indented_title
        indentation = " " * indent
        print(
            indentation
            + "--------------------------------------------------------------------------------"
        )
        print(indentation + title_line)
        print(
            indentation
            + "--------------------------------------------------------------------------------"
        )
        # endregion

    @classmethod
    def _serialize(cls, obj: object, indent: int):

        if cls._is_relevant(obj):
            
            if not cls._is_empty(obj):

                if cls._is_basic(obj):
                    cls._print_basic(obj, indent)

                elif cls._is_str_multiline(obj):
                    cls._print_str_multiline(str(obj), indent)

                elif isinstance(obj, datetime.datetime):
                    cls._print_date(obj, indent)
                
                elif hasattr(obj, "to_dict"):
                    cls._print_object_with_dict(obj, obj.to_dict().items(), indent)

                elif hasattr(obj, "__dict__"):
                    cls._print_object_with_dict(obj, obj.__dict__.items(), indent)

                elif isinstance(obj, dict):
                    cls._print_dict(obj, indent)

                elif isinstance(obj, list):
                    cls._print_list(obj, indent)

                elif isinstance(obj, tuple):
                    cls._print_list(obj, indent)
                
                elif isinstance(obj, set):
                    cls._print_list(obj, indent)
                
                elif isinstance(obj, frozenset):
                    cls._print_list(obj, indent)

                else:
                    cls._print_object(obj, indent)

    @classmethod
    def _is_basic(cls, obj:object):
    
        result = isinstance(obj, (int, float, bool, bytes, complex))
    
        if not result:
            result = cls._is_str_basic(obj)

        return result

    @classmethod
    def _is_str_basic(cls, obj:object):
    
        result = isinstance(obj, str)
    
        if result:
            obj_as_string = str(obj)
            result = "\n" not in obj_as_string

        return result

    @classmethod
    def _print_basic(cls, obj:object, indent: int):

        indentation = " " * indent

        print(f"{indentation}{obj}")

    @classmethod
    def _print_date(cls, date: datetime.datetime, indent: int):

        indentation = " " * indent

        date_as_text = date.strftime("%Y-%m-%d %H:%M:%S")

        print(f"{indentation}{date_as_text}")

    @classmethod
    def _print_object_with_dict(cls, obj: object, items, indent: int):

        indentation = " " * indent
        object_type = str(type(obj))

        print(f"{indentation}{object_type}")

        cls._print_attributes(items, indent + 2)

    @classmethod
    def _print_dict(cls, obj: dict, indent: int):
        cls._print_attributes(obj.items(), indent)        

    @classmethod
    def _print_attributes(cls, items, indent: int):

        indentation = " " * indent

        lengths = [len(item_name) for item_name, item_value in items if cls._is_relevant(item_value) and hasattr(item_name, "__len__")]
        max_len = max(lengths, default=0)
        
        for item_name, item_value in items:
            
            if not isinstance(item_name, str):
                continue

            designation = f"{indentation}{item_name.ljust(max_len)}"

            cls._print_item(item_value, designation, indent)

    @classmethod
    def _print_item(cls, obj: object, designation: str, indent: int):

        def _get_display_value(obj: object) -> str:

            result = str(type(obj))

            if cls._is_basic(obj):
                result = str(obj)

            return result
    
        def _process_not_basic(obj: object, indent: int):
            
            if not cls._is_basic(obj):

                next_indent = indent + 2

                if hasattr(obj, "__dict__"):
                    cls._print_dict(obj.__dict__, next_indent)
                else:
                    cls._serialize(obj, next_indent)
        
        if cls._is_relevant(obj):
            
            if not cls._is_empty(obj):

                if not cls._is_manually_excluded(designation):

                    display_value = _get_display_value(obj)

                    print(f"{designation}: {display_value}")

                    _process_not_basic(obj, indent)

    @classmethod
    def _is_manually_excluded(cls, designation: str)->bool:
        
        result = False

        if "_reply_func_list" in designation:
            result = True

        return result

    @classmethod
    def _is_relevant(cls, obj: object)->bool:
        
        result = True

        obj_type = str(type(obj))
        if obj_type in (
            "<class 'function'>",
            "<class 'property'>",
            "<class 'getset_descriptor'>",
            "<class 'classmethod'>",
            "<class 'NoneType'>",
            "<class 'set'>",
            "<class '_abc._abc_data'>",
            "<class 'autogen.oai.client.OpenAIWrapper'>",
            "<class 'dynaconf.base.Settings'>",
            "<class 'type'>"
        ):
            result = False

        return result

    @classmethod
    def _is_empty(cls, obj: object)->bool:
        
        result = False
            
        if isinstance(obj, dict):
            if len(obj) == 0:
                result = True

        if isinstance(obj, list):
            if len(obj) == 0:
                result = True

        if isinstance(obj, tuple):
            if len(obj) == 0:
                result = True

        if isinstance(obj, set):
            if len(obj) == 0:
                result = True

        if isinstance(obj, frozenset):
            if len(obj) == 0:
                result = True
        
        if isinstance(obj, str):
            if len(obj) == 0:
                result = True

        return result

    @classmethod
    def _print_list(cls, obj: list | tuple | set | frozenset, indent: int):

        indent += 2
        indentation = " " * indent
        
        item: object = None
        for index, item in enumerate(obj):

            designation = f"{indentation}[{index}]"

            cls._print_item(item, designation, indent)

    @classmethod
    def _is_str_multiline(cls, obj:object):
    
        result = isinstance(obj, str)
        obj_as_string = str(obj)

        if result:
            result = "\n" in obj_as_string
            
        return result

    @classmethod
    def _print_str_multiline(cls, obj: str, indent: int):

        array_of_lines = obj.split("\n")

        next_indent = indent + 2            
        Debug._serialize(array_of_lines, next_indent)

    @classmethod
    def _print_object(cls, obj: object, indent: int):

        indentation = " " * indent
        object_type = str(type(obj))
        
        print(f"{indentation}object: {object_type}")

    @classmethod
    def profile(cls, func):

        def wrapper(*args, **kwargs):
            if len(args)==0:
                class_name = "unknown"
            elif hasattr(args[0], "__name__"):
                class_name = args[0].__name__
            else:
                class_name = type(args[0]).__name__

            method_name = func.__name__
            
            cls.print(f"{method_name}()", class_name, cls.indent)
            
            cls.inc()
            result = func(*args, **kwargs)
            cls.dec()

            return result
        
        return wrapper
    
def main():
    Debug.print("Debug library")    

if __name__ == "__main__":
    main()
