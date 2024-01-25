from presentation.mainView import class_mainView
from infrastructure.file import class_file
from models.subtitles import class_subtitles
from models.minute import class_minute


class class_mainController:

    # fields
    __file      : class_file
    __mainView  : class_mainView
    __subtitles : class_subtitles

    def __init__(self):

        # initialize
        self.__file      = class_file()
        self.__mainView  = class_mainView('Synchronise subtitles')
        self.__subtitles = class_subtitles()

    def start(self):

        # create main screen
        self.__mainView.create(self.__load_file)

    def __load_file(self):

        # read and display file
        self.__file.read(self.__mainView.getFileName())
        self.__mainView.display_file(self.__file.getContent())

        # subtitles
        self.__subtitles.process(self.__file.getContent())
        # print(self.__subtitles.getParts().toString(0))
        print(self.__subtitles.toString(0))

        # color parts
        self.__paint_parts()

        # statistics
        self.__mainView.setFirst(self.__subtitles.getParts().getTimes().getFirst().getValue())
        self.__mainView.setLast(self.__subtitles.getParts().getTimes().getLast().getValue())
        self.__mainView.setDuration(self.__subtitles.getParts().getTimes().getDuration())
        
        # tree

        for in_minute_l in range(
                self.__subtitles.getFirst().getMinute(),
                self.__subtitles.getLast().getMinute(),
        ):

            # all subtitles for current minute
            minute_current_l : class_minute = class_minute(in_minute_l, self.__subtitles)

            # add information about current minute
            self.__mainView.insertTreeMinute(
                in_minute_l,
                str(minute_current_l.getFirstSubtitle().getNumber()) + ' - ' +\
                str(minute_current_l.getLastSubtitle().getNumber()),
                str(minute_current_l.getFirstPart().getNumber()) + ' - ' +\
                str(minute_current_l.getLastPart().getNumber()),
            )

            for subtitle_current_l in minute_current_l.getAllSubTitles():

                # subtitle
                self.__mainView.insertTreeSubtitle(
                                                    subtitle_current_l.getMinute(),
                                                    subtitle_current_l.getNumber(),
                                                    subtitle_current_l.getText()
                                                    )

                # times
                # in_index_l: int = 1
                # for time_current_l in subtitle_current_l.parts.times.times:
                #    self.__mainView.insertTreeElement(
                #                                      subtitle_current_l.minute,
                #                                      subtitle_current_l.number,
                #                                      in_index_l,
                #                                      time_current_l.getValue(),
                #                                      time_current_l.getStart(),
                #                                      time_current_l.getEnd()
                #                                     )
                #    in_index_l += 1

    def __paint_parts(self):
        
        # clear content widget
        self.__mainView.clear_content()
        
        # all parts
        for part_current_l in self.__subtitles.getParts().getAll():
            
            # time
            if part_current_l.getIsTime():
                self.__mainView.insertContentTagged(
                    part_current_l.getValue(), 
                    part_current_l.getTag(), 
                    'SteelBlue1'
                )  
            else:
                
                # subtitle number
                if part_current_l.getIsOnlySubTitleNumber():
                    self.__mainView.insertContentTagged(
                        part_current_l.getValue(), 
                        part_current_l.getTag(), 
                        'SteelBlue3'
                    ) 
                else:
                    
                    # normal text
                    self.__mainView.insertContent(part_current_l.getValue())
