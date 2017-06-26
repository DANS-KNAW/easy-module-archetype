#!/usr/bin/env bash

APPHOME=home

for a in "$@"
do
  ARGS="$ARGS'$a' "
done

LC_ALL=en_US.UTF-8 \
mvn exec:java -Dapp.home=$APPHOME \
              -Dlogback.configurationFile=$APPHOME/cfg/logback.xml \
              -Dexec.args="$ARGS"
