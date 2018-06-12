/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl.sip.acao;

import br.net.gvt.efika.acs.model.device.enums.DeviceTR;
import motive.hdm.synchdeviceops.ParameterValueStructDTO;

/**
 *
 * @author G0042204
 */
public class SetT38Enabled extends ParameterValueStructDTO {

    public SetT38Enabled(DeviceTR deviceTr, String value, int wichone) {
        this.name = deviceTr == DeviceTR.TR_181
                ? "Device.Services.VoiceService." + wichone + ".VoiceProfile.1.FaxT38.Enable"
                : "InternetGatewayDevice.Services.VoiceService." + wichone + ".VoiceProfile.1.FaxT38.Enable";
        this.type = "boolean";
        this.value = value;
    }
}
