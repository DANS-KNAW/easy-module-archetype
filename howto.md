HOWTO
=====

This page contains recipe-like instructions.


Add a resource to the RPM
-------------------------
* Problem: I want to add an extra resource to the installed software, apart from the
  standard ones covered by `dans-parent`
* Solution: Extend the inherited `rpm-maven-plugin` configuration.
* Steps:
    1. Open your project's `pom.xml`.
    2. Look up the `rpm-maven-plugin` configuration.
    3. 
    
    

* Explanation

Add a required package to the RPM
---------------------------------


Create a CLI-only application
-----------------------------


Add a new setting to `application.properties` when upgrading
------------------------------------------------------------