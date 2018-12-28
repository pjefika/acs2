/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.device;

import br.net.gvt.efika.acs.model.device.firmware.FirmwareInfo;
import br.net.gvt.efika.acs.model.device.info.DeviceInfo;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.factory.FactoryDAO;
import dto.nbi.service.hdm.alcatel.com.NBIFirmwareImageData;
import dto.nbi.service.hdm.alcatel.com.NBITemplate;
import init.SingletonDeviceTest;
import java.rmi.RemoteException;
import java.util.List;
import notification.dto.nbi.service.hdm.alcatel.com.NBIDeviceActionResult;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author G0042204
 */
public class RemoteDAOImplIT {

    private RemoteDAOImpl instance = new RemoteDAOImpl();

    private final NbiDeviceData nbi = SingletonDeviceTest.getInstance().getDevice();

    public RemoteDAOImplIT() {
    }

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

    /**
     * Test of firmwareUpdate method, of class RemoteDAOImpl.
     *
     * @throws java.rmi.RemoteException
     */
    @Test
    public void test() throws RemoteException {
        try {
            NBITemplate[] templates = instance.getAvailableCriteriaTemplates();
            System.out.println("end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testgetAvailableFirmwareImages() throws RemoteException {
        try {
            System.out.println("getAvailableFirmwareImages");
            List<NBIFirmwareImageData> firmwares = instance.getAvailableFirmwareImages(nbi);
            firmwares.forEach((t) -> {
                System.err.println(t.getName());
            });
            System.out.println("end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test of getDeviceOperationsHistory method, of class RemoteDAOImpl.
     */
    @Test
    public void testGetDeviceOperationsHistory() throws Exception {
        System.out.println("getDeviceOperationsHistory");
        NBIDeviceActionResult[] result = instance.getDeviceOperationsHistory(nbi.getDeviceId());
        for (NBIDeviceActionResult r : result) {
        }

    }

    /**
     * Test of firmwareUpdate method, of class RemoteDAOImpl.
     */
    @Test
    public void testFirmwareUpdate() throws Exception {
        System.out.println("firmwareUpdate");
        DeviceInfo d = FactoryDAO.createSynch().getDeviceInfo(nbi);
        FirmwareInfo info = new FirmwareInfo(d.getFwer(), d.getPreferv());
//        Long expResult = null;
        Long result = instance.firmwareUpdate(nbi, info);
        System.out.println("result->" + result);
    }

    /**
     * Test of getAvailableFirmwareImages method, of class RemoteDAOImpl.
     */
    @Test
    public void testGetAvailableFirmwareImages() throws Exception {
        System.out.println("getAvailableFirmwareImages");
        NbiDeviceData eqp = null;
        RemoteDAOImpl instance = new RemoteDAOImpl();
        List<NBIFirmwareImageData> expResult = null;
        List<NBIFirmwareImageData> result = instance.getAvailableFirmwareImages(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvailableCriteriaTemplates method, of class RemoteDAOImpl.
     */
    @Test
    public void testGetAvailableCriteriaTemplates() throws Exception {
        System.out.println("getAvailableCriteriaTemplates");
        RemoteDAOImpl instance = new RemoteDAOImpl();
        NBITemplate[] expResult = null;
        NBITemplate[] result = instance.getAvailableCriteriaTemplates();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
