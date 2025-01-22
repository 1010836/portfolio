@ECHO OFF
@CLS

ECHO 1. folder:
CD ..
ECHO %CD%

ECHO.
ECHO FIST TIME MUST BE CREATED IN VSCODE

ECHO.
ECHO 2. create
CALL poetry env use  C:\Users\evaristo.figueiredo\.pyenv\pyenv-win\versions\3.12.3\python.exe
                          
ECHO.
ECHO 3. list
CALL poetry env list

ECHO.
ECHO 4. info
CALL poetry env info
