/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.dto;

import model.log.AcaoAcsEnum;

/**
 *
 * @author G0042204
 */
public class SipDiagnosticsIn extends GetDeviceDataIn {

    private Integer phyref;

    public SipDiagnosticsIn() {
        this.setAcao(AcaoAcsEnum.SIP_DIAGNOSTICS);
    }

    public Integer getPhyref() {
        return phyref;
    }

    public void setPhyref(Integer phyref) {
        this.phyref = phyref;
    }

}
