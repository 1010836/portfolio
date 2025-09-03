Looking at your `_Runner` class and its purpose within the c0dice_loader library, `subprocess` is the correct choice over `multiprocessing` for several key reasons:

## Process Isolation vs Thread Sharing

**subprocess** creates completely separate processes with their own:
- Python interpreter instances
- Memory spaces
- Environment variables
- Working directories

**multiprocessing** shares the same Python interpreter and can inherit the parent process's state, which could interfere with:
- Import paths
- Global variables
- Module caches

## PDM Environment Execution

Your code specifically executes Python files/modules within PDM project environments:

````python
cmd = [str(self.__python_path), str(self.__shared.normalized_path)]
result = subprocess.run(cmd, cwd=str(self.__project_root))
````

This pattern requires:
1. **Different Python interpreter** (`self.__python_path` from PDM)
2. **Different working directory** (`self.__project_root`)
3. **Different environment** (PDM's virtual environment)

`multiprocessing` cannot achieve this level of environment isolation since it uses the same Python executable and environment.

## Error Handling and Output Capture

Your implementation captures both stdout and stderr:

````python
result = subprocess.run(
    cmd,
    capture_output=True,
    text=True,
    cwd=str(self.__project_root)
)
````

This allows you to:
- Detect execution failures via `returncode`
- Capture and display output with `print(result.stdout)`
- Handle errors with structured exception raising

`multiprocessing` would require more complex inter-process communication mechanisms to achieve the same level of control.

## Architecture Alignment

Your loader's purpose is to execute external Python modules/files in their proper PDM environments, not to run parallel tasks within the same process context. `subprocess` aligns perfectly with this "external execution" model, while `multiprocessing` is designed for parallel computation within the same application.

The choice of `subprocess` ensures proper isolation, environment control, and clean execution semantics for your PDM-based Python module executor.
