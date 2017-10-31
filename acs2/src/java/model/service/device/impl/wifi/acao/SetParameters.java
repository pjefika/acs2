/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl.wifi.acao;

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
}
