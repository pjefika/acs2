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
import model.device.info.DeviceInfo;

/**
 *
 * @author G0041775
 */
public class DeviceInfoDeserializer extends StdDeserializer<DeviceInfo> {

    public DeviceInfoDeserializer() {
        this(null);
    }

    public DeviceInfoDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public DeviceInfo deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        DeviceInfo d = new DeviceInfo();
        JsonNode node = jp.getCodec().readTree(jp);
        d.setFwer(node.get("fwer").asText());
        d.setHwer(node.get("hwer").asText());
        d.setManufacid(node.get("manufacid").asText());
        d.setPreferv(node.get("preferv").asText());
        d.setProdclass(node.get("prodclass").asText());
        d.setSn(node.get("sn").asText());
        
        

        return d;
    }
}
