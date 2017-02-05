#!/usr/bin/env bash

ARGS=$@
APPHOME=home

mvn exec:java -Dapp.home=$APPHOME \
              -Dexec.args="run-service" \
              -Dlogback.configurationFile=$APPHOME/cfg/logback-service.xml \
#              -Dlogback.statusListenerClass=ch.qos.logback.core.status.OnConsoleStatusListener

# Uncomment the last line if you need to examine the logback initialization process.