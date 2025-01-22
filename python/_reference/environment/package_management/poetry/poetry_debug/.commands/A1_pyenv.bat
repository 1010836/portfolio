@ECHO OFF
@CLS

ECHO 1. folder:
CD ..
ECHO %CD%

ECHO.
ECHO ANALYZE pyenv

ECHO.
ECHO 2. list all available pyenv commands:
CALL pyenv commands     

ECHO.
ECHO 3. print the latest installed or known version with the given prefix:
REM can´t understand
REM CALL pyenv latest 

@REM    local        Set or show the local application-specific Python version
@REM    global       Set or show the global Python version
@REM    shell        Set or show the shell-specific Python version
@REM    install      Install 1 or more versions of Python
@REM    uninstall    Uninstall 1 or more versions of Python
@REM    update       Update the cached version DB
@REM    rehash       Rehash pyenv shims (run this after switching Python versions)
@REM    vname        Show the current Python version
@REM    version      Show the current Python version and its origin
@REM    version-name Show the current Python version
@REM    versions     List all Python versions available to pyenv
@REM    exec         Runs an executable by first preparing PATH so that the selected 
@REM                 Python version's `bin' directory is at the front
@REM    which        Display the full path to an executable
@REM    whence  