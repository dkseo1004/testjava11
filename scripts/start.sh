#!/usr/bin/env bash

ABSPATH=$(readlink -f $0)
ABSDIR=$(dirname $ABSPATH)
source ${ABSDIR}/profile.sh   # profile.sh 임포트

REPOSITORY=/home/ubuntu/app

echo "> Build 파일 복사"
echo "> cp $REPOSITORY/build/libs/*.jar $REPOSITORY/"

cp $REPOSITORY/build/libs/*.jar $REPOSITORY/

echo "> 새 어플리케이션 배포"
JAR_NAME=$(ls -tr $REPOSITORY/*.jar | tail -n 1)    # jar 이름 가져오기

echo "> JAR Name: $JAR_NAME"

echo "> $JAR_NAME 에 실행권한 추가"

chmod +x $JAR_NAME

echo "> $JAR_NAME 실행"

IDLE_PROFILE=$(source ${ABSDIR}/find_idle_profile.sh)  # find_idle_profile.sh를 통해 profile 찾기

echo "> $JAR_NAME 를 profile=$IDLE_PROFILE 로 실행합니다."
echo "> $IDLE_PROFILE 로 실행합니다."
nohup java -jar -Dspring.profiles.active=$IDLE_PROFILE $JAR_NAME > $REPOSITORY/nohup.out 2>&1 &
