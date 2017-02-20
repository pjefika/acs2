/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import java.util.List;
import motive.hdm.synchdeviceops.ExecuteFunctionResponse;

/**
 *
 * @author G0042204
 */
public class SoutUtil {

    public static void print(NbiDeviceData d) {
        System.out.println("DeviceGUID: " + d.getDeviceGUID());
        System.out.println("OUI: " + d.getDeviceId().getOUI());
        System.out.println("getProductClass: " + d.getDeviceId().getProductClass());
        System.out.println("getProtocol: " + d.getDeviceId().getProtocol());
        System.out.println("getSerialNumber: " + d.getDeviceId().getSerialNumber());
        System.out.println("isActivated: " + d.isActivated());
        System.out.println("isCaptured: " + d.isCaptured());
        System.out.println("isManaged: " + d.isManaged());
        System.out.println("");
    }

    public static void print(List<NbiDeviceData> ds) {
        for (NbiDeviceData nbiDeviceData : ds) {
            print(nbiDeviceData);
        }
    }

    public static void print(ExecuteFunctionResponse e) {
        System.out.println(e.getReturn());
    }

}
