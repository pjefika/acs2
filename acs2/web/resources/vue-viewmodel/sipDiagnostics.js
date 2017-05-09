/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// CLASSES
var SipDiagnostics = function(p) {
    if (p) {
        this.ProxyServer = p.ProxyServer;
        this.ProxyServerPort = p.ProxyServerPort;
        this.RegistrarServer = p.RegistrarServer;
        this.UserAgentDomain = p.UserAgentDomain;
        this.UserAgentPort = p.UserAgentPort;
        this.OutboundProxy = p.OutboundProxy;
        this.ConferenceCallURI = p.ConferenceCallURI;
        this.DirectoryNumber = p.DirectoryNumber;
        this.Enable = p.Enable;
        this.LineEnable = p.LineEnable;
        this.AuthUserName = p.AuthUserName;
        this.AuthPassword = p.AuthPassword;
        this.URI = p.URI;
        this.CallState = p.CallState;
        this.DigitMap = p.DigitMap;
        this.ProfileEnable = p.ProfileEnable;
        this.DTMFMethod = p.DTMFMethod;
        this.Codec = p.Codec;
        this.T38Enable = p.T38Enable;
        this.Status = p.Status;
        this.PacketsLost = p.PacketsLost;
    }
};