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
import model.device.dhcp.Dhcp;

/**
 *
 * @author G0041775
 */
public class DhcpDeserializer extends StdDeserializer<Dhcp> {

    public DhcpDeserializer() {
        this(null);
    }

    public DhcpDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Dhcp deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        Dhcp d = new Dhcp();
        JsonNode node = jp.getCodec().readTree(jp);
        d.setDHCPServerEnable(node.get("DHCPServerEnable").asText().equalsIgnoreCase("1"));
        d.setMinAddress(node.get("MinAddress").asText());
        d.setMaxAddress(node.get("MaxAddress").asText());

        return d;
    }
}
