#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#!/usr/bin/env bash

NUMBER_OF_INSTALLATIONS=${symbol_dollar}1
MODULE_NAME=${artifactId}
MODULE_USER=${symbol_dollar}MODULE_NAME
INSTALL_DIR=/opt/dans.knaw.nl/${symbol_dollar}MODULE_NAME
INITD_SCRIPTS_DIR=/etc/init.d
SYSTEMD_SCRIPTS_DIR=/usr/lib/systemd/system

echo "POST-REMOVE: START (Number of current installations: ${symbol_dollar}NUMBER_OF_INSTALLATIONS)"

if [ ${symbol_dollar}NUMBER_OF_INSTALLATIONS -eq 0 ]; then # Last installation to remove, so delete service scripts
    if [ -f ${symbol_dollar}INITD_SCRIPTS_DIR/${symbol_dollar}MODULE_NAME ]; then
        echo -n "Removing initd service script... "
        rm ${symbol_dollar}INITD_SCRIPTS_DIR/${symbol_dollar}MODULE_NAME
        echo "OK"
    fi

    if [ -f ${symbol_dollar}SYSTEMD_SCRIPTS_DIR/${symbol_dollar}{MODULE_NAME}.service ]; then
        echo -n "Removing systemd service script... "
        rm ${symbol_dollar}SYSTEMD_SCRIPTS_DIR/${symbol_dollar}{MODULE_NAME}.service
        echo "OK"
    fi
fi

echo "POST-REMOVE: DONE."
