/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.dto;

import model.device.firmware.FirmwareInfo;

/**
 *
 * @author G0042204
 */
public class FirmwareOut {

    private FirmwareInfo info;

    public FirmwareOut() {
    }

    public FirmwareOut(FirmwareInfo info) {
        this.info = info;
    }

    public FirmwareInfo getInfo() {
        return info;
    }

    public Boolean getUpdated() {
        if (info != null) {
            return info.isOk();
        } else {
            return true;
        }
    }

}
