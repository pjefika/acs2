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

    private String ssid,
            //            index,
            //            frequency,
            //            authentication,
            //            bcEnable,
            //            autochannel,
            //            encryptation,
            //            standard,
            //            beaconType,
            password,
            channel;

    private Boolean radioOperStatus, operStatus;

    public WifiInfoSet() {
    }

    public WifiInfoSet(WifiInfoFull getInfo) {
//       this.authentication = getInfo.getAuthMode();
//       this.bcEnable = getInfo.getBcEnabled().toString();
        this.channel = getInfo.getChannel();
//       this.encryptation = getInfo.getEncType();
//       this.password = getInfo.getKey();
        this.radioOperStatus = true;
        this.operStatus = true;
        this.ssid = getInfo.getSsid();
        this.password = getInfo.getKey();
//       this.standard = getInfo.getStandard();
    }

    public Boolean getRadioOperStatus() {
        return radioOperStatus;
    }

    public void setRadioOperStatus(Boolean radioOperStatus) {
        this.radioOperStatus = radioOperStatus;
    }

//    public String getIndex() {
//        return index;
//    }
//
//    public void setIndex(String index) {
//        this.index = index;
//    }
//
//    public String getFrequency() {
//        return frequency;
//    }
//
//    public void setFrequency(String frequency) {
//        this.frequency = frequency;
//    }
//
//    public String getAuthentication() {
//        return authentication;
//    }
//
//    public void setAuthentication(String authentication) {
//        this.authentication = authentication;
//    }
//
//    public String getBcEnable() {
//        return bcEnable;
//    }
//
//    public void setBcEnable(String bcEnable) {
//        this.bcEnable = bcEnable;
//    }
//
//    public String getAutochannel() {
//        return autochannel;
//    }
//
//    public void setAutochannel(String autochannel) {
//        this.autochannel = autochannel;
//    }
//
//    public String getEncryptation() {
//        return encryptation;
//    }
//
//    public void setEncryptation(String encryptation) {
//        this.encryptation = encryptation;
//    }
//
//    public String getStandard() {
//        return standard;
//    }
//
//    public void setStandard(String standard) {
//        this.standard = standard;
//    }
//
//    public String getBeaconType() {
//        return beaconType;
//    }
//
//    public void setBeaconType(String beaconType) {
//        this.beaconType = beaconType;
//    }
//
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getOperStatus() {
        return operStatus;
    }

    public void setOperStatus(Boolean operStatus) {
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
