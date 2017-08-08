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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.device.DmzInfo;
import model.device.ddns.DdnsInfo;
import model.device.dhcp.Dhcp;
import model.device.firmware.FirmwareInfo;
import model.device.interfacestatistics.InterfaceStatistics;
import model.device.lanhost.LanDevice;
import model.device.log.DeviceLog;
import model.device.log.DeviceLogR;
import model.device.ping.PingRequest;
import model.device.ping.PingResponse;
import model.device.portmapping.PortMappingInfo;
import model.device.pppoe.PPPoECredentialsInfo;
import model.device.sipdiagnostics.SipDiagnostics;
import model.device.traceroute.TraceRouteRequest;
import model.device.wan.WanInfo;
import model.device.wifi.WifiInfoFull;
import model.device.xdsldiagnostics.XdslDiagnostics;
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
public class SynchDeviceDAOIT_Consultas extends EquipamentoTestValues {

    private SynchDeviceDAO instance = FactoryDAO.createSynch();
    private NbiDAO nbi = FactoryDAO.createNBI();
    private NbiDeviceData eqp;

    public SynchDeviceDAOIT_Consultas() {
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
            } catch (NBIException_Exception ex) {
                Logger.getLogger(SynchDeviceDAOIT_Consultas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @After
    public void tearDown() {
        try {
            System.out.println("sleep");
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(SynchDeviceDAOIT_Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of checkOnline method, of class SynchDeviceDAO.
     */
    @Test
    public void testCheckOnline() throws Exception {
        try {
            System.out.println("checkOnline");
            Boolean expResult = true;
            Boolean result = instance.checkOnline(eqp);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test of getFirmwareVersion method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetFirmwareVersion() throws Exception {
        try {
            System.out.println("getFirmwareVersion");
            FirmwareInfo result = instance.getFirmwareVersion(eqp);
            System.out.println("Retorno: " + GsonUtil.serialize(result));
            assertTrue(result != null);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test of getWanInfo method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetWanInfo() {
        try {
            System.out.println("getWanInfo");
            WanInfo result = instance.getWanInfo(eqp);
            System.out.println("Retorno: " + GsonUtil.serialize(result));
            assertTrue(result != null);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test of getLanHosts method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetLanHosts() {
        try {
            System.out.println("getLanHosts");
            List<LanDevice> result = instance.getLanHosts(eqp);
            System.out.println("Retorno: " + GsonUtil.serialize(result));
            assertTrue(result != null);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test of getDmzInfo method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetDmzInfo() {
        try {
            System.out.println("getDmzInfo");
            DmzInfo result = instance.getDmzInfo(eqp);
            System.out.println("Retorno: " + GsonUtil.serialize(result));
            assertTrue(result != null);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test of getWifiInfoFull method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetWifiInfoFull() throws Exception {
        System.out.println("getWifiInfoFull");
        WifiInfoFull result = instance.getWifiInfoFull(eqp);
        System.out.println("Retorno: " + GsonUtil.serialize(result));
        assertTrue(result != null);
    }

    /**
     * Test of getPortMapping method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetPortMapping() throws Exception {
        try {
            System.out.println("getPortMapping");
            List<PortMappingInfo> result = instance.getPortMapping(eqp);
            System.out.println("Retorno: " + GsonUtil.serialize(result));
            assertTrue(result != null);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test of getDhcp method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetDhcp() {
        try {
            System.out.println("getDhcp");
            Dhcp result = instance.getDhcp(eqp);
            System.out.println("Retorno: " + GsonUtil.serialize(result));
            assertTrue(result != null);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test of traceroute method, of class SynchDeviceDAO.
     */
    @Test
    public void testTraceroute() {
        try {
            System.out.println("traceroute");
            PortMappingInfo result = instance.traceroute(eqp, new TraceRouteRequest("www.google.com.br"));
            System.out.println("Retorno: " + GsonUtil.serialize(result));
            assertTrue(result != null);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test of getDdns method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetDdns() throws Exception {
        try {
            System.out.println("traceroute");
            PortMappingInfo result = instance.traceroute(eqp, new TraceRouteRequest("www.google.com.br"));
            System.out.println("Retorno: " + GsonUtil.serialize(result));
            assertTrue(result != null);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test of getXdslDiagnostic method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetXdslDiagnostic() throws Exception {
        try {
            System.out.println("getXdslDiagnostic");
            XdslDiagnostics result = instance.getXdslDiagnostic(eqp);
            System.out.println("Retorno: " + GsonUtil.serialize(result));
            assertTrue(result != null);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test of getDeviceLog method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetDeviceLog() throws Exception {
        System.out.println("getDeviceLog");

        List<DeviceLog> expResult = null;
        List<DeviceLog> result = instance.getDeviceLog(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeviceLogR method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetDeviceLogR() throws Exception {
        try {
            System.out.println("getDeviceLogR");
            List<DeviceLogR> expResult = null;
            List<DeviceLogR> result = instance.getDeviceLogR(eqp);
            assertTrue(!result.isEmpty());
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }

    }

    /**
     * Test of getInterfaceStatistics method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetInterfaceStatistics() throws Exception {
        try {
            System.out.println("getInterfaceStatistics");
            List<InterfaceStatistics> expResult = null;
            List<InterfaceStatistics> result = instance.getInterfaceStatistics(eqp);
            assertTrue(!result.isEmpty());

        } catch (Exception e) {
            fail("The test case is a prototype.");
        }

    }

    /**
     * Test of getPPPoECredentials method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetPPPoECredentials() throws Exception {
        try {
            System.out.println("getPPPoECredentials");
            PPPoECredentialsInfo result = instance.getPPPoECredentials(eqp);
            assertTrue(!result.getUsername().isEmpty());
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

    /**
     * Test of pingDiagnostic method, of class SynchDeviceDAO.
     */
    @Test
    public void testPingDiagnostic() throws Exception {
        System.out.println("pingDiagnostic");
        try {
            PingRequest p = new PingRequest();
            p.setDestAddress("www.google.com.br");
            PingResponse result = instance.pingDiagnostic(eqp, p);
            assertTrue(result.getStatus().equalsIgnoreCase("Complete"));
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

    /**
     * Test of getSipDiagnostics method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetSipDiagnostics() {
        try {
            System.out.println("getSipDiagnostics");
            SipDiagnostics result = instance.getSipDiagnostics(eqp, 1);
            assertTrue(result != null);
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

}
