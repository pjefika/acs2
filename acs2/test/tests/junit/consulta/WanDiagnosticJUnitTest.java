/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.junit.consulta;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.EquipamentoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author G0042204
 */
public class WanDiagnosticJUnitTest {

    public WanDiagnosticJUnitTest() {
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
    public void wanDiagnostic() {

        try {
            EquipamentoDAO d = new EquipamentoDAO();

            Long l = new Long(142014);
            NbiDeviceData eqp;
            eqp = d.findDeviceByGUID(l);

            d.getWanInfo(eqp);
            assertTrue(true);

        } catch (Exception ex) {
            Logger.getLogger(WanDiagnosticJUnitTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }

    }
}