#!/usr/bin/env bash
#
# Copyright (C) 2017 DANS - Data Archiving and Networked Services (info@dans.knaw.nl)
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#         http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

echo Setting .gitignores...
mv _gitignore .gitignore

echo Removing unnecessary directory nesting in scala source code...
mv src/main/scala/nl/knaw/dans/easy/${moduleSubpackage} src/main/scala/${package}
rm -fr src/main/scala/nl
mv src/test/scala/nl/knaw/dans/easy/${moduleSubpackage} src/test/scala/${package}
rm -fr src/test/scala/nl

echo Making helper scripts executable...
chmod +x *.sh

which run-reset-env.sh > /dev/null
if [ $? -eq 0 ]; then
    echo Resetting debug-config...
    run-reset-env.sh
fi

#
# Building is the last thing we do. Somehow bash sometimes skips over the next few characters after the
# mvn invocation. When it then tries to execute the next line starting from the 4th or 5th char it
# runs into what it thinks to be an unkown command, or, if the skipped chars contained a double quote,
# at the end of the script bash looks for the closing one and signals a syntax error.
#
echo Building...
mvn initialize license:format install
