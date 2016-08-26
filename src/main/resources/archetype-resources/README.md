${artifactId}
===========
[![Build Status](https://travis-ci.org/DANS-KNAW/${artifactId}.png?branch=master)](https://travis-ci.org/DANS-KNAW/${artifactId})

<Remove this comment and extend the descriptions below>


SYNOPSIS
--------

    ${artifactId} params


DESCRIPTION
-----------

<Replace with a longer description of this module>


ARGUMENTS
---------

<Replace with output from --help option on the command line>


### Example usage

`${artifactId} -o value`


INSTALLATION AND CONFIGURATION
------------------------------

### Installation steps

1. Unzip the tarball to a directory of your choice, e.g. /opt/
2. A new directory called ${artifactId}-<version> will be created
3. Add the command script to your `PATH` environment variable by creating a symbolic link to it from a directory that is
   on the path, e.g. 
   
        ln -s /opt/${artifactId}-<version>/bin/${artifactId} /usr/bin


### Configuration

General configuration settings can be set in `cfg/application.properties` and logging can be configured
in `cfg/logback.xml`. The available settings are explained in comments in aforementioned files.


BUILDING FROM SOURCE
--------------------

Prerequisites:

* Java 8 or higher
* Maven 3.3.3 or higher

Steps:

        git clone https://github.com/DANS-KNAW/${artifactId}.git
        cd ${artifactId}
        mvn install
