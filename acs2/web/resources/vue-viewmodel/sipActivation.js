/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// CLASSES
var SipActivation = function (p) {
    if (p) {
        this.DirectoryNumber = p.DirectoryNumber;
        this.AuthUserName = p.AuthUserName;
        this.AuthPassword = p.AuthPassword;
        this.ProxyServer = p.ProxyServer;
        this.RegistrarServer = p.RegistrarServer;
        this.UserAgentDomain = p.UserAgentDomain;
        this.OutboundProxy = p.OutboundProxy;
        this.phyReferenceList = p.phyReferenceList;
    }
};