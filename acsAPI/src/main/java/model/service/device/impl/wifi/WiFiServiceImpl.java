/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl.wifi;

import br.net.gvt.efika.acs.model.device.enums.DeviceTR;
import br.net.gvt.efika.acs.model.device.wifi.WifiInfoFull;
import br.net.gvt.efika.acs.model.device.wifi.WifiNets;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import java.util.ArrayList;
import java.util.List;
import model.service.device.GenericDeviceService;
import model.service.device.ThreadControl;
import model.service.device.impl.wifi.acao.SetParameters;
import motive.hdm.synchdeviceops.GetParameterValuesResponseDTO;
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

        List<String> paths = new ArrayList<>();
        try {
            paths.add("InternetGatewayDevice.LANDevice.1.WLANConfiguration.");
            GetParameterValuesResponseDTO wifis = synch().getParametersValues(device, paths);
            return new WifiNets(WifiParser.parse(wifis));
        } catch (Exception e) {
            paths.add("Device.WiFi.");
            GetParameterValuesResponseDTO wifis = synch().getParametersValues(device, paths);
            return new WifiNets(WifiParser.parse(wifis));
        }

    }

    @Override
    public void ativar(NbiDeviceData device) throws Exception {
        System.out.println("Ativar WiFi...");

        try {
            List<ParameterValueStructDTO> lst = new ArrayList<>();
            lst.add(SetParameters.ativarBroadcastWifi(DeviceTR.TR_098, 1));
            lst.add(SetParameters.ativarStatusWifi(DeviceTR.TR_098, 1));
            lst.add(SetParameters.ativarWifi(DeviceTR.TR_098, 1));
            synch().setParametersValues(device, lst);
            try {
                List<ParameterValueStructDTO> l = new ArrayList<>();
                l.add(SetParameters.ativarBroadcastWifi(DeviceTR.TR_098, 5));
                l.add(SetParameters.ativarStatusWifi(DeviceTR.TR_098, 5));
                l.add(SetParameters.ativarWifi(DeviceTR.TR_098, 5));
                synch().setParametersValues(device, l);
            } catch (Exception e) {
            }
        } catch (Exception e) {
            List<ParameterValueStructDTO> lst = new ArrayList<>();
            lst.add(SetParameters.ativarBroadcastWifi(DeviceTR.TR_181, 1));
            lst.add(SetParameters.ativarStatusWifi(DeviceTR.TR_181, 1));
            lst.add(SetParameters.ativarWifi(DeviceTR.TR_181, 1));
            synch().setParametersValues(device, lst);
            try {
                List<ParameterValueStructDTO> l = new ArrayList<>();
                l.add(SetParameters.ativarBroadcastWifi(DeviceTR.TR_181, 5));
                l.add(SetParameters.ativarStatusWifi(DeviceTR.TR_181, 5));
                l.add(SetParameters.ativarWifi(DeviceTR.TR_181, 5));
                synch().setParametersValues(device, l);
            } catch (Exception ex) {
            }
        }
    }

    @Override
    public void desativar(NbiDeviceData device) throws Exception {
        System.out.println("Desativar WiFi...");

        List<ParameterValueStructDTO> lst = new ArrayList<>();
//        lst.add(SetParameters.DESATIVAR_WIFI);
        synch().setParametersValues(device, lst);
    }

    @Override
    public WifiNets alterar(NbiDeviceData device, WifiNets wifis) throws Exception {
        List<ParameterValueStructDTO> lst = new ArrayList<>();
        WifiInfoFull wifi = wifis.getWifi().get(0);
//        lst.add(SetParameters.DESATIVAR_AUTOCHANNEL);
//        lst.add(SetParameters.ATIVAR_WIFI);
        synch().setParametersValues(device, lst);
        ThreadControl.sleep();
        synch().setWifiInfoFull(device, wifi);
        ThreadControl.sleep();
        return consultar(device);
    }

}
