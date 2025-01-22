@ECHO OFF
@CLS

ECHO 1. folder:
CD ..
ECHO %CD%

ECHO.
ECHO 2. remove
CALL poetry remove skunk-debug
CALL poetry remove requests

ECHO.
ECHO 3. show
CALL poetry show

