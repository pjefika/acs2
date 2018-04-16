/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser.device;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import model.device.sipdiagnostics.SipDiagnostics;

/**
 *
 * @author G0041775
 */
public class SipDiagnosticsDeserializer extends StdDeserializer<SipDiagnostics> {

    public SipDiagnosticsDeserializer() {
        this(null);
    }

    public SipDiagnosticsDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public SipDiagnostics deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        SipDiagnostics d = new SipDiagnostics();
        JsonNode node = jp.getCodec().readTree(jp);
        d.setAuthPassword(node.get("values").get("AuthPassword").asText());
        d.setAuthUserName(node.get("values").get("AuthUserName").asText());
        d.setCallState(node.get("values").get("CallState").asText());
        d.setCodec(node.get("values").get("Codec").asText());
        d.setConferenceCallURI(node.get("values").get("ConferenceCallURI").asText());
        d.setDTMFMethod(node.get("values").get("DTMFMethod").asText());
        d.setDigitMap(node.get("values").get("DigitMap").asText());
        d.setDirectoryNumber(node.get("values").get("DirectoryNumber").asText());
        d.setEnable(node.get("entries").get("Enable").get("value").asText());
        d.setLineEnable(node.get("values").get("LineEnable").asText());
        d.setOutboundProxy(node.get("values").get("OutboundProxy").asText());
        d.setPacketsLost(node.get("values").get("PacketsLost").asText());
        d.setProfileEnable(node.get("values").get("ProfileEnable").asText());
        d.setProxyServer(node.get("values").get("ProxyServer").asText());
        d.setProxyServerPort(node.get("values").get("ProxyServerPort").asText());
        d.setRegistrarServer(node.get("values").get("RegistrarServer").asText());
        d.setStatus(node.get("values").get("Status").asText());
        d.setT38Enable(node.get("values").get("T38Enable").asText());
        d.setURI(node.get("values").get("URI").asText());
        d.setUserAgentDomain(node.get("values").get("UserAgentDomain").asText());
        d.setUserAgentPort(node.get("values").get("UserAgentPort").asText());
        d.setIPAddress(node.get("values").get("IPAddress").asText());

        return d;
    }
}
