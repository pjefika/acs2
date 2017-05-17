/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitario.equipamento.acao;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.EquipamentoDAO;
import init.EquipamentoTestValues;
import model.device.serviceclass.ServiceClass;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SetServiceClassJUnitTest {

    public SetServiceClassJUnitTest() {
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
    public void setServiceClass() {
        try {
            EquipamentoDAO d = new EquipamentoDAO();
            NbiDeviceData eqp;
            eqp = d.findDeviceByGUID(EquipamentoTestValues.GUID);
            //eqp = d.findDeviceByGUID(new Long(74021));
            ServiceClass sc = new ServiceClass();
            sc.setClassOfService("service02");
            Boolean b = d.setServiceClass(eqp, sc);
            assertTrue(b);
            sc = d.getServiceClass(eqp);
            System.out.println(sc.getClassOfService());            
            //System.out.println(sc.getClassOfService());
            //assertTrue(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            assertTrue(false);
        }
    }
}
