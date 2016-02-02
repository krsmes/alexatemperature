package net.krsmes.alexatemperature

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler
import spock.lang.Specification

class GetTemperatureSpeechletHandlerSpec extends Specification {

    def handler = new GetTemperatureSpeechletHandler()

    def "handler should implement SpeechletRequestStreamHandler"() {
        expect:
        handler instanceof SpeechletRequestStreamHandler
    }

    def "handler should have proper application id"() {
        expect:
        handler.supportedApplicationIds.contains('amzn1.echo-sdk-ams.app.3328806a-3db4-4639-b032-e9e75fd5ed2d')
    }
}