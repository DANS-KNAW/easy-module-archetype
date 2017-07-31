#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#!/usr/bin/env bash

${symbol_pound}include <service.sh>

NUMBER_OF_INSTALLATIONS=${symbol_dollar}1
MODULE_NAME=${artifactId}
INSTALL_DIR=/opt/dans.knaw.nl/${symbol_dollar}MODULE_NAME
PHASE="POST-INSTALL"

echo "${symbol_dollar}PHASE: START (Number of current installations: ${symbol_dollar}NUMBER_OF_INSTALLATIONS)"
service_install_initd_service_script "${symbol_dollar}INSTALL_DIR/install/${symbol_dollar}MODULE_NAME-initd.sh" ${symbol_dollar}MODULE_NAME
service_install_systemd_unit "${symbol_dollar}INSTALL_DIR/install/${symbol_dollar}MODULE_NAME.service" ${symbol_dollar}MODULE_NAME "${symbol_dollar}INSTALL_DIR/install/override.conf"

service_create_log_directory ${symbol_dollar}MODULE_NAME
echo "${symbol_dollar}PHASE: DONE"
