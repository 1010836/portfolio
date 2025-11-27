You basically have **two big families of tools** to “register every function that is executed” in Python:

1. **Decorator-based instrumentation** – you choose *which* functions to wrap.
2. **Global tracing/profiling hooks** – you get *every* function call (then filter).

I’ll walk through both and how they combine, plus how to cover non-function code blocks.

---

## 1. Core building block: a tracing/profiling decorator

### 1.1. Minimal call-logging decorator

```python
import time
import functools

def trace(func):
    @functools.wraps(func)
    def wrapper(*args, **kwargs):
        start = time.perf_counter()
        try:
            result = func(*args, **kwargs)
            return result
        finally:
            elapsed = time.perf_counter() - start
            print(f"[TRACE] {func.__module__}.{func.__qualname__} "
                  f"took {elapsed:.6f}s")
    return wrapper
```

Usage:

```python
@trace
def compute(x, y):
    return x * y
```

**What this gives you:**

* A record of *every decorated function* that runs.
* Basic timing (wall-clock).
* `@functools.wraps(func)` preserves:

  * `__name__`, `__qualname__`, `__doc__`, etc.
  * So stack traces, logging, and tools like `inspect` see the *original* function, not `wrapper`.

You almost always want `wraps` for tracing/profiling decorators; without it, introspection gets messy and your profiler appears as a bunch of `wrapper` calls.

---

### 1.2. Async-aware decorator

To handle `async def` functions correctly, you need an async wrapper:

```python
def trace_async(func):
    if not asyncio.iscoroutinefunction(func):
        raise TypeError("@trace_async only for async def")

    @functools.wraps(func)
    async def wrapper(*args, **kwargs):
        start = time.perf_counter()
        try:
            return await func(*args, **kwargs)
        finally:
            elapsed = time.perf_counter() - start
            print(f"[TRACE] {func.__module__}.{func.__qualname__} "
                  f"(async) took {elapsed:.6f}s")
    return wrapper
```

You can also build a **unified decorator** that detects sync vs async and wraps accordingly.

---

### 1.3. Decorator with options: enable/disable, logger, threshold

You’ll often want:

* A **registry** of calls.
* A way to **disable** tracing without removing decorators.
* A **threshold** (log only if slower than X ms).
* Integration with the `logging` module.

```python
import logging
import time
import functools

log = logging.getLogger("profiler")
TRACE_ENABLED = True
CALL_REGISTRY = []   # global or per-thread/context, depending on needs

def profile(threshold_ms: float = 0.0, register: bool = True):
    def decorator(func):
        @functools.wraps(func)
        def wrapper(*args, **kwargs):
            if not TRACE_ENABLED:
                return func(*args, **kwargs)

            start = time.perf_counter()
            try:
                result = func(*args, **kwargs)
                return result
            finally:
                elapsed = (time.perf_counter() - start) * 1000
                if elapsed >= threshold_ms:
                    entry = {
                        "func": func.__qualname__,
                        "module": func.__module__,
                        "elapsed_ms": elapsed,
                    }
                    if register:
                        CALL_REGISTRY.append(entry)
                    log.info("[PROFILE] %s.%s took %.3f ms",
                             func.__module__, func.__qualname__, elapsed)
        return wrapper
    return decorator
```

Usage:

```python
@profile(threshold_ms=1.0)
def handle_request(data):
    ...
```

Now you’ve got:

* A **list of all decorated calls** in `CALL_REGISTRY`.
* Full control to filter, aggregate, or export.

---

## 2. How to apply decorators at scale

Decorating a handful of functions is easy. But you asked about “register every function that is executed”. There are several strategies:

### 2.1. Manual decoration (explicit @decorator)

Pros: precise control, minimal magic.
Cons: you *must remember* to decorate.

```python
@profile()
def f1(): ...
@profile()
def f2(): ...
```

You can make it less painful by:

* Decorating base classes or utility functions.
* Exporting a single `@profiled` decorator and using it everywhere.

---

### 2.2. Class decorators: wrap all methods in a class

You can write a decorator that iterates over attributes and wraps every method:

```python
def profile_methods(decorator=profile()):
    def wrap_class(cls):
        for name, attr in list(cls.__dict__.items()):
            # skip magic methods if you want
            if name.startswith("__") and name.endswith("__"):
                continue
            if callable(attr):
                setattr(cls, name, decorator(attr))
        return cls
    return wrap_class
```

Usage:

```python
@profile_methods()
class Service:
    def op1(self): ...
    def op2(self, x): ...
```

Now every method in `Service` is profiled.

---

### 2.3. Metaclasses: auto-decorate new methods on class creation

A **metaclass** can automatically wrap all callables when the class is created:

```python
class ProfiledMeta(type):
    def __new__(mcls, name, bases, namespace):
        new_ns = {}
        for attr_name, attr in namespace.items():
            if callable(attr) and not attr_name.startswith("__"):
                attr = profile()(attr)
            new_ns[attr_name] = attr
        return super().__new__(mcls, name, bases, new_ns)
```

Usage:

```python
class Service(metaclass=ProfiledMeta):
    def op1(self): ...
    def op2(self): ...
```

All instance methods get auto-wrapped.

---

### 2.4. Module-level auto-decoration

If you want to instrument **all functions in a module** without littering `@decorator` everywhere, you can do something like this at the bottom of the module:

```python
import sys
from types import FunctionType

def auto_profile_module(module, decorator):
    for name, obj in list(vars(module).items()):
        if isinstance(obj, FunctionType):
            setattr(module, name, decorator(obj))

current_module = sys.modules[__name__]
auto_profile_module(current_module, profile())
```

