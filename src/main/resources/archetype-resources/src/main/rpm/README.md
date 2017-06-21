RPM Scripts
===========

By adding shell scripts here you can hook into the installation process. The following scripts can
be added:

* `0-prepare.sh`
* `1-pre-install.sh`
* `2-install.sh`
* `3-post-install.sh`
* `4-pre-remove.sh`
* `5-post-remove.sh`
* `6-verify.sh`
* `7-clean.sh`
* `8-pre-trans.sh`
* `9-post-trans.sh`

Including functions from `dans-build-resources`
-----------------------------------------------

You can include functions from `dans-build-resources` like this:

    #include <include-file.sh>

For example

    #include <service.sh>

Will paste the contents of `dans-parent/dans-build-resources/src/main/resources/rpm-includes/service.sh` into your 
shell script at build time.