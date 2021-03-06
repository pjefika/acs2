/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.search;

import model.log.AcaoAcsEnum;
import model.log.LogInAcs;
import util.GsonUtil;

/**
 *
 * @author G0042204
 */
public class SearchIn extends LogInAcs {

    private SearchCriteria criterio;

    private String input;

    public SearchIn() {
    }

    public SearchIn(SearchCriteria criterio, String input) {
        this.criterio = criterio;
        this.input = input;
    }

    public SearchCriteria getCriterio() {
        return criterio;
    }

    public void setCriterio(SearchCriteria criterio) {
        this.criterio = criterio;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public String input() {
        return GsonUtil.serialize(this);
    }

    @Override
    public AcaoAcsEnum acao() {
        return AcaoAcsEnum.BUSCA_EQUIPAMENTO;
    }

}
