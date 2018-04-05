/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import model.exception.JsonUtilException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.device.DmzInfo;
import model.device.ddns.DdnsInfo;
import model.device.firmware.FirmwareInfo;
import model.device.interfacestatistics.InterfaceStatistics;
import model.device.lanhost.LanDevice;
import model.device.log.DeviceLog;
import model.device.log.DeviceLogR;
import model.device.ping.PingResponse;
import model.device.portmapping.PortMappingInfo;
import model.device.pppoe.PPPoECredentialsInfo;
import model.device.serviceclass.ServiceClass;
import model.device.wan.WanInfo;
import model.device.wifi.WifiInfo;
import model.device.wifi.WifiInfoFull;
import model.device.xdsldiagnostics.XdslDiagnostics;
import model.exception.UnsupportedException;
import motive.hdm.synchdeviceops.StringResponseDTO;

/**
 *
 * @author G0042204
 */
public class JsonUtil {

//    public static FirmwareInfo firmwareInfo(StringResponseDTO a) throws Exception {
//        String firmwareVersion = "";
//        String preferredVersion = "";
//        try {
//            
//            JsonElement jelement = new JsonParser().parse(a.getValue());
//            JsonObject jobject = jelement.getAsJsonObject();
//            firmwareVersion = jobject.get("firmwareVersion").toString().replace("\"", "");
//            preferredVersion = jobject.get("preferredVersion").toString().replace("\"", "");
//        } catch (Exception e) {
//            if (a.getValue().equalsIgnoreCase("O CPE não suporta o(s) parâmetro(s) solicitados.")) {
//                throw new UnsupportedException();
//            }
//            throw new JsonUtilException("A resposta da plataforma não estava de acordo com o esperado");
//        }
//        return new FirmwareInfo(firmwareVersion, preferredVersion);
//    }

    public static DmzInfo dmzInfo(StringResponseDTO a) {
        JsonElement jelement = new JsonParser().parse(a.getValue());
        JsonObject jobject = jelement.getAsJsonObject();
        String Enable = jobject.get("Enable").toString().replace("\"", "");
        String IPAddress = jobject.get("IPAddress").toString().replace("\"", "");
        return new DmzInfo(new Boolean(Enable), IPAddress);
    }


    public static List<PortMappingInfo> getPortMappingInfo(StringResponseDTO a) throws JsonUtilException {

        List<PortMappingInfo> lst = new ArrayList<>();

        try {

            JsonArray j = new JsonParser().parse(a.getValue()).getAsJsonArray();

            for (int k = 0; k < j.size(); k++) {
                PortMappingInfo i = new PortMappingInfo();

                JsonObject jobject = j.get(k).getAsJsonObject();

                String externalPort;

                try {
                    externalPort = jobject.get("externalPort").toString().replace("\"", "");
                } catch (Exception e) {
                    externalPort = "";
                }

                String internalClient = jobject.get("internalClient").toString().replace("\"", "");
                String internalPort = jobject.get("internalPort").toString().replace("\"", "");
                String portMapName = jobject.get("portMapName").toString().replace("\"", "");
                Boolean enable = jobject.get("enable").getAsBoolean();
                String protocol = jobject.get("protocol").toString().replace("\"", "");
                String remoteHost = jobject.get("remoteHost").toString().replace("\"", "");

                i.setExternalPort(externalPort);
                i.setInternalClient(internalClient);
                i.setInternalPort(internalPort);
                i.setPortMapName(portMapName);
                i.setEnable(enable);
                i.setProtocol(protocol);
                i.setRemoteHost(remoteHost);

                lst.add(i);
            }
        } catch (IllegalStateException e) {
            throw new JsonUtilException("A resposta da plataforma não era um Json");
        } catch (NullPointerException e) {
            throw new JsonUtilException("A resposta da plataforma não estava de acordo com o esperado");
        }

        return lst;
    }

