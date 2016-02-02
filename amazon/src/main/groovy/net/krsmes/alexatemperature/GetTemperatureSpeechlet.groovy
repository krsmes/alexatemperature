package net.krsmes.alexatemperature

import com.amazon.speech.speechlet.IntentRequest
import com.amazon.speech.speechlet.LaunchRequest
import com.amazon.speech.speechlet.Session
import com.amazon.speech.speechlet.SessionEndedRequest
import com.amazon.speech.speechlet.SessionStartedRequest
import com.amazon.speech.speechlet.Speechlet
import com.amazon.speech.speechlet.SpeechletException
import com.amazon.speech.speechlet.SpeechletResponse

class GetTemperatureSpeechlet implements Speechlet {
    @Override
    void onSessionStarted(SessionStartedRequest request, Session session) throws SpeechletException {

    }

    @Override
    SpeechletResponse onLaunch(LaunchRequest request, Session session) throws SpeechletException {
        return null
    }

    @Override
    SpeechletResponse onIntent(IntentRequest request, Session session) throws SpeechletException {
        return null
    }

    @Override
    void onSessionEnded(SessionEndedRequest request, Session session) throws SpeechletException {

    }
}
