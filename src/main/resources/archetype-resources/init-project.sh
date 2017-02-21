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

echo "Setting .gitignores"
mv _gitignore .gitignore
mv src/main/ansible/_gitignore src/main/ansible/.gitignore

echo "Building ..."
mvn license:format clean install

echo "Removing unnecessary directory nesting in scala source code ..."

echo "Making helper scripts executable ..."
chmod +x run.sh
chmod +x run-service.sh
chmod +x debug-reset-apphome.sh
chmod +x src/main/ansible/*.sh

echo "Resetting debug-config"
./debug-reset-apphome.sh

echo "Done. You may now remove this script; it is of no further use."
