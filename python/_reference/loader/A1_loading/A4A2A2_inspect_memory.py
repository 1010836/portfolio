import gc
import sys
import inspect
import tracemalloc

# Try to import resource module (Unix/Linux only)
try:
    import resource
    HAS_RESOURCE = True
except ImportError:
    HAS_RESOURCE = False

# Try to import psutil for cross-platform memory monitoring
try:
    import psutil
    HAS_PSUTIL = True
except ImportError:
    HAS_PSUTIL = False


def get_memory_usage():
    """Get comprehensive memory usage information."""
    print("Memory Usage Analysis")
    print("=" * 80)

    # Start tracemalloc if not already running
    if not tracemalloc.is_tracing():
        tracemalloc.start()
        print("Started tracemalloc for detailed memory tracking...")

    # Get overall process memory usage
    total_memory_bytes = None

    if HAS_PSUTIL:
        try:
            # Use psutil for cross-platform memory monitoring
            process = psutil.Process()
            memory_info = process.memory_info()
            total_memory_bytes = memory_info.rss  # Resident Set Size in bytes
            print(
                f"Total Process Memory (RSS): {total_memory_bytes:,} bytes ({total_memory_bytes / (1024*1024):.2f} MB)"
            )

            # Additional psutil memory info
            try:
                memory_percent = process.memory_percent()
                print(f"Memory Percentage of System: {memory_percent:.2f}%")
            except:
                pass

        except Exception as e:
            print(f"Could not get psutil memory info: {e}")

    elif HAS_RESOURCE:
        try:
            # Fall back to resource module (Unix/Linux only)
            memory_kb = resource.getrusage(resource.RUSAGE_SELF).ru_maxrss
            if sys.platform == 'win32':
                total_memory_bytes = memory_kb  # Windows reports in bytes
            else:
                total_memory_bytes = memory_kb * 1024  # Unix reports in KB

            print(
                f"Total Process Memory (RSS): {total_memory_bytes:,} bytes ({total_memory_bytes / (1024*1024):.2f} MB)"
            )
        except Exception as e:
            print(f"Could not get resource memory info: {e}")
    else:
        print(
            "Neither psutil nor resource module available - cannot get total process memory"
        )
        print(
            "To get comprehensive memory info, install psutil: pip install psutil"
        )

    # Get tracemalloc statistics
    try:
        current_traced, peak_traced = tracemalloc.get_traced_memory()
        print(
            f"Python Traced Memory (current): {current_traced:,} bytes ({current_traced / (1024*1024):.2f} MB)"
        )
        print(
            f"Python Traced Memory (peak): {peak_traced:,} bytes ({peak_traced / (1024*1024):.2f} MB)"
        )

        # Get detailed tracemalloc snapshot
        snapshot = tracemalloc.take_snapshot()
        top_stats = snapshot.statistics('lineno')

        print(f"\nTop 10 Memory Allocations:")
        print("-" * 50)
        for i, stat in enumerate(top_stats[:10]):
            print(f"{i+1:2}. {stat.traceback.format()[0]}")
            print(
                f"    Size: {stat.size:,} bytes ({stat.size / 1024:.1f} KB), Count: {stat.count}"
            )

    except Exception as e:
        print(f"Could not get tracemalloc statistics: {e}")
        current_traced = None

    return total_memory_bytes, current_traced


