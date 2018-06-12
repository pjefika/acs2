/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl.iptv.acao;

import br.net.gvt.efika.acs.model.dto.IptvDiagnostics;
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
public class IptvDiagnosticsServiceIT {

    public IptvDiagnosticsServiceIT() {
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

    private final NbiDeviceData eqp = SingletonDeviceTest.getInstance().getDevice();
    private final IptvDiagnosticsService instance = new IptvDiagnosticsService();

    /**
     * Test of consultar method, of class IptvDiagnosticsService.
     */
    @Test
    public void testConsultar() throws Exception {
        System.out.println("consultar");
        
        IptvDiagnostics result = instance.consultar(eqp, new IptvDiagnostics());
        System.out.println(new JacksonMapper<>(IptvDiagnostics.class).serialize(result));
    }

    /**
     * Test of alterar method, of class IptvDiagnosticsService.
     */
    @Test
    public void testAlterar() throws Exception {
        System.out.println("alterar");
        NbiDeviceData device = null;
        IptvDiagnostics t = null;
        IptvDiagnosticsService instance = new IptvDiagnosticsService();
        IptvDiagnostics expResult = null;
        IptvDiagnostics result = instance.alterar(device, t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
