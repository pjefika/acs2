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
public class WifiInfoFull extends WifiInfoSet {

    private String admStatus,
                authMode,
                encType,
                key,
                wepKeyIndex,
                macAddress,
                radioStatus, 
                standard,
                wpsDeviceName,
                wpsDevicePassword,
                maxBitRate;

    
   
    private Integer signal;
    
    private Boolean bcEnabled,
                    macAddrControl,
                    wpsEnabled;
    
    
    private String bytesSent,
                        bytesRecv,
                        pctSent,
                        pctRecv,
                        errSent,
                        errRecv;
                        

            

    public WifiInfoFull() {
    }

    public String getAuthMode() {
        return authMode;
    }

    public void setAuthMode(String authMode) {
        this.authMode = authMode;
    }

    public String getEncType() {
        return encType;
    }

    public void setEncType(String encType) {
        this.encType = encType;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getWepKeyIndex() {
        return wepKeyIndex;
    }

    public void setWepKeyIndex(String wepKeyIndex) {
        this.wepKeyIndex = wepKeyIndex;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getRadioStatus() {
        return radioStatus;
    }

    public void setRadioStatus(String radioStatus) {
        this.radioStatus = radioStatus;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getWpsDeviceName() {
        return wpsDeviceName;
    }

    public void setWpsDeviceName(String wpsDeviceName) {
        this.wpsDeviceName = wpsDeviceName;
    }

    public String getWpsDevicePassword() {
        return wpsDevicePassword;
    }

    public void setWpsDevicePassword(String wpsDevicePassword) {
        this.wpsDevicePassword = wpsDevicePassword;
    }

    public String getMaxBitRate() {
        return maxBitRate;
    }

    public void setMaxBitRate(String maxBitRate) {
        this.maxBitRate = maxBitRate;
    }

    public Integer getSignal() {
        return signal;
    }

    public void setSignal(Integer signal) {
        this.signal = signal;
    }

    public Boolean getBcEnabled() {
        return bcEnabled;
    }

    public void setBcEnabled(Boolean bcEnabled) {
        this.bcEnabled = bcEnabled;
    }

    public Boolean getMacAddrControl() {
        return macAddrControl;
    }

    public void setMacAddrControl(Boolean macAddrControl) {
        this.macAddrControl = macAddrControl;
    }

    public String getAdmStatus() {
        return admStatus;
    }

    public void setAdmStatus(String admStatus) {
        this.admStatus = admStatus;
    }

    public Boolean getWpsEnabled() {
        return wpsEnabled;
    }

    public void setWpsEnabled(Boolean wpsEnabled) {
        this.wpsEnabled = wpsEnabled;
    }

    public String getBytesSent() {
        return bytesSent;
    }

    public void setBytesSent(String bytesSent) {
        this.bytesSent = bytesSent;
    }

    public String getBytesRecv() {
        return bytesRecv;
    }

    public void setBytesRecv(String bytesRecv) {
        this.bytesRecv = bytesRecv;
    }

    public String getPctSent() {
        return pctSent;
    }

    public void setPctSent(String pctSent) {
        this.pctSent = pctSent;
    }

    public String getPctRecv() {
        return pctRecv;
    }

    public void setPctRecv(String pctRecv) {
        this.pctRecv = pctRecv;
    }

    public String getErrSent() {
        return errSent;
    }

    public void setErrSent(String errSent) {
        this.errSent = errSent;
    }

    public String getErrRecv() {
        return errRecv;
    }

    public void setErrRecv(String errRecv) {
        this.errRecv = errRecv;
    }

   
}
