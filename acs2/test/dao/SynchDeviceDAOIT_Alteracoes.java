/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.device.SynchDeviceDAO;
import dao.device.NbiDAO;
import com.alcatel.hdm.service.nbi2.NBIException_Exception;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.factory.FactoryDAO;
import init.EquipamentoTestValues;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.device.dhcp.Dhcp;
import model.device.portmapping.PortMappingInfo;
import model.device.pppoe.PPPoECredentialsInfoOut;
import model.device.serviceclass.ServiceClass;
import model.device.sipactivation.SipActivation;
import model.device.wifi.WifiInfoFull;
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
public class SynchDeviceDAOIT_Alteracoes extends EquipamentoTestValues {

    private SynchDeviceDAO instance = FactoryDAO.createSynch();
    private NbiDAO nbi = FactoryDAO.createNBI();
    private NbiDeviceData eqp;

    public SynchDeviceDAOIT_Alteracoes() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws NBIException_Exception {
        if (eqp == null) {
            System.out.println("Consultando...");
            try {
                eqp = nbi.findDeviceByGUID(GUID);
                System.out.println("Retorno: " + GsonUtil.serialize(eqp));
            } catch (NBIException_Exception ex) {
                Logger.getLogger(SynchDeviceDAOIT_Alteracoes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @After
    public void tearDown() {
        try {
            System.out.println("sleep");
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(SynchDeviceDAOIT_Alteracoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of reboot method, of class SynchDeviceDAO.
     */
    @Test
    public void testReboot() throws Exception {
        try {
            System.out.println("reboot");
            Boolean expResult = true;
            Boolean result = instance.reboot(eqp);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test of factoryReset method, of class SynchDeviceDAO.
     */
    @Test
    public void testFactoryReset() throws Exception {
        try {
            System.out.println("factoryReset");
            Boolean expResult = true;
            Boolean result = instance.factoryReset(eqp);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test of setServiceClass method, of class SynchDeviceDAO.
     */
    @Test
    public void testSetServiceClass() throws Exception {
        try {
            System.out.println("setServiceClass");
            ServiceClass sc = instance.getServiceClass(eqp);
            Boolean expResult = true;
            Boolean result = instance.setServiceClass(eqp, sc);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test of setDhcp method, of class SynchDeviceDAO.
     */
    @Test
    public void testSetDhcp() throws Exception {
        try {
            System.out.println("setDhcp");
            Boolean expResult = true;
            Dhcp d = instance.getDhcp(eqp);
            Boolean result = instance.setDhcp(eqp, d);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test of setWifiInfoFull method, of class SynchDeviceDAO.
     */
    @Test
    public void testSetWifiInfoFull() throws Exception {
        try {
            System.out.println("setWifiInfoFull");
            Boolean expResult = true;
            WifiInfoFull w = instance.getWifiInfoFull(eqp);
            Boolean result = instance.setWifiInfoFull(eqp, w);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test of setPPPoECredentials method, of class SynchDeviceDAO.
     * 
     * Retornando O CPE não suporta o(s) parâmetro(s) solicitados.
     */
    @Test
    public void testSetPPPoECredentials() throws Exception {
        try {
            System.out.println("setPPPoECredentials");
            Boolean expResult = true;
            PPPoECredentialsInfoOut p = new PPPoECredentialsInfoOut(instance.getPPPoECredentials(eqp));
            Boolean result = instance.setPPPoECredentials(eqp, p);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test of setPortMapping method, of class SynchDeviceDAO.
     */
    @Test
    public void testSetPortMapping() throws Exception {
        try {
            System.out.println("setPortMapping");
            Boolean expResult = true;
            List<PortMappingInfo> l = new ArrayList<>();
            Boolean result = instance.setPortMapping(eqp, l);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test of setSipActivation method, of class SynchDeviceDAO.
     */
    @Test
    public void testSetSipActivation() throws Exception {
        try {
            System.out.println("setSipActivation");
            Boolean expResult = true;
            SipActivation s = new SipActivation();
            Boolean result = instance.setSipActivation(eqp, s);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
