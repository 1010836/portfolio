@ECHO OFF
@CLS

ECHO 1. folder:
CD ..
ECHO %CD%

ECHO.
ECHO DOES NOT WORK

ECHO.
ECHO 2. create
CALL poetry env remove .venv
                          
ECHO.
ECHO 3. list
CALL poetry env list

ECHO.
ECHO 4. info
CALL poetry env info
