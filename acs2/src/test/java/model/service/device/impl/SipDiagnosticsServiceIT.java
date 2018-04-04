/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import model.AbstractTest;
import model.device.sipdiagnostics.SipDiagnostics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.GsonUtil;

/**
 *
 * @author G0042204
 */
public class SipDiagnosticsServiceIT extends AbstractTest {

    public SipDiagnosticsServiceIT() {
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
     * Test of consultar method, of class SipDiagnosticsService.
     */
    @Test
    public void testConsultar() throws Exception {
        System.out.println("consultar");
        try {
            Integer phyref = 1;
            SipDiagnosticsService instance = new SipDiagnosticsServiceImpl();
            SipDiagnostics result = instance.consultar(eqp, phyref);
            System.out.println(GsonUtil.serialize(result));
            assertTrue(result != null);
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

}
