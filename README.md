easy-module-archetype
=====================
[![Build Status](https://travis-ci.org/DANS-KNAW/easy-module-archetype.png?branch=master)](https://travis-ci.org/DANS-KNAW/easy-module-archetype)

Generate a skeleton EASY Module.

SYNOPSIS
--------

       generate-easy-module.sh

DESCRIPTION
-----------

Creates an EASY scala project, prepopulated with common files and structure. It uses the 
[maven archetype plugin](http://maven.apache.org/archetype/maven-archetype-plugin).

The archetype serves two purposes:

* It sets up a skeleton project for you if you need to create a new EASY module.
* More importantly, the skeleton is set up with the [current common practices].

[current common practices]: common-practices.md

### Example usage

This assumes that you have copied the `generate-easy-module.sh` script to a directory that is on your `$PATH`. On
the Mac that could be `/usr/local/bin`

    $ cd ~/git/my-test-projects
    $ generate-easy-module.sh
    > easy-module-archetype version? (default = 1.x-SNAPSHOT): [Enter]
    > Module artifactId (e.g., easy-test-module): easy-hello-world [Enter]
    > Name module's main package (i.e. the one under nl.knaw.dans.easy): hello [Enter]
    > Description (one to four sentences): Simple example \ [Enter]
      that demonstrates that this generation script works. [Enter]
    > [INFO] Scanning for projects...
      [INFO]
      [INFO] ------------------------------------------------------------------------
      [INFO] Building Maven Stub Project (No POM) 1
      [INFO] ------------------------------------------------------------------------
      ... <more output>
      Confirm properties configuration:
      groupId: nl.knaw.dans.easy
      artifactId: easy-hello-world
      version: 1.x-SNAPSHOT
      package: nl.knaw.dans.easy.hello
      description: Simple example that demonstrates that this generation script works.
      javaName: EasyHelloWorld
      moduleSubpackage: hello
      name: EASY Hello World
       Y: : [Enter]
    > ... <more output>
      
    


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
`archetypeGroupId`       | `nl.knaw.dans.easy`.
`archetypeArtifactId`    | `easy-module-archetype`  
`archetypeVersion`       | The version of the archetype your want to use.
`artifactId`             | Archetype ID for your module `easy-<some name>`.
`description`            | Short description.
`package`                | Main package of your module, must be directly under `nl.knaw.dans.easy`, e.g., `nl.knaw.dans.easy.test`.
`moduleSubpackage`       | The unqualified name of your your main package, e.g., `test`.
`name`                   | Name of your project, capitalized title style, e.g. "My Test Module".
`javaName`               | The same as `name` but with no spaces: `MyTestModule`.




INSTALLATION AND CONFIGURATION
------------------------------

* Add `http://maven.dans.knaw.nl/` as a plug-in repository if you want to use a release version of this plug-in.
* Clone and build the project if you want to use a snapshot.


BUILDING FROM SOURCE
--------------------

Prerequisites:

* Maven 3.3.3 or higher

Steps:

        git clone https://github.com/DANS-KNAW/easy-module-archetype.git
        cd easy-module-archetype
        mvn install
