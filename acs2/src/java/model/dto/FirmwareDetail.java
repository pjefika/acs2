/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;

import model.device.firmware.FirmwareInfo;

/**
 *
 * @author G0042204
 */
public class FirmwareDetail {

    private final FirmwareInfo info;
    private Boolean updated;

    public FirmwareDetail(FirmwareInfo info) {
        this.info = info;
    }

    public FirmwareInfo getInfo() {
        return info;
    }

    public Boolean getUpdated() {
        if (info == null) {
            return true;
        }
        return info.isOk();
    }

}
