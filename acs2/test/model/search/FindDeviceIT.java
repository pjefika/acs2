/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.search;

import model.service.search.SearchCriteria;
import model.service.search.SearchIn;
import model.service.search.FindDeviceImpl;
import model.service.search.FindDevice;
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
            SearchIn in = new SearchIn(SearchCriteria.SERIAL, "LU1321803000973");
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
            SearchIn in = new SearchIn(SearchCriteria.SUBSCRIBER, "CTA-81BEK5U33-013");
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
            SearchIn in = new SearchIn(SearchCriteria.MAC, "68:15:90:66:D9:AA");
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
            SearchIn in = new SearchIn(SearchCriteria.IP, "177.99.223.84");
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
