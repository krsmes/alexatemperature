package net.krsmes.alexatemperature

import groovyx.net.http.HTTPBuilder

import static groovyx.net.http.ContentType.*

class GetTemperatureParticle {
    def API = new HTTPBuilder('https://api.particle.io/')
    def device
    def token

    GetTemperatureParticle() {
        def props = new Properties()
        def res = getClass().getClassLoader().getResourceAsStream('private.properties')
        if (res) {
            props.load((InputStream) res)
            device = props['particle.device']
            token = props['particle.access_token']
        }
    }

    Integer getTemperature() {
        API.post(path: "/v1/devices/$device/temperature", body: [access_token: token], requestContentType: URLENC) { resp, json ->
            resp.status == 200 ? json.return_value.toInteger() : null
        }
    }
}
