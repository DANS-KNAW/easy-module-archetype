#!/usr/bin/env bash

APPHOME=home

for a in "$@"
do
  ARGS="$ARGS'$a' "
done

MAVEN_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,address=8000,suspend=y" \
mvn exec:java -Dapp.home=$APPHOME \
              -Dlogback.configurationFile=$APPHOME/cfg/logback.xml \
              -Dexec.args="$ARGS"