/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.device;

import dto.nbi.service.hdm.alcatel.com.NBITemplate;
import java.rmi.RemoteException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author G0042204
 */
public class RemoteDAOImplIT {

    private RemoteDAOImpl instance = new RemoteDAOImpl();

    public RemoteDAOImplIT() {
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
     * Test of firmwareUpdate method, of class RemoteDAOImpl.
     *
     * @throws java.rmi.RemoteException
     */
    @Test
    public void test() throws RemoteException {
        try {
            NBITemplate[] templates = instance.getAvailableCriteriaTemplates();
            System.out.println("end");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
