/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global moment */

// CLASSES
var EquipamentoAdapted = function(p) {
    if (p) {
        this.activated = p.activated;
        this.deviceGUID = p.deviceGUID;
        this.deviceId = p.deviceId;
        this.macAddress = p.macAddress;
        this.manufacturer = p.manufacturer;
        this.model = p.model;
        this.modelName = p.modelName;
        this.softwareVersion = p.softwareVersion;
        this.subscriberID = p.subscriberID;
        this.ipAddress = p.ipAddress;
        this.checkOn = p.checkOn;
        this.firmwareOk = p.firmWareOk;
        this.type = p.type;
        this.lastActivationTime = p.lastActivationTime;
    }

    delete this.firmwareOk;
    delete this.checkOn;
    delete this.lastActivationTime;
};
