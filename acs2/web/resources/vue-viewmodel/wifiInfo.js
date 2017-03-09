/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// CLASSES
var WifiInfo = function(p) {
    if (p) {
        this.index = p.index;
        this.frequency = p.frequency;
        this.authentication = p.authentication;
        this.broadcastEnabled = p.broadcastEnabled;
        this.channel = p.channel;
        this.operStatus = p.operStatus;
        this.encryptation = p.encryptation;
        this.radioEnabled = p.radioEnabled;
        this.ssid = p.ssid;
        this.standard = p.standard;
        this.ssidPassword = p.ssidPassword;
    }
};
