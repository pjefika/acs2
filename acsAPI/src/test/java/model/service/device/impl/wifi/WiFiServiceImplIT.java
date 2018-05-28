/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl.wifi;

import br.net.gvt.efika.acs.model.device.wifi.WifiNets;
import br.net.gvt.efika.util.json.JacksonMapper;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
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
public class WiFiServiceImplIT {

    public WiFiServiceImplIT() {
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

    private final NbiDeviceData eqp = SingletonDeviceTest.getInstance().getDevice();
    private final WiFiServiceImpl instance = new WiFiServiceImpl();

    /**
     * Test of consultar method, of class WiFiServiceImpl.
     */
    @Test
    public void testConsultar() throws Exception {
        System.out.println("consultar");

        WifiNets result = instance.consultar(eqp);
        System.out.println(new JacksonMapper<>(WifiNets.class).serialize(result));
    }

    /**
     * Test of ativar method, of class WiFiServiceImpl.
     */
    @Test
    public void testAtivar() throws Exception {
        System.out.println("ativar");
        NbiDeviceData device = null;
        WiFiServiceImpl instance = new WiFiServiceImpl();
        instance.ativar(device);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of desativar method, of class WiFiServiceImpl.
     */
    @Test
    public void testDesativar() throws Exception {
        System.out.println("desativar");
        NbiDeviceData device = null;
        WiFiServiceImpl instance = new WiFiServiceImpl();
        instance.desativar(device);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterar method, of class WiFiServiceImpl.
     */
    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        NbiDeviceData device = null;
        WifiNets wifis = null;
        WiFiServiceImpl instance = new WiFiServiceImpl();
        WifiNets expResult = null;
        WifiNets result = instance.alterar(device, wifis);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
