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
        handler.supportedApplicationIds.contains('amzn1.echo-sdk-ams.app.[unique-value-here]')
    }
}