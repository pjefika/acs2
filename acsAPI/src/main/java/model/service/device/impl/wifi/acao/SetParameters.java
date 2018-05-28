/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl.wifi.acao;

import br.net.gvt.efika.acs.model.device.enums.DeviceTR;
import motive.hdm.synchdeviceops.ParameterValueStructDTO;

/**
 *
 * @author G0042204
 */
public class SetParameters {

    public static ParameterValueStructDTO ativarWifi(DeviceTR tr, int wichone) {
        return new AtivarWifi(tr, wichone);
    }

    public static final ParameterValueStructDTO ativarStatusWifi(DeviceTR tr, int wichone) {
        return new AtivarStatusWifi(tr, wichone);
    }

    public static final ParameterValueStructDTO ativarBroadcastWifi(DeviceTR tr, int wichone) {
        return new AtivarBroadcastWifi(tr, wichone);
    }
//    public static final ParameterValueStructDTO DESATIVAR_WIFI = new DesativarWifi();
//    public static final ParameterValueStructDTO DESATIVAR_AUTOCHANNEL = new DesativarAutoChannelWifi();
}
