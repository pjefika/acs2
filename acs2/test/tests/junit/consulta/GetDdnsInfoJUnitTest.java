/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.junit.consulta;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.EquipamentoDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.device.ddns.DdnsInfo;
import model.device.log.DeviceLog;
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
public class GetDdnsInfoJUnitTest {

    public GetDdnsInfoJUnitTest() {
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

            Long l = new Long(90024);
            NbiDeviceData eqp;
            eqp = d.findDeviceByGUID(l);

            //d.capture(l);
            // d.release(l);
            DdnsInfo ddns = d.getDdns(eqp);

            SoutUtil.print(ddns);

            assertTrue(true);

        } catch (Exception ex) {
            Logger.getLogger(GetDdnsInfoJUnitTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }

    }
}
