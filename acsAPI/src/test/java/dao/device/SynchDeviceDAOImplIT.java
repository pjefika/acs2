/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.device;

import br.net.gvt.efika.acs.model.device.DmzInfo;
import br.net.gvt.efika.acs.model.device.ddns.DdnsInfo;
import br.net.gvt.efika.acs.model.device.dhcp.Dhcp;
import br.net.gvt.efika.acs.model.device.dns.Dns;
import br.net.gvt.efika.acs.model.device.firmware.FirmwareInfo;
import br.net.gvt.efika.acs.model.device.info.DeviceInfo;
import br.net.gvt.efika.acs.model.device.interfacestatistics.InterfaceStatistics;
import br.net.gvt.efika.acs.model.device.lanhost.LanDevice;
import br.net.gvt.efika.acs.model.device.log.DeviceLog;
import br.net.gvt.efika.acs.model.device.ping.PingRequest;
import br.net.gvt.efika.acs.model.device.ping.PingResponse;
import br.net.gvt.efika.acs.model.device.portmapping.PortMappingInfo;
import br.net.gvt.efika.acs.model.device.pppoe.PPPoECredentialsInfo;
import br.net.gvt.efika.acs.model.device.serviceclass.ServiceClass;
import br.net.gvt.efika.acs.model.device.sipactivation.SipActivation;
import br.net.gvt.efika.acs.model.device.sipdiagnostics.SipDiagnostics;
import br.net.gvt.efika.acs.model.device.traceroute.TraceRouteRequest;
import br.net.gvt.efika.acs.model.device.wan.WanInfo;
import br.net.gvt.efika.acs.model.device.wifi.WifiInfoFull;
import br.net.gvt.efika.acs.model.device.xdsldiagnostics.XdslDiagnostics;
import br.net.gvt.efika.util.json.JacksonMapper;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import com.fasterxml.jackson.core.type.TypeReference;
import dao.factory.FactoryDAO;
import init.SingletonDeviceTest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import motive.hdm.synchdeviceops.GetParameterAttributesResponseDTO;
import motive.hdm.synchdeviceops.GetParameterValuesResponseDTO;
import motive.hdm.synchdeviceops.NbiSingleDeviceOperationOptions;
import motive.hdm.synchdeviceops.ParameterInfoStructDTO;
import motive.hdm.synchdeviceops.ParameterValueStructDTO;
import motive.hdm.synchdeviceops.SetParameterValuesResponseDTO;
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
    private NbiDeviceData eqp  = SingletonDeviceTest.getInstance().getDevice();

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
//        try {
////            eqp = (NbiDeviceData) new JacksonMapper<>(NbiDeviceData.class).deserialize("{\"domainName\":null,\"activated\":true,\"alarmsEnabled\":true,\"captured\":false,\"commonUniqueIdentifier\":null,\"community\":null,\"connectionRequestPassword\":\"5ce4a65587ede20ceb52aa0080b1e8f3\",\"connectionRequestURL\":\"http://179.181.66.41:7547/\",\"connectionRequestUsername\":\"107223E37FB2-RTF3507VW-N2-009096\",\"currentTime\":1528574805000,\"customAttribute1\":\"10:72:23:E3:7F:B2\",\"customAttribute10\":null,\"customAttribute2\":null,\"customAttribute3\":null,\"customAttribute4\":null,\"customAttribute5\":null,\"customAttribute6\":null,\"customAttribute7\":null,\"customAttribute8\":null,\"customAttribute9\":null,\"deleted\":false,\"deviceClass\":null,\"deviceGUID\":31394283,\"deviceId\":{\"oui\":\"009096\",\"productClass\":\"RTF3507VW-N2\",\"protocol\":\"DEVICE_PROTOCOL_DSLFTR069v1\",\"serialNumber\":\"107223E37FB2\"},\"dynamicVariables\":[{\"encrypt\":false,\"name\":\"inform.itoss.activation.msg\",\"sensitive\":false,\"value\":\"{'operation':'PROVISIONING','mac':'10:72:23:E3:7F:B2','pclass':'RTF3507VW-N2','guid':'31394283','serialNumber':'107223E37FB2','subscriberId':'NO_SUBSCRIBER_IT','parentId':'','parentMac':'','parentIp':'null','timestamp':'2018-04-09T17:26:36.332-03:00'}\"},{\"encrypt\":false,\"name\":\"sip.retries\",\"sensitive\":false,\"value\":\"0\"},{\"encrypt\":false,\"name\":\"vivo.voip.result.data.1\",\"sensitive\":false,\"value\":\"+555131108218\"}],\"firstContactTime\":1523305592553,\"lastActivationTime\":1523305594160,\"lastCapturedBy\":null,\"lastCapturedTime\":null,\"lastContactTime\":1528585551977,\"macAddress\":\"10:72:23:E3:7F:B2\",\"managed\":true,\"manufacturer\":\"Askey\",\"model\":\"Device:1\",\"modelName\":\"RTF3507VW-N2\",\"port\":0,\"portMappingRetryCount\":0,\"serviceTagArray\":[{\"name\":\"inform.itoss.activation.status\",\"value\":\"final_notification_sent_at[2018-04-09T17:26:36.440-03:00]_status[OK]\",\"copyOnFactoryReset\":false,\"factoryResetValue\":null},{\"name\":\"inform.itoss.hpna.status\",\"value\":\"final_notification_sent_at[2018-04-09T17:43:05.064-03:00][12/12]_id[1523306582939]_status[OK]\",\"copyOnFactoryReset\":false,\"factoryResetValue\":null},{\"name\":\"notifyIT\",\"value\":\"true\",\"copyOnFactoryReset\":false,\"factoryResetValue\":null},{\"name\":\"vivo.voip\",\"value\":\"enabled\",\"copyOnFactoryReset\":false,\"factoryResetValue\":null}],\"softwareVersion\":\"BR_SG_s00.00_g000_3507019\",\"subscriberID\":\"PAE-814RXLRF1O-013\",\"type\":0,\"userTagArray\":[],\"httppublicPassword\":\"1523305593192a\",\"httppublicUsername\":\"1523305593192u\",\"pppusername\":null,\"ipaddress\":\"179.181.66.41\",\"ppppassword\":null}");
//        } catch (Exception e) {
//        }

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

            DeviceInfo deviceInfo = instance.getDeviceInfo(eqp);
            System.out.println(new JacksonMapper<>(DeviceInfo.class).serialize(deviceInfo));
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
            e.printStackTrace();
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
            List<ParameterInfoStructDTO> parameters = instance.getParameters(eqp);
            System.out.println(new JacksonMapper<>(new TypeReference<List<ParameterInfoStructDTO>>() {
            }).serialize(parameters));
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
//            paths.add("InternetGatewayDevice.Services.VoiceService.1.VoiceProfile.1.Line.1.DirectoryNumber");
            paths.add("Device.Services.VoiceService.1.VoiceProfile.1.Line.1.DirectoryNumber");

            GetParameterValuesResponseDTO parameters = instance.getParametersValues(eqp, paths);

            System.out.println(new JacksonMapper<>(GetParameterValuesResponseDTO.class).serialize(parameters));
            assertTrue("Cheio", parameters != null);
        } catch (Exception e) {
            fail(e.getMessage());
        }

        // TODO review the generated test code and remove the default call to fail.
    }

    class Paranauezeiro extends Thread {

        public Paranauezeiro(String nomeFrom, String nomeTo) {
            super(new Paranauezin(nomeFrom, nomeTo));
        }

    }

    class Paranaue implements Runnable {

        String nomeFrom, nomeTo;

        public Paranaue(String nomeFroms, String nomeTos) {
            nomeFrom = nomeFroms;
            nomeTo = nomeTos;
        }

        @Override
        public void run() {
            try {
                System.out.println("testMethod");
                JacksonMapper deviceMapper = new JacksonMapper(NbiDeviceData.class);
                JacksonMapper getParameterMapper = new JacksonMapper(GetParameterAttributesResponseDTO.class);
                JacksonMapper setParameterMapper = new JacksonMapper(SetParameterValuesResponseDTO.class);
//                List<String> paths = new ArrayList<>();
//                paths.add("InternetGatewayDevice.X_VIVO_COM_BR.Interfaces.InternetService");
                PrintWriter pw = null;
                try {
                    pw = new PrintWriter(new File(nomeTo));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                StringBuilder builder = new StringBuilder();
                String ColumnNamesList = "Designador;Equipamento;setResult";
                builder.append(ColumnNamesList).append("\n");

                String file = nomeFrom;
                List<String> designadores = new ArrayList<>();
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String line = "";
                    while ((line = br.readLine()) != null) {
                        designadores.add(line);
                    }
                } catch (FileNotFoundException e) {
                    //Some error logging
                }

                //for com designadores
                for (String designador : designadores) {

                    try {
                        List<NbiDeviceData> eqps = FactoryDAO.createNBI().findDevicesBySubscriberId(designador);
                        System.out.println("Quantidade Eqps -> " + eqps.size());
                        if (eqps.size() == 0) {
                            builder.append(designador).append(";").append("0\n");
                        }

                        for (NbiDeviceData eqp1 : eqps) {
                            builder.append(designador).append(";");
                            System.out.println("Equipamento -> " + deviceMapper.serialize(eqp1));
                            builder.append(deviceMapper.serialize(eqp1).replace("&gt;", ">")).append(";");
                            try {
//                                GetParameterValuesResponseDTO parameters = instance.getParametersValues(eqp1, paths);
//                                builder.append(getParameterMapper.serialize(parameters)).append(";");
//                                System.out.println("Parameters -> " + getParameterMapper.serialize(parameters));
                                try {
                                    List<ParameterValueStructDTO> p = new ArrayList<>();
//                                    ParameterValueStructDTO pvs = new ParameterValueStructDTO();
//                                    pvs.setName(parameters.getParameterList().get(0).getValue() + ".X_VIVO_COM_BR_IPv6CPEnable");
//                                    pvs.setType("boolean");
//                                    pvs.setValue("true");
                                    ParameterValueStructDTO pvs1 = new ParameterValueStructDTO();
                                    pvs1.setName("InternetGatewayDevice.LANDevice.1.X_TELEFONICA-ES_IPv6LANHostConfigManagement.AutoConfigurationAddress");
                                    pvs1.setType("boolean");
                                    pvs1.setValue("false");
//                                    p.add(pvs);
                                    p.add(pvs1);
                                    SetParameterValuesResponseDTO s = instance.setParamValues(eqp1, p);
                                    builder.append(setParameterMapper.serialize(s)).append(";\n");
                                    System.out.println(setParameterMapper.serialize(s));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    builder.append(e.getMessage()).append("\n");
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                                builder.append(e.getMessage()).append("\n");
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        builder.append(designador).append(";").append(e.getMessage()).append("\n");
                    }
                }
                pw.write(builder.toString());
                pw.close();
                System.out.println("done!" + nomeTo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    class Paranauezin implements Runnable {

        String nomeFrom, nomeTo;

        public Paranauezin(String nomeFroms, String nomeTos) {
            nomeFrom = nomeFroms;
            nomeTo = nomeTos;
        }

        @Override
        public void run() {
            PrintWriter pw = null;

            try {
                pw = new PrintWriter(new File(nomeTo));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try (BufferedReader br = new BufferedReader(new FileReader(nomeFrom))) {
                String line = "";
                int i = 0;
                while ((line = br.readLine()) != null) {
                    String[] leLine = line.split(";");
                    String praescreve = "";
                    try {
                        List<NbiDeviceData> eqps = FactoryDAO.createNBI().findDeviceBySerialNumber(leLine[4]);
                        if (eqps.isEmpty()) {
                            praescreve = "Equipamento não encontrado.";
                        } else {
                            try {
                                List<ParameterValueStructDTO> p = new ArrayList<>();
                                ParameterValueStructDTO pvs1 = new ParameterValueStructDTO();
                                pvs1.setName("InternetGatewayDevice.LANDevice.1.X_TELEFONICA-ES_IPv6LANHostConfigManagement.AutoConfigurationAddress");
                                pvs1.setType("boolean");
                                pvs1.setValue("false");
                                p.add(pvs1);
                                SetParameterValuesResponseDTO s = instance.setParamValues(eqps.get(0), p);

                                praescreve = new JacksonMapper(SetParameterValuesResponseDTO.class).serialize(s);

                            } catch (Exception ex) {
                                praescreve = ex.getMessage();
                            }
                        }
                    } catch (Exception e) {
                        praescreve = e.getMessage();
                    }
                    System.out.println("LINE " + i + " -> " + praescreve);
                    i++;
                    pw.write(line + praescreve + "\n");
                }
                pw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testMethod() throws Exception {
        //"C:\\Users\\G0041775\\Desktop\\getSetInternetService.csv"
//
        List<String> lFrom = new ArrayList<>();
        List<String> lTo = new ArrayList<>();
        String nomeFrom = "C:\\Users\\G0041775\\Desktop\\Arno\\LAN FALSE\\22-11-2018\\paei2325133135.csv";
        String nomeTo = "C:\\Users\\G0041775\\Desktop\\Arno\\LAN FALSE\\22-11-2018\\paei2325133135Result.csv";

//        String file = "C:\\Users\\G0041775\\Desktop\\Arno\\LAN FALSE\\designadoresRound2";
//        PrintWriter pw = null;
//        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//            String line = "";
//            int i = 0;
//            int o = 30;
//            int n = 0;
//            String fileName = "C:\\Users\\G0041775\\Desktop\\Arno\\LAN FALSE\\desigsRound2" + n + ".csv";
//            String fileTo = "C:\\Users\\G0041775\\Desktop\\Arno\\LAN FALSE\\resultsRound2" + n + ".csv";
//            lFrom.add(fileName);
//            lTo.add(fileTo);
//            try {
//                pw = new PrintWriter(new File(fileName));
//                n++;
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//            while ((line = br.readLine()) != null) {
//                if (i >= o) {
//                    pw.close();
//                    try {
//                        fileName = "C:\\Users\\G0041775\\Desktop\\Arno\\LAN FALSE\\desigsRound2" + n + ".csv";
//                        fileTo = "C:\\Users\\G0041775\\Desktop\\Arno\\LAN FALSE\\resultsRound2" + n + ".csv";
//                        pw = new PrintWriter(new File(fileName));
//                        lFrom.add(fileName);
//                        lTo.add(fileTo);
//                        n++;
//                        i = 0;
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                    }
//                }
//                pw.write(line + "\n");
//                i++;
//            }
//            pw.close();
//        } catch (FileNotFoundException e) {
//            //Some error logging
//        }
        lFrom.add(nomeFrom);
        lTo.add(nomeTo);
        System.out.println("lFrom -> " + lFrom.toString());
        System.out.println("lTo -> " + lTo.toString());

        List<Paranauezeiro> l = new ArrayList<>();
        for (int i = 0; i < lFrom.size(); i++) {
            l.add(new Paranauezeiro(lFrom.get(i), lTo.get(i)));
            l.get(i).start();
        }
        l.forEach((t) -> {
            try {
                t.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(SynchDeviceDAOImplIT.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
//        pw = new PrintWriter(new File("C:\\Users\\G0041775\\Desktop\\Arno\\LAN FALSE\\setFalseResultRound2.csv"));
//        pw.write("Designador;Equipamento;setResult\n");
//        String linz = "";
//        for (String string : lTo) {
//            try (BufferedReader br = new BufferedReader(new FileReader(string))) {
//                while ((linz = br.readLine()) != null) {
//                    if (!linz.contains("Designador;Equipamento;setResult")) {
//                        pw.write(linz + "\n");
//                    }
//                }
//            } catch (Exception e) {
//            }
//        }
//        pw.close();

    }

    @Test

    public void testMethod1() {
        try {
            System.out.println("testMethod1");
            PrintWriter pw = null;
            JacksonMapper deviceMapper = new JacksonMapper(NbiDeviceData.class);
            JacksonMapper getParameterMapper = new JacksonMapper(GetParameterValuesResponseDTO.class);
            List<String> paths = new ArrayList<>();
            paths.add("InternetGatewayDevice.X_VIVO_COM_BR.Interfaces.InternetService");
            try {
                pw = new PrintWriter(new File("C:\\Users\\G0041775\\Desktop\\setInternetService.csv"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            StringBuilder builder = new StringBuilder();
            String ColumnNamesList = "Designador;Equipamento;SetParameter;GetParameter";
            builder.append(ColumnNamesList).append("\n");

            String file = "C:\\Users\\G0041775\\Desktop\\getok.csv";
            List<String[]> linhas = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = "";
                while ((line = br.readLine()) != null) {
                    linhas.add(line.replace("\"\"", "\"").replaceAll(";\"", ";").replaceFirst("\\\"\\n", "").split(";"));
                }
            } catch (FileNotFoundException e) {
                //Some error logging
            }

            for (String[] linha : linhas) {

                try {
//                  
                    builder.append(linha[0]).append(";");
                    NbiDeviceData eqp1 = (NbiDeviceData) deviceMapper.deserialize(linha[1]);
                    System.out.println("Equipamento -> " + deviceMapper.serialize(eqp1));
                    GetParameterValuesResponseDTO parameters = (GetParameterValuesResponseDTO) getParameterMapper.deserialize(linha[2]);
                    builder.append(deviceMapper.serialize(eqp1)).append(";");
                    try {

                        List<ParameterValueStructDTO> p = new ArrayList<>();
                        ParameterValueStructDTO pvs = new ParameterValueStructDTO();
                        pvs.setName(parameters.getParameterList().get(0).getValue() + ".X_VIVO_COM_BR_IPv6CPEnable");
                        pvs.setType("boolean");
                        pvs.setValue("false");
                        p.add(pvs);
                        SetParameterValuesResponseDTO s = instance.setParamValues(eqp1, p);
                        builder.append(new JacksonMapper(SetParameterValuesResponseDTO.class).serialize(s)).append(";");
                        System.out.println(new JacksonMapper(SetParameterValuesResponseDTO.class).serialize(s));

                        List<String> paths1 = new ArrayList<>();
                        paths1.add(parameters.getParameterList().get(0).getValue() + ".X_VIVO_COM_BR_IPv6CPEnable");
                        GetParameterValuesResponseDTO parameters1 = instance.getParametersValues(eqp1, paths1);
                        builder.append(getParameterMapper.serialize(parameters1)).append("\n");
                        System.out.println(getParameterMapper.serialize(parameters1));

                    } catch (Exception e) {
                        e.printStackTrace();
                        builder.append(e.getMessage()).append("\n");
                    }
//                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    builder.append(linha[0]).append(";").append(e.getMessage()).append("\n");
                }
            }
            pw.write(builder.toString());
            pw.close();
            System.out.println("done!");
        } catch (Exception e) {
            e.printStackTrace();
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

        WanInfo result = instance.getWanInfo(eqp);
        System.out.println(new JacksonMapper<>(WanInfo.class).serialize(result));
    }

    /**
     * Test of getServiceClass method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testGetServiceClass() throws Exception {
        System.out.println("getServiceClass");

        ServiceClass result = instance.getServiceClass(eqp);
        System.out.println(new JacksonMapper<>(ServiceClass.class).serialize(result));
    }

    /**
     * Test of setServiceClass method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testSetServiceClass() throws Exception {
        System.out.println("setServiceClass");

        ServiceClass sc = new ServiceClass();
        sc.setClassOfService("service05");

        Boolean result = instance.setServiceClass(eqp, sc);
        System.out.println(result.toString());
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

        DmzInfo result = instance.getDmzInfo(eqp);
        System.out.println(new JacksonMapper<>(DmzInfo.class).serialize(result));
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

        Dhcp result = instance.getDhcp(eqp);
        System.out.println(new JacksonMapper(Dhcp.class).serialize(result));
    }

    /**
     * Test of setDhcp method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testSetDhcp() throws Exception {
        System.out.println("setDhcp");
        Dhcp dh = new Dhcp();
        //instance.getDhcp(eqp);
        dh.setDHCPServerEnable(true);
        dh.setMaxAddress("192.168.15.240");
        dh.setMinAddress("192.168.15.2");

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


        List<WifiInfoFull> wifis = instance.getWifiInfoFull(eqp);
        WifiInfoFull wifi = wifis.get(4);
        wifi.setChannel("108");

//        wifi.setBcEnabled(Boolean.TRUE);
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
        pPPoECredentialsInfo.setUsername("2138513195@turbonetpro");
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

        SipDiagnostics result = instance.getSipDiagnostics(eqp, 2);
//        SipDiagnostics result1 = instance.getSipDiagnostics(eqp, 2);
        System.out.println("phyReference 1->" + new JacksonMapper(SipDiagnostics.class).serialize(result));
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

    /**
     * Test of getParameterAttributes method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testGetParameterAttributes() throws Exception {
        System.out.println("getParameterAttributes");

        String path = "";
        SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
        GetParameterAttributesResponseDTO expResult = null;
        GetParameterAttributesResponseDTO result = instance.getParameterAttributes(eqp, path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setParametersValues method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testSetParametersValues() throws Exception {
        System.out.println("setParametersValues");
        NbiDeviceData eqp = FactoryDAO.createNBI().findDevicesBySubscriberId("FNS-814VU9AHWL-013").get(0);
        List<ParameterValueStructDTO> p = new ArrayList<>();
        ParameterValueStructDTO pvs = new ParameterValueStructDTO();
        pvs.setName("InternetGatewayDevice.WANDevice.1.WANConnectionDevice.1.WANPPPConnection.1.X_VIVO_COM_BR_IPv6CPEnable");
        pvs.setType("boolean");
        pvs.setValue("false");
        p.add(pvs);
        instance.setParametersValues(eqp, p);
        List<String> paths = new ArrayList<>();
        paths.add("InternetGatewayDevice.WANDevice.1.WANConnectionDevice.1.WANPPPConnection.1.X_VIVO_COM_BR_IPv6CPEnable");
        System.out.println(new JacksonMapper(GetParameterValuesResponseDTO.class).serialize(instance.getParametersValues(eqp, paths)));
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setSipDeactivation method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testSetSipDeactivation() throws Exception {
        System.out.println("setSipDeactivation");
        NbiDeviceData eqp = null;
        Integer phyref = null;
        SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
        Boolean expResult = null;
        Boolean result = instance.setSipDeactivation(eqp, phyref);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sipRestart method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testSipRestart() throws Exception {
        System.out.println("sipRestart");
        NbiDeviceData eqp = null;
        Integer phyref = null;
        SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
        Boolean expResult = null;
        Boolean result = instance.sipRestart(eqp, phyref);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exec method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testExec() throws Exception {
        System.out.println("exec");
        NbiDeviceData eqp = null;
        List<Object> json = null;
        int i = 0;
        NbiSingleDeviceOperationOptions opt = null;
        long l = 0L;
        String str = "";
        SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
        StringResponseDTO expResult = null;
        StringResponseDTO result = instance.exec(eqp, json, i, opt, l, str);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of forceOnline method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testForceOnline() throws Exception {
        System.out.println("forceOnline");

        Boolean result = instance.forceOnline(eqp);

        System.out.println(new JacksonMapper(Boolean.class).serialize(result));
    }

    /**
     * Test of getDns method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testGetDns() throws Exception {
        System.out.println("getDns");

        Dns result = instance.getDns(eqp);
        System.out.println(new JacksonMapper<>(Dns.class).serialize(result));
    }

    /**
     * Test of setDns method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testSetDns() throws Exception {
        System.out.println("setDns");
        NbiDeviceData eqp = null;
        String dnsServers = "";
        SynchDeviceDAOImpl instance = new SynchDeviceDAOImpl();
        Boolean expResult = null;
        Boolean result = instance.setDns(eqp, dnsServers);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setT38 method, of class SynchDeviceDAOImpl.
     */
    @Test
    public void testSetT38() throws Exception {
        System.out.println("setT38");

        Boolean result = instance.setT38(eqp, true);

        System.out.println("resultado->" + result);
    }

}