    public static WifiInfo getWifiInfo(StringResponseDTO a) {

        WifiInfo i = new WifiInfo();

        JsonElement jelement = new JsonParser().parse(a.getValue().replace("[", "").replace("]", ""));
        JsonObject jobject = jelement.getAsJsonObject();

        // System.out.println("FullJson: " + jobject.toString());
//        String index = jobject.get("index").toString();
//        String authentication = jobject.get("authentication").toString().replace("\"", "");
        String broadcastEnabled = jobject.get("broadcastEnabled").toString().replace("\"", "");

        String channel;
        try {
            channel = jobject.get("Channel").toString().replace("\"", "");
        } catch (Exception e) {
            channel = jobject.get("channel").toString().replace("\"", "");
        }

        String ssid;
        try {
            ssid = jobject.get("ssid").toString().replace("\"", "");
        } catch (Exception e) {
            ssid = jobject.get("SSID").toString().replace("\"", "");
        }

        String operStatus = jobject.get("operStatus").toString().replace("\"", "");

        //        String encryptation = jobject.get("encryptation").toString().replace("\"", "");
        String radioStatus;
        try {
            radioStatus = jobject.get("RadioEnabled").toString().replace("\"", "");
        } catch (Exception e) {
            radioStatus = jobject.get("radioStatus").toString().replace("\"", "");
        }

//        String standard = jobject.get("Standard").toString().replace("\"", "");
        String password = jobject.get("ssidPassword").toString().replace("\"", "");

//        i.setIndex(index);
//        i.setAuthentication(authentication);
        i.setBroadcastEnabled(broadcastEnabled);
        i.setChannel(channel);
//        i.setOperStatus(tr);
//        i.setEncryptation(encryptation);
//        i.setRadioOperStatus(radioStatus);
        i.setSsid(ssid);
//        i.setStandard(standard);
        i.setSsidPassword(password);

        return i;
    }

    public static WifiInfoFull getWifiInfoFull(StringResponseDTO a) throws JsonUtilException {

        WifiInfoFull i = new WifiInfoFull();

        try {

            JsonElement jelement = new JsonParser().parse(a.getValue().replace("[", "").replace("]", ""));
            JsonObject jobject = jelement.getAsJsonObject();

            String admStatus = jobject.get("admStatus").toString().replace("\"", "");
            String operStatus = jobject.get("operStatus").toString().replace("\"", "");
            String channel = jobject.get("channel").toString().replace("\"", "");
//            Boolean bcEnabled = jobject.get("bcEnabled").getAsBoolean();
//            String maxBitRate = jobject.get("maxBitRate").toString().replace("\"", "");
//            String signal = jobject.get("signal").toString().replace("\"", "");
            String ssid = jobject.get("ssid").toString().replace("\"", "");
//            String authMode = jobject.get("authMode").toString().replace("\"", "");
//            String encType = jobject.get("encType").toString().replace("\"", "");
            String key = jobject.get("key").toString().replace("\"", "");
//            String wepKeyIndex = jobject.get("wepKeyIndex").toString().replace("\"", "");
//            Boolean macAddrControl = jobject.get("macAddrControl").getAsBoolean();
//            String macAddress = jobject.get("macAddress").toString().replace("\"", "");
            String radioStatus;
            try {
                radioStatus = jobject.get("radioStatus").toString().replace("\"", "");
            } catch (Exception e) {
                radioStatus = jobject.get("RadioEnabled").toString().replace("\"", "");
            }
//            String standard = jobject.get("standard").toString().replace("\"", "");
//            String bytesSent = jobject.get("bytesSent").toString().replace("\"", "");
//            String bytesRecv = jobject.get("bytesRecv").toString().replace("\"", "");
//            String pctSent = jobject.get("pctSent").toString().replace("\"", "");
//            String pctRecv = jobject.get("pctRecv").toString().replace("\"", "");
//            String errSent = jobject.get("errSent").toString().replace("\"", "");
//            String errRecv = jobject.get("errRecv").toString().replace("\"", "");
//            Boolean wpsEnabled = jobject.get("wpsEnabled").getAsBoolean();
//            String wpsDeviceName = jobject.get("wpsDeviceName").toString().replace("\"", "");
//            String wpsDevicePassword = jobject.get("wpsDevicePassword").toString().replace("\"", "");

            i.setSsid(ssid);
            i.setAdmStatus(admStatus);
//            i.setAuthMode(authMode);
//            i.setBcEnabled(bcEnabled);
//            i.setBytesRecv(bytesRecv);
//            i.setBytesSent(bytesSent);
            i.setChannel(channel);
//            i.setEncType(encType);
//            i.setErrRecv(errRecv);
//            i.setErrSent(errSent);
            i.setKey(key);
//            i.setMacAddrControl(macAddrControl);
//            i.setMacAddress(macAddress);
//            i.setMaxBitRate(maxBitRate);
            i.setOperStatus(operStatus);
//            i.setPctSent(pctSent);
//            i.setPctRecv(pctRecv);
            i.setRadioStatus(radioStatus);
//            i.setSignal(signal);
//            i.setStandard(standard);
//            i.setWepKeyIndex(wepKeyIndex);
//            i.setWpsDeviceName(wpsDeviceName);
//            i.setWpsDevicePassword(wpsDevicePassword);
//            i.setWpsEnabled(wpsEnabled);

        } catch (IllegalStateException e) {
            throw new JsonUtilException("Falha ao obter resposta da plataforma.");
        } catch (NullPointerException e) {
            throw new JsonUtilException("A resposta da plataforma não estava de acordo com o esperado.");
        }

        return i;
    }

