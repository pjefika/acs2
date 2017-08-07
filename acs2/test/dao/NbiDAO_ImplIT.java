/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import com.alcatel.hdm.service.nbi2.NbiTemplate;
import java.util.List;
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
public class NbiDAO_ImplIT {

    private NbiDAO_Impl instance = new NbiDAO_Impl();

    public NbiDAO_ImplIT() {
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
     * Test of findDeviceByGUID method, of class NbiDAO_Impl.
     */
    @Test
    public void testFindDeviceByGUID() throws Exception {
        System.out.println("findDeviceByGUID");
        Long guid = null;

        NbiDeviceData expResult = null;
        NbiDeviceData result = instance.findDeviceByGUID(guid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findDevicesBySubscriberId method, of class NbiDAO_Impl.
     */
    @Test
    public void testFindDevicesBySubscriberId() throws Exception {
        System.out.println("findDevicesBySubscriberId");
        String subscriberId = "";

        List<NbiDeviceData> expResult = null;
        List<NbiDeviceData> result = instance.findDevicesBySubscriberId(subscriberId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findDevicesByMac method, of class NbiDAO_Impl.
     */
    @Test
    public void testFindDevicesByMac() throws Exception {
        System.out.println("findDevicesByMac");
        String mac = "";

        List<NbiDeviceData> expResult = null;
        List<NbiDeviceData> result = instance.findDevicesByMac(mac);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvailableCriteriaTemplates method, of class NbiDAO_Impl.
     */
    @Test
    public void testGetAvailableCriteriaTemplates() throws Exception {
        System.out.println("getAvailableCriteriaTemplates");
        List<NbiTemplate> expResult = null;
        List<NbiTemplate> result = instance.getAvailableCriteriaTemplates();
        System.out.println("end");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findDeviceByExternalIPAddress method, of class NbiDAO_Impl.
     */
    @Test
    public void testFindDeviceByExternalIPAddress() throws Exception {
        System.out.println("findDeviceByExternalIPAddress");
        String ipAddress = "";

        List<NbiDeviceData> expResult = null;
        List<NbiDeviceData> result = instance.findDeviceByExternalIPAddress(ipAddress);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findDeviceBySerialNumber method, of class NbiDAO_Impl.
     */
    @Test
    public void testFindDeviceBySerialNumber() throws Exception {
        System.out.println("findDeviceBySerialNumber");
        String serial = "";

        List<NbiDeviceData> expResult = null;
        List<NbiDeviceData> result = instance.findDeviceBySerialNumber(serial);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
