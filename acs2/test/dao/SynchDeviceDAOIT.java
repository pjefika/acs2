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
import model.device.pppoe.PPPoECredentialsInfoOut;
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
import util.GsonUtil;

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

        WanInfo result = instance.getWanInfo(eqp);
        System.out.println(GsonUtil.serialize(result));
        assertTrue(result != null);
    }

    /**
     * Test of getServiceClass method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetServiceClass() throws Exception {
        System.out.println("getServiceClass");

        ServiceClass result = instance.getServiceClass(eqp);
        System.out.println(GsonUtil.serialize(result));
        assertTrue(result != null);
    }

    /**
     * Test of setServiceClass method, of class SynchDeviceDAO.
     */
    @Test
    public void testSetServiceClass() throws Exception {
        System.out.println("setServiceClass");

        ServiceClass sc = instance.getServiceClass(eqp);

        Boolean expResult = true;
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

        List<LanDevice> result = instance.getLanHosts(eqp);
        System.out.println(GsonUtil.serialize(result));
        assertTrue(result != null);
    }

    /**
     * Test of getDmzInfo method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetDmzInfo() throws Exception {
        System.out.println("getDmzInfo");

        DmzInfo result = instance.getDmzInfo(eqp);
        System.out.println(GsonUtil.serialize(result));
        assertTrue(result != null);
    }

    /**
     * Test of getWifiInfoFull method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetWifiInfoFull() throws Exception {
        System.out.println("getWifiInfoFull");
        WifiInfoFull result = instance.getWifiInfoFull(eqp);
        System.out.println(GsonUtil.serialize(result));
        assertTrue(result != null);
    }

    /**
     * Test of getPortMapping method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetPortMapping() throws Exception {
        System.out.println("getPortMapping");

        List<PortMappingInfo> result = instance.getPortMapping(eqp);
        System.out.println(GsonUtil.serialize(result));
        assertTrue(result != null);
    }

    /**
     * Test of getDhcp method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetDhcp() throws Exception {
        System.out.println("getDhcp");

        Dhcp result = instance.getDhcp(eqp);
        System.out.println(GsonUtil.serialize(result));
        assertTrue(result != null);
    }

    /**
     * Test of setDhcp method, of class SynchDeviceDAO.
     */
    @Test
    public void testSetDhcp() {
        System.out.println("setDhcp");
        try {
            Dhcp dh = instance.getDhcp(eqp);

            Boolean result = instance.setDhcp(eqp, dh);
            assertEquals(true, result);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    /**
     * Não há doc do retorno
     *
     *
     * Test of traceroute method, of class SynchDeviceDAO.
     */
    @Test
    public void testTraceroute() throws Exception {
        System.out.println("traceroute");

        TraceRouteRequest trace = new TraceRouteRequest("www.google.com.br");
        try {
            PortMappingInfo result = instance.traceroute(eqp, trace);
            System.out.println(GsonUtil.serialize(result));
            assertTrue(result != null);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    /**
     * Test of setWifiInfoFull method, of class SynchDeviceDAO.
     */
    @Test
    public void testSetWifiInfoFull() throws Exception {
        System.out.println("setWifiInfoFull");
        WifiInfoFull wi = instance.getWifiInfoFull(eqp);
        wi.setChannel("6");
//        wi.setSsid(wi.getSsid() + "-efika");
//        wi.setSsid("GVT-72D9");

        assertTrue(instance.setWifiInfoFull(eqp, wi));
    }

    /**
     * Test of getDdns method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetDdns() throws Exception {
        System.out.println("getDdns");

        DdnsInfo result = instance.getDdns(eqp);
        System.out.println(GsonUtil.serialize(result));
        assertTrue(result != null);
    }

    /**
     * Test of getXdslDiagnostic method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetXdslDiagnostic() throws Exception {
        System.out.println("getXdslDiagnostic");

        XdslDiagnostics result = instance.getXdslDiagnostic(eqp);
        System.out.println(GsonUtil.serialize(result));
        assertTrue(result != null);
    }

    /**
     * não retorna adequadamente
     * Test of getDeviceLog method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetDeviceLog() throws Exception {
        System.out.println("getDeviceLog");

        List<DeviceLog> result = instance.getDeviceLog(eqp);
        System.out.println(GsonUtil.serialize(result));
        assertTrue(result != null);
    }

    /**
     * Test of getDeviceLogR method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetDeviceLogR() throws Exception {
        System.out.println("getDeviceLogR");

        List<DeviceLogR> result = instance.getDeviceLogR(eqp);
        System.out.println(GsonUtil.serialize(result));
        assertTrue(result != null);
    }

    /**
     * Test of getInterfaceStatistics method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetInterfaceStatistics() throws Exception {
        System.out.println("getInterfaceStatistics");

        List<InterfaceStatistics> result = instance.getInterfaceStatistics(eqp);
        System.out.println(GsonUtil.serialize(result));
        assertTrue(result != null);
    }

    /**
     * Test of getPPPoECredentials method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetPPPoECredentials() throws Exception {
        System.out.println("getPPPoECredentials");

        PPPoECredentialsInfo result = instance.getPPPoECredentials(eqp);
        System.out.println(GsonUtil.serialize(result));
        assertTrue(result != null);
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
            System.out.println(GsonUtil.serialize(result));
            assertTrue(result.getStatus().equalsIgnoreCase("Complete"));
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

    /**
     * Test of setPPPoECredentials method, of class SynchDeviceDAO.
     */
    @Test
    public void testSetPPPoECredentials() throws Exception {
        System.out.println("setPPPoECredentials");

        PPPoECredentialsInfo pPPoECredentialsInfo = new PPPoECredentialsInfo("turbonet@turbonet", "gvt25");

        StringResponseDTO result = instance.setPPPoECredentials(eqp, new PPPoECredentialsInfoOut(pPPoECredentialsInfo));
        System.out.println(GsonUtil.serialize(result));
        assertTrue(result != null);
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
        System.out.println(GsonUtil.serialize(result));
        assertTrue(result != null);
    }

    /**
     * Não segue o padrão para CPEs que não suportam o parâmetro
     * Test of getSipDiagnostics method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetSipDiagnostics() throws Exception {
        System.out.println("getSipDiagnostics");

        Integer phyref = 1;

        SipDiagnostics result = instance.getSipDiagnostics(eqp, phyref);
        System.out.println(GsonUtil.serialize(result));
        assertTrue(result != null);
    }

    /**
     * Test of setSipActivation method, of class SynchDeviceDAO.
     */
    @Test
    public void testSetSipActivation() throws Exception {
        System.out.println("setSipActivation");

        SipActivation sip = new SipActivation();

        Boolean result = instance.setSipActivation(eqp, sip);
        System.out.println(GsonUtil.serialize(result));
        assertTrue(result != null);
    }

}
