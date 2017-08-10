/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device;

import dao.device.SynchDeviceDAO;
import dao.factory.FactoryDAO;

/**
 *
 * @author G0042204
 */
public class ServiceAbstract {

    private SynchDeviceDAO synch;

    public SynchDeviceDAO synch() {
        if (synch == null) {
            synch = FactoryDAO.createSynch();
        }
        return synch;
    }
}
