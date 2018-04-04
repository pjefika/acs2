/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.dto;

import model.log.AcaoAcsEnum;
import model.log.LogInAcs;

/**
 *
 * @author G0042204
 */
public class DetailIn extends LogInAcs {

    private Long guid;

    public DetailIn() {
    }

    public Long getGuid() {
        return guid;
    }

    public void setGuid(Long guid) {
        this.guid = guid;
    }

    @Override
    public String input() {
        return guid.toString();
    }

    @Override
    public AcaoAcsEnum acao() {
        return AcaoAcsEnum.DETALHE_EQUIPAMENTO;
    }

}
