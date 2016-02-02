package net.krsmes.alexatemperature

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler

/**
 * This class is the handler for an AWS Lambda function powering an Alexa Skills Kit
 * AWS Lambda handler = "net.krsmes.alexatemperature.GetTemperatureSpeechletHandler"
 */
class GetTemperatureSpeechletHandler extends SpeechletRequestStreamHandler{

    private static final Set<String> supportedApplicationIds = new HashSet<String>();
    static {
        /*
         * this value comes from the 'Application Id' of the Alexa Skill
         * see https://developer.amazon.com/edw/home.html#/skills/list
         * You can start a skill and save it with a fake https endpoint to
         * get this applicationId, and then create the lambda function to
         * get the FunctionArn to put in the Alexa Skill.  Kind of a catch-22
         */
        supportedApplicationIds.add("amzn1.echo-sdk-ams.app.3328806a-3db4-4639-b032-e9e75fd5ed2d");
    }

    public GetTemperatureSpeechletHandler() {
        super(new GetTemperatureSpeechlet(), supportedApplicationIds)
    }

}
