@ECHO OFF
@CLS

ECHO 1. folder:
CD ..
ECHO %CD%

ECHO.
ECHO SETUP IS NOW GLOBAL

ECHO.
ECHO 2. virtualenvs.create true:
REM CALL poetry config virtualenvs.create true --local
CALL poetry config virtualenvs.create true
                          
ECHO.
ECHO 3. virtualenvs.in-project true:
REM CALL poetry config virtualenvs.in-project true --local
CALL poetry config virtualenvs.in-project true

ECHO.
ECHO 4. virtualenvs.prefer-active-python true:
REM CALL poetry config virtualenvs.prefer-active-python true --local
CALL poetry config virtualenvs.prefer-active-python true

ECHO.
ECHO 4. list
REM CALL type poetry.toml
CALL poetry config --list