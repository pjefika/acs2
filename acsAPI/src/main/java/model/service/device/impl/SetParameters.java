/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl;

import br.net.gvt.efika.acs.model.device.enums.DeviceTR;
import model.service.device.impl.lan.acao.IPV6Auto;
import model.service.device.impl.sip.acao.SetT38Enabled;
import model.service.device.impl.wifi.acao.AtivarBroadcastWifi;
import model.service.device.impl.wifi.acao.AtivarStatusWifi;
import model.service.device.impl.wifi.acao.AtivarWifi;
import model.service.device.impl.wifi.acao.SetAdmStatusWifi;
import model.service.device.impl.wifi.acao.SetChannelWifi;
import model.service.device.impl.wifi.acao.SetPasswordWifi;
import model.service.device.impl.wifi.acao.SetSsidWifi;
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

    public static final ParameterValueStructDTO setAdmStatusWifi(DeviceTR tr, String value, int wichone) {
        return new SetAdmStatusWifi(tr, value, wichone);
    }

    public static final ParameterValueStructDTO setSsidWifi(DeviceTR tr, String value, int wichone) {
        return new SetSsidWifi(tr, value, wichone);
    }

    public static final ParameterValueStructDTO setChannelWifi(DeviceTR tr, String value, int wichone) {
        return new SetChannelWifi(tr, value, wichone);
    }

    public static final ParameterValueStructDTO setPasswordWifi(DeviceTR tr, String value, int wichone) {
        return new SetPasswordWifi(tr, value, wichone);
    }

    public static final ParameterValueStructDTO setT38Enabled(DeviceTR tr, String value, int wichone) {
        return new SetT38Enabled(tr, value, wichone);
    }

    public static final ParameterValueStructDTO setIPv6Auto(Boolean active) {
        return new IPV6Auto(active);
    }
//    public static final ParameterValueStructDTO DESATIVAR_WIFI = new DesativarWifi();
//    public static final ParameterValueStructDTO DESATIVAR_AUTOCHANNEL = new DesativarAutoChannelWifi();
}
