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

echo "POST-INSTALL: START (Number of current installations: ${symbol_dollar}NUMBER_OF_INSTALLATIONS)"

if [ -d ${symbol_dollar}INITD_SCRIPTS_DIR ]; then
    echo -n "Installing initd service script... "
    cp ${symbol_dollar}INSTALL_DIR/bin/${symbol_dollar}{MODULE_NAME}-initd.sh ${symbol_dollar}INITD_SCRIPTS_DIR/${symbol_dollar}MODULE_NAME
    chmod o+x ${symbol_dollar}INITD_SCRIPTS_DIR/${symbol_dollar}MODULE_NAME
    echo "OK"
fi

if [ -d ${symbol_dollar}SYSTEMD_SCRIPTS_DIR ]; then
    echo -n "Installing systemd service script... "
    cp ${symbol_dollar}INSTALL_DIR/bin/${symbol_dollar}{MODULE_NAME}.service ${symbol_dollar}SYSTEMD_SCRIPTS_DIR/
    echo "OK"
fi

if [ ! -d ${symbol_dollar}LOG_DIR ]; then
    echo -n "Creating directory for logging... "
    mkdir -p ${symbol_dollar}LOG_DIR
    chown ${symbol_dollar}MODULE_USER ${symbol_dollar}LOG_DIR
    echo "OK"
fi

echo "POST-INSTALL: DONE."
