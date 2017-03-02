/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
        if (p.eqp.lastActivationTime) {
            this.dataAutenticacao = new Date(p.eqp.lastActivationTime.year, p.eqp.lastActivationTime.month, p.eqp.lastActivationTime.day, p.eqp.lastActivationTime.hour, p.eqp.lastActivationTime.minute, p.eqp.lastActivationTime.second);
        }
        this.checkOn = p.CheckOnline;
        this.firmwareOk = p.firmWareOk;
    }
};

Equipamento.prototype.dateFormat = function() {
    if (this.dataAutenticacao) {
        return moment(this.dataAutenticacao).format('DD/MM/YYYY HH:mm:ss');
    } else {
        return "#####";
    }

};