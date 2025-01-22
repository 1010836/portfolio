@CLS

@ECHO 1. folder:
@CD .
@ECHO %CD%

@ECHO.
@ECHO 2. global:
@CALL pip config list --global

@ECHO.
@ECHO 3. user:
@CALL pip config list --user

@ECHO.
@ECHO 4. env:
@CALL pip config list --site

@ECHO.
@ECHO 5. index-url:
@CALL pip config set global.index-url http://localhost:3141/cwprogram/stable --global

@ECHO.
@ECHO 6. global:
@CALL pip config list --global

@ECHO.
@ECHO 7. file:
TYPE C:\ProgramData\pip\pip.ini