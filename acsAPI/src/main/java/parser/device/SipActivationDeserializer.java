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
import model.device.sipactivation.SipActivation;

/**
 *
 * @author G0041775
 */
public class SipActivationDeserializer extends StdDeserializer<SipActivation> {

    public SipActivationDeserializer() {
        this(null);
    }

    public SipActivationDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public SipActivation deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        SipActivation d = new SipActivation();
        JsonNode node = jp.getCodec().readTree(jp);
        d.setAuthPassword(node.get("authPassword").asText());
        d.setAuthUserName(node.get("authUserName").asText());
        d.setDirectoryNumber(node.get("directoryNumber").asText());
        d.setOutboundProxy(node.get("outboundProxy").asText());
        d.setPhyReferenceList(node.get("phyReferenceList").asText());
        d.setProxyServer(node.get("proxyServer").asText());
        d.setRegistrarServer(node.get("registrarServer").asText());
        d.setT38Enabled(node.get("t38Enable").asText());
        d.setUserAgentDomain(node.get("userAgentDomain").asText());
        

        return d;
    }
}