    public static WanInfo getWanInfo(StringResponseDTO a) throws JsonUtilException {

        WanInfo i = new WanInfo();

        try {
            JsonElement jelement = new JsonParser().parse(a.getValue().replace("[", "").replace("]", ""));
            JsonObject jobject = jelement.getAsJsonObject();

            String EthernetBytesSent = jobject.get("EthernetBytesSent").toString().replace("\"", "");
            String EthernetBytesReceived = jobject.get("EthernetBytesReceived").toString().replace("\"", "");
            String EthernetPacketsSent = jobject.get("EthernetPacketsSent").toString().replace("\"", "");
            String EthernetPacketsReceived = jobject.get("EthernetPacketsReceived").toString().replace("\"", "");
            String EthernetErrorsSent = jobject.get("EthernetErrorsSent").toString().replace("\"", "");
            String EthernetErrorsReceived = jobject.get("EthernetErrorsReceived").toString().replace("\"", "");
            String EthernetDiscardPacketsSent = jobject.get("EthernetDiscardPacketsSent").toString().replace("\"", "");
            String EthernetDiscardPacketsReceived = jobject.get("EthernetDiscardPacketsReceived").toString().replace("\"", "");

            i.setBytesReceived(EthernetBytesReceived);
            i.setBytesSent(EthernetBytesSent);
            i.setDiscardPacketsReceived(EthernetDiscardPacketsReceived);
            i.setDiscardPacketsSent(EthernetDiscardPacketsSent);
            i.setErrorsReceived(EthernetErrorsReceived);
            i.setErrorsSent(EthernetErrorsSent);
            i.setPacketsReceived(EthernetPacketsReceived);
            i.setPacketsSent(EthernetPacketsSent);
        } catch (IllegalStateException e) {
            throw new JsonUtilException("A resposta da plataforma não era um Json");
        } catch (NullPointerException e) {
            throw new JsonUtilException("A resposta da plataforma não estava de acordo com o esperado");
        }

        return i;
    }

