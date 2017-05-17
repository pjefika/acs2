/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitario.equipamento.acao;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.EquipamentoDAO;
import model.device.ping.PingRequest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import init.EquipamentoTestValues;
import model.device.ping.PingResponse;
import util.SoutUtil;

/**
 *
 * @author G0042204
 */
public class PingDiagnosticJUnitTest {

    public PingDiagnosticJUnitTest() {
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
    public void pingDiagnostic() {
        try {
            EquipamentoDAO d = new EquipamentoDAO();
            NbiDeviceData eqp;
            eqp = d.findDeviceByGUID(EquipamentoTestValues.GUID);
            PingRequest p = new PingRequest();
            p.setDestAddress("www.google.com");
            p.setQtdRequisitions("4");
            PingResponse pingResponse = d.pingDiagnostic(eqp, p);
            assertTrue(pingResponse != null);
            SoutUtil.print(pingResponse);            
        } catch (Exception ex) {
            ex.printStackTrace();
            assertTrue(false);
        }
    }
}
