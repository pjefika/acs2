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
            index,
            //            frequency,
            //            authentication,
            //            bcEnable,
            //            autochannel,
            //            encryptation,
            //            standard,
            //            beaconType,
            password,
            channel;
    private Boolean radioOperStatus, operStatus, autochannel;

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
        this.index = "1";
        try {
            if (!getInfo.getKey().isEmpty()) {
                this.password = getInfo.getKey();
            }
        } catch (Exception e) {
        }

        this.autochannel = false;
//       this.standard = getInfo.getStandard();
    }

    public Boolean getRadioOperStatus() {
        return radioOperStatus;
    }

    public void setRadioOperStatus(Boolean radioOperStatus) {
        this.radioOperStatus = radioOperStatus;
    }

    public Boolean getAutochannel() {
        return autochannel;
    }

    public void setAutochannel(Boolean autochannel) {
        this.autochannel = autochannel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
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
