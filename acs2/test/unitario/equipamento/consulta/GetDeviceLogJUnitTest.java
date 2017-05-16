/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitario.equipamento.consulta;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.EquipamentoDAO;
import init.EquipamentoTestValues;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.device.log.DeviceLogR;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
            List<DeviceLogR> log = d.getDeviceLogR(eqp);
            for (DeviceLogR deviceLogR : log) {
                System.out.println("Index: " + deviceLogR.getIndex());
                System.out.println("Time: " + deviceLogR.getTime());
                System.out.println("Type: " + deviceLogR.getType());
                System.out.println("Servity: " + deviceLogR.getServity());
                System.out.println("LogInformation: " + deviceLogR.getLogInformation());
                System.out.println("------------------------------------------");
            }
            assertTrue(true);
        } catch (Exception ex) {
            Logger.getLogger(GetDeviceLogJUnitTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }
    }
}
