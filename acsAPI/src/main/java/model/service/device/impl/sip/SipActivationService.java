/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl.sip;

import br.net.gvt.efika.acs.model.device.sipactivation.SipActivation;
import br.net.gvt.efika.acs.model.device.sipdiagnostics.SipDiagnostics;
import com.alcatel.hdm.service.nbi2.NbiDeviceData;

/**
 *
 * @author G0042204
 */
public interface SipActivationService {

    public SipDiagnostics ativar(NbiDeviceData device, SipActivation activation) throws Exception;

}
