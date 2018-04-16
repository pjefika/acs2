/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import model.device.sipactivation.SipActivation;
import model.device.sipdiagnostics.SipDiagnostics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0042204
 */
public class SipActivationServiceImplIT {
    
    public SipActivationServiceImplIT() {
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
     * Test of ativar method, of class SipActivationServiceImpl.
     */
    @Test
    public void testAtivar() throws Exception {
        System.out.println("ativar");
        NbiDeviceData device = null;
        SipActivation activation = null;
        SipActivationServiceImpl instance = new SipActivationServiceImpl();
        SipDiagnostics expResult = null;
        SipDiagnostics result = instance.ativar(device, activation);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
