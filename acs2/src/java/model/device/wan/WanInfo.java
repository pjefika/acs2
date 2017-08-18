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
    
    private String BytesSent,
            BytesReceived,
            PacketsSent,
            PacketsReceived,
            ErrorsSent,
            ErrorsReceived,
            DiscardPacketsSent,
            DiscardPacketsReceived;

    public String getBytesSent() {
        return BytesSent;
    }

    public void setBytesSent(String BytesSent) {
        this.BytesSent = BytesSent;
    }

    public String getBytesReceived() {
        return BytesReceived;
    }

    public void setBytesReceived(String BytesReceived) {
        this.BytesReceived = BytesReceived;
    }

    public String getPacketsSent() {
        return PacketsSent;
    }

    public void setPacketsSent(String PacketsSent) {
        this.PacketsSent = PacketsSent;
    }

    public String getPacketsReceived() {
        return PacketsReceived;
    }

    public void setPacketsReceived(String PacketsReceived) {
        this.PacketsReceived = PacketsReceived;
    }

    public String getErrorsSent() {
        return ErrorsSent;
    }

    public void setErrorsSent(String ErrorsSent) {
        this.ErrorsSent = ErrorsSent;
    }

    public String getErrorsReceived() {
        return ErrorsReceived;
    }

    public void setErrorsReceived(String ErrorsReceived) {
        this.ErrorsReceived = ErrorsReceived;
    }

    public String getDiscardPacketsSent() {
        return DiscardPacketsSent;
    }

    public void setDiscardPacketsSent(String DiscardPacketsSent) {
        this.DiscardPacketsSent = DiscardPacketsSent;
    }

    public String getDiscardPacketsReceived() {
        return DiscardPacketsReceived;
    }

    public void setDiscardPacketsReceived(String DiscardPacketsReceived) {
        this.DiscardPacketsReceived = DiscardPacketsReceived;
    }
            
}
