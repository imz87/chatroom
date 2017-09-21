#!/bin/bash

function terminate()
{
    if [ "{$pid}x" != "x" ]
    then
        kill $pid 2>/dev/null
        exit 0
    fi
}

# Do the cleanup when one of SIGHUP, SIGINT, SIGTERM signals is received trap terminate SIGHUP SIGINT SIGTERM

MAIN_CLASS=ir.izolfaghari.chatroom.Startup
MEM_MIN=64m
MEM_MAX=128m

JAVA_OPTS="-server -Xms$MEM_MIN -Xmx$MEM_MAX -XX:+UseParallelGC -XX:+AggressiveOpts -XX:+UseFastAccessorMethods"
JAVA_OPTS="$JAVA_OPTS -verbose:gc -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=logs"
JAVA_OPTS="$JAVA_OPTS -Xloggc:./logs/gc.log"

JMX_OPTS="-Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=8082"
JMX_OPTS="$JMX_OPTS -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false"
JMX_OPTS="$JMX_OPTS -Dcom.sun.management.jmxremote.local.only=false -Djava.rmi.server.hostname=localhost"
JMX_OPTS="$JMX_OPTS -Dcom.sun.management.jmxremote.rmi.port=8083"


JAVA_OPTS="$JAVA_OPTS -Dlogging.config=config/log4j2.xml -Dspring.config.location=config/application.properties"

CP=./:./chatroom.jar
LIB="./lib"

for a in $LIB/*.jar; do
    CP=$CP:$a
done

echo JMX_OPTS is : $JMX_OPTS
echo ClassPath is : $CP

export CLASSPATH=$CP
export LC_ALL='fa_IR.utf8'
java $JAVA_OPTS $OPTS $JMX_OPTS $MAIN_CLASS &

# Grab the pid
pid=$!

echo "Process went to the background  with {$pid} pid."

# Wait fo the process
wait $pid

