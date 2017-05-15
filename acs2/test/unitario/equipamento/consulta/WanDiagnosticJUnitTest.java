/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitario.equipamento.consulta;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.EquipamentoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.device.wan.WanInfo;
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

            NbiDeviceData eqp;
//            eqp = d.findDeviceByGUID(EquipamentoTestValues.GUID);
            eqp = d.findDeviceByGUID(new Long("147035"));

            //SoutUtil.print(eqp);             
            WanInfo w = d.getWanInfo(eqp);
            
            assertTrue(w.getBytesReceived() != null);

        } catch (Exception ex) {
            Logger.getLogger(WanDiagnosticJUnitTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }

    }
}
