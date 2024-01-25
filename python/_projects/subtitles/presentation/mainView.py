from tkinter import *
from tkinter.scrolledtext import ScrolledText
from tkinter import filedialog
from tkinter import ttk


class class_mainView:

    # fields
    __label_fileName_m    : Label  = None
    __entry_fileName_m    : Entry  = None
    __button_fileSearch_m : Button = None
    __button_fileOpen_m   : Button = None

    __label_fileContent_m        : Label        = None
    __scrolledText_fileContent_m : ScrolledText = None
    __scrolledText_altered_m     : ScrolledText = None

    __entry_first_m    : Entry  = None
    __entry_last_m     : Entry  = None
    __entry_duration_m : Entry  = None

    # properties
    tk_master: Tk = None
    ttk_tabs : ttk.Notebook = None

    # constructor
    def __init__(self, te_title_p: str):
        # create form
        self.tk_master = Tk()
        self.tk_master.title(te_title_p)

        # create Tab Control
        self.ttk_tabs = ttk.Notebook(self.tk_master)
        self.ttk_tab1 = ttk.Frame(self.ttk_tabs)
        self.ttk_tabs.add(self.ttk_tab1, text='File')
        self.ttk_tab2 = ttk.Frame(self.ttk_tabs)
        self.ttk_tabs.add(self.ttk_tab2, text='Timetable')

        # tree
        self.__folder_minute_m   = None
        self.__folder_subtitle_m = None

    def create(self, event_loadFile_p):
        self.__createFileSelection(event_loadFile_p)
        self.__createContent()
        self.__createFooter()
        self.__configure()
        self.__createTimetable()
        self.ttk_tabs.pack(expand=1, fill="both")
        self.setFileName("D:/ai/A3_python/subtitles/test.srt")
        mainloop()

    def display_file(self, te_content_p : str):
        self.__scrolledText_fileContent_m.insert(INSERT, te_content_p)

    def clear_content(self):
        self.__scrolledText_fileContent_m.delete('1.0', END)

    def setFileName(self, te_FileName_p: str):
        self.__entry_fileName_m.insert(0, te_FileName_p)

    def getFileName(self):
        return self.__entry_fileName_m.get()

    def setFirst(self, te_first_p : str):
        self.__entry_first_m.insert(0, te_first_p)

    def setLast(self, te_last_p : str):
        self.__entry_last_m.insert(0, te_last_p)

    def setDuration(self, te_duration_p : str):
        self.__entry_duration_m.insert(0, te_duration_p)

    def insertContent(self, te_part_p : str):
        self.__scrolledText_fileContent_m.insert(END, te_part_p)

    def insertContentTagged(self, te_part_p : str, te_name_p : str, te_color_p : str):
        self.__scrolledText_fileContent_m.insert(END, te_part_p, te_name_p)
        self.__scrolledText_fileContent_m.tag_config(te_name_p, background=te_color_p)

    def list_scrolledText(self):
        te_content_l = self.__scrolledText_fileContent_m.get("1.0", END)
        print(te_content_l)

    def insertTreeMinute(self,
                         in_minute_p : int,
                         te_first_p : str,
                         te_last_p : str):
        self.__folder_minute_m = self.tree.insert(
                                                  "",
                                                  'end',
                                                  str(in_minute_p),
                                                  text=str(in_minute_p),
                                                  values=(te_first_p, te_last_p, "")
                                                 )

    def insertTreeSubtitle(self,
                           in_minute_p : int,
                           in_number_p : int,
                           te_text_p   : str):
        self.__folder_subtitle_m = self.tree.insert(
                                                    self.__folder_minute_m,
                                                    'end',
                                                    str(in_minute_p) + "." + str(in_number_p),
                                                    text=te_text_p.replace('\n', '<nl>'),
                                                    values=("", "", "")
                                                   )

    def insertTreeElement(self,
                          in_minute_p    : int,
                          in_number_p    : int,
                          in_index_p     : int,
                          te_timestamp_p : str,
                          in_start_p     : int,
                          in_end_p       : int):
        self.tree.insert(self.__folder_subtitle_m,
                         "end",
                         str(in_minute_p) + "." + str(in_number_p) + "." + str(in_index_p),
                         text="",
                         values=(te_timestamp_p, str(in_start_p), str(in_end_p))
                         )

    def __createFileSelection(self, event_loadFile_m):

        self.__frame_fileName_m = Frame(self.ttk_tab1)
        self.__frame_fileName_m.grid(sticky=W, row=1, column=1)

        # 0.0 label file
        self.__label_FileName_m = Label(self.__frame_fileName_m, text="File:")
        self.__label_FileName_m.grid(row=0, column=0)

        # 0.1 text box file
        self.__entry_fileName_m = Entry(self.__frame_fileName_m, width=125)
        self.__entry_fileName_m.grid(row=0, column=1)

        # 0.2 button file search
        self.__button_fileSearch_m = Button(self.__frame_fileName_m, text="...", command=self.__select_file)
        self.__button_fileSearch_m.grid(row=0, column=2)

        # 0.3 button file open
        self.__button_fileOpen_m = Button(self.__frame_fileName_m, text="Open", command=event_loadFile_m)
        self.__button_fileOpen_m.grid(row=0, column=3)

        # rows
        self.__frame_fileName_m.grid_rowconfigure(0, minsize=20)  # 0: content

        # columns
        self.__frame_fileName_m.grid_columnconfigure(0, minsize=20)  # 0: label
        self.__frame_fileName_m.grid_columnconfigure(1, minsize=20)  # 1: text
        self.__frame_fileName_m.grid_columnconfigure(2, minsize=20)  # 2: search
        self.__frame_fileName_m.grid_columnconfigure(3, minsize=20)  # 3: open

    def __select_file(self):
        te_file_name_l = filedialog.askopenfilename(initialdir="F:/m/starGate/A2_atlantis/A2_videos/A1_atlantis/S3",
                                                    title="Select file",
                                                    filetypes=(
                                                        ("subtitles", "*.srt"),
                                                    )
                                                    )
        self.setFileName(te_file_name_l)

    def __createContent(self):

        self.__frame_content_m = Frame(self.ttk_tab1)
        self.__frame_content_m.grid(sticky=W, row=2, column=1)

        # 0.0 label file
        self.__label_fileContent_m = Label(self.__frame_content_m, text="Content:")
        self.__label_fileContent_m.grid(sticky=W, row=0, column=0)

        # 1.0 scrolledText file
        self.__scrolledText_fileContent_m = ScrolledText(self.__frame_content_m, width=50)
        self.__scrolledText_fileContent_m.grid(row=1, column=0)

        # 1.1 scrolledText altered
        self.__scrolledText_altered_m = ScrolledText(self.__frame_content_m, width=50)
        self.__scrolledText_altered_m.grid(row=1, column=1)

        # rows
        self.__frame_content_m.grid_rowconfigure(0, minsize=20)  # 0: label
        self.__frame_content_m.grid_rowconfigure(1, minsize=20)  # 1: content

        # columns
        self.__frame_content_m.grid_columnconfigure(0, minsize=20)  # 0: file
        self.__frame_content_m.grid_columnconfigure(1, minsize=20)  # 1: altered

    def __createFooter(self):

        self.__frame_footer_m = Frame(self.ttk_tab1)
        self.__frame_footer_m.grid(sticky=W, row=3, column=1)

        # 0.0: first
        self.__entry_first_m = Entry(self.__frame_footer_m, width=20)
        self.__entry_first_m.grid(row=0, column=0)

        # 0.1: last
        self.__entry_last_m = Entry(self.__frame_footer_m, width=20)
        self.__entry_last_m.grid(row=0, column=1)

        # 0.2: duration
        self.__entry_duration_m = Entry(self.__frame_footer_m, width=20)
        self.__entry_duration_m.grid(row=0, column=2)

        # rows
        self.__frame_footer_m.grid_rowconfigure(0, minsize=20)  # 0: content

        # columns
        self.__frame_footer_m.grid_columnconfigure(0, minsize=20)  # 0: first
        self.__frame_footer_m.grid_columnconfigure(1, minsize=20)  # 1: last
        self.__frame_footer_m.grid_columnconfigure(2, minsize=20)  # 2: duration

    def __configure(self):

        # rows
        self.ttk_tab1.grid_rowconfigure(0, minsize=20)  # 0: empty
        self.ttk_tab1.grid_rowconfigure(1, minsize=20)  # 1: file name
        self.ttk_tab1.grid_rowconfigure(2, minsize=20)  # 2: content
        self.ttk_tab1.grid_rowconfigure(3, minsize=20)  # 3: buttons
        self.ttk_tab1.grid_rowconfigure(4, minsize=20)  # 4: empty

        # columns
        self.ttk_tab1.grid_columnconfigure(0, minsize=20)  # 0: empty
        self.ttk_tab1.grid_columnconfigure(1, minsize=20)  # 1: frames
        self.ttk_tab1.grid_columnconfigure(2, minsize=20)  # 2: empty

    def __createTimetable(self):
        # style = ttk.Style(self.ttk_tab2)
        # style.configure('Treeview', rowheight=60)
        self.tree = ttk.Treeview(self.ttk_tab2)
        self.tree["columns"] = ("one", "two", "three")
        self.tree.column("#0", width=270, minwidth=270, stretch=NO)
        self.tree.column("one", width=150, minwidth=150, stretch=NO)
        self.tree.column("two", width=400, minwidth=200)
        self.tree.column("three", width=80, minwidth=50, stretch=NO)
        self.tree.heading("#0", text="Minute/Subtitle", anchor=W)
        self.tree.heading("one", text="Subtitles", anchor=W)
        self.tree.heading("two", text="Parts", anchor=W)
        self.tree.heading("three", text="End", anchor=W)
        self.tree.pack(side=TOP, fill=X)
