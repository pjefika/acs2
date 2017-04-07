/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitario.equipamento.consulta;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.EquipamentoDAO;
import init.EquipamentoTestValues;
import model.device.firmware.FirmwareInfo;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import util.SoutUtil;

/**
 *
 * @author G0042204
 */
public class GetFirmwareVersionJUnitTestDev {

    public GetFirmwareVersionJUnitTestDev() {
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
    public void getFirmwareVersion() {

        try {

            EquipamentoDAO d = new EquipamentoDAO();

            //d.capture(guid);
            //d.release(guid);
            NbiDeviceData eqp;
            eqp = d.findDeviceByGUID(EquipamentoTestValues.GUID);
            SoutUtil.print(eqp);

            FirmwareInfo firmwareVersion = d.getFirmwareVersion(eqp);

            SoutUtil.print(firmwareVersion);
            System.out.println("firmwareVersion::isOk(): " + firmwareVersion.isOk());

        } catch (Exception ex) {
            ex.printStackTrace();
            assertTrue(false);
        }

    }
}
