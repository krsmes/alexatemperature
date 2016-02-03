package net.krsmes.alexatemperature

import com.amazon.speech.speechlet.SpeechletResponse
import spock.lang.Specification

class GetTemperatureSpeechletSpec extends Specification {

    def "onLaunch should return greeting"() {
        given:
        def expectedResponseSpeech = 'Ask me what the temperature is'
        def subject = new GetTemperatureSpeechlet()
        def request = null
        def session = null
        when:
        def response = subject.onLaunch(request, session)
        then:
        response instanceof SpeechletResponse
        response.outputSpeech.text == expectedResponseSpeech
        response.reprompt.outputSpeech.text == expectedResponseSpeech
        response.card.title == 'GetTemperature'
    }

}
