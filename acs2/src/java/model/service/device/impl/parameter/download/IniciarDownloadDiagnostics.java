/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl.parameter.download;

import motive.hdm.synchdeviceops.ParameterValueStructDTO;

/**
 *
 * @author G0042204
 */
public class IniciarDownloadDiagnostics extends ParameterValueStructDTO {

    public IniciarDownloadDiagnostics() {
        this.name = "InternetGatewayDevice.DownloadDiagnostics.DiagnosticsState";
        this.type = "string";
        this.value = "Requested";
    }
}
