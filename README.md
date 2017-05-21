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
* More importantly, the skeleton is set up to support the [current common practices].

### Features
* Stub Scala source, including:
    - Entry point for command line interface (`Command`)
    - Service starter for a `initd` type daemon.
    - Service class that starts up a Jetty instance
    - An App trait that reads in settings from a properties file.
    - Unit test that checks that parts of this `README.md` correpond with the output of the `--help`
      command line option.
    - Unit test that checks that the example configuration supporting the execution of the program
      by Maven contain the configuration keys that are expected by the program.
* Stub assembly resources:
    - Command line starter script, `initd` and `systemd` scripts.
    - Configuration files (`applictation.properties` and separated logback config files for command line
      and daemon execution.)
    - Assembly descriptor for the `tar.gz` archive.
* Stub RPM configuration:
    - A profile in the POM that configures the `rpm-maven-plugin`. This allows you to build the RPM (`mvn clean install -Prpm`)
      (Requires RPM to be installed. On the Mac: `brew install rpm`.)
    - Hook scripts, partially implemented, that will execute during RPM installation (before/after install and 
      before/after remove).
* Vagrant and ansible set-up:
    - Allows you to quickly set-up a VM for testing. Simply type `vagrant up`. (Requires vagrant and ansible to be installed.)
    - `yum-repo.yml` helper script, called from `src/main/ansible/vagrant.yml` (commented out by default) which sets up a
      local yum repo and installs your rpm on the test VM.
* Probably more, by the time your read this...

[current common practices]: common-practices.md

ARGUMENTS
----------

The `generate-easy-module.sh` script will interactively query you for argument values.

EXAMPLES
--------

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
      [INFO] BUILD SUCCESS
      [INFO] ------------------------------------------------------------------------
      [INFO] Total time: 2.333 s
      [INFO] Finished at: 2017-05-21T10:15:21+02:00
      [INFO] Final Memory: 30M/308M
      [INFO] ------------------------------------------------------------------------
    $ cd easy-hello-world [Enter]
    $ rm init-project.sh [Enter]

Now, you are all set to start developing, except ...    

### Delete what you do not use!

The skeleton project contains stubs for a daemon with an HTTP interface and a command line application, and by the time you read this,
possibly more stubs. *It is important to delete the parts that you are not going to use*, to avoid clutter. Yes, even if you may use it
in the future, just delete the stuff! For example: if you only need a command line application, you should delete

* the daemon scripts in `src/main/assembly/bin`,
* the service-related classes,
* the `run-service` sub-command,
* maybe some other things as well: check!


INSTALLATION AND CONFIGURATION
------------------------------

* Add `http://maven.dans.knaw.nl/` as a plug-in repository if you want to use a release version of this plug-in.
* Clone and build the project if you want to use a snapshot.


DEVELOPMENT
-----------

### Building from source

Prerequisites:

* Maven 3.3.3 or higher

Steps:

        git clone https://github.com/DANS-KNAW/easy-module-archetype.git
        cd easy-module-archetype
        mvn install
