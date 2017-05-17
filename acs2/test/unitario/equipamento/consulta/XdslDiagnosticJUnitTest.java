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
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import init.EquipamentoTestValues;
import model.device.xdsldiagnostics.XdslDiagnostics;
import util.SoutUtil;

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
            XdslDiagnostics xd = d.getXdslDiagnostic(eqp);
            assertTrue(xd != null);
            System.out.println("getATUCCRCErrors: " + xd.getATUCCRCErrors());
            System.out.println("getATUCFECErrors: " + xd.getATUCFECErrors());
            System.out.println("getATUCHECErrors: " + xd.getATUCHECErrors());
            System.out.println("getCRCErrors: " + xd.getCRCErrors());
            System.out.println("getDownstreamAttenuation: " + xd.getDownstreamAttenuation());
            System.out.println("getDownstreamCurrRate: " + xd.getDownstreamCurrRate());
            System.out.println("getDownstreamMaxRate: " + xd.getDownstreamMaxRate());
            System.out.println("getDownstreamNoiseMargin: " + xd.getDownstreamNoiseMargin());
            System.out.println("getDownstreamPower: " + xd.getDownstreamPower());
            System.out.println("getFECErrors: " + xd.getFECErrors());
            System.out.println("getHECErrors: " + xd.getHECErrors());
            System.out.println("getLinkRetrain: " + xd.getLinkRetrain());
            System.out.println("getLossOfFraming: " + xd.getLossOfFraming());
            System.out.println("getModulationType: " + xd.getModulationType());
            System.out.println("getSeverelyErroredSecs: " + xd.getSeverelyErroredSecs());
            System.out.println("getShowtimeStart: " + xd.getShowtimeStart());
            System.out.println("getUpstreamAttenuation: " + xd.getUpstreamAttenuation());
            System.out.println("getUpstreamCurrRate: " + xd.getUpstreamCurrRate());
            System.out.println("getUpstreamMaxRate: " + xd.getUpstreamMaxRate());
            System.out.println("getUpstreamNoiseMargin: " + xd.getUpstreamNoiseMargin());
            System.out.println("getUpstreamPower: " + xd.getUpstreamPower());
        } catch (Exception ex) {
            Logger.getLogger(XdslDiagnosticJUnitTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }

    }
}
