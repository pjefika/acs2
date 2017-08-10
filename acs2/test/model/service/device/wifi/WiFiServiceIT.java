/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.wifi;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.device.SynchDeviceDAO;
import dao.factory.FactoryDAO;
import init.EquipamentoTestValues;
import init.SingletonDeviceTest;
import model.device.wifi.WifiInfoFull;
import model.service.factory.FactoryService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0042204
 */
public class WiFiServiceIT extends EquipamentoTestValues {

    WiFiService instance = FactoryService.createWiFiService();
    private final NbiDeviceData device = SingletonDeviceTest.getInstance().getDevice();

    public WiFiServiceIT() {
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
     * Test of consultar method, of class WiFiService.
     */
    @Test
    public void testConsultar() throws Exception {
        try {
            System.out.println("consultar");
            WifiInfoFull result = instance.consultar(device);
            assertTrue(result != null);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test of ativar method, of class WiFiService.
     */
    @Test
    public void testAtivar() throws Exception {
        System.out.println("ativar");
        NbiDeviceData device = null;

        instance.ativar(device);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
