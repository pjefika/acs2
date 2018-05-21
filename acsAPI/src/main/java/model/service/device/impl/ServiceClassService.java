/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl;

import br.net.gvt.efika.acs.model.device.serviceclass.ServiceClass;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import model.service.device.GenericDeviceService;
import model.service.device.MotiveService;
import model.service.device.ThreadControl;

/**
 *
 * @author G0042204
 */
public class ServiceClassService extends GenericDeviceService implements MotiveService<ServiceClass> {

    @Override
    public ServiceClass consultar(NbiDeviceData device) throws Exception {
        return synch().getServiceClass(device);
    }

    @Override
    public ServiceClass alterar(NbiDeviceData device, ServiceClass t) throws Exception {
        synch().setServiceClass(device, t);
        ThreadControl.sleep();
        return consultar(device);
    }

}
