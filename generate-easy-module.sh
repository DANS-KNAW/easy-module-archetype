#!/usr/bin/env bash

DEFAULT_ARCHETYPE_VERSION=1.2.1

read -p "easy-module-archetype version? (default = $DEFAULT_ARCHETYPE_VERSION): " ARCHETYPE_VERSION
read -p "Module artifactId (e.g., easy-test-module): " ARTIFACT_ID
read -p "Name module's main package (i.e. the one UNDER nl.knaw.dans.easy): " SUBPACKAGE
read -p "Description (one to four sentences): " DESCRIPTION
read -p "Backend port number (IN THE 20000-RANGE THAT HAS NOT BEEN TAKEN YET): " BACK_END_PORT

ARTIFACT_PHRASE=`echo $ARTIFACT_ID | tr '-' ' ' | awk '{for (i=1;i<=NF;i++) $i=toupper(substr($i,1,1)) substr($i,2)} 1'`
MODULE_NAME=`echo $ARTIFACT_PHRASE | sed -e 's/Easy/EASY/'`
MODULE_JAVA_NAME=${ARTIFACT_PHRASE// }

mvn archetype:generate -DarchetypeGroupId=nl.knaw.dans.easy \
        -DarchetypeArtifactId=easy-module-archetype \
        -DarchetypeVersion=${ARCHETYPE_VERSION:-"$DEFAULT_ARCHETYPE_VERSION"} \
        -DgroupId=nl.knaw.dans.easy \
        -DartifactId=$ARTIFACT_ID \
        -Dpackage=nl.knaw.dans.easy.$SUBPACKAGE \
        -DmoduleSubpackage=$SUBPACKAGE \
        -DbackendPort="$BACK_END_PORT" \
        -Dname="$MODULE_NAME" \
        -DjavaName="$MODULE_JAVA_NAME" \
        -Ddescription="$DESCRIPTION"

cd $ARTIFACT_ID
sh init-project.sh
