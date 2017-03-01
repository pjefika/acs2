/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.device.firmware;

/**
 *
 * @author G0042204
 */
public class FirmwareInfo {

    private String firmwareVersion;

    private String preferredVersion;

    public FirmwareInfo(String firmwareVersion, String preferredVersion) {
        this.firmwareVersion = firmwareVersion;
        this.preferredVersion = preferredVersion;
    }

    public Boolean isOk() {
        return firmwareVersion.equalsIgnoreCase(preferredVersion);
    }

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    public String getPreferredVersion() {
        return preferredVersion;
    }

    public void setPreferredVersion(String preferredVersion) {
        this.preferredVersion = preferredVersion;
    }

}
