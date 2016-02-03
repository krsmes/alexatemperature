package net.krsmes.alexatemperature

import com.amazon.speech.speechlet.IntentRequest
import com.amazon.speech.speechlet.LaunchRequest
import com.amazon.speech.speechlet.Session
import com.amazon.speech.speechlet.SessionEndedRequest
import com.amazon.speech.speechlet.SessionStartedRequest
import com.amazon.speech.speechlet.Speechlet
import com.amazon.speech.speechlet.SpeechletException
import com.amazon.speech.speechlet.SpeechletResponse
import com.amazon.speech.ui.PlainTextOutputSpeech
import com.amazon.speech.ui.Reprompt
import com.amazon.speech.ui.SimpleCard

class GetTemperatureSpeechlet implements Speechlet {
    @Override
    void onSessionStarted(SessionStartedRequest request, Session session) throws SpeechletException {
    }

    @Override
    SpeechletResponse onLaunch(LaunchRequest request, Session session) throws SpeechletException {
        return greeting()
    }

    @Override
    SpeechletResponse onIntent(IntentRequest request, Session session) throws SpeechletException {
        return null
    }

    @Override
    void onSessionEnded(SessionEndedRequest request, Session session) throws SpeechletException {
    }

    def greeting = {->
        def speech = new PlainTextOutputSpeech(text: 'Ask me what the temperature is')
        SpeechletResponse.newAskResponse(
            speech,
            new Reprompt(outputSpeech: speech),
            new SimpleCard(title: 'GetTemperature')
        )
    }
}
