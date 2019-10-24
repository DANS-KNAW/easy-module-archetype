${artifactId}
===========
[![Build Status](https://travis-ci.org/DANS-KNAW/${artifactId}.png?branch=master)](https://travis-ci.org/DANS-KNAW/${artifactId})

<!-- Remove this comment and extend the descriptions below -->


SYNOPSIS
--------

    ${artifactId} (synopsis of command line parameters)
    ${artifactId} (... possibly multiple lines for subcommands)


DESCRIPTION
-----------

${description}


ARGUMENTS
---------

    Options:

       -h, --help      Show help message
       -v, --version   Show version of this program

    Subcommand: run-service - Starts ${name} as a daemon that services HTTP requests
       -h, --help   Show help message
    ---

EXAMPLES
--------

    ${artifactId} -o value

INSTALLATION AND CONFIGURATION
------------------------------
Currently this project is built as an RPM package for RHEL7/CentOS7 and later. The RPM will install the binaries to
`/opt/dans.knaw.nl/${artifactId}` and the configuration files to `/etc/opt/dans.knaw.nl/${artifactId}`. 

To install the module on systems that do not support RPM you can copy and unarchive the tarball to the target host.
You will have to take care of placing the files in the correct locations for your system yourself. For instructions
on building the tarball, see next section.

BUILDING FROM SOURCE
--------------------
Prerequisites:

* Java 8 or higher
* Maven 3.3.3 or higher
* RPM

Steps:
    
    git clone https://github.com/DANS-KNAW/${artifactId}.git
    cd ${artifactId} 
    mvn clean install

If the `rpm` executable is found at `/usr/local/bin/rpm`, the build profile that includes the RPM 
packaging will be activated. If `rpm` is available, but at a different path, then activate it by using
Maven's `-P` switch: `mvn -Pprm install`.

Optionally, to build the tarball execute:

    mvn assembly:single
