/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.dto;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;

/**
 *
 * @author G0042204
 */
public class DetailOut {

    private NbiDeviceData device;

    private Boolean online;

    private FirmwareOut firmware;

    public NbiDeviceData getDevice() {
        return device;
    }

    public void setDevice(NbiDeviceData device) {
        this.device = device;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public FirmwareOut getFirmware() {
        return firmware;
    }

    public void setFirmware(FirmwareOut firmware) {
        this.firmware = firmware;
    }

}
