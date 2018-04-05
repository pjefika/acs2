/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.device.dhcp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import parser.device.DhcpDeserializer;

/**
 *
 * @author G0041775
 */
@JsonDeserialize(using = DhcpDeserializer.class)
public class Dhcp {

    private String MaxAddress, MinAddress;
    private Boolean DHCPServerEnable;

    public Dhcp() {
    }

    public String getMaxAddress() {
        return MaxAddress;
    }

    public void setMaxAddress(String MaxAddress) {
        this.MaxAddress = MaxAddress;
    }

    public String getMinAddress() {
        return MinAddress;
    }

    public void setMinAddress(String MinAddress) {
        this.MinAddress = MinAddress;
    }

    public Boolean getDHCPServerEnable() {
        return DHCPServerEnable;
    }

    public void setDHCPServerEnable(Boolean DHCPServerEnable) {
        this.DHCPServerEnable = DHCPServerEnable;
    }

}
