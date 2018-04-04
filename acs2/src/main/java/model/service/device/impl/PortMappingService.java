/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import java.util.List;
import model.device.portmapping.PortMappingInfo;
import model.service.device.GenericDeviceService;
import model.service.device.MotiveService;
import model.service.device.ThreadControl;

/**
 *
 * @author G0042204
 */
public class PortMappingService extends GenericDeviceService implements MotiveService<List<PortMappingInfo>> {

    @Override
    public List<PortMappingInfo> consultar(NbiDeviceData device) throws Exception {
        return synch().getPortMapping(device);
    }

    @Override
    public List<PortMappingInfo> alterar(NbiDeviceData device, List<PortMappingInfo> t) throws Exception {
        synch().setPortMapping(device, t);
        ThreadControl.sleep();
        return consultar(device);
    }

}
