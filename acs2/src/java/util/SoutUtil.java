/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.alcatel.hdm.service.nbi2.NbiDeviceActionResult;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import com.alcatel.hdm.service.nbi2.NbiDynamicVariable;
import com.alcatel.hdm.service.nbi2.NbiServiceTag;
import com.alcatel.hdm.service.nbi2.NbiUserTag;
import java.util.List;
import model.device.DmzInfo;
import model.device.ddns.DdnsInfo;
import model.device.firmware.FirmwareInfo;
import model.device.log.DeviceLog;
import model.device.ping.PingResponse;
import model.device.portmapping.PortMappingInfo;
import model.device.pppoe.PPPoECredentialsInfo;
import model.device.wifi.WifiInfo;
import model.device.wifi.WifiInfoFull;
import motive.hdm.synchdeviceops.ExecuteFunctionResponse;

/**
 *
 * @author G0042204
 */
public class SoutUtil {

    public static void print(NbiDeviceData d) {
        System.out.println("DeviceGUID: " + d.getDeviceGUID());
        System.out.println("OUI: " + d.getDeviceId().getOUI());
        System.out.println("SubscriberID: " + d.getSubscriberID());
        System.out.println("ProductClass: " + d.getDeviceId().getProductClass());
        /**
         * "the class of device, which can be one of: 0: REGULAR_DEVICE_CLASS 1:
         * VIRTUAL_DEVICE_CLASS 2: PROXIER_HOSTING_VIRTUAL_DEVICE_CLASS 3:
         * PROXIER_HOSTING_EMBEDDED_DEVICE_CLASS 4:
         * PROXIER_HOSTING_BOTH_DEVICE_CLASS"
         */
        System.out.println("DeviceClass: " + d.getDeviceClass());
        System.out.println("Protocol: " + d.getDeviceId().getProtocol());
        System.out.println("SerialNumber: " + d.getDeviceId().getSerialNumber());
        System.out.println("LastContactTime: " + d.getLastContactTime());
        System.out.println("FirstContactTime: " + d.getFirstContactTime());
        System.out.println("LastActivationTime: " + d.getLastActivationTime());
        System.out.println("getConnectionRequestURL: " + d.getConnectionRequestURL());
        System.out.println("ConnectionRequestUsername: " + d.getConnectionRequestUsername());
        System.out.println("tConnectionRequestPassword: " + d.getConnectionRequestPassword());
        System.out.println("Type: " + d.getType());
        System.out.println("Model: " + d.getModel());

        for (NbiUserTag tag : d.getUserTagArray()) {
            System.out.println("UserTagArray: " + tag.getName() + "| Valor: " + tag.getValue());
        }

        for (NbiServiceTag tag : d.getServiceTagArray()) {
            System.out.println("ServiceTagArray: " + tag.getName() + "| Valor: " + tag.getValue());
        }

        for (NbiDynamicVariable dyn : d.getDynamicVariables()) {
            System.out.println("NbiDynamicVariable: " + dyn.getName() + "| Valor: " + dyn.getValue());
        }

        System.out.println("");
    }

    public static void print(FirmwareInfo i) {
        System.out.println("firmwareVersion: " + i.getFirmwareVersion());
        System.out.println("preferredVersion: " + i.getPreferredVersion());
    }

    public static void print(DmzInfo i) {
        System.out.println("IPAddress: " + i.getIPAddress());
        System.out.println("Enable: " + i.getEnable());
    }

    public static void print(DdnsInfo d) {
        System.out.println("Enable: " + d.getEnable());
        System.out.println("Hostname: " + d.getHostname());
        System.out.println("Provider: " + d.getProvider());
        System.out.println("ProviderUrl: " + d.getProviderUrl());
        System.out.println("User: " + d.getUser());
    }

    public static void print(List<NbiDeviceData> ds) {
        for (NbiDeviceData nbiDeviceData : ds) {
            print(nbiDeviceData);
        }
    }

    public static void print(PPPoECredentialsInfo info) {
        System.out.println("Username: " + info.getUsername());
        System.out.println("Password: " + info.getPassword());
    }

    public static void print(WifiInfo info) {
        System.out.println("SSID: " + info.getSsid());
        System.out.println("Password: " + info.getSsidPassword());
        System.out.println("Frequency: " + info.getFrequency());
        System.out.println("Enryptation: " + info.getEncryptation());
    }

    public static void print(WifiInfoFull info) {
        System.out.println("SSID: " + info.getSsid());
        System.out.println("Senha: " + info.getKey());
        System.out.println("Encriptacao: " + info.getEncType());
        System.out.println("Status: " + info.getOperStatus());
        System.out.println("Canal: " + info.getChannel());
        System.out.println("Broadcast: " + info.getBcEnabled());
        System.out.println("Auth: " + info.getAuthMode());
        System.out.println("Standard: " + info.getStandard());

    }

    public static void print(PortMappingInfo info) {
        System.out.println("ExternalPort: " + info.getExternalPort());
        System.out.println("InternalClient: " + info.getInternalClient());
        System.out.println("RemoteHost: " + info.getRemoteHost());
        System.out.println("PortMapName: " + info.getPortMapName());
    }

    public static void printl(List<DeviceLog> l) {
        for (DeviceLog nbiDeviceData : l) {
            System.out.println("Mensagem: " + nbiDeviceData.getMensagem());
        }
    }

    public static void print(NbiDeviceActionResult r) {
        System.out.println("getFaultString: " + r.getFaultString());
        System.out.println("getStatus: " + r.getStatus());
    }

    public static void print(ExecuteFunctionResponse e) {
        System.out.println(e.getReturn());
    }

    public static void print(PingResponse p) {
        System.out.println("Status" + p.getStatus());
        System.out.println("QtdSuccess" + p.getQtdSuccess());
        System.out.println("QtdFailures" + p.getQtdFailures());
    }

}
