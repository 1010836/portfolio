import sys


def main():

    print("")
    print("-" * 100)
    print(f"{'nº':<4} {'path'}")
    print("-" * 100)

    for i, path in enumerate(sys.path):
        print(f"{i+1:<4} {path}")

    print("-" * 100)
    print("Sys path:", len(sys.path))


if __name__ == "__main__":
    main()
