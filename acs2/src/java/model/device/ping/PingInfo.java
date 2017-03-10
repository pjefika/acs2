/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.device.ping;

/**
 *
 * @author G0034481
 */
public class PingInfo {

    private String repetitions,
            hostAddress,
            qtdFailures,
            qtdSuccess, 
            avgRespTime,
            status;

    public PingInfo() {
    }

    public String getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(String repetitions) {
        this.repetitions = repetitions;
    }

    public String getHostAddress() {
        return hostAddress;
    }

    public void setHostAddress(String hostAddress) {
        this.hostAddress = hostAddress;
    }

    public String getQtdFailures() {
        return qtdFailures;
    }

    public void setQtdFailures(String qtdFailures) {
        this.qtdFailures = qtdFailures;
    }

    public String getQtdSuccess() {
        return qtdSuccess;
    }

    public void setQtdSuccess(String qtdSuccess) {
        this.qtdSuccess = qtdSuccess;
    }

    public String getAvgRespTime() {
        return avgRespTime;
    }

    public void setAvgRespTime(String avgRespTime) {
        this.avgRespTime = avgRespTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
