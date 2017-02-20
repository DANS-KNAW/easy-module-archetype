easy-module-archetype
=====================
[![Build Status](https://travis-ci.org/DANS-KNAW/easy-module-archetype.png?branch=master)](https://travis-ci.org/DANS-KNAW/easy-module-archetype)

Generate a skeleton EASY Module.

SYNOPSIS
--------

           mvn archetype:generate -DarchetypeGroupId=nl.knaw.dans.easy \
                    -DarchetypeArtifactId=easy-module-archetype \
                    -DarchetypeVersion=1.x-SNAPSHOT \
                    -DgroupId=nl.knaw.dans.easy \
                    -DartifactId=easy-module \
                    -Dpackage=nl.knaw.dans.easy.module \
                    -DmoduleSubpackage=module \
                    -Dname="EASY Module" \
                    -DjavaName="EasyModule" \
                    -Ddescription="A longer description of this module"

DESCRIPTION
-----------

Creates an EASY scala project, prepopulated with common files and structure. It uses the 
[maven archetype plugin](http://maven.apache.org/archetype/maven-archetype-plugin).

The archetype serves two purposes:

* It sets up a skeleton project for you if you need to create a new EASY module.
* More importantly, the skeleton is set up with the [current common practices].

[current common practices]: common-practices.md

### Example usage

Using interactively retrieved parameters in the defaults of other parameters does not currently seem feasible. For example,
it would be nicer if the user only had to provide the `moduleSubpackage` and that it would be automatically appended to 
`nl.knaw.dans.easy` to form the package name. However, the order in which the parameters are asked from the user cannot be configured, 
and does not seem to follow any predictable pattern. That is why some redundant information needs to be provided, and user must
ensure that it is consistent:

* The `moduleSubpackage` parameter *must* be the last package name in `package`.
* The `javaName` parameter *must* be the `name` transformed into the format a Java class identifier (no spaces, capitals for the first letter of each word)

         mvn archetype:generate \ 
                -DarchetypeGroupId=nl.knaw.dans.easy \
                -DarchetypeArtifactId=easy-module-archetype \ 
                -DarchetypeVersion=1.x-SNAPSHOT \
                -DartifactId=easy-test-module \
                -Ddescription="A test module" \
                -Dpackage=nl.knaw.dans.easy.test \
                -Dname="Module Test"
                -DjavaName="ModuleTest" \
                -DmoduleSubpackage=test

This will create a module called `easy-test-module`. 

### Initializing the project

The archetype plugin does not take care of everything. That is why a helper script is provided, that will finish setting up the 
project for you:

    sh init-project.sh

Note that you must type `sh` before the script name, as it is not by default executable. The script will generate license headers, build the project
and make some other helper script executable. To find out what it does exactly, take a look at it!

As a final step you should initialize a git project and have the project added to GitHub. I have left this out of `init-project.sh` as I am not sure if
it could mess up your project if you accidentally run `init-project.sh` multiple times. Anyway, the command does not require much of you:

    git init
    
Now, you are all set to start developing, except ...    

### Delete what you do not use!

The skeleton project contains stubs for a daemon with an HTTP interface and a command line application, and by the time you read this,
possibly more stubs. *It is important to delete the parts that you are not going to use*, to avoid clutter. Yes, even if you may use it
in the future, just delete the stuff! For example: if you only need a command line application, you should delete

* the daemon scripts in `src/main/assembly/bin`,
* the service-related classes,
* the `run-service` sub-command,
* maybe some other things as well: check!

ARGUMENTS
----------

Parameter                | Description / value
-------------------------|-----------------------------------------------
archetypeGroupId         | `nl.knaw.dans.easy`
archetypeArtifactId      | `easy-module-archetype`  
archetypeVersion         | The version of the archetype your want to use
artifactId               | Archetype ID for your module `easy-<some name>`
description              | Short description
package                  | Main package of your module, must be directly under `nl.knaw.dans.easy`
moduleSubpackage         | The last part o 
name                     | Name of your project, capitalized title style, e.g. "My Test Module"
javaName                 | The same as `name` but with no spaces: `MyTestModule`




INSTALLATION AND CONFIGURATION
------------------------------

No installation is needed if 


BUILDING FROM SOURCE
--------------------

Prerequisites:

* Maven 3.3.3 or higher

Steps:

        git clone https://github.com/DANS-KNAW/easy-module-archetype.git
        cd easy-module-archetype
        mvn install
