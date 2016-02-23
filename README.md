easy-module-archetype
=====================

SYNOPSIS
--------

After building from source, run the following command to generate an EASY module archetype:
`mvn archetype:generate -DarchetypeGroupId=nl.knaw.dans.easy -DarchetypeArtifactId=easy-module-archetype -DarchetypeVersion=1.0`


DESCRIPTION
-----------

### Maven Archetype Plug-in
Creates an EASY scala project, prepopulated with common files and structure.

see http://maven.apache.org/archetype/maven-archetype-plugin


ARGUMENTS`
----------

* `-DgroupId`, -- defaults to nl.knaw.dans.easy
* `-DtaskId`, -- the name of the task, without 'easy'-prefix
* `-DartifactId`, -- defaults to easy-taskId
* `-DmainClass`, -- should be similar to taskId, but camelCased
* `-Ddescription`, -- description of the task in the pom
* `-Dname`, -- used in pom
* `-Dversion`, -- defaults to SNAPSHOT
* `-DhomeDir`, --


INSTALLATION AND CONFIGURATION
------------------------------

### Installation steps:

1. Unzip the tarball to a directory of your choice, e.g. /opt/
2. A new directory called easy-module-archetype-<version> will be created


BUILDING FROM SOURCE
--------------------

Prerequisites:

* Maven 3.3.3 or higher

Steps:

        git clone https://github.com/DANS-KNAW/easy-module-archetype.git
        cd easy-module-archetype
        mvn install
