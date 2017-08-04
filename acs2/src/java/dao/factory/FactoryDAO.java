/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.factory;

import dao.NbiDAO;
import dao.NbiDAO_Impl;
import dao.RemoteDAO;
import dao.RemoteDAOImpl;
import dao.SynchDeviceDAO;
import dao.SynchDeviceDAOImpl;

/**
 *
 * @author G0042204
 */
public class FactoryDAO {

    public static NbiDAO createNBI() {
        return new NbiDAO_Impl();
    }

    public static RemoteDAO createRemote() {
        return new RemoteDAOImpl();
    }

    public static SynchDeviceDAO createSynch() {
        return new SynchDeviceDAOImpl();
    }

}
