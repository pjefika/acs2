/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.device.wan;

/**
 *
 * @author G0041775
 */
public class WanInfo {
    
    private String EthernetBytesSent,
            EthernetBytesReceived,
            EthernetPacketsSent,
            EthernetPacketsReceived,
            EthernetErrorsSent,
            EthernetErrorsReceived,
            EthernetDiscardPacketsSent,
            EthernetDiscardPacketsReceived;

    public String getEthernetBytesSent() {
        return EthernetBytesSent;
    }

    public void setEthernetBytesSent(String EthernetBytesSent) {
        this.EthernetBytesSent = EthernetBytesSent;
    }

    public String getEthernetBytesReceived() {
        return EthernetBytesReceived;
    }

    public void setEthernetBytesReceived(String EthernetBytesReceived) {
        this.EthernetBytesReceived = EthernetBytesReceived;
    }

    public String getEthernetPacketsSent() {
        return EthernetPacketsSent;
    }

    public void setEthernetPacketsSent(String EthernetPacketsSent) {
        this.EthernetPacketsSent = EthernetPacketsSent;
    }

    public String getEthernetPacketsReceived() {
        return EthernetPacketsReceived;
    }

    public void setEthernetPacketsReceived(String EthernetPacketsReceived) {
        this.EthernetPacketsReceived = EthernetPacketsReceived;
    }

    public String getEthernetErrorsSent() {
        return EthernetErrorsSent;
    }

    public void setEthernetErrorsSent(String EthernetErrorsSent) {
        this.EthernetErrorsSent = EthernetErrorsSent;
    }

    public String getEthernetErrorsReceived() {
        return EthernetErrorsReceived;
    }

    public void setEthernetErrorsReceived(String EthernetErrorsReceived) {
        this.EthernetErrorsReceived = EthernetErrorsReceived;
    }

    public String getEthernetDiscardPacketsSent() {
        return EthernetDiscardPacketsSent;
    }

    public void setEthernetDiscardPacketsSent(String EthernetDiscardPacketsSent) {
        this.EthernetDiscardPacketsSent = EthernetDiscardPacketsSent;
    }

    public String getEthernetDiscardPacketsReceived() {
        return EthernetDiscardPacketsReceived;
    }

    public void setEthernetDiscardPacketsReceived(String EthernetDiscardPacketsReceived) {
        this.EthernetDiscardPacketsReceived = EthernetDiscardPacketsReceived;
    }
            
}
