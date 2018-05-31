/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device;

import dao.device.RemoteDAO;
import dao.device.SynchDeviceDAO;
import dao.factory.FactoryDAO;

/**
 *
 * @author G0042204
 */
public class ServiceAbstract {

    private SynchDeviceDAO synch;

    private RemoteDAO remote;

    public SynchDeviceDAO synch() {
        if (synch == null) {
            synch = FactoryDAO.createSynch();
        }
        return synch;
    }

    public RemoteDAO remote() {
        if (remote == null) {
            remote = FactoryDAO.createRemote();
        }
        return remote;
    }
}
