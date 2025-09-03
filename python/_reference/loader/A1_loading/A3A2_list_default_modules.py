import sys


def main():

    print("")
    print("-" * 150)
    print(f"{'nº':<4} {'name':<30} {'path'}")
    print("-" * 150)

    line_number = 1
    for name, module in sorted(sys.modules.items()):
        if module is not None:
            try:
                file_path = getattr(module, '__file__', 'built-in')
                print(f"{line_number:<4} {name:<30} {file_path}")
            except:
                print(f"{line_number:<4} {name:<30} built-in")
        else:
            print(f"{line_number:<4} {name:<30} None")
        line_number += 1

    print("-" * 150)
    print("Loaded Modules:", len(sys.modules))


if __name__ == "__main__":
    main()
