#!/usr/bin/env bash
APPHOME=home
TEMPDIR=data

rm -fr $APPHOME
cp -r src/main/assembly/dist $APPHOME
cp src/test/resources/debug-config/* $APPHOME/cfg/

if [ -e $TEMPDIR ]; then
    mv $TEMPDIR $TEMPDIR-`date  +"%Y-%m-%d@%H:%M:%S"`
fi

mkdir $TEMPDIR
touch $TEMPDIR/${artifactId}.log

echo "A fresh application home directory for debugging has been set up at $APPHOME"
echo "Output and logging will go to $TEMPDIR"
echo "Add the following VM options to your run configuration to use these directories during debugging:"
echo "-Dapp.home=$APPHOME -Dlogback.configurationFile=$APPHOME/cfg/logback.xml"
