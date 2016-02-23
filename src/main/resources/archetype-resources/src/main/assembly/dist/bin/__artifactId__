#!/bin/sh

SCRIPT_LOCATION=$(cd $(dirname $0)/..; pwd)

if [[ -z $${homeDir} ]]
then
  ${symbol_pound} no home variable was set, default to SCRIPT_LOCATION
  export ${homeDir}=$SCRIPT_LOCATION
fi


if [ $# -eq 0 ]
then
  echo "
  arguments:

    required: 
    optional:   -Deasy.host=localhost
                -Dlogback.configurationFile=<logConfig>
    <logConfig> default: $(cd $(dirname $(dirname $0))/..; pwd)/cfg/logback.xml
                drop <appender-ref ref='STDOUT' /> in your own version
                if you want to rely on the central logging
"
    exit 1
fi

${symbol_pound} required for the log folder configured in logback.xml
${symbol_pound} and the reports folder for RL
pushd $SCRIPT_LOCATION/bin

${symbol_pound} execute
${symbol_pound}
${symbol_pound} command line arguments are passed on as JVM arguments
${symbol_pound} that allows to override and/or extend application.properties
${symbol_pound} for example -Deasy.host=evm or -Deasy.host=localhost
${symbol_pound}
${symbol_pound} optional after the .jar: alternative for application-context.xml
${symbol_pound} create a run script for each delivered alternative

java -Dlogback.statusListenerClass=ch.qos.logback.core.status.OnConsoleStatusListener \
     -Dlogback.configurationFile=$${homeDir}/cfg/logback.xml \
     "${@}" \
     -jar $SCRIPT_LOCATION/bin/${artifactId}.jar 
popd