#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#!/usr/bin/env bash

NUMBER_OF_INSTALLATIONS=${symbol_dollar}1
MODULE_NAME=${artifactId}
MODULE_USER=${symbol_dollar}MODULE_NAME
INSTALL_DIR=/opt/dans.knaw.nl/${symbol_dollar}MODULE_NAME
LOG_DIR=/var/opt/dans.knaw.nl/log/${symbol_dollar}MODULE_NAME
INITD_SCRIPTS_DIR=/etc/init.d
SYSTEMD_SCRIPTS_DIR=/usr/lib/systemd/system

echo "PRE-REMOVE: START (Number of current installations: ${symbol_dollar}NUMBER_OF_INSTALLATIONS)"

echo "PRE-REMOVE: DONE."
