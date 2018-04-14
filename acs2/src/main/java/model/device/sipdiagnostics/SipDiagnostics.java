/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.device.sipdiagnostics;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import parser.device.SipDiagnosticsDeserializer;

/**
 *
 * @author G0041775
 */
@JsonDeserialize(using = SipDiagnosticsDeserializer.class)
public class SipDiagnostics {

    private String ProxyServer, ProxyServerPort, RegistrarServer,
            UserAgentDomain, UserAgentPort, OutboundProxy, ConferenceCallURI,
            DirectoryNumber, Enable, LineEnable, AuthUserName, AuthPassword,
            URI, CallState, DigitMap, ProfileEnable, DTMFMethod, Codec,
            T38Enable, Status, PacketsLost, IPAddress;

    public SipDiagnostics() {
    }

    public String getProxyServer() {
        return ProxyServer;
    }

    public void setProxyServer(String ProxyServer) {
        this.ProxyServer = ProxyServer;
    }

    public String getProxyServerPort() {
        return ProxyServerPort;
    }

    public void setProxyServerPort(String ProxyServerPort) {
        this.ProxyServerPort = ProxyServerPort;
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

    public String getUserAgentPort() {
        return UserAgentPort;
    }

    public void setUserAgentPort(String UserAgentPort) {
        this.UserAgentPort = UserAgentPort;
    }

    public String getOutboundProxy() {
        return OutboundProxy;
    }

    public void setOutboundProxy(String OutboundProxy) {
        this.OutboundProxy = OutboundProxy;
    }

    public String getConferenceCallURI() {
        return ConferenceCallURI;
    }

    public void setConferenceCallURI(String ConferenceCallURI) {
        this.ConferenceCallURI = ConferenceCallURI;
    }

    public String getDirectoryNumber() {
        return DirectoryNumber;
    }

    public void setDirectoryNumber(String DirectoryNumber) {
        this.DirectoryNumber = DirectoryNumber;
    }

    public String getEnable() {
        return Enable;
    }

    public void setEnable(String Enable) {
        this.Enable = Enable;
    }

    public String getLineEnable() {
        return LineEnable;
    }

    public void setLineEnable(String LineEnable) {
        this.LineEnable = LineEnable;
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

    public String getURI() {
        return URI;
    }

    public void setURI(String URI) {
        this.URI = URI;
    }

    public String getCallState() {
        return CallState;
    }

    public void setCallState(String CallState) {
        this.CallState = CallState;
    }

    public String getDigitMap() {
        return DigitMap;
    }

    public void setDigitMap(String DigitMap) {
        this.DigitMap = DigitMap;
    }

    public String getProfileEnable() {
        return ProfileEnable;
    }

    public void setProfileEnable(String ProfileEnable) {
        this.ProfileEnable = ProfileEnable;
    }

    public String getDTMFMethod() {
        return DTMFMethod;
    }

    public void setDTMFMethod(String DTMFMethod) {
        this.DTMFMethod = DTMFMethod;
    }

    public String getCodec() {
        return Codec;
    }

    public void setCodec(String Codec) {
        this.Codec = Codec;
    }

    public String getT38Enable() {
        return T38Enable;
    }

    public void setT38Enable(String T38Enable) {
        this.T38Enable = T38Enable;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getPacketsLost() {
        return PacketsLost;
    }

    public void setPacketsLost(String PacketsLost) {
        this.PacketsLost = PacketsLost;
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }

}
