class class_time:

    # fields
    __in_part_m     : int
    __in_subtitle_m : int
    __te_value_m    : str
    __in_start_m    : int
    __in_end_m      : int

    # properties
    def getPart(self) -> int:
        return self.__in_part_m

    def getSubtitle(self) -> int:
        return self.__in_subtitle_m

    def getValue(self) -> str:
        return self.__te_value_m

    def getStart(self) -> int:
        return self.__in_start_m

    def getEnd(self) -> int:
        return self.__in_end_m

    # constructor
    def __init__(self,
                 in_part_p     : int,
                 in_subtitle_p : int,
                 te_value_p    : str,
                 in_start_p    : int,
                 in_end_p      : int
                 ):

        # fields
        self.__in_part_m     = in_part_p
        self.__in_subtitle_m = in_subtitle_p
        self.__te_value_m    = te_value_p
        self.__in_start_m    = in_start_p
        self.__in_end_m      = in_end_p

    # methods
    def toString(self, in_indent_p: int) -> str:
        te_result_l : str = (' ' * in_indent_p) + \
                            '| ' + \
                            '{:<8}'.format(self.getPart()) + ' | ' + \
                            '{:<8}'.format(self.getSubtitle()) + ' | ' + \
                            '{:<12}'.format(self.getValue()) + ' | ' + \
                            '{:>7}'.format(self.getStart()) + ' | ' + \
                            '{:>7}'.format(self.getEnd())
        return te_result_l
