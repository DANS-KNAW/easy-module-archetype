#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#!/usr/bin/env bash
${symbol_pound}include <service.sh>

NUMBER_OF_INSTALLATIONS=${symbol_dollar}1
MODULE_NAME=${artifactId}
INSTALL_DIR=/opt/dans.knaw.nl/${symbol_dollar}MODULE_NAME
PHASE="POST-REMOVE"

echo "${symbol_dollar}PHASE: START (Number of current installations: ${symbol_dollar}NUMBER_OF_INSTALLATIONS)"
service_remove_systemd_unit ${symbol_dollar}MODULE_NAME ${symbol_dollar}NUMBER_OF_INSTALLATIONS
echo "${symbol_dollar}PHASE: DONE"
