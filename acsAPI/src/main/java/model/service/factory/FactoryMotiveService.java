/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.factory;

import br.net.gvt.efika.acs.model.device.dhcp.Dhcp;
import model.service.device.MotiveService;
import model.service.device.impl.DhcpService;

/**
 *
 * @author G0042204
 */
public class FactoryMotiveService {

    public static MotiveService<?> create(Object o) {
        MotiveService<?> ret = null;
        if (o instanceof Dhcp) {
            ret = new DhcpService();
        }
        
        return ret;
    }

}
