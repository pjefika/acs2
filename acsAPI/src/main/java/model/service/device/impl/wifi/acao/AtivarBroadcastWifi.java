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
public class AtivarBroadcastWifi extends ParameterValueStructDTO {

    public AtivarBroadcastWifi(DeviceTR deviceTr, int wichone) {
        this.name = deviceTr == DeviceTR.TR_181
                ? "Device.WiFi.AccessPoint." + wichone + ".SSIDAdvertisementEnabled"
                : "InternetGatewayDevice.LANDevice.1.WLANConfiguration." + wichone + ".SSIDAdvertisementEnabled";
        this.type = "boolean";
        this.value = "true";
    }
}
