import functools
import inspect
import sys
import threading
import time
import types
from typing import Any, List
from contextlib import contextmanager

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


class Profiler:

    @staticmethod
    def profile(func):

        def profile_wrapper(*args, **kwargs):

            memory = Memory("cegid.pos.core.loader", 102400)
            memory.download()

            profiler = Profiler()
            # profiler.filter.hide("encodings")
            # profiler.filter.hide("colorama")
            # profiler.filter.hide("threading")
            profiler.settings.display_raw_output()
            profiler.start()

            result = func(*args, **kwargs)

            profiler.stop()
            profiler.report()

            memory.upload(profiler.log)

            return result

        return profile_wrapper

    @contextmanager
    def internal_profile(self, event: str, times: list[float]) -> Any:

        profiler_frame = inspect.currentframe()
        if profiler_frame is not None:
            profiler_frame = profiler_frame.f_back
        if profiler_frame is not None:
            profiler_frame = profiler_frame.f_back

        if event == "call":
            self.__registration.internal(times, profiler_frame, "call")
        try:
            yield
        finally:
            if event == "return":
                self.__registration.internal(times, profiler_frame, "return")

    # region 1. private properties

    __calls: List[State]
    __times: dict[int, list[float]]
    __lock: threading.Lock
    __start_time: float
    __filter: _Filter
    __settings: _Settings
    __registration: _Registration

    # endregion

    # region 2. public properties

    @property
    def log(self) -> List[State]:
        return self.__calls

    @property
    def filter(self) -> _Filter:
        return self.__filter

    @property
    def settings(self) -> _Settings:
        return self.__settings

    # endregion

    # region 3. constructor

    def __init__(self):

        self.__calls = []
        self.__lock = threading.Lock()

        self.__times = {}
        self.__start_time = time.perf_counter()

        self.__filter = _Filter(self.__lock)
        self.__settings = _Settings(self.__lock)

        self.__registration = _Registration(
            self,
            self.__calls,
            self.__lock,
            self.__start_time,
            self.__settings,
            self.__filter
        )

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
        report = _Report(self.__calls, self.__settings.raw)
        report.print(self.__settings.compact)

    # endregion

    # region 5. private methods

    def profile_function(self, frame: types.FrameType, event, arg) -> None:

        thread_id = threading.get_ident()
        with self.__lock:
            if thread_id not in self.__times:
                self.__times[thread_id] = []

        with self.internal_profile(event, self.__times[thread_id]):
            self.__registration.run(self.__times[thread_id], frame, event)

    def remove_first_and_last(self):
        if len(self.__calls) > 2:
            self.__calls = self.__calls[1:-1]

    # endregion

    # region 6. context manager support

    def __enter__(self):
        self.start()
        return self

    def __exit__(self, exc_type, exc_val, exc_tb):
        self.stop()
        return False

    # endregion
