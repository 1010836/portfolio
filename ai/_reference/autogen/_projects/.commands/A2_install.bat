@CLS

@ECHO 1. folder:
@CD .
@ECHO %CD%

@ECHO.
@ECHO 2. login:
call devpi login cwprogram --password 9715

@ECHO.
@ECHO 2. list indexes:
call devpi use -l

@ECHO.
@ECHO 3. use index
call devpi use http://localhost:3141/cwprogram/stable

@ECHO.
@ECHO 3. install debug
call devpi install debug

@ECHO.
@ECHO 4. verify
call pipdeptree --python auto