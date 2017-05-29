#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#!/usr/bin/env bash

NUMBER_OF_INSTALLATIONS=${symbol_dollar}1
MODULE_NAME=${artifactId}
MODULE_USER=${symbol_dollar}MODULE_NAME

echo "PRE-INSTALL: START (Number of current installations: ${symbol_dollar}NUMBER_OF_INSTALLATIONS)"

if [ ${symbol_dollar}NUMBER_OF_INSTALLATIONS -gt 0 ]; then
    echo -n "Attempting to stop service... "
    service ${symbol_dollar}MODULE_NAME stop  2> /dev/null 1> /dev/null
    if [ ${symbol_dollar}? -ne 0 ]; then
        systemctl stop ${symbol_dollar}MODULE_NAME 2> /dev/null 1> /dev/null
    fi
    echo "OK"
fi

id -u ${symbol_dollar}MODULE_USER 2> /dev/null 1> /dev/null

if [ "${symbol_dollar}?" == "1" ]; # User not found
then
    echo -n "Creating module user: ${symbol_dollar}MODULE_USER... "
    useradd --system ${symbol_dollar}MODULE_USER 2> /dev/null
    echo "OK"
else
    echo "Module user ${symbol_dollar}MODULE_USER already exists. No action taken."
fi

echo "PRE-INSTALL: DONE."