    public static ServiceClass getServiceClass(StringResponseDTO a) {

        ServiceClass sc = new ServiceClass();

        JsonElement jelement = new JsonParser().parse(a.getValue());
        JsonObject jobject = jelement.getAsJsonObject();
        System.out.println(jobject.toString());
        String serviceOfClass = jobject.get("AccessClass") != null ? jobject.get("AccessClass").toString().replace("\"", "") : jobject.get("classOfService").toString().replace("\"", "");

        sc.setClassOfService(serviceOfClass);

        return sc;
    }

    public static DdnsInfo ddnsInfo(StringResponseDTO a) throws JsonUtilException {

        DdnsInfo d = new DdnsInfo();

        try {

            JsonElement jelement = new JsonParser().parse(a.getValue());
            JsonObject jobject = jelement.getAsJsonObject();

            Boolean enable = new Boolean(jobject.get("Enable").toString().replace("\"", ""));
            String hostname = jobject.get("Hostname").toString().replace("\"", "");
            String password = jobject.get("Password").toString().replace("\"", "");
            String provider = jobject.get("Provider").toString().replace("\"", "");
            String providerUrl = jobject.get("ProviderURL").toString().replace("\"", "");
            String user = jobject.get("User").toString().replace("\"", "");

            d.setEnable(enable);
            d.setHostname(hostname);
            d.setPassword(password);
            d.setProvider(provider);
            d.setProviderUrl(providerUrl);
            d.setUser(user);

        } catch (IllegalStateException e) {
            throw new JsonUtilException("A resposta da plataforma não era um Json");
        } catch (NullPointerException e) {
            throw new JsonUtilException("A resposta da plataforma não estava de acordo com o esperado");
        }

        return d;
    }

    public static List<DeviceLog> deviceLog(StringResponseDTO a) {
        JsonElement jelement = new JsonParser().parse(a.getValue());
        JsonObject jobject = jelement.getAsJsonObject();
        String[] split = jobject.get("DeviceLog").toString().replace("\"", "").replace("\\n", "\n").replace("\\t", "    ").split("\n");

        List<DeviceLog> logs = new ArrayList<>();

        for (String string : split) {
            logs.add(new DeviceLog(string));
        }

        return logs;
    }

    public static List<LanDevice> getLanHosts(StringResponseDTO a) throws JsonUtilException {

        List<LanDevice> lst = new ArrayList<>();

        try {

            String tratativa = a.getValue().replace("{", "[{").replace("}", "}]").replaceAll("\"HostNumberOfEntries\":\"[0-9]{1,10}\",", "").replaceAll("Host.[0-9]{1,10}.", "").replace("\",\"IPAddress\"", "\"},{\"IPAddress\"");
            JsonElement jelement = new JsonParser().parse(tratativa);

//        System.out.println("Element: " + jelement.toString());
            JsonArray j = jelement.getAsJsonArray();

//        System.out.println("JsonArray: " + j.toString());
            for (int k = 0; k < j.size(); k++) {
                LanDevice l = new LanDevice();

                JsonObject jobject = j.get(k).getAsJsonObject();
                l.setIpAddress(jobject.get("IPAddress").toString().replace("\"", ""));
                l.setAddressSource(jobject.get("AddressSource").toString().replace("\"", ""));
                l.setLeaseTimeRemaining(jobject.get("LeaseTimeRemaining").toString().replace("\"", ""));
                l.setMacAddress(jobject.get("MACAddress").toString().replace("\"", ""));
                l.setHostName(jobject.get("HostName").toString().replace("\"", ""));
                l.setInterfaceType(jobject.get("InterfaceType").toString().replace("\"", ""));
                l.setAtivo(Boolean.valueOf(jobject.get("Active").toString().replace("\"", "")));
                lst.add(l);
            }
        } catch (IllegalStateException e) {
            if (a.getValue().contains("HostNumberOfEntries")) {
                return lst;
            }
            throw new JsonUtilException("A resposta da plataforma não era um Json");
        } catch (NullPointerException e) {
            if (a.getValue().contains("HostNumberOfEntries")) {
                return lst;
            }
            throw new JsonUtilException("A resposta da plataforma não estava de acordo com o esperado");
        }

        return lst;
    }

