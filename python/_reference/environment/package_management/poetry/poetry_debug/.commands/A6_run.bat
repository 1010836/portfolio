@ECHO OFF
@CLS

ECHO 1. folder:
CD ..
ECHO %CD%

ECHO.
ECHO 2. list
CALL poetry install

ECHO.
ECHO 3. info
CALL poetry run debug
