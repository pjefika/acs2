/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.junit;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.EquipamentoDAO;
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
public class ListarEquipamentosPorSerialJUnitTest {

    public ListarEquipamentosPorSerialJUnitTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void listarEquipamentosPorSerial() {
        try {
            EquipamentoDAO d = new EquipamentoDAO();

            List<NbiDeviceData> eqp = d.listarEquipamentosPorSerial("CP1302RM8V3");

            SoutUtil.print(eqp);

            assertTrue(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            assertTrue(false);
        }

    }
}
