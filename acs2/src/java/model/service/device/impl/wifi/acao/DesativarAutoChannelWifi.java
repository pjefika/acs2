/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl.wifi.acao;

import motive.hdm.synchdeviceops.ParameterValueStructDTO;

/**
 *
 * @author G0042204
 */
public class DesativarAutoChannelWifi extends ParameterValueStructDTO {

    public DesativarAutoChannelWifi() {
        this.name = "InternetGatewayDevice.LANDevice.1.WLANConfiguration.1.AutoChannelEnable";
        this.type = "boolean";
        this.value = "false";
    }
}
