/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device.impl;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import model.device.sipdiagnostics.SipDiagnostics;

/**
 *
 * @author G0042204
 */
public interface SipDiagnosticsService {

    public SipDiagnostics consultar(NbiDeviceData device, Integer phyref) throws Exception;

}
