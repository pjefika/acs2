/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl;

import br.net.gvt.efika.acs.model.device.dhcp.Dhcp;
import br.net.gvt.efika.acs.model.exception.TratativaExcessao;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import model.service.device.GenericDeviceService;
import model.service.device.MotiveService;
import model.service.device.ThreadControl;

/**
 *
 * @author G0042204
 */
public class DhcpService extends GenericDeviceService implements MotiveService<Dhcp> {

    @Override
    public Dhcp consultar(NbiDeviceData device) throws Exception {
        try {
            return synch().getDhcp(device);
        } catch (Exception ex) {
            TratativaExcessao.treatException(ex);
        }
        return null;
    }

    @Override
    public Dhcp alterar(NbiDeviceData device, Dhcp t) throws Exception {
        try {
            synch().setDhcp(device, t);
            ThreadControl.sleep();
            return consultar(device);
        } catch (Exception ex) {
            TratativaExcessao.treatException(ex);
        }
        return null;
    }

}
