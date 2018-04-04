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
public class DhcpSet {

    private String dhcpServerEnable, startAddress, endAddress;

    public DhcpSet(Dhcp d) {
        this.dhcpServerEnable = d.getDHCPServerEnable();
        this.startAddress = d.getMinAddress();
        this.endAddress = d.getMaxAddress();
    }

    public String getDhcpServerEnable() {
        return dhcpServerEnable;
    }

    public void setDhcpServerEnable(String dhcpServerEnable) {
        this.dhcpServerEnable = dhcpServerEnable;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public String getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }

}
