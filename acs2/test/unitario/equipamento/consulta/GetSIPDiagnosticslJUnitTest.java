/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitario.equipamento.consulta;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.EquipamentoDAO;
import init.EquipamentoTestValues;
import model.device.sipdiagnostics.SipDiagnostics;
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
public class GetSIPDiagnosticslJUnitTest {

    public GetSIPDiagnosticslJUnitTest() {
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
    public void getSipDiagnostics() {
        try {
            EquipamentoDAO d = new EquipamentoDAO();

            NbiDeviceData eqp;

            eqp = d.findDeviceByGUID(EquipamentoTestValues.GUID);
           
            SipDiagnostics sip = d.getSipDiagnostics(eqp, 50);

            System.out.println(sip.getDirectoryNumber());
            
            assertTrue(true);

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }
}