    public static PingResponse pingResponse(StringResponseDTO a) throws JsonUtilException {
        PingResponse r = new PingResponse();
        try {
            JsonElement jelement = new JsonParser().parse(a.getValue());
            JsonObject jobject = jelement.getAsJsonObject();

            String status;
            try {
                status = jobject.get("status").toString().replace("\"", "");
            } catch (Exception e) {
                status = jobject.get("diagnosticState").toString().replace("\"", "");
            }

            String avgRespTime = jobject.get("avgRespTime").toString().replace("\"", "");
            String qtdSuccess = jobject.get("qtdSuccess").toString().replace("\"", "");
            String qtdFailures = jobject.get("qtdFailures").toString().replace("\"", "");
            String hostAddress = jobject.get("hostAddress").toString().replace("\"", "");
            String repetitions = jobject.get("repetitions").toString().replace("\"", "");

            r.setStatus(status);
            r.setAvgRespTime(avgRespTime);
            r.setQtdSuccess(qtdSuccess);
            r.setQtdFailures(qtdFailures);
            r.setHostAddress(hostAddress);
            r.setRepetitions(repetitions);
        } catch (IllegalStateException e) {
            throw new JsonUtilException("A resposta da plataforma não era um Json");
        } catch (NullPointerException e) {
            throw new JsonUtilException("A resposta da plataforma não estava de acordo com o esperado");
        }
        return r;
    }

    public static String removeBracket(String json) {
        return json;
        // .replace("[", "").replace("]", "").replace("\"", "\"\"");
    }

    public static PPPoECredentialsInfo getPPPoECredentialsInfo(StringResponseDTO a) throws JsonUtilException {

        PPPoECredentialsInfo i = new PPPoECredentialsInfo();
        try {
            JsonElement jelement = new JsonParser().parse(a.getValue());
            JsonObject jobject = jelement.getAsJsonObject();
            String username = jobject.get("Username").toString().replace("\"", "");
            String password = jobject.get("Password").toString().replace("\"", "");
            i = new PPPoECredentialsInfo(username, password);
        } catch (IllegalStateException e) {
            throw new JsonUtilException("A resposta da plataforma não era um Json");
        } catch (NullPointerException e) {
            throw new JsonUtilException("A resposta da plataforma não estava de acordo com o esperado");
        }

        return i;
    }

