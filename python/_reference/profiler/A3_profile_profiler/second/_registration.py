import inspect
import time
import threading
from typing import List, TYPE_CHECKING, Any
import types

from .state import State
from ._filter import _Filter
from ._settings import _Settings

if TYPE_CHECKING:
    from .profiler import Profiler


class _Registration:

    # region 1. private properties
    if TYPE_CHECKING:
        __parent: Profiler
    else:
        __parent: Any

    __calls: List[State]
    __lock: threading.Lock

    __times: list[float]
    __start_time: float

    __settings: _Settings
    __filter: _Filter

    # endregion

    # region 2. constructor

    def __init__(
        self,
        parent: Any,
        calls: List[State],
        lock: threading.Lock,
        start_time: float,
        settings: _Settings,
        filter: _Filter
    ):
        self.__parent = parent

        self.__calls = calls
        self.__lock = lock

        self.__start_time = start_time

        self.__settings = settings
        self.__filter = filter

    # endregion

    # region 4. public methods

    def run(
        self,
        times: list[float],
        frame: types.FrameType,
        event: str,
    ):

        with self.__parent.internal_profile(event, times):
            self.internal(times, frame, event)

    def internal(
        self,
        times: list[float],
        frame: types.FrameType,
        event: str,
    ):

        self.__times = times

        state = State.create(frame, event, self.__times)

        if self.__filter.skip(state): return

        if event == 'call':
            self.__handle_call_event(state)
        elif event == 'return':
            self.__handle_return_event(state)

    # endregion

    # region 5. private methods

    def __handle_call_event(self, state: State):

        self.__calculate_call_duration(state)

        with self.__lock:
            if not self.__update_compact_count("call", state):
                self.__calls.append(state)

    def __calculate_call_duration(self, state: State) -> None:

        start_time = time.perf_counter()
        with self.__lock:
            self.__times.append(start_time)

        state.elapsed = start_time - self.__start_time
        state.duration = 0.0

    def __update_compact_count(self, event: str, state: State) -> bool:

        result = False

        if self.__settings.compact:
            index = self.__find_matching_log_entry(event, state)
            if index is not None:
                self.__calls[index].count += 1
                result = True

        return result

    def __find_matching_log_entry(
        self,
        event: str,
        state: State
    ) -> int | None:

        result = next(
            (
                index for index in reversed(range(len(self.__calls)))
                if self.__calls[index].key == state.key and self.__calls[index]
                .event == event and self.__calls[index].depth == state.depth
            ),
            None
        )

        return result

    def __handle_return_event(self, state: State):

        self.__calculate_return_duration(state)

        with self.__lock:
            self.__update_call_duration(state)

        if self.__settings.only_call:
            return

        with self.__lock:
            if not self.__update_compact_count("return", state):
                self.__calls.append(state)

    def __calculate_return_duration(self, state: State) -> None:

        with self.__lock:
            if self.__times.__len__() == 0:
                return

            start_time = self.__times.pop()

        end_time = time.perf_counter()
        state.duration = end_time - start_time
        state.elapsed = end_time - self.__start_time

    def __update_call_duration(self, state: State) -> None:
        index = self.__find_matching_log_entry("call", state)
        if index is not None:
            self.__calls[index].duration += state.duration

    # endregion
