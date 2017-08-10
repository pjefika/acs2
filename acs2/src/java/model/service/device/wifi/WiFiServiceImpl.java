/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.wifi;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import model.device.wifi.WifiInfoFull;
import model.exception.WifiInativoException;
import model.service.device.ServiceAbstract;
import model.service.device.ThreadControl;
import model.service.device.wifi.acao.SetParameters;

/**
 *
 * @author G0042204
 */
public class WiFiServiceImpl extends ServiceAbstract implements WiFiService {

    @Override
    public WifiInfoFull consultar(NbiDeviceData device) throws Exception {
        try {
            return getSynch().getWifiInfoFull(device);
        } catch (WifiInativoException e) {
            ThreadControl.sleep();
            this.ativar(device);
            ThreadControl.sleep();
            return getSynch().getWifiInfoFull(device);
        }
    }

    @Override
    public void ativar(NbiDeviceData device) throws Exception {
        System.out.println("Ativar WiFi...");
        getSynch().setParametersValues(device, SetParameters.ATIVAR_WIFI);
    }

    @Override
    public void desativar(NbiDeviceData device) throws Exception {
        System.out.println("Desativar WiFi...");
        getSynch().setParametersValues(device, SetParameters.DESATIVAR_WIFI);
    }

    @Override
    public WifiInfoFull alterar(NbiDeviceData device, WifiInfoFull wifi) throws Exception {
        getSynch().setWifiInfoFull(device, wifi);
        ThreadControl.sleep();
        return consultar(device);
    }

}
