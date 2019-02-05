/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl.lan.acao;

import motive.hdm.synchdeviceops.ParameterValueStructDTO;

/**
 *
 * @author G0041775
 */
public class IPV6Auto extends ParameterValueStructDTO {

    public IPV6Auto(Boolean active) {
        this.name = "InternetGatewayDevice.LANDevice.1.X_TELEFONICA-ES_IPv6LANHostConfigManagement.AutoConfigurationAddress";
        this.type = "boolean";
        this.value = active.toString();
    }

}
