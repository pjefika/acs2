/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;

/**
 *
 * @author G0042204
 */
public class SoutUtil {

    public static void print(NbiDeviceData d) {

        System.out.println(d.getDeviceId().getOUI());
        System.out.println(d.getDeviceId().getProductClass());
        System.out.println(d.getDeviceId().getProtocol());
        System.out.println(d.getDeviceId().getSerialNumber());
        System.out.println(d.isActivated());

    }

}
