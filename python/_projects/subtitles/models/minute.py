from typing import List
from models.subtitles import class_subtitles
from models.subtitle import class_subtitle
from models.part import class_part


class class_minute:

    # fields
    __in_minute_m       : int
    __list_subtitles_m : List[class_subtitle]
    __list_parts_m     : List[class_part]

    # properties
    def getMinute(self) -> int:
        return self.__in_minute_m

    def getAllSubTitles(self) -> List[class_subtitle]:
        return self.__list_subtitles_m

    def getFirstSubtitle(self) -> class_subtitle:
        return self.__list_subtitles_m[0]

    def getLastSubtitle(self) -> class_subtitle:
        return self.__list_subtitles_m[-1]

    def getAllParts(self) -> List[class_part]:
        return self.__list_parts_m

    def getFirstPart(self) -> class_part:
        return self.__list_parts_m[0]

    def getLastPart(self) -> class_part:
        return self.__list_parts_m[-1]

    # constructor
    def __init__(
            self,
            in_minute_p : int,
            subtitles_p : class_subtitles
    ):

        # initialize
        self.__in_minute_m       = in_minute_p
        self.__list_subtitles_m  = []
        self.__list_parts_m      = []
        self.__process(subtitles_p)

    def __process(self, subtitles_p) -> None:
        self.__list_subtitles_m = list(
            filter(
                lambda subtitle_current_l:
                subtitle_current_l.getMinute() == self.__in_minute_m,
                subtitles_p.getAll()
            )
        )
        self.__list_parts_m = list(
            filter(
                lambda part_current_l:
                part_current_l.minute == self.__in_minute_m,
                subtitles_p.getParts().getAll()
            )
        )
