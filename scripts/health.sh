#!/usr/bin/env bash




# Get the absolute path of the script
ABSPATH=$(readlink -f $0)
ABSDIR=$(dirname $ABSPATH)

# Include source scripts
source $ABSDIR/script/profile.sh
source $ABSDIR/script/switch.sh

# Find an idle port
IDLE_PORT=$(find_idle_port)

echo "> Health Check Start!"
echo "> IDLE_PORT: $IDLE_PORT"
echo "> curl -s http://localhost:$IDLE_PORT/profile "
sleep 10

for RETRY_COUNT in {1..10}
do
  RESPONSE=$(curl -s http://localhost:${IDLE_PORT}/profile)
  UP_COUNT=$(echo ${RESPONSE} | grep 'real' | wc -l)

  if [ ${UP_COUNT} -ge 1 ]
  then
    echo "> Health check successful"
    switch_proxy
    break
  else
    echo "> The health check response is unknown or is not running."
    echo "> Health check: ${RESPONSE}"
  fi

  if [ ${RETRY_COUNT} -eq 10 ]
  then
    echo "> Health check failed. "
    echo "> Deployment will end without connecting to Nginx."
    exit 1
  fi

  echo "> Health check connection failed. Retry..."
  sleep 10
done
