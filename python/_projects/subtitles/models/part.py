import re


class class_part:

    # fields
    __in_number_m         : int
    minute                : int
    __in_subtitleNumber_m : int
    __te_value_m          : str
    # 0: text
    # 1: timestamp
    # 2: only subtitle number
    # 3: text and subtitle number, 4: error
    __in_type_m           : int
    __te_tag_m            : str = ''
    __te_firstPart_m      : str = ''
    __te_secondPart_m     : str = ''

    # properties
    def getNumber(self) -> int:
        return self.__in_number_m

    def getSubtitleNumber(self) -> int:
        return self.__in_subtitleNumber_m

    def getValue(self) -> str:
        return self.__te_value_m

    def getIsText(self) -> bool:
        return self.__in_type_m == 0

    def getIsTime(self) -> bool:
        return self.__in_type_m == 1

    def getIsOnlySubTitleNumber(self) -> bool:
        return self.__in_type_m == 2

    def getIsTextAndSubTitleNumber(self) -> bool:
        return self.__in_type_m == 3

    def getIsError(self) -> bool:
        return self.__in_type_m == 4

    def getTag(self) -> str:
        return self.__te_tag_m

    def getFirstPart(self) -> str:
        return self.__te_firstPart_m

    def getSecondPart(self) -> str:
        return self.__te_secondPart_m

    # constructor
    def __init__(self, in_number_p : int, in_subtitleNumber_p : int, te_value_p: str):

        # fields
        self.__in_number_m         = in_number_p
        self.minute                = -1
        self.__in_subtitleNumber_m = in_subtitleNumber_p
        self.__te_value_m          = te_value_p
        self.__in_type_m           = 0
        self.__te_tag_m            = ''
        self.__te_firstPart_m      = ''
        self.__te_secondPart_m     = ''

        # classify
        self.__defineType()

    # methods
    def toString(self, in_indent_p : int):

        # begin
        te_result_l : str = (' ' * in_indent_p) + '| '

        # data
        te_result_l += '{:>8}'.format(str(self.__in_number_m)) + ' | '
        te_result_l += '{:>8}'.format(str(self.minute)) + ' | '
        te_result_l += '{:>8}'.format(str(self.__in_subtitleNumber_m)) + ' | '
        te_result_l += '{:>6}'.format(self.__te_tag_m) + ' | '

        # type
        if self.__in_type_m == 1:
            te_result_l += '{:<6}'.format("time") + ' | '
        else:
            if self.__in_type_m == 2:
                te_result_l += '{:<6}'.format("number") + ' | '
            else:
                te_result_l += '{:<6}'.format("text") + ' | '

        # value
        te_result_l += ' ' + self.__te_value_m.replace('\n', '<nl>')

        return te_result_l

    # procedures
    def __defineType(self):

        pattern_time_l = re.compile('(\\d{2}:\\d{2}:\\d{2},\\d{3})')
        match_found_l = pattern_time_l.match(self.__te_value_m)

        # is time
        if match_found_l is not None:

            # type
            self.__in_type_m = 1

            # tag
            self.__te_tag_m = "TS" + str(self.__in_number_m)

        else:

            # find <number><carriage return><line feed>
            pattern_subtitle_l = re.compile('(\\d+\n)')
            match_found_l = pattern_subtitle_l.search(self.__te_value_m)

            # exists subtitle number
            if match_found_l is not None:

                # divide in parts
                list_parts_l = pattern_subtitle_l.split(self.__te_value_m)

                # exists only one subtitle number
                if len(list_parts_l) == 3:

                    # only subtitle number (only first line of the file)
                    if list_parts_l[0] == '':

                        # subtitle number
                        self.__in_type_m = 2

                        # define subtitle number
                        self.__in_subtitleNumber_m = int(list_parts_l[1].replace('\n', ''))

                        # define tag
                        self.__te_tag_m = "N" + str(self.__in_number_m)

                    else:

                        # text and subtitle number
                        self.__in_type_m = 3

                        # get text
                        self.__te_firstPart_m = list_parts_l[0]

                        # get subtitle number
                        self.__te_secondPart_m = list_parts_l[1]

                        # define subtitle number
                        self.__in_subtitleNumber_m = int(list_parts_l[1].replace('\n', ''))

                        # no need to define tag it will be defined when creating the two parts

                # impossible more the one subtitle number
                # (subtitle ended with number \n)
                else:
                    self.__in_type_m = 4

            # only text
            else:
                self.__in_type_m = 0
