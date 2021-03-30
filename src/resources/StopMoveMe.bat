@echo off
for /f "delims= " %%a in ('jps -lv ^| find /i "MoveMe.jar"') do set PID=%%a
taskkill /f /PID %PID%
pause