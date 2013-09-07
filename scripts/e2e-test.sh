#!/bin/bash

BASE_DIR=`dirname $0`
export PATH=$PATH:/usr/local/bin/

echo ""
echo "Starting Karma Server (http://karma-runner.github.io)"
echo "-------------------------------------------------------------------"

karma start $BASE_DIR/../test/javascript/config/karma-e2e.conf.js $*
