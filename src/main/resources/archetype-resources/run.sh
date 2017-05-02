#!/usr/bin/env bash

APPHOME=home

for a in "$@"
do
  ARGS="$ARGS'$a' "
done

mvn exec:java -Dapp.home=$APPHOME \
              -Dlogback.configurationFile=$APPHOME/cfg/logback.xml \
              -Dexec.args="$ARGS"
