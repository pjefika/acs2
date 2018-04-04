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
import model.device.firmware.FirmwareInfo;

/**
 *
 * @author G0041775
 */
public class FirmwareInfoDeserializer extends StdDeserializer<FirmwareInfo> {

    public FirmwareInfoDeserializer() {
        this(null);
    }

    public FirmwareInfoDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public FirmwareInfo deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        
        JsonNode node = jp.getCodec().readTree(jp);
        String firmwareVersion = node.get("firmwareVersion").asText();
        String preferredVersion = node.get("preferredVersion").asText();
        
        return new FirmwareInfo(firmwareVersion, preferredVersion);
    }
}
