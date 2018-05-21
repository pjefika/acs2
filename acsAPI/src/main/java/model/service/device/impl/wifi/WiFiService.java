/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl.wifi;

import br.net.gvt.efika.acs.model.device.wifi.WifiNets;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import model.service.device.MotiveService;

/**
 *
 * @author G0042204
 */
public interface WiFiService extends MotiveService<WifiNets>{

    @Override
    public WifiNets consultar(NbiDeviceData device) throws Exception;

    @Override
    public WifiNets alterar(NbiDeviceData device, WifiNets wifis) throws Exception;

    public void ativar(NbiDeviceData device) throws Exception;

    public void desativar(NbiDeviceData device) throws Exception;

}
