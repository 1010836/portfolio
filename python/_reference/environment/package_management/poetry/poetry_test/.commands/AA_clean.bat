@ECHO OFF
@CLS

ECHO 1. folder:
CD ..
ECHO %CD%

ECHO.
ECHO 2. .venv:
CALL rmdir /s /q .venv

ECHO.
ECHO 3. dist:
CALL rmdir /s /q dist

ECHO.
ECHO 4. __pycache__:
FOR /r . %%A in (__pycache__) do (
    @IF exist "%%A" (
        ECHO   2.1 Deleting %%A
        RD /s /q "%%A"
    )
)

ECHO.
ECHO 5. *.pyc:
for /r . %%A in (*.pyc) do (
    if exist "%%A" (
        ECHO   3.1 Deleting %%A
        DEL /f /q "%%A"
    )
)

ECHO.
ECHO 6. .pytest_cache:
for /r . %%A in (.pytest_cache) do (
    if exist "%%A" (
        ECHO   4.1 Deleting %%A
        RD /s /q "%%A"
    )
)

ECHO.
ECHO 7. build dist *.egg-info:
for /d %%A in (build dist *.egg-info) do (
    if exist "%%A" (
        ECHO   5.1 Deleting %%A
        RD /s /q "%%A"
    )
)

ECHO.
ECHO 8. clear poetry cache:
CALL poetry cache clear _default_cache --all
CALL poetry cache clear PyPI --all

ECHO.
ECHO 9. delete cache:
CALL RMDIR C:\Users\evaristo.figueiredo\AppData\Local\pypoetry\Cache /s /q