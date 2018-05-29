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
public class SetPasswordWifi extends ParameterValueStructDTO {

    public SetPasswordWifi(DeviceTR deviceTr, String value, int wichone) {
        this.name = deviceTr == DeviceTR.TR_181
                ? "Device.WiFi.AccessPoint." + wichone + ".Security.KeyPassphrase"
                : "InternetGatewayDevice.LANDevice.1.WLANConfiguration." + wichone + ".KeyPassphrase";
        this.type = "string";
        this.value = value;
    }
}
