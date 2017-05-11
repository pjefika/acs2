/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global moment */

// CLASSES
var Dhcp = function (p) {
    if (p) {
        this.MaxAddress = p.MaxAddress;
        this.MinAddress = p.MinAddress;
        this.DHCPServerEnable = p.DHCPServerEnable;
    }
    
};