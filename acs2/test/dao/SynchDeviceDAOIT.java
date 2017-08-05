/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.alcatel.hdm.service.nbi2.NBIException_Exception;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.factory.FactoryDAO;
import init.EquipamentoTestValues;
import java.util.List;
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
import model.device.sipactivation.SipActivation;
import model.device.sipdiagnostics.SipDiagnostics;
import model.device.traceroute.TraceRouteRequest;
import model.device.wan.WanInfo;
import model.device.wifi.WifiInfoFull;
import model.device.xdsldiagnostics.XdslDiagnostics;
import motive.hdm.synchdeviceops.ParameterValueStructDTO;
import motive.hdm.synchdeviceops.StringResponseDTO;
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
public class SynchDeviceDAOIT extends EquipamentoTestValues {

    private SynchDeviceDAO instance = FactoryDAO.createSynch();
    private NbiDAO nbi = FactoryDAO.createNBI();
    private NbiDeviceData eqp;

    public SynchDeviceDAOIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws NBIException_Exception {
        eqp = nbi.findDeviceByGUID(this.GUID);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of reboot method, of class SynchDeviceDAO.
     */
    @Test
    public void testReboot() throws Exception {
        System.out.println("reboot");

        Boolean expResult = null;
        Boolean result = instance.reboot(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of factoryReset method, of class SynchDeviceDAO.
     */
    @Test
    public void testFactoryReset() throws Exception {
        System.out.println("factoryReset");

        Boolean expResult = null;
        Boolean result = instance.factoryReset(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkOnline method, of class SynchDeviceDAO.
     */
    @Test
    public void testCheckOnline() throws Exception {
        System.out.println("checkOnline");
        Boolean expResult = true;
        Boolean result = instance.checkOnline(eqp);
        assertEquals(expResult, result);
    }

    /**
     * Test of getFirmwareVersion method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetFirmwareVersion() throws Exception {
        System.out.println("getFirmwareVersion");
        FirmwareInfo result = instance.getFirmwareVersion(eqp);
        assertTrue(result != null);
    }

    /**
     * Test of getParameters method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetParameters() throws Exception {
        System.out.println("getParameters");

        instance.getParameters(eqp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParametersWifi method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetParametersWifi() throws Exception {
        System.out.println("getParametersWifi");

        instance.getParametersWifi(eqp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParametersValues method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetParametersValues() throws Exception {
        System.out.println("getParametersValues");

        List<String> paths = null;

        instance.getParametersValues(eqp, paths);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParameterValue method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetParameterValue() throws Exception {
        System.out.println("getParameterValue");

        String path = "";

        instance.getParameterValue(eqp, path);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setParametersValues method, of class SynchDeviceDAO.
     */
    @Test
    public void testSetParametersValues() throws Exception {
        System.out.println("setParametersValues");

        ParameterValueStructDTO p = null;

        instance.setParametersValues(eqp, p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWanInfo method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetWanInfo() throws Exception {
        System.out.println("getWanInfo");

        WanInfo expResult = null;
        WanInfo result = instance.getWanInfo(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getServiceClass method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetServiceClass() throws Exception {
        System.out.println("getServiceClass");

        ServiceClass expResult = null;
        ServiceClass result = instance.getServiceClass(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setServiceClass method, of class SynchDeviceDAO.
     */
    @Test
    public void testSetServiceClass() throws Exception {
        System.out.println("setServiceClass");

        ServiceClass sc = null;

        Boolean expResult = null;
        Boolean result = instance.setServiceClass(eqp, sc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLanHosts method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetLanHosts() throws Exception {
        System.out.println("getLanHosts");

        List<LanDevice> expResult = null;
        List<LanDevice> result = instance.getLanHosts(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDmzInfo method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetDmzInfo() throws Exception {
        System.out.println("getDmzInfo");

        DmzInfo expResult = null;
        DmzInfo result = instance.getDmzInfo(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWifiInfoFull method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetWifiInfoFull() throws Exception {
        System.out.println("getWifiInfoFull");

        WifiInfoFull expResult = null;
        WifiInfoFull result = instance.getWifiInfoFull(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPortMapping method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetPortMapping() throws Exception {
        System.out.println("getPortMapping");

        List<PortMappingInfo> expResult = null;
        List<PortMappingInfo> result = instance.getPortMapping(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDhcp method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetDhcp() throws Exception {
        System.out.println("getDhcp");

        Dhcp expResult = null;
        Dhcp result = instance.getDhcp(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDhcp method, of class SynchDeviceDAO.
     */
    @Test
    public void testSetDhcp() throws Exception {
        System.out.println("setDhcp");

        Dhcp dh = null;

        Boolean expResult = null;
        Boolean result = instance.setDhcp(eqp, dh);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of traceroute method, of class SynchDeviceDAO.
     */
    @Test
    public void testTraceroute() throws Exception {
        System.out.println("traceroute");

        TraceRouteRequest trace = null;

        PortMappingInfo expResult = null;
        PortMappingInfo result = instance.traceroute(eqp, trace);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWifiInfoFull method, of class SynchDeviceDAO.
     */
    @Test
    public void testSetWifiInfoFull() throws Exception {
        System.out.println("setWifiInfoFull");

        WifiInfoFull wifi = null;

        Boolean expResult = null;
        Boolean result = instance.setWifiInfoFull(eqp, wifi);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDdns method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetDdns() throws Exception {
        System.out.println("getDdns");

        DdnsInfo expResult = null;
        DdnsInfo result = instance.getDdns(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getXdslDiagnostic method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetXdslDiagnostic() throws Exception {
        System.out.println("getXdslDiagnostic");

        XdslDiagnostics expResult = null;
        XdslDiagnostics result = instance.getXdslDiagnostic(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        System.out.println("getDeviceLogR");

        List<DeviceLogR> expResult = null;
        List<DeviceLogR> result = instance.getDeviceLogR(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInterfaceStatistics method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetInterfaceStatistics() throws Exception {
        System.out.println("getInterfaceStatistics");

        List<InterfaceStatistics> expResult = null;
        List<InterfaceStatistics> result = instance.getInterfaceStatistics(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPPPoECredentials method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetPPPoECredentials() throws Exception {
        System.out.println("getPPPoECredentials");

        PPPoECredentialsInfo expResult = null;
        PPPoECredentialsInfo result = instance.getPPPoECredentials(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pingDiagnostic method, of class SynchDeviceDAO.
     */
    @Test
    public void testPingDiagnostic() throws Exception {
        System.out.println("pingDiagnostic");

        PingRequest p = null;

        PingResponse expResult = null;
        PingResponse result = instance.pingDiagnostic(eqp, p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPPPoECredentials method, of class SynchDeviceDAO.
     */
    @Test
    public void testSetPPPoECredentials() throws Exception {
        System.out.println("setPPPoECredentials");

        PPPoECredentialsInfo pPPoECredentialsInfo = null;

        StringResponseDTO expResult = null;
        StringResponseDTO result = instance.setPPPoECredentials(eqp, pPPoECredentialsInfo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPortMapping method, of class SynchDeviceDAO.
     */
    @Test
    public void testSetPortMapping() throws Exception {
        System.out.println("setPortMapping");

        List<PortMappingInfo> ports = null;

        Boolean expResult = null;
        Boolean result = instance.setPortMapping(eqp, ports);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSipDiagnostics method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetSipDiagnostics() throws Exception {
        System.out.println("getSipDiagnostics");

        Integer phyref = null;

        SipDiagnostics expResult = null;
        SipDiagnostics result = instance.getSipDiagnostics(eqp, phyref);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSipActivation method, of class SynchDeviceDAO.
     */
    @Test
    public void testSetSipActivation() throws Exception {
        System.out.println("setSipActivation");

        SipActivation sip = null;

        Boolean expResult = null;
        Boolean result = instance.setSipActivation(eqp, sip);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
