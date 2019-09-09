#!/usr/bin/env bash
#
# Copyright (C) 2018 DANS - Data Archiving and Networked Services (info@dans.knaw.nl)
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#


DEFAULT_ARCHETYPE_VERSION=2.0.3
PROJECT_PREFIX="easy"

read -p "easy-module-archetype version? (default = $DEFAULT_ARCHETYPE_VERSION): " ARCHETYPE_VERSION
read -p "Module artifactId (e.g., easy-test-module): " ARTIFACT_ID
read -p "Name module's main package (i.e. the one UNDER nl.knaw.dans.easy): " SUBPACKAGE
read -p "Description (one to four sentences): " DESCRIPTION
read -p "Backend port number (IN THE 20000-RANGE THAT HAS NOT BEEN TAKEN YET): " BACK_END_PORT

PROJECT_PREFIX_REGEX="^([^-]+)-.*$"
if [[ "$ARTIFACT_ID" =~ $PROJECT_PREFIX_REGEX ]]; then
    PROJECT_PREFIX=`echo "$ARTIFACT_ID" | sed -E "s/$PROJECT_PREFIX_REGEX/\1/"`
else
    echo "artifactId does not match the expected pattern; module is not generated"
    exit 1
fi

ARTIFACT_PHRASE=`echo $ARTIFACT_ID | tr '-' ' ' | awk '{for (i=1;i<=NF;i++) $i=toupper(substr($i,1,1)) substr($i,2)} 1'`
MODULE_NAME=`echo $ARTIFACT_PHRASE | awk '{$1=toupper($1); print $0}'`
MODULE_JAVA_NAME=${ARTIFACT_PHRASE// }

mvn archetype:generate -DarchetypeGroupId=nl.knaw.dans.easy \
        -DarchetypeArtifactId=easy-module-archetype \
        -DarchetypeVersion=${ARCHETYPE_VERSION:-"$DEFAULT_ARCHETYPE_VERSION"} \
        -DgroupId=nl.knaw.dans.$PROJECT_PREFIX \
        -DartifactId=$ARTIFACT_ID \
        -Dpackage=nl.knaw.dans.$PROJECT_PREFIX.$SUBPACKAGE \
        -DprojectPrefix=$PROJECT_PREFIX \
        -DmoduleSubpackage=$SUBPACKAGE \
        -DbackendPort="$BACK_END_PORT" \
        -Dname="$MODULE_NAME" \
        -DjavaName="$MODULE_JAVA_NAME" \
        -Ddescription="$DESCRIPTION" \
        -DinceptionYear=$(date +"%Y")

cd $ARTIFACT_ID
sh init-project.sh
rm init-project.sh
