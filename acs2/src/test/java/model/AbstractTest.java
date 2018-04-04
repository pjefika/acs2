/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.device.SynchDeviceDAO;
import dao.factory.FactoryDAO;
import init.SingletonDeviceTest;

/**
 *
 * @author G0042204
 */
public abstract class AbstractTest {

    protected SynchDeviceDAO instance = FactoryDAO.createSynch();
    protected NbiDeviceData eqp = SingletonDeviceTest.getInstance().getDevice();
}
