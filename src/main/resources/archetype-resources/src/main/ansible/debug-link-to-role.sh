#!/usr/bin/env bash
# Creates a symbolic link to the local standard location of the role project.
# Only intended for debugging the role project. Normally, you should use the
# ansible-galaxy installed role from GitHub, which is automatically downloaded
# when doing "vagrant up".

ROLE1=dans.${artifactId}
ROLE2=dans.easy-includes

rm `dirname $0`/roles/$ROLE1
rm `dirname $0`/roles/$ROLE2

ln -s ~/git/dtap/roles/$ROLE1 `dirname $0`/roles/$ROLE1
ln -s ~/git/dtap/roles/$ROLE2 `dirname $0`/roles/$ROLE2

