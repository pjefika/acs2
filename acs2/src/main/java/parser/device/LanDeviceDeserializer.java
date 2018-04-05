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
import model.device.lanhost.LanDevice;

/**
 *
 * @author G0041775
 */
public class LanDeviceDeserializer extends StdDeserializer<LanDevice> {

    public LanDeviceDeserializer() {
        this(null);
    }

    public LanDeviceDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public LanDevice deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        LanDevice l = new LanDevice();
        JsonNode node = jp.getCodec().readTree(jp);
        l.setIpAddress(node.get("IPAddress").asText());
        l.setAddressSource(node.get("AddressSource").asText());
        l.setLeaseTimeRemaining(node.get("LeaseTimeRemaining").asText());
        l.setMacAddress(node.get("MACAddress").asText());
        l.setHostName(node.get("HostName").asText());
        l.setInterfaceType(node.get("InterfaceType").asText());
        l.setAtivo(node.get("Active").asText().equalsIgnoreCase("1"));

        return l;
    }
}
