/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitario.equipamento.acao;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.EquipamentoDAO;
import model.device.firmware.FirmwareInfo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import init.EquipamentoTestValues;
import util.SoutUtil;

/**
 *
 * @author G0042204
 */
public class FirmwareUpdateJUnitTest {

    public FirmwareUpdateJUnitTest() {
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
    public void firmwareUpdate() {
        try {
            EquipamentoDAO d = new EquipamentoDAO();
            NbiDeviceData eqp;
            eqp = d.findDeviceByGUID(EquipamentoTestValues.GUID);
            SoutUtil.print(eqp);

//            FirmwareInfo oi = d.getFirmwareVersion(eqp);
            FirmwareInfo oi = new FirmwareInfo("B14103-GVT-RC2-103140", "B14103-GVT-RC2-102360");

            SoutUtil.print(oi);

            Thread.sleep(15000);

            Long oper = d.firmwareUpdate(eqp, oi);

            System.out.println("oper: " + oper);

            assertTrue(oper != null);

        } catch (Exception ex) {
            ex.printStackTrace();
            assertTrue(false);
        }
    }
}
