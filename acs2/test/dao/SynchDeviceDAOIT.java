/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.DeviceOperationException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.NBIException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.OperationTimeoutException;
import com.motive.synchdeviceopsimpl.synchdeviceoperationsnbiservice.ProviderException;
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
import model.exception.HdmException;
import model.exception.JsonUtilException;
import model.exception.UnsupportedException;
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
public class SynchDeviceDAOIT {
    
    public SynchDeviceDAOIT() {
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
     * Test of reboot method, of class SynchDeviceDAO.
     */
    @Test
    public void testReboot() throws Exception {
        System.out.println("reboot");
        NbiDeviceData eqp = null;
        SynchDeviceDAO instance = new SynchDeviceDAOImpl();
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
        NbiDeviceData eqp = null;
        SynchDeviceDAO instance = new SynchDeviceDAOImpl();
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
        NbiDeviceData eqp = null;
        SynchDeviceDAO instance = new SynchDeviceDAOImpl();
        Boolean expResult = null;
        Boolean result = instance.checkOnline(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirmwareVersion method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetFirmwareVersion() throws Exception {
        System.out.println("getFirmwareVersion");
        NbiDeviceData eqp = null;
        SynchDeviceDAO instance = new SynchDeviceDAOImpl();
        FirmwareInfo expResult = null;
        FirmwareInfo result = instance.getFirmwareVersion(eqp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParameters method, of class SynchDeviceDAO.
     */
    @Test
    public void testGetParameters() throws Exception {
        System.out.println("getParameters");
        NbiDeviceData eqp = null;
        SynchDeviceDAO instance = new SynchDeviceDAOImpl();
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
        NbiDeviceData eqp = null;
        SynchDeviceDAO instance = new SynchDeviceDAOImpl();
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
        NbiDeviceData eqp = null;
        List<String> paths = null;
        SynchDeviceDAO instance = new SynchDeviceDAOImpl();
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
        NbiDeviceData eqp = null;
        String path = "";
        SynchDeviceDAO instance = new SynchDeviceDAOImpl();
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
        NbiDeviceData eqp = null;
        ParameterValueStructDTO p = null;
        SynchDeviceDAO instance = new SynchDeviceDAOImpl();
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
        NbiDeviceData eqp = null;
        SynchDeviceDAO instance = new SynchDeviceDAOImpl();
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
        NbiDeviceData eqp = null;
        SynchDeviceDAO instance = new SynchDeviceDAOImpl();
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
        NbiDeviceData eqp = null;
        ServiceClass sc = null;
        SynchDeviceDAO instance = new SynchDeviceDAOImpl();
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
        NbiDeviceData eqp = null;
        SynchDeviceDAO instance = new SynchDeviceDAOImpl();
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
        NbiDeviceData eqp = null;
        SynchDeviceDAO instance = new SynchDeviceDAOImpl();
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
        NbiDeviceData eqp = null;
        SynchDeviceDAO instance = new SynchDeviceDAOImpl();
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
        NbiDeviceData eqp = null;
        SynchDeviceDAO instance = new SynchDeviceDAOImpl();
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
        NbiDeviceData eqp = null;
        SynchDeviceDAO instance = new SynchDeviceDAOImpl();
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
        NbiDeviceData eqp = null;
        Dhcp dh = null;
        SynchDeviceDAO instance = new SynchDeviceDAOImpl();
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
        NbiDeviceData eqp = null;
        TraceRouteRequest trace = null;
        SynchDeviceDAO instance = new SynchDeviceDAOImpl();
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
        NbiDeviceData eqp = null;
        WifiInfoFull wifi = null;
        SynchDeviceDAO instance = new SynchDeviceDAOImpl();
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
        NbiDeviceData eqp = null;
        SynchDeviceDAO instance = new SynchDeviceDAOImpl();
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
        NbiDeviceData eqp = null;
        SynchDeviceDAO instance = new SynchDeviceDAOImpl();
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
        NbiDeviceData eqp = null;
        SynchDeviceDAO instance = new SynchDeviceDAOImpl();
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
        NbiDeviceData eqp = null;
        SynchDeviceDAO instance = new SynchDeviceDAOImpl();
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
        NbiDeviceData eqp = null;
        SynchDeviceDAO instance = new SynchDeviceDAOImpl();
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
        NbiDeviceData eqp = null;
        SynchDeviceDAO instance = new SynchDeviceDAOImpl();
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
        NbiDeviceData eqp = null;
        PingRequest p = null;
        SynchDeviceDAO instance = new SynchDeviceDAOImpl();
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
        NbiDeviceData eqp = null;
        PPPoECredentialsInfo pPPoECredentialsInfo = null;
        SynchDeviceDAO instance = new SynchDeviceDAOImpl();
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
        NbiDeviceData eqp = null;
        List<PortMappingInfo> ports = null;
        SynchDeviceDAO instance = new SynchDeviceDAOImpl();
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
        NbiDeviceData eqp = null;
        Integer phyref = null;
        SynchDeviceDAO instance = new SynchDeviceDAOImpl();
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
        NbiDeviceData eqp = null;
        SipActivation sip = null;
        SynchDeviceDAO instance = new SynchDeviceDAOImpl();
        Boolean expResult = null;
        Boolean result = instance.setSipActivation(eqp, sip);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class SynchDeviceDAOImpl implements SynchDeviceDAO {

        public Boolean reboot(NbiDeviceData eqp) throws DeviceOperationException, NBIException, ProviderException {
            return null;
        }

        public Boolean factoryReset(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException {
            return null;
        }

        public Boolean checkOnline(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException {
            return null;
        }

        public FirmwareInfo getFirmwareVersion(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, ProviderException, JsonUtilException {
            return null;
        }

        public void getParameters(NbiDeviceData eqp) throws Exception {
        }

        public void getParametersWifi(NbiDeviceData eqp) throws Exception {
        }

        public void getParametersValues(NbiDeviceData eqp, List<String> paths) throws Exception {
        }

        public void getParameterValue(NbiDeviceData eqp, String path) throws Exception {
        }

        public void setParametersValues(NbiDeviceData eqp, ParameterValueStructDTO p) throws Exception {
        }

        public WanInfo getWanInfo(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException {
            return null;
        }

        public ServiceClass getServiceClass(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, UnsupportedException {
            return null;
        }

        public Boolean setServiceClass(NbiDeviceData eqp, ServiceClass sc) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException {
            return null;
        }

        public List<LanDevice> getLanHosts(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException {
            return null;
        }

        public DmzInfo getDmzInfo(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException {
            return null;
        }

        public WifiInfoFull getWifiInfoFull(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, JsonUtilException, HdmException, ProviderException {
            return null;
        }

        public List<PortMappingInfo> getPortMapping(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException {
            return null;
        }

        public Dhcp getDhcp(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException {
            return null;
        }

        public Boolean setDhcp(NbiDeviceData eqp, Dhcp dh) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException {
            return null;
        }

        public PortMappingInfo traceroute(NbiDeviceData eqp, TraceRouteRequest trace) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException {
            return null;
        }

        public Boolean setWifiInfoFull(NbiDeviceData eqp, WifiInfoFull wifi) throws DeviceOperationException, NBIException {
            return null;
        }

        public DdnsInfo getDdns(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException {
            return null;
        }

        public XdslDiagnostics getXdslDiagnostic(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException {
            return null;
        }

        public List<DeviceLog> getDeviceLog(NbiDeviceData eqp) throws JsonUtilException, DeviceOperationException, NBIException, ProviderException, OperationTimeoutException {
            return null;
        }

        public List<DeviceLogR> getDeviceLogR(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException {
            return null;
        }

        public List<InterfaceStatistics> getInterfaceStatistics(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException {
            return null;
        }

        public PPPoECredentialsInfo getPPPoECredentials(NbiDeviceData eqp) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException {
            return null;
        }

        public PingResponse pingDiagnostic(NbiDeviceData eqp, PingRequest p) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException, JsonUtilException {
            return null;
        }

        public StringResponseDTO setPPPoECredentials(NbiDeviceData eqp, PPPoECredentialsInfo pPPoECredentialsInfo) throws DeviceOperationException, OperationTimeoutException, NBIException, ProviderException {
            return null;
        }

        public Boolean setPortMapping(NbiDeviceData eqp, List<PortMappingInfo> ports) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException {
            return null;
        }

        public SipDiagnostics getSipDiagnostics(NbiDeviceData eqp, Integer phyref) throws DeviceOperationException, NBIException, OperationTimeoutException, JsonUtilException, HdmException, ProviderException, UnsupportedException {
            return null;
        }

        public Boolean setSipActivation(NbiDeviceData eqp, SipActivation sip) throws DeviceOperationException, NBIException, OperationTimeoutException, ProviderException {
            return null;
        }
    }
    
}
