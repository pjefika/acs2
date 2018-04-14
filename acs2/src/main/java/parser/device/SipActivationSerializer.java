/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser.device;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import model.device.sipactivation.SipActivation;

/**
 *
 * @author G0041775
 */
public class SipActivationSerializer extends StdSerializer<SipActivation> {

    public SipActivationSerializer() {
        this(null);
    }

    public SipActivationSerializer(Class<SipActivation> t) {
        super(t);
    }

    @Override
    public void serialize(
            SipActivation value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        jgen.writeStartObject();
        jgen.writeStringField("DirectoryNumber", value.getDirectoryNumber());
        jgen.writeStringField("AuthUserName", value.getAuthUserName());
        jgen.writeStringField("AuthPassword", value.getAuthPassword());
        jgen.writeStringField("ProxyServer", value.getProxyServer());
        jgen.writeStringField("RegistrarServer", value.getRegistrarServer());
        jgen.writeStringField("UserAgentDomain", value.getUserAgentDomain());
        jgen.writeStringField("OutboundProxy", value.getOutboundProxy());
        jgen.writeStringField("phyReferenceList", value.getPhyReferenceList());

        jgen.writeStringField("T38Enable", value.getT38Enabled());
        jgen.writeEndObject();
    }
}
