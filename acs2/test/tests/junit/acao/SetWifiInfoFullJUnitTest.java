/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.junit.acao;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.EquipamentoDAO;
import model.device.wifi.WifiInfoFull;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tests.junit.init.EquipamentoTestValues;
import util.SoutUtil;

/**
 *
 * @author G0042204
 */
public class SetWifiInfoFullJUnitTest {

    public SetWifiInfoFullJUnitTest() {
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
    public void setDeviceInfo() {
        try {
            EquipamentoDAO d = new EquipamentoDAO();

            NbiDeviceData eqp;

            eqp = d.findDeviceByGUID(EquipamentoTestValues.GUID);

            WifiInfoFull info = d.getWifiInfoFull(eqp);
            SoutUtil.print(info);
            info.setSsid("efika-dev");
            info.setAuthMode("None");
            info.setEncType("None");
            info.setBcEnabled(Boolean.TRUE);
            info.setChannel("5");
            info.setStandard("b");
            info.setKey("1303000712");

            assertTrue(d.setWifiInfoFull(eqp, info));

            SoutUtil.print(d.getWifiInfoFull(eqp));

        } catch (Exception ex) {
            ex.printStackTrace();
            assertTrue(false);
        }
    }
}