def get_current_module_memory():
    """Calculate memory usage specifically for the current module."""
    current_module = sys.modules[__name__]
    current_module_file = getattr(current_module, '__file__', '')

    print(f"\nCurrent Module Memory Analysis: {current_module.__name__}")
    print("=" * 80)

    # Get tracemalloc statistics filtered by current module
    if tracemalloc.is_tracing():
        try:
            snapshot = tracemalloc.take_snapshot()
            # Filter traces by current module file
            if current_module_file:
                module_stats = [
                    stat for stat in snapshot.statistics('lineno')
                    if stat.traceback.format()
                    [0].startswith(f'  File "{current_module_file}"')
                ]

                if module_stats:
                    total_module_memory = sum(
                        stat.size for stat in module_stats
                    )
                    print(
                        f"Module Traced Memory: {total_module_memory:,} bytes ({total_module_memory / 1024:.2f} KB)"
                    )

                    print(f"\nModule Memory Allocations (top 5):")
                    print("-" * 50)
                    for i, stat in enumerate(module_stats[:5]):
                        line_info = stat.traceback.format()[0].split(
                            ', line '
                        )[-1].split(':'
                                    )[0] if ', line ' in stat.traceback.format(
                                    )[0] else 'unknown'
                        print(
                            f"{i+1}. Line {line_info}: {stat.size:,} bytes ({stat.size / 1024:.1f} KB), {stat.count} allocations"
                        )
                else:
                    print(
                        "No traced memory allocations found for current module"
                    )
                    total_module_memory = 0
            else:
                print(
                    "Could not determine module file path for memory filtering"
                )
                total_module_memory = 0

        except Exception as e:
            print(f"Error analyzing module memory: {e}")
            total_module_memory = 0
    else:
        print(
            "Tracemalloc not running - cannot analyze module-specific memory"
        )
        total_module_memory = 0

    # Alternative: Calculate memory of module objects via GC
    module_objects = []
    gc_memory = 0

    try:
        all_objects = gc.get_objects()
        for obj in all_objects:
            try:
                if (hasattr(obj, '__module__') and obj.__module__ == current_module.__name__) or \
                   (hasattr(obj, 'f_code') and hasattr(obj.f_code, 'co_filename') and
                    obj.f_code.co_filename == current_module_file):
                    module_objects.append(obj)
                    try:
                        gc_memory += sys.getsizeof(obj)
                    except (TypeError, ValueError):
                        pass
            except (AttributeError, TypeError):
                continue

        print(f"\nGarbage Collector Analysis:")
        print(f"Module objects found: {len(module_objects)}")
        print(
            f"Approximate module object memory: {gc_memory:,} bytes ({gc_memory / 1024:.2f} KB)"
        )

    except Exception as e:
        print(f"Error in GC analysis: {e}")

    return total_module_memory, gc_memory


def inspect_current_module():
    # Get the current module
    current_module = sys.modules[__name__]

    print(f"Module Inspection: {current_module.__name__}")
    print("=" * 80)

    # Display module metadata
    print("Module Metadata:")
    print("-" * 40)
    print(f"Name: {getattr(current_module, '__name__', 'N/A')}")
    print(f"File: {getattr(current_module, '__file__', 'N/A')}")
    print(f"Package: {getattr(current_module, '__package__', 'N/A')}")
    print(f"Spec: {getattr(current_module, '__spec__', 'N/A')}")
    print(f"Doc: {getattr(current_module, '__doc__', 'N/A')}")

    # Get all members of the module
    members = inspect.getmembers(current_module)

    print(f"\nModule Members ({len(members)} total):")
    print("-" * 40)

    # Categorize members
    functions = []
    classes = []
    modules = []
    variables = []

    for name, obj in members:
        if inspect.isfunction(obj):
            functions.append((name, obj))
        elif inspect.isclass(obj):
            classes.append((name, obj))
        elif inspect.ismodule(obj):
            modules.append((name, obj))
        else:
            variables.append((name, obj))

    # Display functions
    if functions:
        print(f"\nFunctions ({len(functions)}):")
        for name, func in functions:
            module_name = getattr(func, '__module__', 'unknown')
            file_info = ""
            try:
                if hasattr(func, '__code__'):
                    file_info = f" at line {func.__code__.co_firstlineno}"
            except:
                pass
            print(f"  {name:<20} from {module_name}{file_info}")

            # Show function signature
            try:
                sig = inspect.signature(func)
                print(f"    Signature: {name}{sig}")
            except:
                print(f"    Signature: <unavailable>")

    # Display classes
    if classes:
        print(f"\nClasses ({len(classes)}):")
        for name, cls in classes:
            module_name = getattr(cls, '__module__', 'unknown')
            print(f"  {name:<20} from {module_name}")

            # Show class methods
            class_members = inspect.getmembers(cls, inspect.isfunction)
            if class_members:
                for method_name in class_members[:3]:  # Show first 3 methods
                    print(f"    - {method_name}()")
                if len(class_members) > 3:
                    print(f"    ... and {len(class_members) - 3} more methods")

    # Display imported modules
    if modules:
        print(f"\nImported Modules ({len(modules)}):")
        for name, mod in modules:
            file_path = getattr(mod, '__file__', 'built-in')
            print(f"  {name:<20} -> {file_path}")

    # Display variables
    if variables:
        print(f"\nVariables ({len(variables)}):")
        for name, var in variables:
            if not name.startswith('__'):  # Skip dunder variables
                var_type = type(var).__name__
                var_repr = repr(var)
                if len(var_repr) > 50:
                    var_repr = var_repr[:47] + "..."
                print(f"  {name:<20} ({var_type}): {var_repr}")


