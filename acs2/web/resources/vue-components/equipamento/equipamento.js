/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


// CLASSES
var Equipamento = function(p) {
    if (p) {
        this.activated = p.activated;
        this.deviceGUID = p.deviceGUID;
        this.deviceId = p.deviceId;
        this.macAddress = p.macAddress;
        this.manufacturer = p.manufacturer;
        this.subscriberID = p.subscriberID;
    }

};