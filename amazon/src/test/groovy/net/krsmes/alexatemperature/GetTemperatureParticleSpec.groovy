package net.krsmes.alexatemperature

import spock.lang.Specification

class GetTemperatureParticleSpec extends Specification {

    def subject = new GetTemperatureParticle()

    def "getTemperature should return value from invoking particle"() {
        given:
        def params = [:]
        subject.API = [post: { it, closure -> params = it; closure([status: 200], [return_value: 99]) }]
        when:
        def result = subject.getTemperature()
        then:
        result == 99
        params.path == "/v1/devices/PARTICLE_DEVICE_ID/temperature"
        params.body.access_token == subject.token
        params.requestContentType == groovyx.net.http.ContentType.URLENC
    }


}