def inspect_module_objects_in_gc():
    # Get current module for comparison
    current_module = sys.modules[__name__]
    current_module_file = getattr(current_module, '__file__', '')

    print(f"Objects in GC from module: {current_module.__name__}")
    print("=" * 80)

    # Get all objects from garbage collector
    all_objects = gc.get_objects()
    module_objects = []

    # Filter objects that belong to this module
    for obj in all_objects:
        try:
            # Check if object has a module attribute pointing to our module
            if hasattr(
                obj,
                '__module__'
            ) and obj.__module__ == current_module.__name__:
                module_objects.append(obj)
            # Check if it's a frame from our module
            elif hasattr(obj, 'f_code') and hasattr(obj.f_code, 'co_filename'):
                if obj.f_code.co_filename == current_module_file:
                    module_objects.append(obj)
        except:
            continue

    print(f"Found {len(module_objects)} objects from this module:")
    print("-" * 40)

    # Group by type
    type_counts = {}
    for obj in module_objects:
        obj_type = type(obj).__name__
        type_counts[obj_type] = type_counts.get(obj_type, 0) + 1

    # Display type summary
    for obj_type, count in sorted(type_counts.items(), key=lambda x: x[1], reverse=True):
        print(f"{obj_type:<25} : {count:>6}")

    print(f"\nDetailed Object Information:")
    print("-" * 40)

    # Display detailed info for each object
    for i, obj in enumerate(module_objects[:20]):  # Limit to first 20
        obj_type = type(obj).__name__
        obj_id = id(obj)

        # Get size if possible
        try:
            obj_size = sys.getsizeof(obj)
        except:
            obj_size = "N/A"

        # Get string representation (truncated)
        try:
            obj_repr = repr(obj)
            if len(obj_repr) > 60:
                obj_repr = obj_repr[:57] + "..."
        except:
            obj_repr = "<repr unavailable>"

        print(
            f"{i+1:>3}. {obj_type:<20} | ID: {obj_id} | Size: {obj_size:<8} | {obj_repr}"
        )

    if len(module_objects) > 20:
        print(f"\n... and {len(module_objects) - 20} more objects")


def main():

    # Get comprehensive memory usage first
    total_memory, traced_memory = get_memory_usage()

    print("\n" + "=" * 80)

    # Use inspect module for proper module introspection
    inspect_current_module()

    print("\n" + "=" * 80)

    # Get current module specific memory usage
    module_traced, module_gc = get_current_module_memory()

    print("\n" + "=" * 80)

    # Also show GC objects if needed
    inspect_module_objects_in_gc()

    # Summary
    print("\n" + "=" * 80)
    print("MEMORY USAGE SUMMARY")
    print("=" * 80)
    if total_memory:
        print(
            f"Total Application Memory: {total_memory:,} bytes ({total_memory / (1024*1024):.2f} MB)"
        )
    if traced_memory:
        print(
            f"Python Traced Memory: {traced_memory:,} bytes ({traced_memory / (1024*1024):.2f} MB)"
        )
        if total_memory and traced_memory:
            percentage = (traced_memory / total_memory) * 100
            print(f"Traced Memory as % of Total: {percentage:.2f}%")

    print(
        f"Current Module Memory (traced): {module_traced:,} bytes ({module_traced / 1024:.2f} KB)"
    )
    print(
        f"Current Module Memory (GC objects): {module_gc:,} bytes ({module_gc / 1024:.2f} KB)"
    )

    if traced_memory and module_traced > 0:
        module_percentage = (module_traced / traced_memory) * 100
        print(f"Module Memory as % of Traced: {module_percentage:.2f}%")


if __name__ == "__main__":
    main()
