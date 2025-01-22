@ECHO OFF
@CLS

ECHO 1. folder:
CD ..
ECHO %CD%

ECHO.
ECHO 2. add
CALL poetry add -D mypy

ECHO.
ECHO 3. show
CALL poetry show

