/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import java.util.List;
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
public class DeviceOnlineServiceImplIT {
    
    public DeviceOnlineServiceImplIT() {
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
     * Test of isOnline method, of class DeviceOnlineServiceImpl.
     */
    @Test
    public void testIsOnline() throws Exception {
        System.out.println("isOnline");
        NbiDeviceData eqp = null;
        DeviceOnlineServiceImpl instance = new DeviceOnlineServiceImpl();
        Boolean expResult = null;
        Boolean result = instance.isOnline(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAnyOnline method, of class DeviceOnlineServiceImpl.
     */
    @Test
    public void testIsAnyOnline() throws Exception {
        System.out.println("isAnyOnline");
        List<NbiDeviceData> eqps = null;
        DeviceOnlineServiceImpl instance = new DeviceOnlineServiceImpl();
        Boolean expResult = null;
        Boolean result = instance.isAnyOnline(eqps);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
