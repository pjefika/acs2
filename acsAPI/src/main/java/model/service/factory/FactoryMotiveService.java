/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.factory;

import br.net.gvt.efika.acs.model.device.dhcp.Dhcp;
import model.service.device.MotiveFromTreeService;
import model.service.device.MotiveService;
import model.service.device.impl.DhcpService;
import model.service.device.impl.iptv.acao.IptvDiagnosticsService;
import model.service.device.impl.sip.DirectoryNumberService;
import model.service.device.impl.sip.T38EnabledService;

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

    public static MotiveFromTreeService createTreeChanger(Class c) {
        if (c.getSimpleName().equalsIgnoreCase("T38Enabled")) {
            return new T38EnabledService();
        }
        if (c.getSimpleName().equalsIgnoreCase("DirectoryNumber")) {
            return new DirectoryNumberService();
        }
        if (c.getSimpleName().equalsIgnoreCase("IptvDiagnostics")) {
            return new IptvDiagnosticsService();
        }

        return null;
    }

}
