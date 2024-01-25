class class_subtitle:

    # fields
    __in_number_m : int
    __in_minute_m : int
    __te_text_m   : str

    # properties
    def getNumber(self) -> int:
        return self.__in_number_m

    def getMinute(self) -> int:
        return self.__in_minute_m

    def getText(self) -> str:
        return self.__te_text_m

    # constructor
    def __init__(self, in_number_p : int, in_minute_p : int, te_text_p : str):

        # initialize
        self.__in_number_m = in_number_p
        self.__in_minute_m = in_minute_p
        self.__te_text_m   = te_text_p

    # methods
    def toString(self, in_indent_p : int):
        te_result_l : str = (' ' * in_indent_p) + \
                            '| ' + \
                            '{:>6}'.format(str(self.__in_number_m)) + ' | ' + \
                            '{:>6}'.format(str(self.__in_minute_m)) + ' | ' + \
                            self.__te_text_m.replace('\n', '<nl>')
        return te_result_l
