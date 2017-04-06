package unitario.equipamento.consulta;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.EquipamentoDAO;

import static org.junit.Assert.assertTrue;

import java.util.List;
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
public class GetPortMappingJUnitTest {

    public GetPortMappingJUnitTest() {
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
    public void getPortMapping() {
        try {
            EquipamentoDAO d = new EquipamentoDAO();

            NbiDeviceData eqp;

            eqp = d.findDeviceByGUID(EquipamentoTestValues.GUID);

            List<PortMappingInfo> info = d.getPortMapping(eqp);

            for (PortMappingInfo portMappingInfo : info) {
                SoutUtil.print(portMappingInfo);
            }

            assertTrue(true);

        } catch (Exception ex) {
            ex.printStackTrace();
            assertTrue(false);
        }
    }
}