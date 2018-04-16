/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.device.firmware;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import parser.device.FirmwareInfoDeserializer;

/**
 *
 * @author G0042204
 */
@JsonDeserialize(using = FirmwareInfoDeserializer.class)
public class FirmwareInfo {

    private String firmwareVersion;

    private String preferredVersion;

    public FirmwareInfo() {
    }

    public FirmwareInfo(String firmwareVersion, String preferredVersion) {
        this.firmwareVersion = firmwareVersion;
        this.preferredVersion = preferredVersion;
    }

    /**
     * Validação de Firmware Equipamentos sem Firmware Cadastrados devem ser
     * considerados atualizados;
     *
     * @return
     */
    public Boolean isOk() {
        /**
         * Sem firmware preferencials
         */
        if (this.preferredVersion.isEmpty()) {
            return true;
        }
        /**
         * Tratativa Gambiarra devido a falha de arquitetura MOTIVE
         */
        return firmwareVersion.concat("-preferred").equalsIgnoreCase(preferredVersion);
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
