/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.device;

import dao.device.SynchDeviceDAO;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.factory.FactoryDAO;
import init.EquipamentoTestValues;
import init.SingletonDeviceTest;
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
import model.device.serviceclass.ServiceClass;
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

/**
 *
 * @author G0042204
 */
public class SynchDeviceDAOIT_Consultas extends EquipamentoTestValues {

    private final SynchDeviceDAO instance = FactoryDAO.createSynch();
    private final NbiDeviceData eqp = SingletonDeviceTest.getInstance().getDevice();

    public SynchDeviceDAOIT_Consultas() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
//        if (eqp == null) {
//            System.out.println("Consultando...");
//            try {
//                eqp = nbi.findDeviceByGUID(GUID);
//                System.out.println("Retorno: " + GsonUtil.serialize(eqp));
//            } catch (NBIException_Exception ex) {
//                Logger.getLogger(SynchDeviceDAOIT_Consultas.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
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
    public void testCheckOnline() {
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
    public void testGetFirmwareVersion() {
        try {
            System.out.println("getFirmwareVersion");
            FirmwareInfo result = instance.getFirmwareVersion(eqp);
//            System.out.println("Retorno: " + GsonUtil.serialize(result));
            assertTrue(result != null);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testGetServiceClass() {
        try {
            System.out.println("getFirmwareVersion");
            ServiceClass result = instance.getServiceClass(eqp);
//            System.out.println("Retorno: " + GsonUtil.serialize(result));
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
//            System.out.println("Retorno: " + GsonUtil.serialize(result));
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
//            System.out.println("Retorno: " + GsonUtil.serialize(result));
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
//            System.out.println("Retorno: " + GsonUtil.serialize(result));
            assertTrue(result != null);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test of getWifiInfoFull method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetWifiInfoFull() {
        try {
            System.out.println("getWifiInfoFull");
//            WifiInfoFull result = instance.getWifiInfoFull(eqp);
//            System.out.println("Retorno: " + GsonUtil.serialize(result));
//            assertTrue(result != null);
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

    /**
     * Test of getPortMapping method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetPortMapping() {
        try {
            System.out.println("getPortMapping");
            List<PortMappingInfo> result = instance.getPortMapping(eqp);
//            System.out.println("Retorno: " + GsonUtil.serialize(result));
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
//            System.out.println("Retorno: " + GsonUtil.serialize(result));
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
//            System.out.println("Retorno: " + GsonUtil.serialize(result));
            assertTrue(result != null);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test of getDdns method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetDdns() {
        try {
            System.out.println("testGetDdns");
            DdnsInfo result = instance.getDdns(eqp);
//            System.out.println("Retorno: " + GsonUtil.serialize(result));
            assertTrue(result != null);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test of getXdslDiagnostic method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetXdslDiagnostic() {
        try {
            System.out.println("getXdslDiagnostic");
            XdslDiagnostics result = instance.getXdslDiagnostic(eqp);
//            System.out.println("Retorno: " + GsonUtil.serialize(result));
            assertTrue(result != null);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test of getDeviceLog method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetDeviceLog() {
        try {
            System.out.println("getDeviceLog");
            List<DeviceLog> result = instance.getDeviceLog(eqp);
//            System.out.println("Retorno: " + GsonUtil.serialize(result));
            assertTrue(!result.isEmpty());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test of getDeviceLogR method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetDeviceLogR() {
        try {
            System.out.println("getDeviceLogR");
//            List<DeviceLogR> result = instance.getDeviceLogR(eqp);
//            System.out.println("Retorno: " + GsonUtil.serialize(result));
//            assertTrue(!result.isEmpty());
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }

    }

    /**
     * Test of getInterfaceStatistics method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetInterfaceStatistics() {
        try {
            System.out.println("getInterfaceStatistics");
            List<InterfaceStatistics> result = instance.getInterfaceStatistics(eqp);
//            System.out.println("Retorno: " + GsonUtil.serialize(result));

            assertTrue(!result.isEmpty());

        } catch (Exception e) {
            fail("The test case is a prototype.");
        }

    }

    /**
     * Test of getPPPoECredentials method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetPPPoECredentials() {
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
    public void testPingDiagnostic() {
        System.out.println("pingDiagnostic");
        try {
            PingRequest p = new PingRequest();
            p.setDestAddress("www.google.com.br");
            PingResponse result = instance.pingDiagnostic(eqp, p);
//            System.out.println("Retorno: " + GsonUtil.serialize(result));
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
//            System.out.println("leSIP: " + GsonUtil.serialize(result));
            assertTrue(result != null);
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());
        }

    }

}
