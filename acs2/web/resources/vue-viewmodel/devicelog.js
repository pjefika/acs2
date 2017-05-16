/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global moment */

// CLASSES
var DeviceLog = function (p) {
    if (p) {
        this.Index = p.Index;
        this.Time = p.Time;
        this.Type = p.Type;
        this.Servity = p.Servity;
        this.LogInformation = p.LogInformation;
    }    
};