#!/bin/bash

ROOT_PATH="/home/ubuntu/cicd"
JAR="$ROOT_PATH/application.jar"

APP_LOG="$ROOT_PATH/application.log"
ERROR_LOG="$ROOT_PATH/error.log"
START_LOG="$ROOT_PATH/start.log"

NOW=$(date +%c)

echo "[$NOW] $JAR 복사" >> $START_LOG
cp $ROOT_PATH/build/libs/*.jar $JAR

echo "[$NOW] > $JAR 실행" >> $START_LOG
nohup java -jar $JAR > $APP_LOG 2> $ERROR_LOG &

SERVICE_PID=$(pgrep -f $JAR)
echo "[$NOW] > 서비스 PID: $SERVICE_PID" >> $START_LOG

echo "> $JAR 를 profile=$IDLE_PROFILE 로 실행합니다."
nohup java -jar \
  -Dspring.profiles.active=$IDLE_PROFILE \
  $JAR > $REPOSITORY/nohup.out 2>&1 &

