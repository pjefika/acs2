/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.dto;

import br.net.gvt.efika.acs.model.device.sipactivation.SipActivation;
import model.log.AcaoAcsEnum;

/**
 *
 * @author G0042204
 */
public class SipActivationIn extends GetDeviceDataIn {

    private SipActivation sip;

    public SipActivationIn() {
        this.setAcao(AcaoAcsEnum.SIP_ACTIVATION);
    }

    public SipActivation getSip() {
        return sip;
    }

    public void setSip(SipActivation sip) {
        this.sip = sip;
    }

}
