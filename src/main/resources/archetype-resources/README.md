${artifactId}
===========
[![Build Status](https://travis-ci.org/DANS-KNAW/${artifactId}.png?branch=master)](https://travis-ci.org/DANS-KNAW/${artifactId})


SYNOPSIS
--------

    ${artifactId} params


DESCRIPTION
-----------

###


ARGUMENTS
---------

* ``-o``, ``--option`` -- description of option




``${artifactId}``

INSTALLATION AND CONFIGURATION
------------------------------

### Installation steps:

1. Unzip the tarball to a directory of your choice, e.g. /opt/
2. A new directory called ${artifactId}-<version> will be created


### Configuration

General configuration settings can be set in ``${homeDir}/cfg/appliation.properties`` and logging can be configured
in ``${homeDir}/cfg/logback.xml``. The available settings are explained in comments in aforementioned files.


BUILDING FROM SOURCE
--------------------

Prerequisites:

* Java 8 or higher
* Maven 3.3.3 or higher

Steps:

        git clone https://github.com/DANS-KNAW/${artifactId}.git
        cd ${artifactId}
        mvn install


[client command-line utilities]: https://wiki.duraspace.org/display/FEDORA38/Client+Command-line+Utilities
[FOXML]: https://wiki.duraspace.org/pages/viewpage.action?pageId=66585857
[dans-parent]: https://github.com/DANS-KNAW/dans-parent
[json]: http://json.org/
