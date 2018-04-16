/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.wifi;

import model.service.device.impl.wifi.WiFiService;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
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
//import util.GsonUtil;

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
    public void testConsultar() {
        try {
            System.out.println("consultar");
//            WifiInfoFull result = instance.consultar(device);
//            System.out.println(GsonUtil.serialize(result));
//            assertTrue(result != null);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test of ativar method, of class WiFiService.
     */
    @Test
    public void testAtivar() {
        try {
            System.out.println("ativar");
            instance.ativar(device);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testDesativar() {
        try {
            System.out.println("desativar");
            instance.desativar(device);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
