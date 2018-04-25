/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.device;

import br.net.gvt.efika.util.json.JacksonMapper;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import com.fasterxml.jackson.core.type.TypeReference;
import init.SingletonDeviceTest;
import java.util.ArrayList;
import java.util.List;
import model.device.DmzInfo;
import model.device.ddns.DdnsInfo;
import model.device.dhcp.Dhcp;
import model.device.dhcp.DhcpSet;
import model.device.firmware.FirmwareInfo;
import model.device.info.DeviceInfo;
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
import motive.hdm.synchdeviceops.GetParameterAttributesResponseDTO;
import motive.hdm.synchdeviceops.GetParameterValuesResponseDTO;
import motive.hdm.synchdeviceops.ParameterInfoStructDTO;
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

    @Test
    public void testGetDeviceInfo() throws Exception {
        try {
            System.out.println("getDeviceInfo");

            SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
            DeviceInfo deviceInfo = instance.getDeviceInfo(eqp);
            System.out.println("end");
            // TODO review the generated test code and remove the default call to fail.
        } catch (Exception e) {
            fail(e.getMessage());
        }

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
    public void testCheckOnline() {
        try {
            System.out.println("checkOnline");
            SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
            Boolean expResult = true;
            Boolean result = instance.checkOnline(eqp);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail("The test case is a prototype.");
        }

    }

    /**
     * Test of getFirmwareVersion method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testGetFirmwareVersion() throws Exception {
        System.out.println("getFirmwareVersion");

        FirmwareInfo result = instance.getFirmwareVersion(eqp);
        System.out.println(new JacksonMapper(FirmwareInfo.class).serialize(result));

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
//            System.out.println(GsonUtil.serialize(parameters));
            assertTrue("Cheio", !parameters.isEmpty());
        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());

        }
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
//            System.out.println(GsonUtil.serialize(parameters));
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
//            System.out.println(GsonUtil.serialize(parameters));
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

        List<LanDevice> result = instance.getLanHosts(eqp);
//        System.out.println("Booleano->"+result.get(0).getAtivo());
        System.out.println(new JacksonMapper(List.class).serialize(result));
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

        List<WifiInfoFull> result = instance.getWifiInfoFull(eqp);
        System.out.println(new JacksonMapper(new TypeReference<List<WifiInfoFull>>() {
        }).serialize(result));
    }

    /**
     * Test of getPortMapping method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testGetPortMapping() throws Exception {
        System.out.println("getPortMapping");

        List<PortMappingInfo> result = instance.getPortMapping(eqp);
        System.out.println(new JacksonMapper(new TypeReference<List<PortMappingInfo>>() {
        }).serialize(result));
    }

    /**
     * Test of getDhcp method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testGetDhcp() throws Exception {
        System.out.println("getDhcp");

        SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
        Dhcp result = instance.getDhcp(eqp);
        System.out.println(new JacksonMapper(Dhcp.class).serialize(result));
    }

    /**
     * Test of setDhcp method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testSetDhcp() throws Exception {
        System.out.println("setDhcp");
        Dhcp dh = instance.getDhcp(eqp);

        Boolean result = instance.setDhcp(eqp, dh);
        System.out.println(result);
    }

    /**
     * Test of traceroute method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testTraceroute() throws Exception {
        System.out.println("traceroute");

        TraceRouteRequest trace = new TraceRouteRequest("");
        PortMappingInfo result = instance.traceroute(eqp, trace);
        System.out.println(new JacksonMapper(PortMappingInfo.class).serialize(result));
    }

    /**
     * Test of setWifiInfoFull method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testSetWifiInfoFull() throws Exception {
        System.out.println("setWifiInfoFull");

        WifiInfoFull wifi = instance.getWifiInfoFull(eqp).get(0);
        wifi.setBcEnabled(Boolean.TRUE);
        Boolean result = instance.setWifiInfoFull(eqp, wifi);
        System.out.println("ResultadoFinal->" + new JacksonMapper(new TypeReference<WifiInfoFull>() {
        }).serialize(instance.getWifiInfoFull(eqp)));
    }

    /**
     * Test of getDdns method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testGetDdns() throws Exception {
        System.out.println("getDdns");

        DdnsInfo result = instance.getDdns(eqp);
        System.out.println(new JacksonMapper(DdnsInfo.class).serialize(result));
    }

    /**
     * Test of getXdslDiagnostic method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testGetXdslDiagnostic() throws Exception {
        System.out.println("getXdslDiagnostic");

        XdslDiagnostics result = instance.getXdslDiagnostic(eqp);
        System.out.println(new JacksonMapper(XdslDiagnostics.class).serialize(result));
    }

    /**
     * Test of getDeviceLog method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testGetDeviceLog() throws Exception {
        System.out.println("getDeviceLog");
        List<DeviceLog> result = instance.getDeviceLog(eqp);
        System.out.println(new JacksonMapper(new TypeReference<List<DeviceLog>>() {
        }).serialize(result));
    }

    /**
     * Test of getDeviceLogR method, of class SynchDeviceDAOImpl.
     */
//    @Test
//    public void testGetDeviceLogR() throws Exception {
//        System.out.println("getDeviceLogR");
//        
//        List<DeviceLogR> result = instance.getDeviceLogR(eqp);
//        System.out.println(new JacksonMapper(new TypeReference<List<DeviceLogR>>(){}).serialize(result));
//    }
    /**
     * Test of getInterfaceStatistics method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testGetInterfaceStatistics() throws Exception {
        System.out.println("getInterfaceStatistics");

        List<InterfaceStatistics> result = instance.getInterfaceStatistics(eqp);
        System.out.println(new JacksonMapper(List.class).serialize(result));
    }

    /**
     * Test of getPPPoECredentials method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testGetPPPoECredentials() throws Exception {
        System.out.println("getPPPoECredentials");

        PPPoECredentialsInfo result = instance.getPPPoECredentials(eqp);
        System.out.println(new JacksonMapper(PPPoECredentialsInfo.class).serialize(result));
    }

    /**
     * Test of pingDiagnostic method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testPingDiagnostic() throws Exception {
        System.out.println("pingDiagnostic");

        PingRequest p = new PingRequest();
        p.setDestAddress("www.google.com");

        PingResponse result = instance.pingDiagnostic(eqp, p);
        System.out.println(new JacksonMapper(PingResponse.class).serialize(result));
    }

    /**
     * Test of setPPPoECredentials method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testSetPPPoECredentials() throws Exception {
        System.out.println("setPPPoECredentials");

        PPPoECredentialsInfo pPPoECredentialsInfo = instance.getPPPoECredentials(eqp);
        pPPoECredentialsInfo.setPassword("gvt25");
        instance.setPPPoECredentials(eqp, pPPoECredentialsInfo);

    }

    /**
     * Test of setPortMapping method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testSetPortMapping() throws Exception {
        System.out.println("setPortMapping");

        List<PortMappingInfo> ports = new ArrayList<>();

        Boolean result = instance.setPortMapping(eqp, ports);

    }

    /**
     * Test of getSipDiagnostics method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testGetSipDiagnostics() throws Exception {
        System.out.println("getSipDiagnostics");

        SipDiagnostics result = instance.getSipDiagnostics(eqp, 1);
//        SipDiagnostics result1 = instance.getSipDiagnostics(eqp, 2);
        System.out.println("phyReference 1->"+new JacksonMapper(SipDiagnostics.class).serialize(result));
//        System.out.println("phyReference 2->"+new JacksonMapper(SipDiagnostics.class).serialize(result1));
    }

    /**
     * Test of setSipActivation method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testSetSipActivation() throws Exception {
        System.out.println("setSipActivation");
        SipDiagnostics diag = instance.getSipDiagnostics(eqp, 1);
        SipActivation sip = new SipActivation();
        sip.setAuthPassword("17588");
        sip.setAuthUserName(diag.getAuthUserName());
        sip.setDirectoryNumber(diag.getDirectoryNumber());
        sip.setOutboundProxy(diag.getOutboundProxy());
        sip.setPhyReferenceList("1");
        sip.setProxyServer(diag.getProxyServer());
        sip.setRegistrarServer(diag.getRegistrarServer());
        sip.setUserAgentDomain(diag.getUserAgentDomain());
        sip.setT38Enabled("0");
        Boolean result = instance.setSipActivation(eqp, sip);
        assertTrue(result);
    }

}
