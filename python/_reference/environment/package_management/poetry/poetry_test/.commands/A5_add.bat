@ECHO OFF
@CLS

ECHO 1. folder:
CD ..
ECHO %CD%

ECHO.
ECHO 2. setup
CALL poetry source add --priority=primary local http://localhost:3141/cwprogram/stable/+simple/
CALL poetry config http-basic.local cwprogram 9715

ECHO.
ECHO 3. add
CALL poetry add skunk-debug
CALL poetry add requests

ECHO.
ECHO 4. show
CALL poetry show

