from typing import List
from datetime import datetime
from models.time import class_time


def times_header(in_indent_p: int) -> str:
    te_result_l : str = (' ' * in_indent_p) + '| '
    te_result_l      += '{:<8}'.format('part') + ' | '
    te_result_l      += '{:<8}'.format('subtitle') + ' | '
    te_result_l      += '{:<12}'.format('time') + ' | '
    te_result_l      += '{:>7}'.format('start') + ' | '
    te_result_l      += '{:>7}'.format('end') + '\n'
    te_result_l      += (' ' * in_indent_p) + '+'
    te_result_l      += ('-' * 10) + '+'
    te_result_l      += ('-' * 10) + '+'
    te_result_l      += ('-' * 14) + '+'
    te_result_l      += ('-' * 9) + '+'
    te_result_l      += ('-' * 9)
    return te_result_l


class class_times:

    # fields
    __list_times_m  : List[class_time]

    # properties
    def getAll(self) -> List[class_time]:
        return self.__list_times_m

    def getFirst(self) -> class_time:
        return self.__list_times_m[0]

    def getLast(self) -> class_time:
        return self.__list_times_m[-1]

    def getDuration(self) -> str:
        datetime_lastTime_l    = datetime.strptime("01.01.2020 " + self.getLast().getValue(), '%d.%m.%Y %H:%M:%S,%f')
        datetime_firstTime_l   = datetime.strptime("01.01.2020 " + self.getFirst().getValue(), '%d.%m.%Y %H:%M:%S,%f')
        timestamp_lastTime_l   = datetime.timestamp(datetime_lastTime_l)
        timestamp_firstTime_l  = datetime.timestamp(datetime_firstTime_l)
        timestamp_difference_l = (timestamp_lastTime_l  - timestamp_firstTime_l)
        dateTime_difference_l  = datetime.fromtimestamp(timestamp_difference_l)
        te_difference_l        = dateTime_difference_l.strftime('%H:%M:%S,%f')
        return te_difference_l

    # constructor
    def __init__(self):

        # initialize
        self.__list_times_m  = []

    # methods
    def clear(self):
        self.__list_times_m.clear()

    def add(self, time_new_p: class_time):
        self.__list_times_m.append(time_new_p)

    def toString(self, in_indent_p : int):

        # header
        te_result_l : str = (' ' * in_indent_p) + \
                            'times( ' + \
                            str(len(self.__list_times_m)) + ', '  + \
                            self.getDuration() + \
                            ' )\n'

        # times
        te_result_l     += times_header(in_indent_p + 2)
        for time_current_l in self.__list_times_m:
            te_result_l += '\n'
            te_result_l += time_current_l.toString(in_indent_p + 2)

        return te_result_l
