/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl.wifi;

import br.net.gvt.efika.acs.model.device.wifi.WifiInfoFull;
import br.net.gvt.efika.acs.model.device.wifi.WifiNets;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import java.util.ArrayList;
import java.util.List;
import br.net.gvt.efika.acs.model.exception.WifiInativoException;
import model.service.device.GenericDeviceService;
import model.service.device.ThreadControl;
import model.service.device.impl.wifi.acao.SetParameters;
import motive.hdm.synchdeviceops.ParameterValueStructDTO;

/**
 *
 * @author G0042204
 */
public class WiFiServiceImpl extends GenericDeviceService implements WiFiService {

    /**
     * Consulta configuração WiFi e ativa caso inativa.
     *
     * @param device
     * @return
     * @throws Exception
     */
    @Override
    public WifiNets consultar(NbiDeviceData device) throws Exception {
        try {
            return new WifiNets(synch().getWifiInfoFull(device));
        } catch (WifiInativoException e) {
            ThreadControl.sleep();
            this.ativar(device);
            ThreadControl.sleep();
            return new WifiNets(synch().getWifiInfoFull(device));
        }
    }

    @Override
    public void ativar(NbiDeviceData device) throws Exception {
        System.out.println("Ativar WiFi...");
        List<ParameterValueStructDTO> lst = new ArrayList<>();
        lst.add(SetParameters.ATIVAR_WIFI);
        lst.add(SetParameters.ATIVAR_STATUS_WIFI);
        synch().setParametersValues(device, lst);
    }

    @Override
    public void desativar(NbiDeviceData device) throws Exception {
        System.out.println("Desativar WiFi...");

        List<ParameterValueStructDTO> lst = new ArrayList<>();
        lst.add(SetParameters.DESATIVAR_WIFI);
        synch().setParametersValues(device, lst);
    }

    @Override
    public WifiNets alterar(NbiDeviceData device, WifiNets wifis) throws Exception {
        List<ParameterValueStructDTO> lst = new ArrayList<>();
        WifiInfoFull wifi = wifis.getWifi().get(0);
        lst.add(SetParameters.DESATIVAR_AUTOCHANNEL);
        lst.add(SetParameters.ATIVAR_WIFI);
        synch().setParametersValues(device, lst);
        ThreadControl.sleep();
        synch().setWifiInfoFull(device, wifi);
        ThreadControl.sleep();
        return consultar(device);
    }

}
