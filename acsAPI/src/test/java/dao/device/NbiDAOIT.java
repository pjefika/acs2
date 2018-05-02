/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.device;

import br.net.gvt.efika.util.json.JacksonMapper;
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
 * @author G0042204
 */
public class NbiDAOIT {

    private NbiDAO instance = new NbiDAO_Impl();

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
     * Test of findDeviceByGUID method, of class NbiDAO.
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
     * Test of findDevicesBySubscriberId method, of class NbiDAO.
     */
    @Test
    public void testFindDevicesBySubscriberId() throws Exception {
        System.out.println("findDevicesBySubscriberId");
        String subscriberId = "NIU-811ECMZQZR-013";

        List<NbiDeviceData> result = instance.findDevicesBySubscriberId(subscriberId);
        System.out.println(new JacksonMapper(List.class).serialize(result));
        
    }

    /**
     * Test of findDevicesByMac method, of class NbiDAO.
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
     * Test of findDeviceByExternalIPAddress method, of class NbiDAO.
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
     * Test of findDeviceBySerialNumber method, of class NbiDAO.
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
