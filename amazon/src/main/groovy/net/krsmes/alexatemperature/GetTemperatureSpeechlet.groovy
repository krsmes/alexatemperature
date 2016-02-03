package net.krsmes.alexatemperature

import com.amazon.speech.speechlet.IntentRequest
import com.amazon.speech.speechlet.LaunchRequest
import com.amazon.speech.speechlet.Session
import com.amazon.speech.speechlet.SessionEndedRequest
import com.amazon.speech.speechlet.SessionStartedRequest
import com.amazon.speech.speechlet.Speechlet
import com.amazon.speech.speechlet.SpeechletException
import com.amazon.speech.speechlet.SpeechletResponse
import com.amazon.speech.ui.Card
import com.amazon.speech.ui.PlainTextOutputSpeech
import com.amazon.speech.ui.Reprompt
import com.amazon.speech.ui.SimpleCard

class GetTemperatureSpeechlet implements Speechlet {
    private static final SPEECH_ON_LAUNCH = 'Ask me what the temperature is'
    private static final SPEECH_HELP_INTENT = 'You can ask what is the temperature, or how cold is it, or how hot is it'
    private static final SPEECH_GET_TEMPERATURE = 'The temperature is 55 degrees fahrenheit'

    @Override
    void onSessionStarted(SessionStartedRequest request, Session session) throws SpeechletException {
    }

    @Override
    SpeechletResponse onLaunch(LaunchRequest request, Session session) throws SpeechletException {
        askResponse(SPEECH_ON_LAUNCH, new SimpleCard(title: 'GetTemperature'))
    }

    @Override
    SpeechletResponse onIntent(IntentRequest request, Session session) throws SpeechletException {
        switch (request?.intent?.name) {
            case 'GetTemperatureIntent': tellResponse(SPEECH_GET_TEMPERATURE); break
            case 'AMAZON.HelpIntent': askResponse(SPEECH_HELP_INTENT); break
            default: null
        }
    }

    @Override
    void onSessionEnded(SessionEndedRequest request, Session session) throws SpeechletException {
    }

    def askResponse = { speechText, Card card = null ->
        def speech = new PlainTextOutputSpeech(text: speechText)
        card ? SpeechletResponse.newAskResponse(speech, new Reprompt(outputSpeech: speech), card)
            : SpeechletResponse.newAskResponse(speech, new Reprompt(outputSpeech: speech))
    }

    def tellResponse = { speechText, Card card = null ->
        def speech = new PlainTextOutputSpeech(text: speechText)
        card ? SpeechletResponse.newTellResponse(speech, card) : SpeechletResponse.newTellResponse(speech)
    }
}
