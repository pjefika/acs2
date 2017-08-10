/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.dto;

import model.device.wifi.WifiInfoFull;
import model.log.AcaoAcsEnum;

/**
 *
 * @author G0042204
 */
public class SetWifiIn extends GetDeviceDataIn {

    private WifiInfoFull wifi;

    public SetWifiIn() {
        this.setAcao(AcaoAcsEnum.SET_WIFI_INFO);
    }

    public WifiInfoFull getWifi() {
        return wifi;
    }

    public void setWifi(WifiInfoFull wifi) {
        this.wifi = wifi;
    }

}
