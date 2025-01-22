@ECHO OFF
@CLS

ECHO 1. folder:
CD ..
ECHO %CD%

ECHO.
ECHO 2. setup
CALL poetry config repositories.local http://localhost:3141/cwprogram/stable

ECHO.
ECHO 3. config:
CALL poetry config --list

ECHO.
ECHO 4. publish
CALL poetry publish -r local -u cwprogram -p 9715

