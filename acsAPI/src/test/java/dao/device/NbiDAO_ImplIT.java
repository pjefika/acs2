/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.device;

import br.net.gvt.efika.util.json.JacksonMapper;
import com.alcatel.hdm.service.nbi2.NbiCommunicationLog;
import com.alcatel.hdm.service.nbi2.NbiDeviceActionResult;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import com.alcatel.hdm.service.nbi2.NbiTemplate;
import init.SingletonDeviceTest;
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

    private final NbiDeviceData nbi = SingletonDeviceTest.getInstance().getDevice();

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
        Long guid = 26648107l;

        NbiDeviceData result = instance.findDeviceByGUID(guid);
        System.out.println(new JacksonMapper(NbiDeviceData.class).equals(result));
    }

    /**
     * Test of findDevicesBySubscriberId method, of class NbiDAO_Impl.
     */
    @Test
    public void testFindDevicesBySubscriberId() throws Exception {
        System.out.println("findDevicesBySubscriberId");
        String subscriberId = "NO_SUBSCRIBER";

        List<NbiDeviceData> expResult = null;
        List<NbiDeviceData> result = instance.findDevicesBySubscriberId(subscriberId);
        for (NbiDeviceData nbiDeviceData : result) {
//            System.out.println("LeDevice: " + GsonUtil.serialize(nbiDeviceData));
        }

        assertTrue(result != null);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
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
    public void testGetAvailableCriteriaTemplates() {
        try {
            System.out.println("getAvailableCriteriaTemplates");
            List<NbiTemplate> result = instance.getAvailableCriteriaTemplates();
//            System.out.println(GsonUtil.serialize(result));
            System.out.println("end");
            assertTrue(!result.isEmpty());
            // TODO review the generated test code and remove the default call to fail.
        } catch (Exception e) {
            fail(e.getMessage());
        }

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
        String serial = "LU1421603000323";

//        List<NbiDeviceData> expResult = null;
        List<NbiDeviceData> result = instance.findDeviceBySerialNumber(serial);
        System.out.println(new JacksonMapper(List.class).serialize(result));
    }

    /**
     * Test of getCommunicationLogsByDeviceID method, of class NbiDAO_Impl.
     */
    @Test
    public void testGetCommunicationLogsByDeviceID() throws Exception {
        System.out.println("getCommunicationLogsByDeviceID");
        List<NbiCommunicationLog> result = instance.getCommunicationLogsByDeviceID(nbi.getDeviceId());
        
        for (NbiCommunicationLog com : result) {
            System.out.println("com.getMessage(): " + com.getMessage());
            System.out.println("com.getDetail(): " + com.getDetail());
        }

        assertTrue(!result.isEmpty());
    }

    /**
     * Test of getDeviceOperationsHistory method, of class NbiDAO_Impl.
     */
    @Test
    public void testGetDeviceOperationsHistory() throws Exception {
        System.out.println("getDeviceOperationsHistory");
        List<NbiDeviceActionResult> result = instance.getDeviceOperationsHistory(nbi.getDeviceId());
//        System.out.println(GsonUtil.serialize(result));
        assertTrue(!result.isEmpty());

    }

}
