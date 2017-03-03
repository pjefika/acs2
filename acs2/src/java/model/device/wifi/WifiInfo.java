/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.device.wifi;

/**
 *
 * @author G0042204
 */
public class WifiInfo {

    private String index,
            frequency,
            authentication,
            broadcastEnabled,
            channel,
            operStatus,
            enryptation,
            radioStatus,
            ssid,
            standard,
            ssidPassword;

    public WifiInfo() {
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getAuthentication() {
        return authentication;
    }

    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }

    public String getBroadcastEnabled() {
        return broadcastEnabled;
    }

    public void setBroadcastEnabled(String broadcastEnabled) {
        this.broadcastEnabled = broadcastEnabled;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getOperStatus() {
        return operStatus;
    }

    public void setOperStatus(String operStatus) {
        this.operStatus = operStatus;
    }

    public String getEnryptation() {
        return enryptation;
    }

    public void setEnryptation(String enryptation) {
        this.enryptation = enryptation;
    }

    public String getRadioStatus() {
        return radioStatus;
    }

    public void setRadioStatus(String radioStatus) {
        this.radioStatus = radioStatus;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getSsidPassword() {
        return ssidPassword;
    }

    public void setSsidPassword(String ssidPassword) {
        this.ssidPassword = ssidPassword;
    }

}
