/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl.parameter;

import model.service.device.impl.parameter.download.DownloadURL;
import model.service.device.impl.parameter.download.IniciarDownloadDiagnostics;
import model.service.device.impl.parameter.wifi.acao.AtivarStatusWifi;
import model.service.device.impl.parameter.wifi.acao.AtivarWifi;
import model.service.device.impl.parameter.wifi.acao.DesativarAutoChannelWifi;
import model.service.device.impl.parameter.wifi.acao.DesativarWifi;
import motive.hdm.synchdeviceops.ParameterValueStructDTO;

/**
 *
 * @author G0042204
 */
public class SetParameters {

    public static final ParameterValueStructDTO ATIVAR_WIFI = new AtivarWifi();
    public static final ParameterValueStructDTO ATIVAR_STATUS_WIFI = new AtivarStatusWifi();
    public static final ParameterValueStructDTO DESATIVAR_WIFI = new DesativarWifi();
    public static final ParameterValueStructDTO DESATIVAR_AUTOCHANNEL = new DesativarAutoChannelWifi();
    public static final ParameterValueStructDTO DOWNLOAD_URL = new DownloadURL();
    public static final ParameterValueStructDTO INICIAR_DOWNLOAD_DIAGNOSTICS = new IniciarDownloadDiagnostics();

}
