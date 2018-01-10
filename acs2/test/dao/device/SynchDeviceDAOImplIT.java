/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.device;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import init.SingletonDeviceTest;
import java.util.ArrayList;
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
import model.service.device.impl.parameter.SetParameters;
import motive.hdm.synchdeviceops.GetParameterAttributesResponseDTO;
import motive.hdm.synchdeviceops.GetParameterValuesResponseDTO;
import motive.hdm.synchdeviceops.ParameterInfoStructDTO;
import motive.hdm.synchdeviceops.ParameterValueStructDTO;
import motive.hdm.synchdeviceops.StringResponseDTO;
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
public class SynchDeviceDAOImplIT {

    private final SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
    private final NbiDeviceData eqp = SingletonDeviceTest.getInstance().getDevice();

    public SynchDeviceDAOImplIT() {
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
     * Test of reboot method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testReboot() throws Exception {
        System.out.println("reboot");

        SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
        Boolean expResult = null;
        Boolean result = instance.reboot(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of factoryReset method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testFactoryReset() throws Exception {
        System.out.println("factoryReset");

        SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
        Boolean expResult = null;
        Boolean result = instance.factoryReset(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkOnline method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testCheckOnline() throws Exception {
        System.out.println("checkOnline");

        SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
        Boolean expResult = null;
        Boolean result = instance.checkOnline(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirmwareVersion method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testGetFirmwareVersion() throws Exception {
        System.out.println("getFirmwareVersion");

        SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
        FirmwareInfo expResult = null;
        FirmwareInfo result = instance.getFirmwareVersion(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParameters method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testGetParameters() throws Exception {
        try {
            System.out.println("getParameters");
            SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
            List<ParameterInfoStructDTO> parameters = instance.getParameters(eqp);
            System.out.println(GsonUtil.serialize(parameters));
            assertTrue("Cheio", !parameters.isEmpty());
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());

        }
    }

    @Test
    public void testGetParametersValuesDownloadDiagnostics() {
        try {
            System.out.println("getParametersValues");
            List<String> paths = new ArrayList<>();
            paths.add("InternetGatewayDevice.DownloadDiagnostics.");
            GetParameterValuesResponseDTO parameters = instance.getParametersValues(eqp, paths);
            System.out.println(GsonUtil.serialize(parameters));
            assertTrue("Cheio", parameters != null);
        } catch (Exception e) {
            fail(e.getMessage());
        }

        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getParametersValues method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testGetParametersValues() {
        try {
            System.out.println("getParametersValues");
            List<String> paths = new ArrayList<>();
            paths.add("InternetGatewayDevice.LANDevice.1.WLANConfiguration.");

            GetParameterValuesResponseDTO parameters = instance.getParametersValues(eqp, paths);
            System.out.println(GsonUtil.serialize(parameters));
            assertTrue("Cheio", parameters != null);
        } catch (Exception e) {
            fail(e.getMessage());
        }

        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testMethod() {
        try {
            System.out.println("getParameterAttributes");
            String paths = "InternetGatewayDevice.LANDevice.1.WLANConfiguration.1.Enable";
            GetParameterAttributesResponseDTO parameters = instance.getParameterAttributes(eqp, paths);
            System.out.println(GsonUtil.serialize(parameters));
            assertTrue("Cheio", parameters != null);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test of getParameterValue method, of class SynchDeviceDAOImpl.
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
     * Test of getWanInfo method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testGetWanInfo() throws Exception {
        System.out.println("getWanInfo");

        SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
        WanInfo expResult = null;
        WanInfo result = instance.getWanInfo(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getServiceClass method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testGetServiceClass() throws Exception {
        System.out.println("getServiceClass");

        SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
        ServiceClass expResult = null;
        ServiceClass result = instance.getServiceClass(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setServiceClass method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testSetServiceClass() throws Exception {
        System.out.println("setServiceClass");

        ServiceClass sc = null;
        SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
        Boolean expResult = null;
        Boolean result = instance.setServiceClass(eqp, sc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLanHosts method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testGetLanHosts() throws Exception {
        System.out.println("getLanHosts");

        SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
        List<LanDevice> expResult = null;
        List<LanDevice> result = instance.getLanHosts(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDmzInfo method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testGetDmzInfo() throws Exception {
        System.out.println("getDmzInfo");

        SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
        DmzInfo expResult = null;
        DmzInfo result = instance.getDmzInfo(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWifiInfoFull method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testGetWifiInfoFull() throws Exception {
        System.out.println("getWifiInfoFull");

        SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
        WifiInfoFull expResult = null;
        WifiInfoFull result = instance.getWifiInfoFull(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPortMapping method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testGetPortMapping() throws Exception {
        System.out.println("getPortMapping");

        SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
        List<PortMappingInfo> expResult = null;
        List<PortMappingInfo> result = instance.getPortMapping(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDhcp method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testGetDhcp() throws Exception {
        System.out.println("getDhcp");

        SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
        Dhcp expResult = null;
        Dhcp result = instance.getDhcp(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDhcp method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testSetDhcp() throws Exception {
        System.out.println("setDhcp");

        Dhcp dh = null;
        SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
        Boolean expResult = null;
        Boolean result = instance.setDhcp(eqp, dh);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of traceroute method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testTraceroute() throws Exception {
        System.out.println("traceroute");

        TraceRouteRequest trace = null;
        SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
        PortMappingInfo expResult = null;
        PortMappingInfo result = instance.traceroute(eqp, trace);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWifiInfoFull method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testSetWifiInfoFull() throws Exception {
        System.out.println("setWifiInfoFull");

        WifiInfoFull wifi = null;
        SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
        Boolean expResult = null;
        Boolean result = instance.setWifiInfoFull(eqp, wifi);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDdns method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testGetDdns() throws Exception {
        System.out.println("getDdns");

        SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
        DdnsInfo expResult = null;
        DdnsInfo result = instance.getDdns(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getXdslDiagnostic method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testGetXdslDiagnostic() throws Exception {
        System.out.println("getXdslDiagnostic");

        SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
        XdslDiagnostics expResult = null;
        XdslDiagnostics result = instance.getXdslDiagnostic(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeviceLog method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testGetDeviceLog() throws Exception {
        System.out.println("getDeviceLog");

        SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
        List<DeviceLog> expResult = null;
        List<DeviceLog> result = instance.getDeviceLog(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeviceLogR method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testGetDeviceLogR() throws Exception {
        System.out.println("getDeviceLogR");

        SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
        List<DeviceLogR> expResult = null;
        List<DeviceLogR> result = instance.getDeviceLogR(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInterfaceStatistics method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testGetInterfaceStatistics() throws Exception {
        System.out.println("getInterfaceStatistics");

        SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
        List<InterfaceStatistics> expResult = null;
        List<InterfaceStatistics> result = instance.getInterfaceStatistics(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPPPoECredentials method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testGetPPPoECredentials() throws Exception {
        System.out.println("getPPPoECredentials");

        SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
        PPPoECredentialsInfo expResult = null;
        PPPoECredentialsInfo result = instance.getPPPoECredentials(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pingDiagnostic method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testPingDiagnostic() throws Exception {
        System.out.println("pingDiagnostic");

        PingRequest p = null;
        SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
        PingResponse expResult = null;
        PingResponse result = instance.pingDiagnostic(eqp, p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPPPoECredentials method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testSetPPPoECredentials() throws Exception {
        System.out.println("setPPPoECredentials");

        PPPoECredentialsInfo pPPoECredentialsInfo = null;
        SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
        StringResponseDTO expResult = null;
//        StringResponseDTO result = instance.setPPPoECredentials(eqp, pPPoECredentialsInfo);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetParameters() {
        try {
            List<ParameterValueStructDTO> lst = new ArrayList<>();
            lst.add(SetParameters.DOWNLOAD_URL);
            lst.add(SetParameters.INICIAR_DOWNLOAD_DIAGNOSTICS);
            instance.setParametersValues(eqp, lst);
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

    /**
     * Test of setPortMapping method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testSetPortMapping() throws Exception {
        System.out.println("setPortMapping");

        List<PortMappingInfo> ports = null;
        SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
        Boolean expResult = null;
        Boolean result = instance.setPortMapping(eqp, ports);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSipDiagnostics method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testGetSipDiagnostics() throws Exception {
        try {
            System.out.println("getSipDiagnostics");
            Integer phyref = 1;
            SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
            SipDiagnostics result = instance.getSipDiagnostics(eqp, phyref);
            System.out.println("--------");
            System.out.println(GsonUtil.serialize(result));
        } catch (Exception e) {
            fail(e.getMessage());
        }

        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setSipActivation method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testSetSipActivation() throws Exception {
        System.out.println("setSipActivation");

        SipActivation sip = null;
        SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
        Boolean expResult = null;
        Boolean result = instance.setSipActivation(eqp, sip);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
