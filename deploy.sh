#!/bin/bash
# Warning: this script has only been tested on macOS Sierra. There's a good chance
# it won't work on other operating systems. If you get it working on another OS,
# please send a pull request with any changes required. Thanks!
set -e

### CloudFoundry CLI utilities
CLOUD_DOMAIN=${DOMAIN:-run.pivotal.io}
CLOUD_TARGET=api.${DOMAIN}

function login(){
    cf api | grep ${CLOUD_TARGET} || cf api ${CLOUD_TARGET} --skip-ssl-validation
    cf apps | grep OK || cf login
}

function app_domain(){
    D=`cf apps | grep $1 | tr -s ' ' | cut -d' ' -f 6 | cut -d, -f1`
    echo $D
}

function deploy_service(){
    N=$1
    D=`app_domain $N`
    JSON='{"uri":"http://'$D'"}'
    cf create-user-provided-service $N -p $JSON
}

### Installation

cd `dirname $0`
r=`pwd`
echo $r

## Reset
cf d -f ionic-server

cf a

# Stormpath
stormpathApiKeyId=`cat ~/.stormpath/apiKey.properties | grep apiKey.id | cut -f3 -d\ `
stormpathApiKeySecret=`cat ~/.stormpath/apiKey.properties | grep apiKey.secret | cut -f3 -d\ `

# Deploy the server
cd $r/server
mvn clean package
cf push -p target/*jar ionic-server --no-start  --random-route
cf set-env ionic-server STORMPATH_API_KEY_ID $stormpathApiKeyId
cf set-env ionic-server STORMPATH_API_KEY_SECRET $stormpathApiKeySecret
cf set-env ionic-server FORCE_HTTPS true
cf start ionic-server

# Get the URL for the server
serverUri=https://`app_domain ionic-server`

# Deploy the client
cd $r/client
npm run clean
# replace the server URL in the client
sed -i -e "s|http://localhost:8080|$serverUri|g" src/app/app.module.ts
npm install && ionic build ios

# deploy client to phone
ionic run ios

# cleanup changed files
git checkout $r/client
rm $r/client/src/app/app.module.ts-e