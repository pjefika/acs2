/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// CLASSES
var WifiInfoFull = function(p) {
    if (p) {
        this.admStatus = p.admStatus;
        this.operStatus = p.operStatus;
        this.channel = p.channel;
        this.bcEnabled = p.bcEnabled;
        this.maxBitRate = p.maxBitRate;
        this.signal = p.signal;
        this.ssid = p.ssid;
        this.authMode = p.authMode;
        this.ssid = p.ssid;
        this.encType = p.encType;
        this.key = p.key;
        this.wepKeyIndex = p.wepKeyIndex;
        this.macAddrControl = p.macAddrControl;
        this.macAddress = p.macAddress;
        this.radioStatus = p.radioStatus;
        this.standard = p.standard;
        this.bytesSent = p.bytesSent;
        this.bytesRecv = p.bytesRecv;
        this.pctSent = p.pctSent;
        this.pctRecv = p.pctRecv;
        this.errSent = p.errSent;
        this.errRecv = p.errRecv;
        this.wpsEnabled = p.wpsEnabled;
        this.wpsDeviceName = p.wpsDeviceName;
        this.wpsDevicePassword = p.wpsDevicePassword;
    }
};
