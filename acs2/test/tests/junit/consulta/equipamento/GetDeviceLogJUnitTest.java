/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.junit.consulta.equipamento;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.EquipamentoDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.device.log.DeviceLog;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tests.junit.init.EquipamentoTestValues;
import util.SoutUtil;

/**
 *
 * @author G0042204
 */
public class GetDeviceLogJUnitTest {

    public GetDeviceLogJUnitTest() {
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
    public void getDeviceLog() {

        try {
            EquipamentoDAO d = new EquipamentoDAO();

            Long l = EquipamentoTestValues.GUID;
            NbiDeviceData eqp;
            eqp = d.findDeviceByGUID(l);

            //d.capture(l);
            // d.release(l);
            List<DeviceLog> log = d.getDeviceLog(eqp);

            SoutUtil.printl(log);

            assertTrue(log.size() > 1);

        } catch (Exception ex) {
            Logger.getLogger(GetDeviceLogJUnitTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);

        }

    }
}