import functools
import inspect
import sys
import threading
import time
import types
from typing import Any, List

from cegid.pos.core.loader import Memory

from .state import State
from ._registration import _Registration
from ._report import _Report
from ._filter import _Filter
from ._settings import _Settings

# if compact
#   the duration value
#       is accumulate by function and level
#         so
#           some functions from level + 1
#           may accumulate time of the same function
#           in another instance of the same class
#           and the function from level don´t


def internal(func):

    @functools.wraps(func)
    def internal_wrapper(self, frame, event, arg):

        profiler_frame = inspect.currentframe()

        thread_id = threading.get_ident()

        with Profiler.instance.lock:
            if thread_id not in Profiler.instance.times:
                Profiler.instance.times[thread_id] = []

        registration = _Registration(
            Profiler.instance.calls,
            Profiler.instance.lock,
            Profiler.instance.times[thread_id],
            Profiler.instance.start_time,
            Profiler.instance.settings,
            Profiler.instance.filter
        )

        registration.run(profiler_frame, "call")
        result = func(self, frame, event, arg)
        registration.run(profiler_frame, "return")

        return result

    return internal_wrapper


class Profiler:

    @staticmethod
    def profile(func):

        def profile_wrapper(*args, **kwargs):

            memory = Memory("cegid.pos.core.loader", 102400)
            memory.download()

            profiler = Profiler()
            profiler.filter.hide("encodings")
            profiler.filter.hide("colorama")
            profiler.start()

            result = func(*args, **kwargs)

            profiler.stop()
            profiler.report()

            memory.upload(profiler.log)

            return result

        return profile_wrapper

    # region 1. private properties

    calls: List[State]
    times: dict[int, list[float]]
    lock: threading.Lock
    start_time: float
    filter: _Filter
    settings: _Settings

    # endregion

    # region 2. public properties

    @property
    def log(self) -> List[State]:
        return self.calls

    # endregion

    # region 3. constructor

    def __init__(self):

        Profiler.instance = self

        self.calls = []
        self.lock = threading.Lock()

        self.times = {}
        self.start_time = time.perf_counter()

        self.filter = _Filter(self.lock)
        self.settings = _Settings(self.lock)

    # endregion

    # region 4. public methods

    def start(self):

        if sys.getprofile() is None:
            sys.setprofile(self.profile_function)

        if threading.getprofile() is None:
            threading.setprofile(self.profile_function)

    def stop(self):

        if sys.getprofile() == self.profile_function:
            sys.setprofile(None)

        if threading.getprofile() == self.profile_function:
            threading.setprofile(None)

        # self.remove_first_and_last()

    def report(self):
        report = _Report(self.calls, self.settings.raw)
        report.print(self.settings.compact)

    # endregion

    # region 5. private methods

    def profile_function(self, frame: types.FrameType, event, arg) -> None:

        profiler_frame = inspect.currentframe()

        thread_id = threading.get_ident()

        with self.lock:
            if thread_id not in self.times:
                self.times[thread_id] = []

        registration = _Registration(
            self.calls,
            self.lock,
            self.times[thread_id],
            self.start_time,
            self.settings,
            self.filter
        )

        if event == "call": registration.run(profiler_frame, "call")
        registration.run(frame, event)
        if event == "return": registration.run(profiler_frame, "return")

    def remove_first_and_last(self):
        if len(self.calls) > 2:
            self.calls = self.calls[1:-1]

    # endregion

    # region 6. context manager support

    def __enter__(self):
        self.start()
        return self

    def __exit__(self, exc_type, exc_val, exc_tb):
        self.stop()
        return False

    # endregion
