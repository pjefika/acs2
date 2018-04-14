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
import model.device.xdsldiagnostics.XdslDiagnostics;

/**
 *
 * @author G0041775
 */
public class XdslDiagnosticsDeserializer extends StdDeserializer<XdslDiagnostics> {

    public XdslDiagnosticsDeserializer() {
        this(null);
    }

    public XdslDiagnosticsDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public XdslDiagnostics deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        XdslDiagnostics d = new XdslDiagnostics();
        JsonNode node = jp.getCodec().readTree(jp);
        d.setModulationType(node.get("ModulationType").asText());
        d.setShowtimeStart(node.get("ShowtimeStart").asText());
        d.setUpstreamMaxRate(node.get("UpstreamMaxRate").asText());
        d.setUpstreamCurrRate(node.get("UpstreamCurrRate").asText());
        d.setUpstreamPower(node.get("UpstreamPower").asText());
        d.setUpstreamNoiseMargin(node.get("UpstreamNoiseMargin").asText());
        d.setUpstreamAttenuation(node.get("UpstreamAttenuation").asText());
        d.setDownstreamMaxRate(node.get("DownstreamMaxRate").asText());
        d.setDownstreamCurrRate(node.get("DownstreamCurrRate").asText());
        d.setDownstreamPower(node.get("DownstreamPower").asText());
        d.setDownstreamNoiseMargin(node.get("DownstreamNoiseMargin").asText());
        d.setDownstreamAttenuation(node.get("DownstreamAttenuation").asText());
        d.setLinkRetrain(node.get("LinkRetrain").asText());
        d.setLossOfFraming(node.get("LossOfFraming").asText());
        d.setSeverelyErroredSecs(node.get("SeverelyErroredSecs").asText());
        d.setATUCFECErrors(node.get("ATUCFECErrors").asText());
        d.setATUCHECErrors(node.get("ATUCHECErrors").asText());
        d.setATUCCRCErrors(node.get("ATUCCRCErrors").asText());
        d.setFECErrors(node.get("FECErrors").asText());
        d.setHECErrors(node.get("HECErrors").asText());
        d.setCRCErrors(node.get("CRCErrors").asText());
        

        return d;
    }
}
