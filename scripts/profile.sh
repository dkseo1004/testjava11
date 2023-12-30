#!/usr/bin/env bash


function find_idle_profile() {
    RESPONSE_CODE=$(curl -s -o /dev/null -w "%{http_code}" http://15.165.59.117/test)

    if [ ${RESPONSE_CODE} -ge 400 ] # 400보다 크면 (즉, 40x/ 50x 에러 모두 포함)
    then
        CURRENT_PROFILE=set2
    else
        CURRENT_PROFILE=$(curl -s http://15.165.59.117/test)
    fi

    if [ "${CURRENT_PROFILE}" == "set1" ]
    then
        IDLE_PROFILE=set2
    else
        IDLE_PROFILE=set1
    fi

    echo "${IDLE_PROFILE}"
}

# 쉬고있는 profile의 port 찾기
function find_idle_port() {
    IDLE_PROFILE=$(find_idle_profile)

    if [ "${IDLE_PROFILE}" == "set1" ]
    then
        echo "8081"
    else
        echo "8082"
    fi
}