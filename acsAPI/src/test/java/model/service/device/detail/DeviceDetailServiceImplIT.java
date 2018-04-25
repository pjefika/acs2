/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.detail;

import br.net.gvt.efika.util.json.JacksonMapper;
import init.EquipamentoTestValues;
import model.service.dto.DetailOut;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
//import util.GsonUtil;

/**
 *
 * @author G0042204
 */
public class DeviceDetailServiceImplIT extends EquipamentoTestValues {

    public DeviceDetailServiceImplIT() {
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

    /**
     * Test of consultar method, of class DeviceDetailServiceImpl.
     */
    @Test
    public void testConsultar() throws Exception {
        try {
            System.out.println("consultar");
            DeviceDetailServiceImpl instance = new DeviceDetailServiceImpl();
            DetailOut result = instance.consultar(GUID);
            System.out.println(new JacksonMapper(DetailOut.class).serialize(result));
            assertEquals("Online", true, result.getOnline());
            assertEquals("Updated", result.getFirmware().getUpdated(), true);
//            assertEquals("FirmwareUpdated", result.getFirmware().getUpdated(), true);

        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

    }

}
