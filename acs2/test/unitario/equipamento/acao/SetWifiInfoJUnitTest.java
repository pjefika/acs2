/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitario.equipamento.acao;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.EquipamentoDAO;
import model.device.wifi.WifiInfo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.SoutUtil;

/**
 *
 * @author G0042204
 */
public class SetWifiInfoJUnitTest {

    public SetWifiInfoJUnitTest() {
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
    public void getDeviceInfo() {
        try {
            EquipamentoDAO d = new EquipamentoDAO();

            NbiDeviceData eqp;

            eqp = d.findDeviceByGUID(new Long(139020));

            WifiInfo info = d.getWifiInfo(eqp);

            SoutUtil.print(info);

            /**
             * Alterções
             */
            info.setSsid("Teste Efika - Set Wifi");
            //info.setSsid("Teste Efika");

            assertTrue(d.setWifiInfo(eqp, info));

        } catch (Exception ex) {
            ex.printStackTrace();
            assertTrue(false);
        }
    }
}