That wraps every top-level function defined in that module.
(Methods of classes will still need class decorators or metaclasses as above.)

---

## 3. Global “register every function” approaches

If your real requirement is **“I want to know about *every* function that runs, without decorating it”**, decorators alone are not enough.

You need **global tracing hooks**:

### 3.1. `sys.setprofile` – function call/return profiler

* Fires on function **call** and **return** events (and C calls/returns).
* Works with Python’s built-in profilers (like `cProfile`).
* You give it a `profile_function(frame, event, arg)`.

High-level pattern:

```python
import sys

CALL_LOG = []

def global_profiler(frame, event, arg):
    if event not in ("call", "return"):
        return

    code = frame.f_code
    func_name = code.co_name
    module_name = frame.f_globals.get("__name__", "")
    # you can filter by module_name if you want

    if event == "call":
        CALL_LOG.append(("call", module_name, func_name))
    elif event == "return":
        CALL_LOG.append(("return", module_name, func_name))

# enable
sys.setprofile(global_profiler)

# disable
# sys.setprofile(None)
```

This gives you **every Python function call**, not just decorated ones, across all modules (optionally filter them to your package).

> Note: `sys.setprofile` sees calls to your decorator wrapper as well, so you’ll usually want to detect and skip your own profiler functions using module/name filters.

---

### 3.2. `sys.settrace` – line-by-line or call/return tracing

* Similar to `setprofile`, but more fine-grained: can fire on `"call"`, `"line"`, `"return"`, `"exception"`, etc.
* More overhead, better for detailed tracing / coverage than timing.

Basic idea:

```python
import sys

def tracer(frame, event, arg):
    if event == "call":
        code = frame.f_code
        print(f"CALL {code.co_name} in {code.co_filename}:{code.co_firstlineno}")
    return tracer  # must return itself (or another function) to keep tracing

sys.settrace(tracer)
```

Good for building custom **tracers/loggers**, not so great if you only want coarse profiling (too slow).

---

### 3.3. Built-in profilers: `cProfile`, `profile`

For pure **performance profiling** (not just “who was called”), use `cProfile`:

```python
import cProfile
import pstats

def main():
    # your program entrypoint
    ...

if __name__ == "__main__":
    profiler = cProfile.Profile()
    profiler.enable()
    main()
    profiler.disable()
    stats = pstats.Stats(profiler).sort_stats("cumulative")
    stats.print_stats(30)  # top 30 functions by cumulative time
```

`cProfile` internally uses something like `sys.setprofile`, but is implemented in C and highly optimized.

This will show:

* Every function executed.
* Call counts.
* Total and cumulative time.

You can combine this with decorators if you want extra metadata or filtering.

---

## 4. Non-function code (arbitrary blocks)

You also mentioned wanting to “decorate normal code, not functions”. Decorators only work on callables, but you can use **context managers** for code blocks.

### 4.1. Timing or tracing a code block

```python
import time
from contextlib import contextmanager

@contextmanager
def profile_block(name: str):
    start = time.perf_counter()
    try:
        yield
    finally:
        elapsed = time.perf_counter() - start
        print(f"[BLOCK] {name} took {elapsed:.6f}s")

# Usage:
def something():
    with profile_block("heavy part"):
        # any arbitrary code here
        ...
```

You can store block info in a registry just like with decorators.

---

### 4.2. Combine: decorator + block profiling

Often you:

* Use a **global profiler (`cProfile`/`sys.setprofile`)** for high-level “which functions matter?”
* Use **decorators/context managers** to deep-dive into specific hot paths or external calls (db, HTTP, etc.).

---

## 5. How they fit together in practice

Here’s a simple architecture you can adopt:

1. **Global view**:

   * Wrap your entrypoint (`main()` or the web app startup) in a `cProfile` run or `sys.setprofile` hook to capture *all* functions.
   * Or run your tests under `cProfile`.

2. **Selective detailed tracing**:

   * Use `@profile()` / `@trace` decorators on:

     * Public API functions.
     * Core domain services.
     * Performance-critical utilities.
   * Use class decorators / metaclasses where you want every method in a service or repository profiled.

3. **Arbitrary code blocks**:

   * Use context managers for complex sections inside big functions where you don’t want to split into smaller functions.

4. **Registration & export**:

   * Store structured data (module, qualname, timestamp, elapsed, call depth) in a registry.
   * Periodically flush that registry to:

     * Logs (JSON lines).
     * A file.
     * Prometheus or another metrics store.

---

## 6. Brief summary of your options

To **register every function that is executed**, you have these main possibilities:

* **Per-function decorators** (`@profile`, `@trace`):

  * Manual, precise control, low magic.
* **Class decorators / metaclasses**:

  * Auto-decorate all methods in specific classes.
* **Module-level auto-wrapping**:

  * Wrap all functions in a module at import time.
* **Global hooks**:

  * `sys.setprofile`: get all function calls/returns globally.
  * `sys.settrace`: get all calls/lines/returns/exceptions (more detailed, more overhead).
  * `cProfile`: ready-made, efficient profiler that tracks all calls and timings.
* **Context managers**:

  * For profiling non-function code blocks.

If you want, next step I can:

* Design a **small profiling library** for you with:

  * A global `Profiler` object.
  * Decorators (`@profiler.trace`, `@profiler.profile`).
  * Context managers (`with profiler.block("name"):`).
  * Optional integration with `sys.setprofile` for “trace everything” mode.
