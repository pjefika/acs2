/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl.wifi;

import br.net.gvt.efika.acs.model.device.wifi.WifiNetsV2;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import model.service.device.MotiveService;

/**
 *
 * @author G0042204
 */
public interface WiFiServiceV2 extends MotiveService<WifiNetsV2>{

    @Override
    public WifiNetsV2 consultar(NbiDeviceData device) throws Exception;

    @Override
    public WifiNetsV2 alterar(NbiDeviceData device, WifiNetsV2 wifis) throws Exception;

}
