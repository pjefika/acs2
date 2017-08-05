/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.factory;

import model.search.FindDevice;
import model.search.FindDeviceImpl;
import model.service.DeviceDetailService;
import model.service.DeviceDetailServiceImpl;

/**
 *
 * @author G0042204
 */
public class FactoryService {

    public static FindDevice createFindDevice() {
        return new FindDeviceImpl();
    }

    public static DeviceDetailService createDeviceDetailService() {
        return new DeviceDetailServiceImpl();
    }

}
