#!/usr/bin/env bash

: ${LAMBDA_FUNCTION_NAME="get-temperature"}
: ${LAMBDA_ZIP_FILE="amazon-1.0-SNAPSHOT.zip"}
: ${LAMBDA_HANDLER="net.krsmes.alexatemperature.GetTemperatureSpeechletHandler"}
: ${AWS_IAM_ID="738229398314"}

zipit() {
    gradle buildZip
}

create() {
    zipit
    aws lambda create-function --function-name $LAMBDA_FUNCTION_NAME \
        --zip-file fileb://`pwd`/build/distributions/$LAMBDA_ZIP_FILE \
        --role arn:aws:iam::$AWS_IAM_ID:role/lambda_basic_execution \
        --handler $LAMBDA_HANDLER \
        --runtime java8 --timeout 15 --memory-size 512
}

update() {
    zipit
    aws lambda update-function-code --function-name $LAMBDA_FUNCTION_NAME \
        --zip-file fileb://`pwd`/build/distributions/$LAMBDA_ZIP_FILE
}

$1
