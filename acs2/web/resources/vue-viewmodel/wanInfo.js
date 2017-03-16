/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// CLASSES
var WanInfo = function(p) {
    if (p) {
        this.EthernetBytesSent = p.EthernetBytesSent;
        this.EthernetBytesReceived = p.EthernetBytesReceived;
        this.EthernetPacketsSent = p.EthernetPacketsSent;
        this.EthernetPacketsReceived = p.EthernetPacketsReceived;
        this.EthernetErrorsSent = p.EthernetErrorsSent;
        this.EthernetErrorsReceived = p.EthernetErrorsReceived;
        this.EthernetDiscardPacketsSent = p.EthernetDiscardPacketsSent;
        this.EthernetDiscardPacketsReceived = p.EthernetDiscardPacketsReceived;
    }
};