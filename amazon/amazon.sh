#!/usr/bin/env bash

: ${LAMBDA_FUNCTION_NAME="get-temperature"}
: ${LAMBDA_ZIP_FILE="amazon-1.0-SNAPSHOT.zip"}
: ${LAMBDA_HANDLER="net.krsmes.alexatemperature.GetTemperatureSpeechletHandler"}
: ${AWS_IAM_ID="738229398314"}

zipit() {
    gradle buildZip
}

# note: to use aws cli it must be configured with an ID and key
# create one from the aws iam console https://console.aws.amazon.com/iam/home?region=us-east-1#users
# by adding a user, when you add the user get the ID and key and run 'aws configure'
# it will ask for an 'access key id' and a 'secret access key' as well as a default region (us-east-1)

create() {
    zipit
    aws lambda create-function --function-name $LAMBDA_FUNCTION_NAME \
        --zip-file fileb://`pwd`/build/distributions/$LAMBDA_ZIP_FILE \
        --role arn:aws:iam::$AWS_IAM_ID:role/lambda_basic_execution \
        --handler $LAMBDA_HANDLER \
        --runtime java8 --timeout 15 --memory-size 512

    # after creating and event source must be added to and set to "Alexa Skills Kit"
    # there is probably a aws cli way of doing this
    # https://console.aws.amazon.com/lambda/home?region=us-east-1#/functions/get-temperature?tab=eventSources
}

update() {
    zipit
    aws lambda update-function-code --function-name $LAMBDA_FUNCTION_NAME \
        --zip-file fileb://`pwd`/build/distributions/$LAMBDA_ZIP_FILE
}

get() {
    # use this to get the FunctionArn which is needed by the Alexa Skill
    # https://developer.amazon.com/edw/home.html#/skills/list

    aws lambda get-function --function-name $LAMBDA_FUNCTION_NAME
}

$1
