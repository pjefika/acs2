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
public class WifiInfoSet {

    private String operStatus,
            ssid,
            radioOperStatus,
            index,
            frequency,
            authentication,
            broadcastEnable,
            autochannel,
            encryptation,
            standard,
            beaconType,
            password,
            channel;

    public WifiInfoSet(){
    }
    
    public WifiInfoSet(String a, String a1, String a2) {
       
    }

    public WifiInfoSet(WifiInfoFull getInfo){
       this.authentication = getInfo.getAuthMode();
       this.broadcastEnable = getInfo.getBcEnabled().toString();
       this.channel = getInfo.getChannel();
       this.encryptation = getInfo.getEncType();
//       this.operStatus = getInfo.getOperStatus();
//       this.password = getInfo.getKey();
       this.radioOperStatus = getInfo.getRadioStatus();
       this.ssid = getInfo.getSsid();
       this.standard = getInfo.getStandard();
    }
    
    public String getRadioOperStatus() {
        return radioOperStatus;
    }

    public void setRadioOperStatus(String radioOperStatus) {
        this.radioOperStatus = radioOperStatus;
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

    public String getBroadcastEnable() {
        return broadcastEnable;
    }

    public void setBroadcastEnable(String broadcastEnable) {
        this.broadcastEnable = broadcastEnable;
    }

    public String getAutochannel() {
        return autochannel;
    }

    public void setAutochannel(String autochannel) {
        this.autochannel = autochannel;
    }

    public String getEncryptation() {
        return encryptation;
    }

    public void setEncryptation(String encryptation) {
        this.encryptation = encryptation;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getBeaconType() {
        return beaconType;
    }

    public void setBeaconType(String beaconType) {
        this.beaconType = beaconType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

    public String getOperStatus() {
        return operStatus;
    }

    public void setOperStatus(String operStatus) {
        this.operStatus = operStatus;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }


}
