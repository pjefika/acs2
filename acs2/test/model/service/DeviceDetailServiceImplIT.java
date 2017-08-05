/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import init.EquipamentoTestValues;
import model.dto.DeviceDetail;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author G0042204
 */
public class DeviceDetailServiceImplIT extends EquipamentoTestValues {

    public DeviceDetailServiceImplIT() {
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
     * Test of consultar method, of class DeviceDetailServiceImpl.
     */
    @Test
    public void testConsultar() throws Exception {
        System.out.println("consultar");
        DeviceDetailServiceImpl instance = new DeviceDetailServiceImpl();
        DeviceDetail result = instance.consultar(GUID);
        System.out.println("end");
        assertTrue(result != null);

    }

}
