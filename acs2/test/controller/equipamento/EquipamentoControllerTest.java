/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.equipamento;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import dao.EquipamentoDAO;
import init.EquipamentoTestValues;
import java.util.List;
import model.device.dhcp.Dhcp;
import model.device.firmware.FirmwareInfo;
import model.device.portmapping.PortMappingInfo;
import model.device.pppoe.PPPoECredentialsInfo;
import model.device.serviceclass.ServiceClass;
import model.device.sipactivation.SipActivation;
import model.device.sipdiagnostics.SipDiagnostics;
import model.device.wifi.WifiInfoFull;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author G0041775
 */
public class EquipamentoControllerTest {

    public EquipamentoControllerTest() {
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
     * Test of detalhes method, of class EquipamentoController.
     */
    @Test
    public void testDetalhes() {
        System.out.println("detalhes");
        String guid = EquipamentoTestValues.GUID.toString();
        EquipamentoController instance = new EquipamentoController();
        try {
            instance.detalhes(guid);
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of detalhesJson method, of class EquipamentoController.
     */
    @Test
    public void testDetalhesJson() {
        System.out.println("detalhesJson");
        String guid = EquipamentoTestValues.GUID.toString();
        EquipamentoController instance = new EquipamentoController();
        try {
            instance.detalhesJson(guid);
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * Test of getFirmwareVersion method, of class EquipamentoController.
     */
    @Test
    public void testGetFirmwareVersion() {
        System.out.println("getFirmwareVersion");
        EquipamentoDAO d = new EquipamentoDAO();
        EquipamentoController instance = new EquipamentoController();
        try {
            NbiDeviceData nbiDeviceData = d.findDeviceByGUID(EquipamentoTestValues.GUID);
            instance.getFirmwareVersion(nbiDeviceData);
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getWifiInfoFull method, of class EquipamentoController.
     */
    @Test
    public void testGetWifiInfoFull() {
        System.out.println("getWifiInfoFull");
        EquipamentoDAO d = new EquipamentoDAO();
        EquipamentoController instance = new EquipamentoController();
        try {
            NbiDeviceData nbiDeviceData = d.findDeviceByGUID(EquipamentoTestValues.GUID);
            instance.getWifiInfoFull(nbiDeviceData);
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    /**
     * Test of getWanInfo method, of class EquipamentoController.
     */
    @Test
    public void testGetWanInfo() {
        System.out.println("getWanInfo");
        EquipamentoDAO d = new EquipamentoDAO();
        EquipamentoController instance = new EquipamentoController();
        try {
            NbiDeviceData nbiDeviceData = d.findDeviceByGUID(EquipamentoTestValues.GUID);
            instance.getWanInfo(nbiDeviceData);
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    /**
     * Test of getXdslDiagnostics method, of class EquipamentoController.
     */
    @Test
    public void testGetXdslDiagnostics() {
        System.out.println("getXdslDiagnostics");
        EquipamentoDAO d = new EquipamentoDAO();
        EquipamentoController instance = new EquipamentoController();
        try {
            NbiDeviceData nbiDeviceData = d.findDeviceByGUID(EquipamentoTestValues.GUID);
            instance.getXdslDiagnostics(nbiDeviceData);
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    /**
     * Test of getInterfaceStatistics method, of class EquipamentoController.
     */
    @Test
    public void testGetInterfaceStatistics() {
        System.out.println("getInterfaceStatistics");
        EquipamentoDAO d = new EquipamentoDAO();
        EquipamentoController instance = new EquipamentoController();
        try {
            NbiDeviceData nbiDeviceData = d.findDeviceByGUID(EquipamentoTestValues.GUID);
            instance.getInterfaceStatistics(nbiDeviceData);
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    /**
     * Test of getPortMappingInfo method, of class EquipamentoController.
     */
    @Test
    public void testGetPortMappingInfo() {
        System.out.println("getPortMappingInfo");
        EquipamentoDAO d = new EquipamentoDAO();
        EquipamentoController instance = new EquipamentoController();
        try {
            NbiDeviceData nbiDeviceData = d.findDeviceByGUID(EquipamentoTestValues.GUID);
            instance.getPortMappingInfo(nbiDeviceData);
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    /**
     * Test of getLanHosts method, of class EquipamentoController.
     */
    @Test
    public void testGetLanHosts() {
        System.out.println("getLanHosts");
        EquipamentoDAO d = new EquipamentoDAO();
        EquipamentoController instance = new EquipamentoController();
        try {
            NbiDeviceData nbiDeviceData = d.findDeviceByGUID(EquipamentoTestValues.GUID);
            instance.getLanHosts(nbiDeviceData);
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    /**
     * Test of updateFirmwareVersion method, of class EquipamentoController.
     */
    @Test
    public void testUpdateFirmwareVersion() {
        System.out.println("updateFirmwareVersion");
        EquipamentoDAO d = new EquipamentoDAO();
        EquipamentoController instance = new EquipamentoController();
        try {
            NbiDeviceData nbiDeviceData = d.findDeviceByGUID(EquipamentoTestValues.GUID);
            FirmwareInfo info = d.getFirmwareVersion(nbiDeviceData);
            instance.updateFirmwareVersion(nbiDeviceData, info);
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    /**
     * Test of reboot method, of class EquipamentoController.
     */
    @Test
    public void testReboot() {
        System.out.println("reboot");
        EquipamentoDAO d = new EquipamentoDAO();
        EquipamentoController instance = new EquipamentoController();
        try {
            NbiDeviceData nbiDeviceData = d.findDeviceByGUID(EquipamentoTestValues.GUID);
            instance.reboot(nbiDeviceData);
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    /**
     * Test of factoryReset method, of class EquipamentoController.
     */
    @Test
    public void testFactoryReset() {
        System.out.println("factoryReset");
        EquipamentoDAO d = new EquipamentoDAO();
        EquipamentoController instance = new EquipamentoController();
        try {
            NbiDeviceData nbiDeviceData = d.findDeviceByGUID(EquipamentoTestValues.GUID);
            instance.factoryReset(nbiDeviceData);
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    /**
     * Test of setWifiFull method, of class EquipamentoController.
     */
    @Test
    public void testSetWifiFull() {
        System.out.println("setWifiFull");
        EquipamentoDAO d = new EquipamentoDAO();
        EquipamentoController instance = new EquipamentoController();
        try {
            NbiDeviceData nbiDeviceData = d.findDeviceByGUID(EquipamentoTestValues.GUID);
            WifiInfoFull info = d.getWifiInfoFull(nbiDeviceData);
            instance.setWifiFull(nbiDeviceData, info);
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    /**
     * Test of checkOnline method, of class EquipamentoController.
     */
    @Test
    public void testCheckOnline() {
        System.out.println("checkOnline");
        EquipamentoDAO d = new EquipamentoDAO();
        EquipamentoController instance = new EquipamentoController();
        try {
            NbiDeviceData nbiDeviceData = d.findDeviceByGUID(EquipamentoTestValues.GUID);
            instance.checkOnline(nbiDeviceData);
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    /**
     * Test of getPPPoECredentials method, of class EquipamentoController.
     */
    @Test
    public void testGetPPPoECredentials() {
        System.out.println("getPPPoECredentials");
        EquipamentoDAO d = new EquipamentoDAO();
        EquipamentoController instance = new EquipamentoController();
        try {
            NbiDeviceData nbiDeviceData = d.findDeviceByGUID(EquipamentoTestValues.GUID);
            instance.getPPPoECredentials(nbiDeviceData);
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    /**
     * Test of setPPPoECredentials method, of class EquipamentoController.
     */
    @Test
    public void testSetPPPoECredentials() {
        System.out.println("setPPPoECredentials");
        EquipamentoDAO d = new EquipamentoDAO();
        EquipamentoController instance = new EquipamentoController();
        try {
            NbiDeviceData nbiDeviceData = d.findDeviceByGUID(EquipamentoTestValues.GUID);
            PPPoECredentialsInfo pPPoECredentialsInfo = d.getPPPoECredentials(nbiDeviceData);
            instance.setPPPoECredentials(nbiDeviceData, pPPoECredentialsInfo);
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    /**
     * Test of getDdns method, of class EquipamentoController.
     */
    @Test
    public void testGetDdns() {
        System.out.println("getDdns");
        EquipamentoDAO d = new EquipamentoDAO();
        EquipamentoController instance = new EquipamentoController();
        try {
            NbiDeviceData nbiDeviceData = d.findDeviceByGUID(EquipamentoTestValues.GUID);
            instance.getDdns(nbiDeviceData);
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    /**
     * Test of pingDiagnostic method, of class EquipamentoController.
     */
    @Test
    public void testPingDiagnostic() {
        System.out.println("pingDiagnostic");
        EquipamentoDAO d = new EquipamentoDAO();
        String request = "www.google.com.br";
        EquipamentoController instance = new EquipamentoController();
        try {
            NbiDeviceData nbiDeviceData = d.findDeviceByGUID(EquipamentoTestValues.GUID);
            instance.pingDiagnostic(nbiDeviceData, request);
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    /**
     * Test of setPortMappingInfo method, of class EquipamentoController.
     */
    @Test
    public void testSetPortMappingInfo() {
        System.out.println("setPortMappingInfo");
        EquipamentoDAO d = new EquipamentoDAO();
        EquipamentoController instance = new EquipamentoController();
        try {
            NbiDeviceData nbiDeviceData = d.findDeviceByGUID(EquipamentoTestValues.GUID);
            List<PortMappingInfo> ports = d.getPortMapping(nbiDeviceData);
            instance.setPortMappingInfo(nbiDeviceData, ports);
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    /**
     * Test of getSipDiagnostics method, of class EquipamentoController.
     */
    @Test
    public void testGetSipDiagnostics() {
        System.out.println("getSipDiagnostics");
        EquipamentoDAO d = new EquipamentoDAO();
        Integer phyref = 1;
        EquipamentoController instance = new EquipamentoController();
        try {
            NbiDeviceData nbiDeviceData = d.findDeviceByGUID(EquipamentoTestValues.GUID);
            instance.getSipDiagnostics(nbiDeviceData, phyref);
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    /**
     * Test of setSipActivation method, of class EquipamentoController.
     */
    @Test
    public void testSetSipActivation() {
        System.out.println("setSipActivation");
        EquipamentoDAO d = new EquipamentoDAO();
        EquipamentoController instance = new EquipamentoController();
        try {
            NbiDeviceData nbiDeviceData = d.findDeviceByGUID(EquipamentoTestValues.GUID);
            SipDiagnostics s = d.getSipDiagnostics(nbiDeviceData, 1);
            SipActivation sipAct = new SipActivation();
            sipAct.setAuthPassword(s.getAuthPassword());
            sipAct.setAuthUserName(s.getAuthUserName());
            sipAct.setDirectoryNumber(s.getDirectoryNumber());
            sipAct.setOutboundProxy(s.getOutboundProxy());
            sipAct.setPhyReferenceList("1");
            sipAct.setProxyServer(s.getProxyServer());
            sipAct.setRegistrarServer(s.getRegistrarServer());
            sipAct.setUserAgentDomain(s.getUserAgentDomain());
            instance.setSipActivation(nbiDeviceData, sipAct);
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    /**
     * Test of getServiceClass method, of class EquipamentoController.
     */
    @Test
    public void testGetServiceClass() {
        System.out.println("getServiceClass");
        EquipamentoDAO d = new EquipamentoDAO();
        EquipamentoController instance = new EquipamentoController();
        try {
            NbiDeviceData nbiDeviceData = d.findDeviceByGUID(EquipamentoTestValues.GUID);
            instance.getServiceClass(nbiDeviceData);
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    /**
     * Test of setServiceClass method, of class EquipamentoController.
     */
    @Test
    public void testSetServiceClass() {
        System.out.println("setServiceClass");
        EquipamentoDAO d = new EquipamentoDAO();
        EquipamentoController instance = new EquipamentoController();
        try {
            NbiDeviceData nbiDeviceData = d.findDeviceByGUID(EquipamentoTestValues.GUID);
            ServiceClass info = d.getServiceClass(nbiDeviceData);
            instance.setServiceClass(nbiDeviceData, info);
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    /**
     * Test of getDhcp method, of class EquipamentoController.
     */
    @Test
    public void testGetDhcp() {
        System.out.println("getDhcp");
        EquipamentoDAO d = new EquipamentoDAO();
        EquipamentoController instance = new EquipamentoController();
        try {
            NbiDeviceData nbiDeviceData = d.findDeviceByGUID(EquipamentoTestValues.GUID);
            instance.getDhcp(nbiDeviceData);
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    /**
     * Test of setDhcp method, of class EquipamentoController.
     */
    @Test
    public void testSetDhcp() {
        System.out.println("setDhcp");
        EquipamentoDAO d = new EquipamentoDAO();
        EquipamentoController instance = new EquipamentoController();
        try {
            NbiDeviceData nbiDeviceData = d.findDeviceByGUID(EquipamentoTestValues.GUID);
            Dhcp info = d.getDhcp(nbiDeviceData);
            instance.setDhcp(nbiDeviceData, info);
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    /**
     * Test of getDmzInfo method, of class EquipamentoController.
     */
    @Test
    public void testGetDmzInfo() {
        System.out.println("getDmzInfo");
        EquipamentoDAO d = new EquipamentoDAO();
        EquipamentoController instance = new EquipamentoController();
        try {
            NbiDeviceData nbiDeviceData = d.findDeviceByGUID(EquipamentoTestValues.GUID);
            instance.getDmzInfo(nbiDeviceData);
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    /**
     * Test of getDeviceLogR method, of class EquipamentoController.
     */
    @Test
    public void testGetDeviceLogR() {
        System.out.println("getDeviceLogR");
        EquipamentoDAO d = new EquipamentoDAO();
        EquipamentoController instance = new EquipamentoController();
        try {
            NbiDeviceData nbiDeviceData = d.findDeviceByGUID(EquipamentoTestValues.GUID);
            instance.getDeviceLogR(nbiDeviceData);
            assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

//    /**
//     * Test of gerarLog method, of class EquipamentoController.
//     */
//    @Test
//    public void testGerarLog() {
//        System.out.println("gerarLog");
//        NbiDeviceData nbiDeviceData = null;
//        String acao = "";
//        String valores = "";
//        EquipamentoController instance = new EquipamentoController();
//        instance.gerarLog(nbiDeviceData, acao, valores);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of includeSerializer method, of class EquipamentoController.
     */
//    @Test
//    public void testIncludeSerializer() {
//        System.out.println("includeSerializer");
//        Object a = null;
//        EquipamentoController instance = new EquipamentoController();
//        instance.includeSerializer(a);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
