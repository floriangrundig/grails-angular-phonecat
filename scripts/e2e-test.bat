@echo off

REM Windows script for running e2e tests with the grails karma-test-runner plugin
REM
REM Requirements:
REM - NodeJS (http://nodejs.org/)
REM - Karma (npm install -g karma)
REM - Karma (npm install -g karma-ng-scenario)
REM - Karma (npm install -g karma-ie-launcher)
REM - Karma (npm install -g karma-remote-reporter)

set PATH=%PATH%;"C:\Dokumente und Einstellungen\florian\Anwendungsdaten\npm"

set CHROME_BIN="C:\Programme\Google\Chrome\Application\chrome.exe"
set IE_BIN="C:\Programme\Internet Explorer\iexplore.exe"

set BASE_DIR=%~dp0
karma start "%BASE_DIR%\..\test\javascript\config\karma-e2e.conf.js" %*
