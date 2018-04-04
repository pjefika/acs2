/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.dto;

import com.alcatel.hdm.service.nbi2.NbiDeviceData;
import model.log.AcaoAcsEnum;
import model.log.LogInAcs;
import util.GsonUtil;

/**
 *
 * @author G0042204
 */
public class GetDeviceDataIn extends LogInAcs {

    private NbiDeviceData device;

    private AcaoAcsEnum acao;

    @Override
    public String input() {
        return GsonUtil.serialize(device);
    }

    @Override
    public AcaoAcsEnum acao() {
        return acao;
    }

    public NbiDeviceData getDevice() {
        return device;
    }

    public void setDevice(NbiDeviceData device) {
        this.device = device;
    }

    public void setAcao(AcaoAcsEnum acao) {
        this.acao = acao;
    }

}
