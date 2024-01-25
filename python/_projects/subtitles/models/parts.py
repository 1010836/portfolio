import re
from typing import List
from collections import defaultdict
from models.part import class_part
from models.times import class_times
from models.time import class_time


def parts_header(in_indent_p: int) -> str:
    te_result_l : str = (' ' * in_indent_p) + '| '
    te_result_l      += '{:>8}'.format('number') + ' | '
    te_result_l      += '{:>8}'.format('minute') + ' | '
    te_result_l      += '{:>8}'.format('subtitle') + ' | '
    te_result_l      += '{:>6}'.format('tag') + ' | '
    te_result_l      += '{:<6}'.format('type') + ' | '
    te_result_l      += 'text\n'
    te_result_l      += (' ' * in_indent_p) + '+'
    te_result_l      += ('-' * 10) + '+'
    te_result_l      += ('-' * 10) + '+'
    te_result_l      += ('-' * 10) + '+'
    te_result_l      += ('-' * 8) + '+'
    te_result_l      += ('-' * 8) + '+'
    te_result_l      += ('-' * 7)
    return te_result_l


class class_parts:

    # fields
    __list_parts_m : List[class_part]
    __times_m      : class_times

    # properties
    def getAll(self) -> List[class_part]:
        return self.__list_parts_m

    def getFirst(self) -> class_part:
        return self.__list_parts_m[0]

    def getLast(self) -> class_part:
        return self.__list_parts_m[-1]

    def getTimes(self) -> class_times:
        return self.__times_m

    def getAllBySubtitle(self) :

        # class to aggregate
        defaultdict_groups = defaultdict(list)

        # group subtitles by subtitle number
        for part_current_l in self.__list_parts_m:
            defaultdict_groups[part_current_l.getSubtitleNumber()].append(part_current_l)

        # [(<subtitle number  1>, [part1..partN]) ... (<subtitle number  N>, [part1..partN])  )
        return defaultdict_groups.items()

    # constructor
    def __init__(self):

        # initialize
        self.__list_parts_m  = []
        self.__times_m  = class_times()

    # methods
    def clear(self):
        self.__list_parts_m.clear()
        self.__times_m.clear()

    def process(self, te_content_p : str) -> None:

        # clear
        self.clear()

        # re.compile('(\n\\d+\n.*)')
        # re.compile('(?<!,)(\\d+\n)')
        pattern_time_l = re.compile('(\\d{2}:\\d{2}:\\d{2},\\d{3})')

        # times
        list_times_l : List[re.Match] = list(pattern_time_l.finditer(te_content_p))

        # parts
        list_parts_l = pattern_time_l.split(te_content_p)

        # index in list_times_l
        in_indexTimes_l     : int = 0

        # defined when a part with number is found
        in_subtitleNumber_l : int = 0

        # part number
        in_partNumber_l : int = 0

        # all parts
        for te_text_l in list_parts_l:

            # new part
            in_partNumber_l += 1
            part_current_l : class_part = class_part(in_partNumber_l, in_subtitleNumber_l, te_text_l)

            # add only text
            if part_current_l.getIsText():
                self.__list_parts_m.append(part_current_l)

            else:

                # add part and time information
                if part_current_l.getIsTime():

                    # add new time ro list
                    self.__addTime(
                        list_times_l,
                        in_indexTimes_l,
                        part_current_l,
                        in_subtitleNumber_l,
                        in_partNumber_l
                    )

                    # no parameters by reference
                    in_indexTimes_l += 1

                else:

                    # only in the first line of the file
                    if part_current_l.getIsOnlySubTitleNumber():

                        # update subtitle number
                        in_subtitleNumber_l = part_current_l.getSubtitleNumber()

                        # add to list
                        self.__list_parts_m.append(part_current_l)

                    else:

                        # divide in two parts (text and subtitle number)
                        if part_current_l.getIsTextAndSubTitleNumber():

                            # update subtitle number (no parameters by reference)
                            in_subtitleNumber_l = self.__addTextAndSubtitleNumber(
                                part_current_l,
                                in_partNumber_l,
                                in_subtitleNumber_l
                            )

                            # part has been divided
                            in_partNumber_l += 1

                        # more then one sub title number in text
                        # (subtitle terminated with number)
                        else:
                            self.__list_parts_m.append(part_current_l)

    def toString(self, in_indent_p : int) -> str:

        # header
        te_result_l: str = (' ' * in_indent_p) + \
                           'parts ( ' + \
                           str(len(self.__list_parts_m)) + ', ' +\
                           str(len(self.__times_m.getAll())) + \
                           ' )\n'

        # parts
        te_result_l += parts_header(in_indent_p + 2)
        for part_current_l in self.__list_parts_m:
            te_result_l += '\n'
            te_result_l += part_current_l.toString(in_indent_p + 2)

        # times
        te_result_l += '\n'
        te_result_l += self.__times_m.toString(in_indent_p + 2)

        return te_result_l

    # procedures
    def __addTime(
            self,
            list_times_p : List[re.Match],
            in_indexTimes_p : int,
            part_current_p : class_part,
            in_subtitleNumber_p : int,
            in_partNumber_p: int
    ):

        # add to list
        self.__list_parts_m.append(part_current_p)

        # get time from list
        match_current_l: re.Match = list_times_p[in_indexTimes_p]

        # create part.time
        time_current_l = class_time(
            in_partNumber_p,
            in_subtitleNumber_p,
            part_current_p.getValue(),
            match_current_l.start(),
            match_current_l.end()
        )

        # times
        self.__times_m.add(time_current_l)

    def __addTextAndSubtitleNumber(
            self,
            part_current_p      : class_part,
            in_partNumber_p     : int,
            in_subtitleNumber_p : int
    ) -> int:

        # text part
        part_first_l = class_part(in_partNumber_p, in_subtitleNumber_p, part_current_p.getFirstPart())

        # get updated subtitle number define when define the type
        in_subtitleNumber_p = part_current_p.getSubtitleNumber()

        # subtitle number
        part_second_l = class_part(in_partNumber_p + 1, in_subtitleNumber_p, part_current_p.getSecondPart())

        # add parts
        self.__list_parts_m.append(part_first_l)
        self.__list_parts_m.append(part_second_l)

        return in_subtitleNumber_p
