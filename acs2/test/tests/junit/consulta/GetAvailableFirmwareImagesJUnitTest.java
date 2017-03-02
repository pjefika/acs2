/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.junit.consulta;

import dao.EquipamentoDAO;
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

            Long guid = new Long(142014);
            EquipamentoDAO d = new EquipamentoDAO();

            d.getAvailableFirmwareImages(d.findDeviceByGUID(guid));

        } catch (Exception ex) {
            ex.printStackTrace();
            assertTrue(false);
        }
    }
}
