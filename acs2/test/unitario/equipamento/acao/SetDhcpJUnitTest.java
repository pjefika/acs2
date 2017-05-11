/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitario.equipamento.acao;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.EquipamentoDAO;
import init.EquipamentoTestValues;
import model.device.dhcp.Dhcp;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SetDhcpJUnitTest {

    public SetDhcpJUnitTest() {
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
    public void setDhcp() {
        try {
            EquipamentoDAO d = new EquipamentoDAO();

            NbiDeviceData eqp;

            eqp = d.findDeviceByGUID(EquipamentoTestValues.GUID);

            Dhcp dh = d.getDhcp(eqp);
            dh.setDHCPServerEnable("1");
            d.setDhcp(eqp, dh);
            dh = d.getDhcp(eqp);
            System.out.println(dh.getDHCPServerEnable());

            assertTrue(true);

        } catch (Exception ex) {
            ex.printStackTrace();
            assertTrue(false);
        }
    }
}
