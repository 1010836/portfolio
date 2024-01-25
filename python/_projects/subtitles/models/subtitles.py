from typing import List
from crossCutting.time import toMinute
from models.parts import class_parts
from models.subtitle import class_subtitle


def subtitles_header(in_indent_p: int) -> str:
    te_result_l : str = (' ' * in_indent_p) + '| '
    te_result_l      += '{:>6}'.format('number') + ' | '
    te_result_l      += '{:>6}'.format('minute') + ' | '
    te_result_l      += 'text\n'
    te_result_l      += (' ' * in_indent_p) + '+'
    te_result_l      += ('-' * 8) + '+'
    te_result_l      += ('-' * 8) + '+'
    te_result_l      += ('-' * 6)
    return te_result_l


class class_subtitles:

    # fields
    __list_subtitles_m : List[class_subtitle]
    __parts_m          : class_parts

    # properties
    def getAll(self) -> List[class_subtitle]:
        return self.__list_subtitles_m

    def getFirst(self) -> class_subtitle:
        return self.__list_subtitles_m[0]

    def getLast(self) -> class_subtitle:
        return self.__list_subtitles_m[-1]

    def getParts(self) -> class_parts:
        return self.__parts_m

    # constructor
    def __init__(self):

        # initialize
        self.__list_subtitles_m = []
        self.__parts_m          = class_parts()

    # methods
    def clear(self):
        self.__list_subtitles_m.clear()
        self.__parts_m.clear()

    def process(self, te_content_p: str):

        # clear
        self.clear()

        # process parts
        self.__parts_m.process(te_content_p)

        # process subtitles
        self.__list_subtitles_m = list(
                                        map(
                                            lambda tuple_part:
                                            class_subtitle(
                                                            tuple_part[0],
                                                            toMinute(
                                                                list(
                                                                    filter(
                                                                        lambda part_filter:
                                                                        part_filter.getIsTime(),
                                                                        tuple_part[1]
                                                                    )
                                                                )[0].getValue()
                                                            ),
                                                            "".join(
                                                                part_join_l.getValue()
                                                                for part_join_l in tuple_part[1]
                                                            )
                                            ),
                                            self.__parts_m.getAllBySubtitle()
                                        )
                                    )

        # define minute in parts
        self.__updateMinuteInParts()

    def toString(self, in_indent_p : int) -> str:

        # header
        te_result_l : str = (' ' * in_indent_p) + \
                            'subtitles (' + \
                            str(len(self.__list_subtitles_m))  + \
                            ')\n'

        # subtitles
        te_result_l     += subtitles_header(in_indent_p + 2)
        for subtitle_current_l in self.__list_subtitles_m:
            te_result_l += '\n'
            te_result_l += subtitle_current_l.toString(in_indent_p + 2)

        return te_result_l

    # procedures
    def __updateMinuteInParts(self):
        for part_l in self.__parts_m.getAll():
            subtitle_l = next(
                element for element in self.__list_subtitles_m
                if element.getNumber() == part_l.getSubtitleNumber()
            )
            part_l.minute = subtitle_l.getMinute()
