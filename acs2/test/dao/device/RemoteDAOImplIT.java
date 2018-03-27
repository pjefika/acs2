/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.device;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dto.nbi.service.hdm.alcatel.com.NBIFirmwareImageData;
import dto.nbi.service.hdm.alcatel.com.NBITemplate;
import init.SingletonDeviceTest;
import java.rmi.RemoteException;
import java.util.List;
import notification.dto.nbi.service.hdm.alcatel.com.NBIDeviceActionResult;
import org.junit.After;
import org.junit.AfterClass;
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

}
