/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.device;

/**
 *
 * @author G0042204
 */
public class DmzInfo {

    private Boolean Enable;

    private String IPAddress;

    public DmzInfo() {
    }

    public DmzInfo(Boolean Enable, String IPAddress) {
        this.Enable = Enable;
        this.IPAddress = IPAddress;
    }

    public Boolean getEnable() {
        return Enable;
    }

    public void setEnable(Boolean Enable) {
        this.Enable = Enable;
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }

}
