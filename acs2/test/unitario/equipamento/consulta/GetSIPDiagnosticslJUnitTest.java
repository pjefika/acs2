/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitario.equipamento.consulta;

import com.alcatel.hdm.service.nbi2.NBIException_Exception;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.DeviceOperationException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.NBIException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.OperationTimeoutException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.ProviderException;
import dao.EquipamentoDAO;
import model.exception.HdmException;
import model.exception.JsonUtilException;
import model.exception.UnsupportedException;
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
    public void getSipDiagnostics() throws HdmException {
        try {
            EquipamentoDAO d = new EquipamentoDAO();
            NbiDeviceData eqp;
            eqp = d.findDeviceByGUID(EquipamentoTestValues.GUID);           
            SipDiagnostics sip = d.getSipDiagnostics(eqp, 1); 
            
            assertTrue(sip != null);            
            System.out.println("getAuthPassword: " + sip.getAuthPassword());
            System.out.println("getAuthUserName: " + sip.getAuthUserName());
            System.out.println("getCallState: " + sip.getCallState());
            System.out.println("getCodec: " + sip.getCodec());
            System.out.println("getConferenceCallURI: " + sip.getConferenceCallURI());
            System.out.println("getDTMFMethod: " + sip.getDTMFMethod());
            System.out.println("getDigitMap: " + sip.getDigitMap());
            System.out.println("getDirectoryNumber: " + sip.getDirectoryNumber());
            System.out.println("getEnable: " + sip.getEnable());
            System.out.println("getLineEnable: " + sip.getLineEnable());
            System.out.println("getOutboundProxy: " + sip.getOutboundProxy());
            System.out.println("getPacketsLost: " + sip.getPacketsLost());
            System.out.println("getProfileEnable: " + sip.getProfileEnable());
            System.out.println("getProxyServer: " + sip.getProxyServer());
            System.out.println("getProxyServerPort: " + sip.getProxyServerPort());
            System.out.println("getRegistrarServer: " + sip.getRegistrarServer());
            System.out.println("getStatus: " + sip.getStatus());
            System.out.println("getT38Enable: " + sip.getT38Enable());
            System.out.println("getURI: " + sip.getURI());
            System.out.println("getUserAgentDomain: " + sip.getUserAgentDomain());
            System.out.println("getUserAgentPort: " + sip.getUserAgentPort());
        } catch (Exception e) {            
            e.printStackTrace();
            assertTrue(false);
        }
    }
}
