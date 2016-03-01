easy-module-archetype
=====================
-[![Build Status](https://travis-ci.org/DANS-KNAW/easy-module-archetype.png?branch=master)](https://travis-ci.org/DANS-KNAW/easy-module-archetype)


SYNOPSIS
--------

After building from source, run the following command to generate an EASY module archetype:

`mvn archetype:generate -DarchetypeGroupId=nl.knaw.dans.easy -DarchetypeArtifactId=easy-module-archetype -DarchetypeVersion=1.0`


DESCRIPTION
-----------

### Maven Archetype Plug-in
Creates an EASY scala project, prepopulated with common files and structure.

see <http://maven.apache.org/archetype/maven-archetype-plugin>


ARGUMENTS
----------

* `-DgroupId`, -- defaults to **nl.knaw.dans.easy**
* `-DartifactId`
* `-Ddescription`, -- description of module task in the pom
* `-Dname`, -- used in pom
* `-Dversion`, -- defaults to **SNAPSHOT**

### Example usage

      mvn archetype:generate \ 
                -DarchetypeGroupId=nl.knaw.dans.easy \
                -DarchetypeArtifactId=easy-module-archetype \ 
                -DarchetypeVersion=1.x-SNAPSHOT \
                -DartifactId=easy-test-module \
                -Ddescription="A test module" \
                -Dpackage=nl.knaw.dans.easy.test 

This will create a module called `easy-test-module`. You need to execute `mvn license:format` in this module before
you can successfully build it.

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
