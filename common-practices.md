Common Practices
================

Code Style
----------
* Use one directory for all the packages from the `nl` package down to the top-level package
  for the project, for example `nl.knaw.dans.easy.mymodule` should be a directory (with dots
  in its name). Sub-packages of `mymodule` should be one directory per package (Java-style).
* Use the code formatting settings as specified in ... (to be provided).

Resource Management
-------------------
* Use the `java.nio` API rather than `java.io`, for example prefer `java.nio.files.Path`
  over `java.io.File` and the function in  `java.nio.files.Paths` over the `java.io.File`
  methods. When using libraries that expect `java.io.File` objects as parameters, convert
  them at the last possible moment.
* Use the `scala-arm` library to ensure that resources are closed, instead of doing it
  manually (e.g., in `finally` blocks).
  
  
  

  



