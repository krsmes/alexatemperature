package net.krsmes.alexatemperature

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler

/**
 * This class is the handler for an AWS Lambda function powering an Alexa Skills Kit
 * AWS Lambda handler = "net.krsmes.alexatemperature.GetTemperatureSpeechletHandler"
 */
class GetTemperatureSpeechletHandler extends SpeechletRequestStreamHandler{

    private static final Set<String> supportedApplicationIds = new HashSet<String>();
    static {
        supportedApplicationIds.add("amzn1.echo-sdk-ams.app.[unique-value-here]");
    }

    public GetTemperatureSpeechletHandler() {
        super(new GetTemperatureSpeechlet(), supportedApplicationIds)
    }

}
