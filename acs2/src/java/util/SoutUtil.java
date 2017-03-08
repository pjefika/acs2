/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.alcatel.hdm.service.nbi2.NbiDeviceActionResult;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import java.util.List;
import model.device.ddns.DdnsInfo;
import model.device.firmware.FirmwareInfo;
import model.device.log.DeviceLog;
import model.device.portmapping.PortMappingInfo;
import model.device.pppoe.PPPoECredentialsInfo;
import model.device.wifi.WifiInfo;
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
        System.out.println("getProductClass: " + d.getDeviceId().getProductClass());
        System.out.println("getProtocol: " + d.getDeviceId().getProtocol());
        System.out.println("SerialNumber: " + d.getDeviceId().getSerialNumber());
        System.out.println("LastContactTime: " + d.getLastContactTime());
        System.out.println("getConnectionRequestURL: " + d.getConnectionRequestURL());
        System.out.println("getConnectionRequestUsername: " + d.getConnectionRequestUsername());
        System.out.println("getConnectionRequestPassword: " + d.getConnectionRequestPassword());
        System.out.println("");
    }

    public static void print(FirmwareInfo i) {
        System.out.println("firmwareVersion: " + i.getFirmwareVersion());
        System.out.println("preferredVersion: " + i.getPreferredVersion());
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

    public static void print(PortMappingInfo info) {
        System.out.println("ExternalPort: " + info.getExternalPort());
        System.out.println("InternalClient: " + info.getInternalClient());
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

}