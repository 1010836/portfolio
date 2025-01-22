@ECHO OFF
@CLS

ECHO 1. folder:
CD ..
ECHO %CD%

ECHO.
ECHO 2. cahe:
TREE C:\Users\evaristo.figueiredo\AppData\Local\pypoetry 

ECHO.
ECHO   2.1 list:
CALL poetry cache list

ECHO.
ECHO 3. config:
CALL poetry config --list

ECHO.
ECHO 3.1 global:
TYPE C:\Users\evaristo.figueiredo\AppData\Roaming\pypoetry\config.toml

ECHO.
ECHO 4. env list:
CALL poetry env list

ECHO.
ECHO 5. env info:
CALL poetry env info

ECHO.
ECHO 6. site:
CALL python -m site


