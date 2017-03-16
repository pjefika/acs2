/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// CLASSES
var InterfaceStatistics = function(p) {
    if (p) {
        this.ifType = p.ifType;
        this.adminStatus = p.adminStatus;
        this.operStatus = p.operStatus;
        this.ifName = p.ifName;
        this.ipAddress = p.ipAddress;
        this.ipAddrType = p.ipAddrType;
        this.macAddress = p.macAddress;
        this.bytesSent = p.bytesSent;
        this.bytesRecv = p.bytesRecv;
        this.errSent = p.errSent;
        this.errRecv = p.errRecv;
        this.pctSent = p.pctSent;
        this.pctRecv = p.pctRecv;
        this.mcSent = p.mcSent;
        this.mcRecv = p.mcRecv; 
        this.bcSent = p.bcSent;
        this.bcRecv = p.bcRecv; 
    }
};