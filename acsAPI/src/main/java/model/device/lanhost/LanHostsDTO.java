/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.device.lanhost;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author G0042204
 */
public class LanHostsDTO {

    private List<LanDevice> devices;

    private String HostNumberOfEntries;

    public LanHostsDTO() {
        devices = new ArrayList<>();
    }

    public List<LanDevice> getDevices() {
        return devices;
    }

    public void setDevices(List<LanDevice> devices) {
        this.devices = devices;
    }

    public String getHostNumberOfEntries() {
        return HostNumberOfEntries;
    }

    public void setHostNumberOfEntries(String hostNumberOfEntries) {
        this.HostNumberOfEntries = hostNumberOfEntries;
    }

}
