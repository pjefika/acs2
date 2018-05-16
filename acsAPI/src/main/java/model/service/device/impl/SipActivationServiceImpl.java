/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl;

import br.net.gvt.efika.acs.model.device.sipactivation.SipActivation;
import br.net.gvt.efika.acs.model.device.sipdiagnostics.SipDiagnostics;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import model.service.device.GenericDeviceService;
import model.service.device.ThreadControl;

public class SipActivationServiceImpl extends GenericDeviceService implements SipActivationService {

    @Override
    public SipDiagnostics ativar(NbiDeviceData device, SipActivation activation) throws Exception {
        if (!synch().setSipActivation(device, activation)) {
            throw new Exception("Falha ao ativar SIP.");
        }else{
            ThreadControl.sleep();
            SipDiagnosticsService s = new SipDiagnosticsServiceImpl();
            return s.consultar(device, new Integer(activation.getPhyReferenceList()));
        }
    }

}
