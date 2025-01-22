@ECHO OFF
@CLS

ECHO 1. folder:
CD ..
ECHO %CD%

ECHO.
ECHO 2. build
CALL poetry build

