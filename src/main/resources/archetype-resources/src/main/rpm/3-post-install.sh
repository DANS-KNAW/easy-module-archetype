#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#!/usr/bin/env bash

${symbol_pound}include <log.sh>
${symbol_pound}include <service.sh>

NUMBER_OF_INSTALLATIONS=${symbol_dollar}1
MODULE_NAME=${artifactId}
INSTALL_DIR=/opt/dans.knaw.nl/${symbol_dollar}MODULE_NAME
PHASE="POST-INSTALL"

log_script_start ${symbol_dollar}PHASE ${symbol_dollar}NUMBER_OF_INSTALLATIONS
service_install_initd_service_script "${symbol_dollar}INSTALL_DIR/bin/${symbol_dollar}MODULE_NAME-initd.sh" ${symbol_dollar}MODULE_NAME
service_install_systemd_unit "${symbol_dollar}INSTALL_DIR/bin/${symbol_dollar}MODULE_NAME.service"
service_create_log_directory ${symbol_dollar}MODULE_NAME
log_script_done ${symbol_dollar}PHASE
