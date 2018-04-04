/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.factory;

import static javafx.scene.input.KeyCode.T;
import model.service.search.FindDevice;
import model.service.search.FindDeviceImpl;
import model.service.device.detail.DeviceDetailService;
import model.service.device.detail.DeviceDetailServiceImpl;
import model.service.device.impl.wifi.WiFiService;
import model.service.device.impl.wifi.WiFiServiceImpl;

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

    public static WiFiService createWiFiService() {
        return new WiFiServiceImpl();
    }

    public static WiFiService createServiceClassService() {
        return new WiFiServiceImpl();
    }

}
