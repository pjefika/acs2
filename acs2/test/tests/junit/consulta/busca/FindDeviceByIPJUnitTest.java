/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.junit.consulta.busca;

import com.alcatel.hdm.service.nbi2.NBIException_Exception;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.EquipamentoDAO;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tests.junit.init.EquipamentoTestValues;
import util.SoutUtil;

/**
 *
 * @author G0042204
 */
public class FindDeviceByIPJUnitTest {

    public FindDeviceByIPJUnitTest() {
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
    public void listarEquipamentosPorIp() {

        try {
            EquipamentoDAO d = new EquipamentoDAO();

            List<NbiDeviceData> eqp = d.listarEquipamentosPorIp(d.findDeviceByGUID(EquipamentoTestValues.GUID).getIPAddress());
            SoutUtil.print(eqp);
            assertTrue(true);
        } catch (NBIException_Exception ex) {
            ex.printStackTrace();
            assertTrue(false);
        }
    }
}
