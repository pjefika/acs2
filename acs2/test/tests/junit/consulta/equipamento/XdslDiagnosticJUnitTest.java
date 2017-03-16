/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.junit.consulta.equipamento;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.EquipamentoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class XdslDiagnosticJUnitTest {

    public XdslDiagnosticJUnitTest() {
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
    public void xDSLDiagnostic() {

        try {
            EquipamentoDAO d = new EquipamentoDAO();

            NbiDeviceData eqp;
            eqp = d.findDeviceByGUID(EquipamentoTestValues.GUID);

            d.xDSLDiagnostic(eqp);

        } catch (Exception ex) {
            Logger.getLogger(XdslDiagnosticJUnitTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }

    }
}
