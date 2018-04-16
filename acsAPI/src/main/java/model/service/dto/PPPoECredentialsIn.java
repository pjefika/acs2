/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.dto;

import model.device.pppoe.PPPoECredentialsInfo;
import model.log.AcaoAcsEnum;

/**
 *
 * @author G0042204
 */
public class PPPoECredentialsIn extends GetDeviceDataIn {

    private PPPoECredentialsInfo credentials;

    public PPPoECredentialsIn() {
        this.setAcao(AcaoAcsEnum.SET_PPPOE_CREDENTIALS);
    }

    public PPPoECredentialsInfo getCredentials() {
        return credentials;
    }

    public void setCredentials(PPPoECredentialsInfo credentials) {
        this.credentials = credentials;
    }

}
