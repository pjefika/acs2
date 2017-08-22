/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import model.device.pppoe.PPPoECredentialsInfo;
import model.service.device.GenericDeviceService;

/**
 *
 * @author G0042204
 */
public class PppoeCredentialsInServiceImpl extends GenericDeviceService implements PppoeCredentialsInService {

    @Override
    public Boolean alterar(NbiDeviceData device, PPPoECredentialsInfo t) throws Exception {
        return synch().setPPPoECredentials(device, t);
    }

}