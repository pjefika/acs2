/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.dto;

import model.device.dhcp.Dhcp;
import model.log.AcaoAcsEnum;

/**
 *
 * @author G0042204
 */
public class DdnsIn extends GetDeviceDataIn {

    private Object ddns;

    public DdnsIn() {
        this.setAcao(AcaoAcsEnum.SET_DDNS);
    }

    public Object getDdns() {
        return ddns;
    }

    public void setDdns(Object ddns) {
        this.ddns = ddns;
    }

}
