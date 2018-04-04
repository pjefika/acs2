/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.device.log;

/**
 *
 * @author G0034481
 */
public class DeviceLogR {

    private String Index, Time, Type, Servity, LogInformation;

    public DeviceLogR() {
    }

    public String getIndex() {
        return Index;
    }

    public void setIndex(String Index) {
        this.Index = Index;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getServity() {
        return Servity;
    }

    public void setServity(String Servity) {
        this.Servity = Servity;
    }

    public String getLogInformation() {
        return LogInformation;
    }

    public void setLogInformation(String LogInformation) {
        this.LogInformation = LogInformation;
    }

}
