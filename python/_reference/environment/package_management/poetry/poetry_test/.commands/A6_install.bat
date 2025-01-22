@ECHO OFF
@CLS

ECHO 1. folder:
CD ..
ECHO %CD%

ECHO.
ECHO 2. install
CALL poetry install

ECHO.
ECHO 3. shell
CALL poetry shell 

ECHO.
ECHO 4. list: see editable
CALL pip list

REM Package           Version Editable project location
REM ----------------- ------- -------------------------
REM mypy              1.10.0
REM mypy-extensions   1.0.0
REM pip               23.3.2
REM skunk-debug       0.1.0   D:\python\skunk_debug    
REM typing_extensions 4.12.2
