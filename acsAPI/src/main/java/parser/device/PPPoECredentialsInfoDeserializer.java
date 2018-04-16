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
import model.device.pppoe.PPPoECredentialsInfo;

/**
 *
 * @author G0041775
 */
public class PPPoECredentialsInfoDeserializer extends StdDeserializer<PPPoECredentialsInfo> {

    public PPPoECredentialsInfoDeserializer() {
        this(null);
    }

    public PPPoECredentialsInfoDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public PPPoECredentialsInfo deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        PPPoECredentialsInfo d = new PPPoECredentialsInfo();
        JsonNode node = jp.getCodec().readTree(jp);
        d.setUsername(node.get("Username").asText());
        d.setPassword(node.get("Password").asText());

        return d;
    }
}
