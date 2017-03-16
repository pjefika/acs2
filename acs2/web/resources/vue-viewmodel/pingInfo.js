/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var Ping = function (p) {    
    if (p) {
        this.repetitions = p.repetitions;
        this.hostAddress = p.hostAddress;
        this.qtdFailures = p.qtdFailures;
        this.qtdSuccess = p.qtdSuccess;
        this.avgRespTime = p.avgRespTime;
        this.status = p.status;        
    }    
}
