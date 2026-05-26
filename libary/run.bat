@echo off
chcp 65001 >nul
setlocal enabledelayedexpansion
set JAVA_TOOL_OPTIONS=
cd /d "%~dp0"
java -Dfile.encoding=UTF-8 -cp target/classes library.com.App
pause
