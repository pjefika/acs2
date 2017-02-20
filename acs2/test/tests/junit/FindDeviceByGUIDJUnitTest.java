/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.junit;

import com.alcatel.hdm.service.nbi2.NBIException_Exception;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.EquipamentoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tests.dev;
import util.SoutUtil;

/**
 *
 * @author G0042204
 */
public class FindDeviceByGUIDJUnitTest {

    public FindDeviceByGUIDJUnitTest() {
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
    public void findDeviceByGUID() {

        try {
            EquipamentoDAO d = new EquipamentoDAO();

            NbiDeviceData eqp;

            eqp = d.findDeviceByGUID(new Long(94015));
            SoutUtil.print(eqp);
            assertTrue(true);
        } catch (NBIException_Exception ex) {
            Logger.getLogger(dev.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }
    }
}
