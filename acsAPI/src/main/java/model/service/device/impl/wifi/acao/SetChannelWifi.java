/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl.wifi.acao;

import br.net.gvt.efika.acs.model.device.enums.DeviceTR;
import motive.hdm.synchdeviceops.ParameterValueStructDTO;

/**
 *
 * @author G0042204
 */
public class SetChannelWifi extends ParameterValueStructDTO {

    public SetChannelWifi(DeviceTR deviceTr, String value, int wichone) {
        this.name = deviceTr == DeviceTR.TR_181
                ? "Device.WiFi.Radio." + wichone + ".Channel"
                : "InternetGatewayDevice.LANDevice.1.WLANConfiguration." + wichone + ".Channel";
        this.type = "unsignedInt";
        this.value = value;
    }
}