    public static List<InterfaceStatistics> getInterfaceStatistics(StringResponseDTO a) throws JsonUtilException {

        List<InterfaceStatistics> list = new ArrayList<>();

        try {

            JsonElement jelement = new JsonParser().parse(a.getValue());
            JsonArray jarray = jelement.getAsJsonArray();

            for (JsonElement jsonElement : jarray) {
                JsonObject jobject = jsonElement.getAsJsonObject();

                InterfaceStatistics i = new InterfaceStatistics();

                String operStatus = jobject.get("operStatus") != null ? jobject.get("operStatus").toString().replace("\"", "") : "";
                String ipAddress = jobject.get("ipAddress") != null ? jobject.get("ipAddress").toString().replace("\"", "") : "";
                if (operStatus.contentEquals("Up") && !(ipAddress.isEmpty())) {
                    String ifType;
                    if (jobject.get("ifType") != null) {
                        ifType = jobject.get("ifType").toString().replace("\"", "");
                    } else if (jobject.get("iftype") != null) {
                        ifType = jobject.get("iftype").toString().replace("\"", "");
                    } else {
                        ifType = "";
                    }
                    String adminStatus = jobject.get("adminStatus") != null ? jobject.get("adminStatus").toString().replace("\"", "") : "";
                    String ifName = jobject.get("ifName") != null ? jobject.get("ifName").toString().replace("\"", "") : "";

                    String ipAddrType = jobject.get("ipAddrType") != null ? jobject.get("ipAddrType").toString().replace("\"", "") : "";
                    String macAddress = jobject.get("macAddress") != null ? jobject.get("macAddress").toString().replace("\"", "") : "";
                    String bytesSent = jobject.get("bytesSent") != null ? jobject.get("bytesSent").toString().replace("\"", "") : "";
                    String bytesRecv = jobject.get("bytesRecv") != null ? jobject.get("bytesRecv").toString().replace("\"", "") : "";
                    String errSent = jobject.get("errSent") != null ? jobject.get("errSent").toString().replace("\"", "") : "";
                    String errRecv = jobject.get("errRecv") != null ? jobject.get("errRecv").toString().replace("\"", "") : "";
                    String pctSent = jobject.get("pctSent") != null ? jobject.get("pctSent").toString().replace("\"", "") : "";
                    String pctRecv = jobject.get("pctRecv") != null ? jobject.get("pctRecv").toString().replace("\"", "") : "";
                    String mcSent = jobject.get("mcSent") != null ? jobject.get("mcSent").toString().replace("\"", "") : "";
                    String mcRecv = jobject.get("mcRecv") != null ? jobject.get("mcRecv").toString().replace("\"", "") : "";
                    String bcSent = jobject.get("bcSent") != null ? jobject.get("bcSent").toString().replace("\"", "") : "";
                    String bcRecv = jobject.get("bcRecv") != null ? jobject.get("bcRecv").toString().replace("\"", "") : "";

                    i.setAdminStatus(adminStatus);
                    i.setIpAddress(ipAddress);
                    i.setBcRecv(bcRecv);
                    i.setBcSent(bcSent);
                    i.setBytesRecv(bytesRecv);
                    i.setBytesSent(bytesSent);
                    i.setErrRecv(errRecv);
                    i.setErrSent(errSent);
                    i.setIfName(ifName);
                    i.setIfType(ifType);
                    i.setIpAddrType(ipAddrType);
                    i.setMacAddress(macAddress);
                    i.setMcRecv(mcRecv);
                    i.setMcSent(mcSent);
                    i.setOperStatus(operStatus);
                    i.setPctRecv(pctRecv);
                    i.setPctSent(pctSent);

                    list.add(i);
                }

            }
        } catch (IllegalStateException e) {
            throw new JsonUtilException("A resposta da plataforma não era um Json");
        } catch (NullPointerException e) {
            throw new JsonUtilException("A resposta da plataforma não estava de acordo com o esperado");
        }

        return list;
    }

