/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.dto;

import br.net.gvt.efika.acs.model.device.dhcp.Dhcp;
import model.log.AcaoAcsEnum;

/**
 *
 * @author G0042204
 */
public class DhcpIn extends GetDeviceDataIn {

    private Dhcp dhcp;

    public DhcpIn() {
        this.setAcao(AcaoAcsEnum.SET_DHCP);
    }

    public Dhcp getDhcp() {
        return dhcp;
    }

    public void setDhcp(Dhcp dhcp) {
        this.dhcp = dhcp;
    }

}
