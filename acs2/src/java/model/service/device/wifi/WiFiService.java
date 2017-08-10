/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.wifi;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import model.device.wifi.WifiInfoFull;
import model.service.device.MotiveService;

/**
 *
 * @author G0042204
 */
public interface WiFiService extends MotiveService<WifiInfoFull>{

    @Override
    public WifiInfoFull consultar(NbiDeviceData device) throws Exception;

    @Override
    public WifiInfoFull alterar(NbiDeviceData device, WifiInfoFull wifi) throws Exception;

    public void ativar(NbiDeviceData device) throws Exception;

    public void desativar(NbiDeviceData device) throws Exception;

}
