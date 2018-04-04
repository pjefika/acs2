/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl.parameter;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.device.SynchDeviceDAOImpl;
import init.SingletonDeviceTest;
import java.util.List;
import motive.hdm.synchdeviceops.ParameterInfoStructDTO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.GsonUtil;

/**
 *
 * @author G0042204
 */
public class ParameterServiceImplIT {

    private final NbiDeviceData eqp = SingletonDeviceTest.getInstance().getDevice();
    private ParameterServiceImpl instance = new ParameterServiceImpl();

    public ParameterServiceImplIT() {
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
     * Test of getParameters method, of class ParameterServiceImpl.
     */
    @Test
    public void testGetParameters() {
        try {
            System.out.println("getParameters");
            List<ParameterInfoStructDTO> result = instance.getParameters(eqp);
            System.out.println(GsonUtil.serialize(result));
            assertTrue(result != null);
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

}
