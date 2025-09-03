# multiple process communication (IPC)

### Queues and Pipes
Queues and pipes are fundamental for communication between processes. They are the most common and straightforward methods for passing messages.

* **Pipes** are a simpler form of communication, typically used for two-way communication between a parent process and a child process. Python's `multiprocessing.Pipe()` returns a pair of connection objects connected by a pipe. They are best for one-to-one communication.
* **Queues** are thread- and process-safe, making them excellent for passing data between multiple processes in a producer-consumer model. The `multiprocessing.Queue` class is a FIFO (First-In, First-Out) data structure that allows multiple processes to put and get items.  This method is more versatile than pipes because it can handle many-to-many communication.

---

### Shared Memory
Shared memory allows multiple processes to access the same region of memory. This method is often the fastest way to communicate because it avoids the overhead of copying data.

* **`multiprocessing.Value` and `multiprocessing.Array`** are used for simple data types. `Value` is for a single shared variable, and `Array` is for a shared array of a specific type.
* **`multiprocessing.Manager`** provides a way to create more complex shared objects, such as lists, dictionaries, and user-defined classes. It creates a server process that manages these objects and allows other processes to access them through proxies. This is useful when you need to share a complex data structure that is not a simple value or array.

---

### Sockets
**Sockets** provide a robust and flexible way to communicate, even across a network. They allow processes on different machines to interact. In Python, the `socket` module provides low-level networking primitives. While more complex to set up than queues or pipes, sockets are essential for distributed systems where processes are not running on the same machine.

---

### Signals
**Signals** are a simple form of inter-process communication used to notify a process of an event. A process can send a signal to another process to interrupt its normal flow of execution. The `signal` module in Python allows you to handle signals, such as `SIGINT` (sent when you press Ctrl+C), which can be caught and handled by your program. They are not used for data exchange but for notification.

---

### Other synchronization primitives
While not for data transfer, synchronization primitives are crucial for coordinating processes to prevent race conditions when using shared resources like shared memory.

* **Locks (`multiprocessing.Lock`)** are used to serialize access to a shared resource. Only one process can acquire the lock at a time.
* **Semaphores (`multiprocessing.Semaphore`)** are similar to locks but allow a limited number of processes to access a resource simultaneously.
* **Events (`multiprocessing.Event`)** are a way for one process to signal to other processes that an event has occurred. Processes can wait for the event to be set before proceeding.

# sub process

Of the possibilities for inter-process communication discussed, you can use **pipes** and **sockets** with the `subprocess` module. Queues and shared memory, which are part of the `multiprocessing` module, are not directly integrated with `subprocess` for communication.

-----

### Pipes

Pipes are the most common way to communicate with a subprocess. The `subprocess.run()` and `subprocess.Popen()` functions have `stdout` and `stdin` arguments that can be set to `subprocess.PIPE`. This creates a pipe that connects the standard output of the child process to a file-like object in the parent process, and a similar pipe for standard input.

  * **Reading from a subprocess:** You can capture the output of a command by setting `stdout=subprocess.PIPE`.
    ```python
    import subprocess

    result = subprocess.run(['ls', '-l'], capture_output=True, text=True)
    print(result.stdout)
    ```
  * **Writing to a subprocess:** You can send input to a subprocess by setting `stdin=subprocess.PIPE` and using the `communicate()` method.
    ```python
    import subprocess

    proc = subprocess.Popen(['grep', 'example'], stdin=subprocess.PIPE, stdout=subprocess.PIPE, text=True)
    stdout, stderr = proc.communicate(input='This is a line with an example.\nThis is another line.')
    print(stdout)
    ```

-----

### Sockets

You can use sockets for more flexible communication with a subprocess, especially if the child process is designed to act as a server or a client. You would first create a socket in the parent process and then pass information about that socket (like its file descriptor or address) to the child process. The child process can then connect to or accept connections on that socket. This approach is more complex than using pipes but allows for more sophisticated communication patterns, including network-based IPC.
