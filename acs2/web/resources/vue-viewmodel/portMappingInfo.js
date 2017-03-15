/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var PortMapping = function(p) {
    if (p) {
        this.externalPort = p.externalPort;
        this.internalClient = p.internalClient;
        this.internalPort = p.internalPort;
        this.portMapName = p.portMapName;
        this.enable = p.enable;
        this.protocol = p.protocol;
        this.remoteHost = p.remoteHost;
    }
};


PortMapping.prototype.equals = function(p) {
    return (this.externalPort === p.externalPort &&
            this.internalClient === p.internalClient &&
            this.internalPort === p.internalPort &&
            this.portMapName === p.portMapName &&
            this.enable === p.enable &&
            this.protocol === p.protocol &&
            this.remoteHost === p.remoteHost);
};