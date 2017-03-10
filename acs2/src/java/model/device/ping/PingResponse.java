/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.device.ping;

/**
 *
 * @author G0042204
 */
public class PingResponse {

    private String status, avgRespTime, qtdSuccess, qtdFailures, hostAddress, repetitions;

    public PingResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAvgRespTime() {
        return avgRespTime;
    }

    public void setAvgRespTime(String avgRespTime) {
        this.avgRespTime = avgRespTime;
    }

    public String getQtdSuccess() {
        return qtdSuccess;
    }

    public void setQtdSuccess(String qtdSuccess) {
        this.qtdSuccess = qtdSuccess;
    }

    public String getQtdFailures() {
        return qtdFailures;
    }

    public void setQtdFailures(String qtdFailures) {
        this.qtdFailures = qtdFailures;
    }

    public String getHostAddress() {
        return hostAddress;
    }

    public void setHostAddress(String hostAddress) {
        this.hostAddress = hostAddress;
    }

    public String getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(String repetitions) {
        this.repetitions = repetitions;
    }

}
