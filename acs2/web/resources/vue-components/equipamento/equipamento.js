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
    }
};


Equipamento.prototype.dateFormat = function() {
    return moment(Equipamento.dataAutenticacao).format('DD/MM/YYYY HH:mm:ss');
};

Equipamento.prototype.dataAutenticacao = function() {
    if (Equipamento.lastActivationTime) {
        return Equipamento.dateFormat(new Date(Equipamento.lastActivationTime.year, Equipamento.lastActivationTime.month, Equipamento.lastActivationTime.day, Equipamento.lastActivationTime.hour, Equipamento.lastActivationTime.minute, Equipamento.lastActivationTime.second));
    } else {
        return "#####";
    }
};