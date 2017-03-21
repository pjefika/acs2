/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global moment */

// CLASSES
var Equipamento = function(p) {
    if (p) {
        this.activated = p.eqp.activated;
        this.deviceGUID = p.eqp.deviceGUID;
        this.deviceId = p.eqp.deviceId;
        this.macAddress = p.eqp.macAddress;
        this.manufacturer = p.eqp.manufacturer;
        this.model = p.eqp.model;
        this.modelName = p.eqp.modelName;
        this.softwareVersion = p.eqp.softwareVersion;
        this.subscriberID = p.eqp.subscriberID;
        this.ipAddress = p.eqp.ipAddress;
        this.checkOn = p.checkOn;
        this.firmwareOk = p.firmWareOk;
        this.type = p.eqp.type;
        this.lastActivationTime = p.eqp.lastActivationTime;
    }

};

Equipamento.prototype.isModem = function() {
    return this.type === 0;
};

Equipamento.prototype.dataAutenticacao = function() {

    if (this.lastActivationTime) {
        return moment(new Date(this.lastActivationTime.year, this.lastActivationTime.month, this.lastActivationTime.day, this.lastActivationTime.hour, this.lastActivationTime.minute, this.lastActivationTime.second)).format('DD/MM/YYYY HH:mm:ss');
    } else {
        return null;
    }
};
