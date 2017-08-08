#!/usr/bin/env bash
set -e # abort when a command fails

TEMPDIR=data
if [ -e $TEMPDIR ]; then
    mv $TEMPDIR ${symbol_dollar}{TEMPDIR}-${symbol_dollar}(date  +"%Y-%m-%d@%H:%M:%S")
fi
mkdir $TEMPDIR

echo -n "Pre-creating log..."
touch $TEMPDIR/${artifactId}.log
echo "OK"
