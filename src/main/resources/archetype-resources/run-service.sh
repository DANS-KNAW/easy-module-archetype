#!/usr/bin/env bash

ARGS=$@
APPHOME=home

MAVEN_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,address=8000,suspend=n" \
mvn exec:java -Dapp.home=$APPHOME \
              -Dexec.args="run-service" \
              -Dlogback.configurationFile=$APPHOME/cfg/logback-service.xml \
#              -Dlogback.statusListenerClass=ch.qos.logback.core.status.OnConsoleStatusListener

# Uncomment the last line if you need to examine the logback initialization process.