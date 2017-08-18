/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.log;

import javax.validation.constraints.NotNull;
import model.entity.LogEntity;

/**
 *
 * @author G0042204
 */
public abstract class LogInAcs {

    LogEntity l = new LogEntity();

    @NotNull
    private String executor;

    public LogEntity create() {
        l.setAcao(acao());
        l.setEntrada(input());
        l.setExecutor(getExecutor());
        return l;
    }

    public abstract String input();

    public abstract AcaoAcsEnum acao();

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

}
