class class_file:

    # fields
    __te_file_content_m : str = ""

    def getContent(self):
        return self.__te_file_content_m

    def read(self, te_fileName_p : str):
        file_subtitles_l = open(te_fileName_p, "r")
        self.__te_file_content_m = file_subtitles_l.read()
        file_subtitles_l.close()
