/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitario.equipamento.acao;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.EquipamentoDAO;
import init.EquipamentoTestValues;
import model.device.sipactivation.SipActivation;
import model.device.sipdiagnostics.SipDiagnostics;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class SipActivationJUnitTest {

    public SipActivationJUnitTest() {
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
    public void setSip() {
        try {
            EquipamentoDAO d = new EquipamentoDAO();

            NbiDeviceData eqp;

            eqp = d.findDeviceByGUID(EquipamentoTestValues.GUID);

            SipDiagnostics leGet = d.getSipDiagnostics(eqp, 1);
            
            SipActivation leSet = new SipActivation();
            
            leSet.setDirectoryNumber(leGet.getDirectoryNumber());
            leSet.setAuthUserName(leGet.getAuthUserName());
            leSet.setAuthPassword(leGet.getDirectoryNumber().replace("+55", ""));
            leSet.setProxyServer(leGet.getProxyServer());
            leSet.setRegistrarServer(leGet.getRegistrarServer());
            leSet.setUserAgentDomain(leGet.getUserAgentDomain());
            leSet.setOutboundProxy(leGet.getOutboundProxy());
            leSet.setPhyReferenceList("1");
            
            Boolean foi = d.setSipActivation(eqp, leSet);
            

            assertTrue(foi);

        } catch (Exception ex) {
            ex.printStackTrace();
            assertTrue(false);
        }
    }
}
