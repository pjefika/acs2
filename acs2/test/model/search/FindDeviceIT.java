/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.search;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.SoutUtil;

/**
 *
 * @author G0042204
 */
public class FindDeviceIT {

    FindDevice instance = new FindDeviceImpl();

    public FindDeviceIT() {
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
     * Test of find method, of class FindDevice.
     */
    @Test
    public void testFindSerial() throws Exception {
        try {
            System.out.println("find - SearchCriteria.SERIAL");
            SearchIn in = new SearchIn(SearchCriteria.SERIAL, "QX4S1EB598946");
            List<NbiDeviceData> result = instance.find(in);

            result.forEach((t) -> {
                SoutUtil.print(t);
            });
            assertTrue(!result.isEmpty());
            // TODO review the generated test code and remove the default call to fail.
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFindSubscriber() throws Exception {
        try {
            System.out.println("find - SearchCriteria.SUBCRIBER");
            SearchIn in = new SearchIn(SearchCriteria.SUBCRIBER, "FLA-81D2X6SWR-013");
            List<NbiDeviceData> result = instance.find(in);

            result.forEach((t) -> {
                SoutUtil.print(t);
            });
            assertTrue(!result.isEmpty());
            // TODO review the generated test code and remove the default call to fail.
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testFindMac() throws Exception {
        try {
            System.out.println("find - SearchCriteria.MAC");
            SearchIn in = new SearchIn(SearchCriteria.MAC, "B8:88:E3:EA:14:C8");
            List<NbiDeviceData> result = instance.find(in);

            result.forEach((t) -> {
                SoutUtil.print(t);
            });
            assertTrue(!result.isEmpty());
            // TODO review the generated test code and remove the default call to fail.
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    
        @Test
    public void testFindIP() throws Exception {
        try {
            System.out.println("find - SearchCriteria.IP");
            SearchIn in = new SearchIn(SearchCriteria.IP, "177.134.146.39");
            List<NbiDeviceData> result = instance.find(in);

            result.forEach((t) -> {
                SoutUtil.print(t);
            });
            assertTrue(!result.isEmpty());
            // TODO review the generated test code and remove the default call to fail.
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
