/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device;

import br.net.gvt.efika.acs.model.device.firmware.FirmwareInfo;
import br.net.gvt.efika.acs.model.device.info.DeviceInfo;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.factory.FactoryDAO;
import init.SingletonDeviceTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0041775
 */
public class FirmwareServiceImplIT {

    public FirmwareServiceImplIT() {
    }

    private final NbiDeviceData eqp = SingletonDeviceTest.getInstance().getDevice();

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    FirmwareServiceImpl instance = new FirmwareServiceImpl();

    /**
     * Test of firmwareUpdate method, of class FirmwareServiceImpl.
     */
    @Test
    public void testFirmwareUpdate() throws Exception {
        System.out.println("firmwareUpdate");

        DeviceInfo d = FactoryDAO.createSynch().getDeviceInfo(eqp);
        FirmwareInfo info = new FirmwareInfo(d.getFwer(), d.getPreferv());
        Boolean result = instance.firmwareUpdate(eqp, info);
        System.out.println("result->" + result);
    }

}
