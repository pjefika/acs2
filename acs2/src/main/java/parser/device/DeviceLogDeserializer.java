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
import model.device.log.DeviceLog;

/**
 *
 * @author G0041775
 */
public class DeviceLogDeserializer extends StdDeserializer<DeviceLog> {

    public DeviceLogDeserializer() {
        this(null);
    }

    public DeviceLogDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public DeviceLog deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        DeviceLog d = new DeviceLog();
        JsonNode node = jp.getCodec().readTree(jp);
        d.setMensagem(node.get("DeviceLog").asText());

        return d;
    }
}
