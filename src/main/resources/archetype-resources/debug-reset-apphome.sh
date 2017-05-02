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
