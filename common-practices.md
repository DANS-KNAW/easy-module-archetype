Common Practices
================

Code Style
----------
* Use one directory for all the packages from the `nl` package down to the top-level package
  for the project, for example `nl.knaw.dans.easy.mymodule` should be a directory (with dots
  in its name). Sub-packages of `mymodule` should be one directory per package (Java-style).
  *(Rationale: easier to navigate when using tools with no support for Java packagges, e.g.,
   when working from the command line. Also, the packages `nl` through `easy` are never used
   to contain resources directly.)*
* Use the code formatting settings as specified in ... (to be provided).
  *(Rationale: too much variation in code formatting distracts from the code logic
   (or lack thereof ;-). Git diffs only show relevant changes in code text)*

Resource Management
-------------------
* Use the `java.nio` API rather than `java.io`, for example prefer `java.nio.files.Path`
  over `java.io.File` and the functions in  `java.nio.files.Paths` over the `java.io.File`
  methods. When using libraries that expect `java.io.File` objects as parameters, convert
  them at the last possible moment.
* Use the `scala-arm` library to ensure that resources are closed, instead of doing it
  manually (e.g., in `finally` blocks).
* Save text content (including XML) as UTF-8 encoded. Use the [StandardCharsets constant] for this, rather than
  a magic string.
* Do not assume that XML is UTF-8 encoded, but instead let the parser use the `encoding` attribute
  in the XML prolog.

[StandardCharsets constant]: https://docs.oracle.com/javase/8/docs/api/java/nio/charset/StandardCharsets.html#UTF_8
  
Testing
-------
* We use the following predefined testing levels. Each test should belong clearly
  under one of these. For each level we have or will develop common practices.
    - Unit tests (test one function)
    - Service- and consumer tests
    - End-to-end tests
* Prefer unit tests (single function) over service test (exercises the whole service)
* Do not let some side effect of your unit test, such as artifacts produced, drive their
  development. *(Rationale: unit tests must be small in scope, coherent and clear, so that
  they are easily evolved in tandem with the code they test. "Small in scope" means they
  depend on little else than the code under test, but also that other things do not
  depend on them.)*
* Every unit test must copy and process any file data it uses to the directory `target/test/<test-simple-classname>`.
  An exception can be made if the unit test only reads and does not write *any* data.
  *(Rationale: this convention makes it easier to find the data, when debugging the unit tests)*
* Prefer making the input data part of the unit test source text over reading it from a file. A
  trade-off needs to be made here. Input data in the source code makes it more readily available when
  reading the test, but if the input is very large it may obscure the test logic.
* Every unit test must start with a clean slate, even if this means copying the same files multiple times.
  *(Rationale: the extra time spent copying the files will be marginal, while it makes it much easier to
  comprehend what is going on in a specific test)*
* Do clean-up at the start of the test and not at the end. *(Rationale: when running individual
  unit tests it is then easier to diagnose problems. Since all the data is put under `target` a
  `mvn clean` will clean up everything anyway.)*  
* Avoid all branching logic and most iteration logic in the unit tests. *(Rationale: the tests should
  focus on the pre- and post-conditions of the function under test. It should be readily comprehensible
  what data goes in and what is supposed to come out. Branching logic obscures this. Processing
  efficiency and DRY are of lower priority, here.)*
  
Debugging
---------
* We use the following predefined ways to start the application under test. Do not
  introduce new ways.
    - Start App object from the IDE. This is the way to go when you need step-through 
    - Start with maven `run.sh` or `run-service.sh`
    - Deploy to test VM (`deasy`) and start in the same way as in production.
  
  
Packaging and Installation
--------------------------
*To be implemented*

* Each module must be packaged as an RPM. Additionally it
  may also be packaged as a `tar.gz` file.
* The RPM must contain correct metadata, and particularly all its dependencies.
* The RPM must create all the databases and other resources that the module needs
  to function. 
* The RPM should come with reasonable defaults, and *if possible* install the module
  in a state where it will work without any further configuration. It *must not* however
  contain any DANS specific configuration settings.
* When the package is removed, the RPM should remove all the resources that can safely
  be removed. It should leave resources that could possibly be needed after uninstall,
  such as log files, databases and system users (in most cases).
* The RPM must be able to upgrade from the previous version, it may fail when trying to 
  upgrade skipping versions.
  
Documentation
-------------
* Each module should have a `README.md` file with the following sections. The ones
  marked with (*) are mandatory.
    - Title and short description, build status link to tracis-ci. (*)
    - SYNOPSIS (*)
    - DESCRIPTION (*)
    - ARGUMENTS (*)
    - EXAMPLES
    - INSTALLATION AND CONFIGURATION (*)
    - DEVELOPMENT
* Sections that become too big should refer to other documentation pages, also located
  in the root of the project, and marked up in markdown.
* For command line applications ARGUMENTS must contain exactly the output of the 
  arguments as displayed by the `--help` option. This correspondence should be checked
  by a unit test.

  

  



