/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl.wifi;

import br.net.gvt.efika.acs.model.device.enums.DeviceTR;
import br.net.gvt.efika.acs.model.device.wifi.WifiInfoFull;
import java.util.ArrayList;
import java.util.List;
import model.service.device.impl.wifi.acao.SetParameters;
import motive.hdm.synchdeviceops.GetParameterValuesResponseDTO;
import motive.hdm.synchdeviceops.ParameterValueStructDTO;

/**
 *
 * @author G0041775
 */
public class WifiParser {

    public static List<WifiInfoFull> parse(GetParameterValuesResponseDTO vals) {
        List<WifiInfoFull> l = new ArrayList<>();
        WifiInfoFull dois = parse(vals, 1);
//        WifiInfoFull guest = parse(vals, 2);
        WifiInfoFull cinco = parse(vals, 5);
        if (dois.getAdmStatus() != null) {
            l.add(dois);
        }
//        if (guest.getAdmStatus() != null) {
//            l.add(guest);
//        }
        if (cinco.getAdmStatus() != null) {
            l.add(cinco);
        }

        return l;
    }

    public static WifiInfoFull parse(GetParameterValuesResponseDTO vals, int wichone) {
        WifiInfoFull wifi = new WifiInfoFull();
        for (ParameterValueStructDTO p : vals.getParameterList()) {
            if (p.getName().equalsIgnoreCase("InternetGatewayDevice.LANDevice.1.WLANConfiguration." + wichone + ".Enable")
                    || p.getName().equalsIgnoreCase("Device.WiFi.SSID." + wichone + ".Enable")) {
                wifi.setAdmStatus(p.getValue());
            }
            if (p.getName().equalsIgnoreCase("InternetGatewayDevice.LANDevice.1.WLANConfiguration." + wichone + ".Status")
                    || p.getName().equalsIgnoreCase("Device.WiFi.SSID." + wichone + ".Status")) {
                wifi.setOperStatus(p.getValue());
            }
            if (p.getName().equalsIgnoreCase("InternetGatewayDevice.LANDevice.1.WLANConfiguration." + wichone + ".Channel")
                    || p.getName().equalsIgnoreCase("Device.WiFi.SSID." + wichone + ".Channel")) {
                wifi.setChannel(p.getValue());
            }
            if (p.getName().equalsIgnoreCase("InternetGatewayDevice.LANDevice.1.WLANConfiguration." + wichone + ".WPAAuthenticationMode")) {
                wifi.setAuthMode(p.getValue());
            }
            if (p.getName().equalsIgnoreCase("InternetGatewayDevice.LANDevice.1.WLANConfiguration." + wichone + ".SSIDAdvertisementEnabled")
                    || p.getName().equalsIgnoreCase("Device.WiFi.AccessPoint." + wichone + ".SSIDAdvertisementEnabled")) {
                wifi.setBcEnabled(p.getValue());
            }
            if (p.getName().equalsIgnoreCase("InternetGatewayDevice.LANDevice.1.WLANConfiguration." + wichone + ".TotalBytesReceived")
                    || p.getName().equalsIgnoreCase("Device.WiFi.Radio." + wichone + ".Stats.BytesReceived")) {
                wifi.setBytesRecv(p.getValue());
            }
            if (p.getName().equalsIgnoreCase("InternetGatewayDevice.LANDevice.1.WLANConfiguration." + wichone + ".BytesSent")
                    || p.getName().equalsIgnoreCase("Device.WiFi.Radio." + wichone + ".Stats.BytesSent")) {
                wifi.setBytesSent(p.getValue());
            }
            if (p.getName().equalsIgnoreCase("InternetGatewayDevice.LANDevice.1.WLANConfiguration." + wichone + ".WPAEncryptionModes")) {
                wifi.setEncType(p.getValue());
            }
            if (p.getName().equalsIgnoreCase("InternetGatewayDevice.LANDevice.1.WLANConfiguration." + wichone + ".Stats.ErrorsReceived")
                    || p.getName().equalsIgnoreCase("Device.WiFi.Radio." + wichone + ".Stats.ErrorsReceived")) {
                wifi.setErrRecv(p.getValue());
            }
            if (p.getName().equalsIgnoreCase("InternetGatewayDevice.LANDevice.1.WLANConfiguration." + wichone + ".Stats.ErrorsSent")
                    || p.getName().equalsIgnoreCase("Device.WiFi.Radio." + wichone + ".Stats.ErrorsSent")) {
                wifi.setErrSent(p.getValue());
            }
            if (p.getName().equalsIgnoreCase("InternetGatewayDevice.LANDevice.1.WLANConfiguration." + wichone + ".KeyPassphrase")
                    || p.getName().equalsIgnoreCase("Device.WiFi.AccessPoint." + wichone + ".Security.KeyPassphrase")) {
                wifi.setKey(p.getValue());
            }
            if (p.getName().equalsIgnoreCase("InternetGatewayDevice.LANDevice.1.WLANConfiguration." + wichone + ".MACAddressControlEnabled")
                    || p.getName().equalsIgnoreCase("Device.WiFi.AccessPoint." + wichone + ".MACAddressControlEnabled")) {
                wifi.setMacAddrControl(p.getValue());
            }
            if (p.getName().equalsIgnoreCase("InternetGatewayDevice.LANDevice.1.WLANConfiguration." + wichone + ".BSSID")
                    || p.getName().equalsIgnoreCase("Device.WiFi.SSID." + wichone + ".BSSID")) {
                wifi.setMacAddress(p.getValue());
            }
            if (p.getName().equalsIgnoreCase("InternetGatewayDevice.LANDevice.1.WLANConfiguration." + wichone + ".MaxBitRate")
                    || p.getName().equalsIgnoreCase("Device.WiFi.Radio." + wichone + ".MaxBitRate")) {
                wifi.setMaxBitRate(p.getValue());
            }
            if (p.getName().equalsIgnoreCase("InternetGatewayDevice.LANDevice.1.WLANConfiguration." + wichone + ".TotalPacketsReceived")
                    || p.getName().equalsIgnoreCase("Device.WiFi.Radio." + wichone + ".Stats.PacketsReceived")) {
                wifi.setPctRecv(p.getValue());
            }
            if (p.getName().equalsIgnoreCase("InternetGatewayDevice.LANDevice.1.WLANConfiguration." + wichone + ".TotalPacketsSent")
                    || p.getName().equalsIgnoreCase("Device.WiFi.Radio." + wichone + ".Stats.PacketsSent")) {
                wifi.setPctSent(p.getValue());
            }
            if (p.getName().equalsIgnoreCase("InternetGatewayDevice.LANDevice.1.WLANConfiguration." + wichone + ".RadioEnable")
                    || p.getName().equalsIgnoreCase("Device.WiFi.Radio." + wichone + ".Status")) {
                wifi.setRadioStatus(p.getValue());
            }
            if (p.getName().equalsIgnoreCase("InternetGatewayDevice.LANDevice.1.WLANConfiguration." + wichone + ".TransmitPower")
                    || p.getName().equalsIgnoreCase("Device.WiFi.Radio." + wichone + ".TransmitPower")) {
                wifi.setSignal(p.getValue());
            }
            if (p.getName().equalsIgnoreCase("InternetGatewayDevice.LANDevice.1.WLANConfiguration." + wichone + ".SSID")
                    || p.getName().equalsIgnoreCase("Device.WiFi.SSID." + wichone + ".SSID")) {
                wifi.setSsid(p.getValue());
            }
            if (p.getName().equalsIgnoreCase("InternetGatewayDevice.LANDevice.1.WLANConfiguration." + wichone + ".Standard")
                    || p.getName().equalsIgnoreCase("Device.WiFi.Radio." + wichone + ".OperatingStandards")) {
                wifi.setStandard(p.getValue());
            }
            if (p.getName().equalsIgnoreCase("InternetGatewayDevice.LANDevice.1.WLANConfiguration." + wichone + ".WEPKeyIndex")
                    || p.getName().equalsIgnoreCase("Device.WiFi.AccessPoint." + wichone)) {
                wifi.setWepKeyIndex(p.getValue());
            }
            if (p.getName().equalsIgnoreCase("InternetGatewayDevice.LANDevice.1.WLANConfiguration." + wichone + ".WPS.DeviceName")) {
                wifi.setWpsDeviceName(p.getValue());
            }
            if (p.getName().equalsIgnoreCase("InternetGatewayDevice.LANDevice.1.WLANConfiguration." + wichone + ".WPS.DevicePassword")
                    || p.getName().equalsIgnoreCase("Device.WiFi.AccessPoint." + wichone + ".WPS.PIN")) {
                wifi.setWpsDevicePassword(p.getValue());
            }
            if (p.getName().equalsIgnoreCase("InternetGatewayDevice.LANDevice.1.WLANConfiguration." + wichone + ".WPS.Enable")
                    || p.getName().equalsIgnoreCase("Device.WiFi.AccessPoint." + wichone + ".WPS.Enable")) {
                wifi.setWpsEnabled(p.getValue());
            }
            if (p.getName().equalsIgnoreCase("InternetGatewayDevice.LANDevice.1.WLANConfiguration." + wichone + ".Alias")) {
                wifi.setAlias(p.getValue());
            }

        }
        return wifi;
    }

    public static List<ParameterValueStructDTO> parse(WifiInfoFull wifi, DeviceTR tr) {
        List<ParameterValueStructDTO> l = new ArrayList<>();
        int wichone = 1;

        if (wifi.getAlias() != null && wifi.getAlias().contains("5ghz")) {
            wichone = 5;
        }
//        else if (wifi.getAlias().contains("2ghz-02")) {
//            wichone = 2;
//        }

        l.add(SetParameters.setAdmStatusWifi(tr, wifi.getAdmStatus(), wichone));
        l.add(SetParameters.setChannelWifi(tr, wifi.getChannel(), wichone));
        if (!wifi.getKey()
                .isEmpty()) {
            l.add(SetParameters.setPasswordWifi(tr, wifi.getKey(), wichone));
        }

        l.add(SetParameters.setSsidWifi(tr, wifi.getSsid(), wichone));

        return l;
    }

}
