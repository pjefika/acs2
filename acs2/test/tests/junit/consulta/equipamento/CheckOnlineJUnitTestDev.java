/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.junit.consulta.equipamento;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.EquipamentoDAO;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tests.junit.init.EquipamentoTestValues;

/**
 *
 * @author G0042204
 */
public class CheckOnlineJUnitTestDev {

    public CheckOnlineJUnitTestDev() {
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
    public void checkOnline() {

        try {
            EquipamentoDAO d = new EquipamentoDAO();

            NbiDeviceData eqp;
//            eqp = d.findDeviceByGUID(new Long(142012));
//            eqp = d.findDeviceByGUID(new Long(23006));
            eqp = d.findDeviceByGUID(EquipamentoTestValues.GUID);
//            eqp = d.findDeviceByGUID(new Long(23006));
//            eqp = d.findDeviceByGUID(new Long(23006));

            Boolean r = d.checkOnline(eqp);

            assertTrue(r);

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }

    }
}
