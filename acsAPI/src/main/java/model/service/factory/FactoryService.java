/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.factory;

import br.net.gvt.efika.acs.model.search.FindDevice;
import br.net.gvt.efika.acs.model.search.FindDeviceImpl;
import model.service.device.DeviceOnlineService;
import model.service.device.DeviceOnlineServiceImpl;
import model.service.device.FirmwareService;
import model.service.device.FirmwareServiceImpl;
import model.service.device.MotiveFromTreeService;
import model.service.device.detail.DeviceDetailService;
import model.service.device.detail.DeviceDetailServiceImpl;
import model.service.device.impl.sip.T38EnabledService;
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

    public static DeviceOnlineService createDeviceOnlineService() {
        return new DeviceOnlineServiceImpl();
    }

    public static WiFiService createWiFiService() {
        return new WiFiServiceImpl();
    }

    public static WiFiService createServiceClassService() {
        return new WiFiServiceImpl();
    }

    public static FirmwareService createFirmwareService() {
        return new FirmwareServiceImpl();
    }

    public static MotiveFromTreeService createTreeChanger(Class c) {
        if (c.getSimpleName().equalsIgnoreCase("T38Enabled")) {
            return new T38EnabledService();
        }

        return null;
    }

}
