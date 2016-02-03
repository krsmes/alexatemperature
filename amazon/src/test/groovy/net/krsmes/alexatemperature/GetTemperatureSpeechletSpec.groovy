package net.krsmes.alexatemperature

import com.amazon.speech.slu.Intent
import com.amazon.speech.speechlet.IntentRequest
import com.amazon.speech.speechlet.SpeechletResponse
import spock.lang.Specification

class GetTemperatureSpeechletSpec extends Specification {

    def subject = new GetTemperatureSpeechlet()
    def request = null
    def session = null

    def setup() {
        subject.particle = [getTemperature: {-> new Random().nextInt(100)}] as GetTemperatureParticle
    }

    def "onLaunch should return greeting"() {
        given:
        def expectedResponseSpeech = 'Ask me what the temperature is'
        when:
        def response = subject.onLaunch(request, session)
        then:
        response instanceof SpeechletResponse
        response.outputSpeech.text == expectedResponseSpeech
        response.reprompt.outputSpeech.text == expectedResponseSpeech
        response.card.title == 'GetTemperature'
    }

    def "onIntent should return help response on help intent"() {
        given:
        def expectedResponseSpeech = 'You can ask what is the temperature, or how cold is it, or how hot is it'
        request = intentRequest('AMAZON.HelpIntent')
        when:
        def response = subject.onIntent(request, session)
        then:
        response instanceof SpeechletResponse
        response.outputSpeech.text == expectedResponseSpeech
    }

    def "onIntent should return temperature response on get temperature intent"() {
        given:
        def expectedResponseSpeech = /The temperature is \d+ degrees fahrenheit/
        request = intentRequest('GetTemperatureIntent')
        when:
        def response = subject.onIntent(request, session)
        then:
        response instanceof SpeechletResponse
        response.outputSpeech.text ==~ expectedResponseSpeech
    }

    def "getTemperature should return temperature from particle"() {
        given:
        subject.particle = [getTemperature: {-> 99}] as GetTemperatureParticle
        when:
        def result = subject.getTemperature()
        then:
        result == 99;
    }

    def intentRequest = { String name ->
        IntentRequest.builder().withRequestId('requestid').withIntent(
            Intent.builder().withName(name).build()
        ).build()
    }
}
