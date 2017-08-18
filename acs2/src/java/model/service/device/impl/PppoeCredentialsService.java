/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import model.device.pppoe.PPPoECredentialsInfo;
import model.device.serviceclass.ServiceClass;
import model.service.device.GenericDeviceService;
import model.service.device.MotiveService;
import model.service.device.ThreadControl;

/**
 *
 * @author G0042204
 */
public class PppoeCredentialsService extends GenericDeviceService implements MotiveService<PPPoECredentialsInfo> {

    @Override
    public PPPoECredentialsInfo consultar(NbiDeviceData device) throws Exception {
        return synch().getPPPoECredentials(device);
    }

    @Override
    public PPPoECredentialsInfo alterar(NbiDeviceData device, PPPoECredentialsInfo t) throws Exception {
        synch().setPPPoECredentials(device, t);
        ThreadControl.sleep();
        return consultar(device);
    }

}
