#!/bin/bash
SCRIPT_DIR=`dirname $BASH_SOURCE`;
SCRIPT_DIR=`readlink -m $SCRIPT_DIR`;
echo "$SCRIPT_DIR/version.sh"; exit 1;
WORKING_DIR=`pwd`;
source "$SCRIPT_DIR/version.sh";
source "$SCRIPT_DIR/config.sh";

if [ -d "$SCRIPT_DIR/richfaces-simpleapp" ]; then
    rm -rf "$SCRIPT_DIR/richfaces-simpleapp";
fi

cd $SCRIPT_DIR;
${MAVEN} ${MAVEN_ARGS} archetype:generate -Dbasedir=${SCRIPT_DIR} -DarchetypeGroupId=org.richfaces.archetypes -DarchetypeArtifactId=richfaces-archetype-simpleapp -DarchetypeVersion=${RICHFACES_VERSION} -DgroupId=org.richfaces.tests.archetypes -DartifactId=richfaces-simpleapp -Dversion=${RICHFACES_VERSION} -Dpackage=org.richfaces.tests.archetypes.simpleapp -DinteractiveMode=false $@;
${MAVEN} ${MAVEN_ARGS} -f $SCRIPT_DIR/richfaces-simpleapp/pom.xml clean package -Prelease;
cd $WORKING_DIR;