    public static XdslDiagnostics getXdslDiagnostics(StringResponseDTO a) throws JsonUtilException {
        XdslDiagnostics x = new XdslDiagnostics();

        try {
            JsonElement jelement = new JsonParser().parse(a.getValue());
            JsonObject jobject = jelement.getAsJsonObject();

            String ModulationType = jobject.get("ModulationType").toString().replace("\"", "");
            String ShowtimeStart = jobject.get("ShowtimeStart").toString().replace("\"", "");
            String UpstreamMaxRate = jobject.get("UpstreamMaxRate").toString().replace("\"", "");
            String UpstreamCurrRate = jobject.get("UpstreamCurrRate").toString().replace("\"", "");
            String UpstreamPower = jobject.get("UpstreamPower").toString().replace("\"", "");
            String UpstreamNoiseMargin = jobject.get("UpstreamNoiseMargin").toString().replace("\"", "");
            String UpstreamAttenuation = jobject.get("UpstreamAttenuation").toString().replace("\"", "");
            String DownstreamMaxRate = jobject.get("DownstreamMaxRate").toString().replace("\"", "");
            String DownstreamCurrRate = jobject.get("DownstreamCurrRate").toString().replace("\"", "");
            String DownstreamPower = jobject.get("DownstreamPower").toString().replace("\"", "");
            String DownstreamNoiseMargin = jobject.get("DownstreamNoiseMargin").toString().replace("\"", "");
            String DownstreamAttenuation = jobject.get("DownstreamAttenuation").toString().replace("\"", "");
            String LinkRetrain = jobject.get("LinkRetrain").toString().replace("\"", "");
            String LossOfFraming = jobject.get("LossOfFraming").toString().replace("\"", "");
            String SeverelyErroredSecs = jobject.get("SeverelyErroredSecs").toString().replace("\"", "");
            String ATUCFECErrors = jobject.get("ATUCFECErrors").toString().replace("\"", "");
            String ATUCHECErrors = jobject.get("ATUCHECErrors").toString().replace("\"", "");
            String ATUCCRCErrors = jobject.get("ATUCCRCErrors").toString().replace("\"", "");
            String FECErrors = jobject.get("FECErrors").toString().replace("\"", "");
            String HECErrors = jobject.get("HECErrors").toString().replace("\"", "");
            String CRCErrors = jobject.get("CRCErrors").toString().replace("\"", "");

            x.setATUCCRCErrors(ATUCCRCErrors);
            x.setATUCFECErrors(ATUCFECErrors);
            x.setATUCHECErrors(ATUCHECErrors);
            x.setCRCErrors(CRCErrors);
            x.setDownstreamAttenuation(DownstreamAttenuation);
            x.setDownstreamCurrRate(DownstreamCurrRate);
            x.setDownstreamMaxRate(DownstreamMaxRate);
            x.setDownstreamPower(DownstreamPower);
            x.setDownstreamNoiseMargin(DownstreamNoiseMargin);
            x.setFECErrors(FECErrors);
            x.setHECErrors(HECErrors);
            x.setLinkRetrain(LinkRetrain);
            x.setLossOfFraming(LossOfFraming);
            x.setModulationType(ModulationType);
            x.setSeverelyErroredSecs(SeverelyErroredSecs);
            x.setShowtimeStart(ShowtimeStart);
            x.setUpstreamAttenuation(UpstreamAttenuation);
            x.setUpstreamCurrRate(UpstreamCurrRate);
            x.setUpstreamMaxRate(UpstreamMaxRate);
            x.setUpstreamNoiseMargin(UpstreamNoiseMargin);
            x.setUpstreamPower(UpstreamPower);
        } catch (IllegalStateException e) {
            throw new JsonUtilException("A resposta da plataforma não era um Json");
        } catch (NullPointerException e) {
            throw new JsonUtilException("A resposta da plataforma não estava de acordo com o esperado");
        }

        return x;
    }

    public static List<DeviceLogR> deviceLogR(StringResponseDTO a) {
        JsonElement jelement = new JsonParser().parse(a.getValue());
        JsonObject jobject = jelement.getAsJsonObject();
        String[] split = jobject.get("DeviceLog").toString().replace("\"", "").replace("\\n", "\n").split("\n");
        JsonArray list = new JsonArray();
        for (String string : split) {
            if (!string.isEmpty()) {
                //System.out.println(string);                
                String[] lineSplit = string.replace("\"", "").replace("\\t", "\t").split("\t");
//                System.out.println("Index" + lineSplit[0]);
//                System.out.println("Time" + lineSplit[1]);
//                System.out.println("Type" + lineSplit[2]);
//                System.out.println("Servity" + lineSplit[3]);
//                System.out.println("LogInformation" + lineSplit[4]);
//                System.out.println("----------------------------------");
                JsonObject obj = new JsonObject();
                obj.addProperty("Index", lineSplit[0]);
                obj.addProperty("Time", lineSplit[1]);
                obj.addProperty("Type", lineSplit[2]);
                obj.addProperty("Servity", lineSplit[3]);
                obj.addProperty("LogInformation", lineSplit[4]);
                list.add(obj);
            }
        }
        //System.out.println(list);
        //List<DeviceLogR> logs = new ArrayList<>();        
        DeviceLogR[] logs = gson.fromJson(list, DeviceLogR[].class);
        return Arrays.asList(logs);
    }

}
