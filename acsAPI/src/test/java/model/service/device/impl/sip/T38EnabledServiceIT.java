/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl.sip;

import br.net.gvt.efika.acs.model.dto.T38Enabled;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
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
public class T38EnabledServiceIT {
    
    public T38EnabledServiceIT() {
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
     * Test of consultar method, of class T38EnabledService.
     */
    @Test
    public void testConsultar() throws Exception {
        System.out.println("consultar");
        NbiDeviceData device = null;
        T38Enabled t38 = null;
        T38EnabledService instance = new T38EnabledService();
        T38Enabled expResult = null;
        T38Enabled result = instance.consultar(device, t38);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterar method, of class T38EnabledService.
     */
    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        NbiDeviceData device = null;
        T38Enabled t = null;
        T38EnabledService instance = new T38EnabledService();
        T38Enabled expResult = null;
        T38Enabled result = instance.alterar(device, t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
