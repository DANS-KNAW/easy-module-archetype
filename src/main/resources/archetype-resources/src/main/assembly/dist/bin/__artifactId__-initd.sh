#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#!/usr/bin/env bash
#  /etc/init.d/${artifactId}

# ***** FILL IN APPROPRIATE RUN-LEVELS, START-UP AND SHUTDOWN PRIORITIES !!! ******
# chkconfig: 2345 92 58

### BEGIN INIT INFO
# Provides:          ${artifactId}
# Short-Description: Starts the ${artifactId} service
# Description:       This file is used to start the daemon
#                    and should be placed in /etc/init.d
### END INIT INFO

NAME="${artifactId}"
EXEC="/usr/bin/jsvc"
APPHOME="/usr/local/${artifactId}"
JAVA_HOME="/usr/lib/jvm/jre"
CLASSPATH="${symbol_dollar}APPHOME/bin/${symbol_dollar}NAME.jar:`echo ${symbol_dollar}APPHOME/lib/*.jar | sed 's/ /:/g'`"
CLASS="${package}.ServiceStarter"
ARGS=""
USER="${artifactId}"
PID="/var/run/${symbol_dollar}NAME.pid"
OUTFILE="/var/log/${symbol_dollar}NAME/${symbol_dollar}NAME.out"
ERRFILE="/var/log/${symbol_dollar}NAME/${symbol_dollar}NAME.err"
WAIT_TIME=60

jsvc_exec()
{
    cd ${symbol_dollar}{APPHOME}
    LC_ALL=en_US.UTF-8 \
    ${symbol_dollar}{EXEC} -home ${symbol_dollar}{JAVA_HOME} -cp ${symbol_dollar}{CLASSPATH} -user ${symbol_dollar}{USER} -outfile ${symbol_dollar}{OUTFILE} -errfile ${symbol_dollar}{ERRFILE} -pidfile ${symbol_dollar}{PID} -wait ${symbol_dollar}{WAIT_TIME} \
          -Dapp.home=${symbol_dollar}{APPHOME} -Dconfig.file=${symbol_dollar}{APPHOME}/cfg/application.conf \
          -Dlogback.configurationFile=${symbol_dollar}{APPHOME}/cfg/logback-service.xml ${symbol_dollar}1 ${symbol_dollar}{CLASS} ${symbol_dollar}{ARGS}
}

start_jsvc_exec()
{
    jsvc_exec
    if [[ ${symbol_dollar}? == 0 ]]; then # start is successful
        echo "${symbol_dollar}NAME has started."
    else
        echo "${symbol_dollar}NAME did not start successfully (exit code: ${symbol_dollar}?)."
    fi
}

stop_jsvc_exec()
{
    jsvc_exec "-stop"
    if [[ ${symbol_dollar}? == 0 ]]; then # stop is successful
        echo "${symbol_dollar}NAME has stopped."
    else
        echo "${symbol_dollar}NAME did not stop successfully (exit code: ${symbol_dollar}?)".
    fi
}

restart_jsvc_exec()
{
    echo "Restarting ${symbol_dollar}NAME ..."
    jsvc_exec "-stop"
    if [[ ${symbol_dollar}? == 0 ]]; then # stop is successful
        echo "${symbol_dollar}NAME has stopped, starting again ..."
        jsvc_exec
        if [[ ${symbol_dollar}? == 0 ]]; then # start is successful
            echo "${symbol_dollar}NAME has restarted."
        else
            echo "${symbol_dollar}NAME did not start successfully (exit code: ${symbol_dollar}?)."
        fi
    else
        echo "${symbol_dollar}NAME did not stop successfully (exit code: ${symbol_dollar}?)."
    fi
}

case "${symbol_dollar}1" in
    start)
        if [ -f "${symbol_dollar}PID" ]; then # service is running
            echo "${symbol_dollar}NAME is already running, no action taken."
            exit 1
        else
            echo "Starting ${symbol_dollar}NAME ..."
            start_jsvc_exec
        fi
    ;;
    stop)
        if [ -f "${symbol_dollar}PID" ]; then # service is running
            echo "Stopping ${symbol_dollar}NAME ..."
            stop_jsvc_exec
        else
            echo "${symbol_dollar}NAME is not running, no action taken."
            exit 1
        fi
    ;;
    restart)
        if [ -f "${symbol_dollar}PID" ]; then # service is running
            restart_jsvc_exec
        else
            echo "${symbol_dollar}NAME is not running, just starting ..."
            start_jsvc_exec
        fi
    ;;
    status)
        if [ -f "${symbol_dollar}PID" ]; then # if service is running
            echo "${symbol_dollar}NAME (pid `cat ${symbol_dollar}PID`) is running."
        else
            echo "${symbol_dollar}NAME is stopped."
        fi
    ;;
    *)
        echo "Usage: sudo service ${symbol_dollar}NAME {start|stop|restart|status}" >&2
        exit 3
    ;;
esac
