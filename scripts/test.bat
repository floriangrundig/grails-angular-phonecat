@echo off

REM Windows script for running unit tests with the grails karma-test-runner plugin
REM
REM Requirements:
REM - NodeJS (http://nodejs.org/)
REM - Karma (npm install -g karma)
REM - Karma (npm install -g karma-remote-reporter)

set PATH=%PATH%;"C:\Users\flo\AppData\Roaming\npm"

set CHROME_BIN="C:\Program Files (x86)\Google\Chrome\Application\chrome.exe"
set IE_BIN="C:\Program Files\Internet Explorer\iexplore.exe"


set BASE_DIR=%~dp0
karma start "%BASE_DIR%\..\test\javascript\config\karma.conf.js" %*
