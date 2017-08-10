/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import java.util.List;
import model.device.portmapping.PortMappingInfo;
import model.device.sipactivation.SipActivation;
import model.device.sipdiagnostics.SipDiagnostics;
import model.service.device.GenericDeviceService;
import model.service.device.MotiveService;
import model.service.device.ThreadControl;

/**
 *
 * @author G0042204
 */
public class SipService extends GenericDeviceService implements MotiveService<SipDiagnostics> {

    @Override
    public SipDiagnostics consultar(NbiDeviceData device) throws Exception {
        return synch().getSipDiagnostics(device, 1);
    }

    @Override
    public SipDiagnostics alterar(NbiDeviceData device, SipDiagnostics t) throws Exception {
        
        synch().setSipActivation(device, t);
        ThreadControl.sleep();
        return consultar(device);
    }

}
