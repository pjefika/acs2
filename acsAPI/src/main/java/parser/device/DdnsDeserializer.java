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
import model.device.ddns.DdnsInfo;

/**
 *
 * @author G0041775
 */
public class DdnsDeserializer extends StdDeserializer<DdnsInfo> {

    public DdnsDeserializer() {
        this(null);
    }

    public DdnsDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public DdnsInfo deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        DdnsInfo d = new DdnsInfo();
        JsonNode node = jp.getCodec().readTree(jp);
        d.setProvider(node.get("Provider").asText());
        d.setEnable(node.get("Enable").asText().equalsIgnoreCase("1"));
        d.setPassword(node.get("Password").asText());
        d.setUser(node.get("User").asText());
        d.setHostname(node.get("Hostname").asText());
        d.setProviderUrl(node.get("ProviderURL").asText());
        

        return d;
    }
}
