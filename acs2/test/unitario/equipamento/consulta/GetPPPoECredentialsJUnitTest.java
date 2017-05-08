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
import exception.JsonUtilException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.device.pppoe.PPPoECredentialsInfo;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import init.EquipamentoTestValues;
import util.SoutUtil;

/**
 *
 * @author G0042204
 */
public class GetPPPoECredentialsJUnitTest {

    public GetPPPoECredentialsJUnitTest() {
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
    public void getPPPoECredentials() throws Exception {

        EquipamentoDAO d = new EquipamentoDAO();
        Long l = EquipamentoTestValues.GUID;
        NbiDeviceData eqp;
        eqp = d.findDeviceByGUID(l);
        //d.capture(l);
        // d.release(l);
        
        PPPoECredentialsInfo info = d.getPPPoECredentials(eqp);

        //System.out.println(info.getUsername());

        assertTrue(true);

    }
}
