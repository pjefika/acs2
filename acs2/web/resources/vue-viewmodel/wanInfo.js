/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// CLASSES
var WanInfo = function(p) {
    if (p) {
        this.BytesSent = p.BytesSent;
        this.BytesReceived = p.BytesReceived;
        this.PacketsSent = p.PacketsSent;
        this.PacketsReceived = p.PacketsReceived;
        this.ErrorsSent = p.ErrorsSent;
        this.ErrorsReceived = p.ErrorsReceived;
        this.DiscardPacketsSent = p.DiscardPacketsSent;
        this.DiscardPacketsReceived = p.DiscardPacketsReceived;
    }
};