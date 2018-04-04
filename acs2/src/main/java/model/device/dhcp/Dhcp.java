/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.device.dhcp;

/**
 *
 * @author G0041775
 */
public class Dhcp {
    
    private String MaxAddress, MinAddress,DHCPServerEnable;

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

    public String getDHCPServerEnable() {
        return DHCPServerEnable;
    }

    public void setDHCPServerEnable(String DHCPServerEnable) {
        this.DHCPServerEnable = DHCPServerEnable;
    }
    
    
}
