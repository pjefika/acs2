/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.dto;

import model.device.serviceclass.ServiceClass;
import model.log.AcaoAcsEnum;

/**
 *
 * @author G0042204
 */
public class ServiceClassIn extends GetDeviceDataIn {

    private ServiceClass service;

    public ServiceClassIn() {
        this.setAcao(AcaoAcsEnum.SET_SERVICE_CLASS);
    }

    public ServiceClass getService() {
        return service;
    }

    public void setService(ServiceClass service) {
        this.service = service;
    }

}
