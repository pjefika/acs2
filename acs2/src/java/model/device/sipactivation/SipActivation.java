/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.device.sipactivation;

/**
 *
 * @author G0041775
 */
public class SipActivation {

    private String DirectoryNumber,
            AuthUserName,
            AuthPassword,
            ProxyServer,
            RegistrarServer,
            UserAgentDomain,
            OutboundProxy, phyReferenceList;

    private Boolean t38Enable;

    public SipActivation() {
    }

    public String getDirectoryNumber() {
        return DirectoryNumber;
    }

    public void setDirectoryNumber(String DirectoryNumber) {
        this.DirectoryNumber = DirectoryNumber;
    }

    public String getAuthUserName() {
        return AuthUserName;
    }

    public void setAuthUserName(String AuthUserName) {
        this.AuthUserName = AuthUserName;
    }

    public String getAuthPassword() {
        return AuthPassword;
    }

    public void setAuthPassword(String AuthPassword) {
        this.AuthPassword = AuthPassword;
    }

    public String getProxyServer() {
        return ProxyServer;
    }

    public void setProxyServer(String ProxyServer) {
        this.ProxyServer = ProxyServer;
    }

    public String getRegistrarServer() {
        return RegistrarServer;
    }

    public void setRegistrarServer(String RegistrarServer) {
        this.RegistrarServer = RegistrarServer;
    }

    public String getUserAgentDomain() {
        return UserAgentDomain;
    }

    public void setUserAgentDomain(String UserAgentDomain) {
        this.UserAgentDomain = UserAgentDomain;
    }

    public String getOutboundProxy() {
        return OutboundProxy;
    }

    public void setOutboundProxy(String OutboundProxy) {
        this.OutboundProxy = OutboundProxy;
    }

    public String getPhyReferenceList() {
        return phyReferenceList;
    }

    public void setPhyReferenceList(String phyReferenceList) {
        this.phyReferenceList = phyReferenceList;
    }

    public Boolean getT38Enable() {
        return t38Enable;
    }

    public void setT38Enable(Boolean t38Enable) {
        this.t38Enable = t38Enable;
    }

}
