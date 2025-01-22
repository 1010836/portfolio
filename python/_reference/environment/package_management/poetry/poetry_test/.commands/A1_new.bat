@ECHO OFF
@CLS

ECHO 1. folder:
CD ..\..
ECHO %CD%

ECHO.
ECHO NEED TO BE OUT OF THE PROJECT FOLDER

ECHO.
ECHO 2. new:
CALL poetry new --src test

ECHO.
ECHO 3. list:
TREE test /f
