/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.junit.consulta.equipamento;

import com.alcatel.hdm.service.nbi2.NbiDeviceActionResult;
import dao.EquipamentoDAO;
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
public class GetDeviceOperationStatusJUnitTest {

    public GetDeviceOperationStatusJUnitTest() {
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
    public void getDeviceOperationStatus() {
        try {

            Long guid = new Long(94015);
            EquipamentoDAO d = new EquipamentoDAO();

            NbiDeviceActionResult t = d.getDeviceOperationStatus(d.findDeviceByGUID(guid), new Long(158355));
            SoutUtil.print(t);

            assertTrue(true);

        } catch (Exception ex) {
            ex.printStackTrace();
            assertTrue(false);
        }

    }
}
