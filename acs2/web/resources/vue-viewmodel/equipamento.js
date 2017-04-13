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
        this.firmwareVersion = p.firmwareVersion;
        this.type = p.eqp.type;
        this.lastActivationTime = p.eqp.lastActivationTime;
        this.firstContactTime = p.eqp.firstContactTime;
    }

};

Equipamento.prototype.isModem = function() {
    return this.type === 0;
};

Equipamento.prototype.dataAutenticacao = function() {

    if (this.lastActivationTime) {
        return moment([this.lastActivationTime.orig_year, (this.lastActivationTime.orig_month - 1), this.lastActivationTime.orig_day, this.lastActivationTime.orig_hour, this.lastActivationTime.orig_minute, this.lastActivationTime.orig_second]).format('DD/MM/YYYY HH:mm:ss');
    } else {
        return null;
    }
};

Equipamento.prototype.primeiroContato = function() {

    if (this.firstContactTime) {
        return moment([this.firstContactTime.orig_year, (this.firstContactTime.orig_month - 1), this.firstContactTime.orig_day, this.firstContactTime.orig_hour, this.firstContactTime.orig_minute, this.firstContactTime.orig_second]).format('DD/MM/YYYY HH:mm:ss');
    } else {
        return null;
    }
};
