/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl.lan;

import br.net.gvt.efika.acs.model.dto.LANIPv6Auto;
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
public class IPv6AutoServiceIT {
    
    public IPv6AutoServiceIT() {
    }
    private NbiDeviceData device = SingletonDeviceTest.getInstance().getDevice();
    //null;
    private IPv6AutoService instance = new IPv6AutoService();
    
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
     * Test of consultar method, of class IPv6AutoService.
     */
    @Test
    public void testConsultar() throws Exception {
        System.out.println("consultar");
        NbiDeviceData device = null;
        LANIPv6Auto ipv6 = null;
        IPv6AutoService instance = new IPv6AutoService();
        LANIPv6Auto expResult = null;
        LANIPv6Auto result = instance.consultar(device, ipv6);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterar method, of class IPv6AutoService.
     */
    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        
        LANIPv6Auto t = new LANIPv6Auto(false);
        LANIPv6Auto result = instance.alterar(device, t);
        
        System.out.println(new JacksonMapper(LANIPv6Auto.class).serialize(result));
        
        
    }
    
}
