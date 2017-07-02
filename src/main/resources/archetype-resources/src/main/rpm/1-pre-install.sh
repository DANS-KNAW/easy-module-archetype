#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#!/usr/bin/env bash

${symbol_pound}include <service.sh>

NUMBER_OF_INSTALLATIONS=${symbol_dollar}1
MODULE_NAME=${artifactId}
PHASE="PRE-INSTALL"

echo "${symbol_dollar}PHASE: START (Number of current installations: ${symbol_dollar}NUMBER_OF_INSTALLATIONS)"
service_stop ${symbol_dollar}MODULE_NAME ${symbol_dollar}NUMBER_OF_INSTALLATIONS
service_create_module_user ${symbol_dollar}MODULE_NAME
echo "${symbol_dollar}PHASE: DONE"
