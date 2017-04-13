/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitario.equipamento.consulta;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.EquipamentoDAO;
import init.EquipamentoTestValues;
import java.util.ArrayList;
import java.util.List;
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
public class InvestigacaoWifiJUnitTest {

    public InvestigacaoWifiJUnitTest() {
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
    public void getParameters() {
        try {
            EquipamentoDAO d = new EquipamentoDAO();

            NbiDeviceData eqp;
//            eqp = d.findDeviceByGUID(new Long(142012));
//            eqp = d.findDeviceByGUID(new Long(23006));
            eqp = d.findDeviceByGUID(EquipamentoTestValues.GUID);
//            eqp = d.findDeviceByGUID(new Long(23006));
//            eqp = d.findDeviceByGUID(new Long(23006));

            List<String> lst = new ArrayList<>();

            lst.add("InternetGatewayDevice.LANDevice.1.WLANConfiguration.1.Enable");
            lst.add("InternetGatewayDevice.LANDevice.1.WLANConfiguration.1.KeyPassphrase");
            lst.add("InternetGatewayDevice.LANDevice.1.WLANConfiguration.1.WEPEncryptionLevel");
            lst.add("InternetGatewayDevice.LANDevice.1.WLANConfiguration.1.BasicEncryptionModes");
            lst.add("InternetGatewayDevice.LANDevice.1.WLANConfiguration.1.BasicAuthenticationMode");
            lst.add("InternetGatewayDevice.LANDevice.1.WLANConfiguration.1.WPAEncryptionModes");
            lst.add("InternetGatewayDevice.LANDevice.1.WLANConfiguration.1.WPAAuthenticationMode");
            lst.add("InternetGatewayDevice.LANDevice.1.WLANConfiguration.1.IEEE11iEncryptionModes");
            lst.add("InternetGatewayDevice.LANDevice.1.WLANConfiguration.1.IEEE11iAuthenticationMode");

            d.getParametersValues(eqp, lst);

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }
}
