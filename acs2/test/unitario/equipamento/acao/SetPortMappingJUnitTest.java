package unitario.equipamento.acao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.EquipamentoDAO;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

import model.device.portmapping.PortMappingInfo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import init.EquipamentoTestValues;

import util.SoutUtil;

/**
 *
 * @author G0034481
 */
public class SetPortMappingJUnitTest {

    public SetPortMappingJUnitTest() {
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
    public void setPortMapping() {
        try {
            EquipamentoDAO d = new EquipamentoDAO();

            NbiDeviceData eqp;

            eqp = d.findDeviceByGUID(EquipamentoTestValues.GUID);

            // d.setPortMapping(eqp, d.getPortMapping(eqp));
            int i = 1;

            for (PortMappingInfo portMappingInfo : d.getPortMapping(eqp)) {
                System.out.println("Número: " + i);
                SoutUtil.print(portMappingInfo);
                System.out.println("-----------------");
                i++;
            }

            assertTrue(true);

        } catch (Exception ex) {
            ex.printStackTrace();
            assertTrue(false);
        }
    }
}
