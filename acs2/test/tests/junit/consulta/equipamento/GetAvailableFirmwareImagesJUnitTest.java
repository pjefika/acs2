/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.junit.consulta.equipamento;

import dao.EquipamentoDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tests.junit.init.EquipamentoTestValues;

/**
 *
 * @author G0042204
 */
public class GetAvailableFirmwareImagesJUnitTest {

    public GetAvailableFirmwareImagesJUnitTest() {
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

    @Test
    public void getAvailableFirmwareImages() {
        try {

            EquipamentoDAO d = new EquipamentoDAO();

            d.getAvailableFirmwareImages(d.findDeviceByGUID(EquipamentoTestValues.GUID));

        } catch (Exception ex) {
            ex.printStackTrace();
            assertTrue(false);
        }
    }
}
