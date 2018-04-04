/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.device.ddns;

/**
 *
 * @author G0042204
 */
public class DdnsInfo {

    private Boolean enable;

    private String provider, user, password, hostname, providerUrl;

    public DdnsInfo() {
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getProviderUrl() {
        return providerUrl;
    }

    public void setProviderUrl(String providerurl) {
        this.providerUrl = providerurl;
    }
}
