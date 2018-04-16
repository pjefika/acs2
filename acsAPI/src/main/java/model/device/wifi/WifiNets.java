/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.device.wifi;

import java.util.List;

/**
 *
 * @author G0041775
 */
public class WifiNets {

    private List<WifiInfoFull> wifi;

    public WifiNets() {
    }

    public WifiNets(List<WifiInfoFull> wifi) {
        this.wifi = wifi;
    }

    public List<WifiInfoFull> getWifi() {
        return wifi;
    }

    public void setWifi(List<WifiInfoFull> wifi) {
        this.wifi = wifi;
    }

}
