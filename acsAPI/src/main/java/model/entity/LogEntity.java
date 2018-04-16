/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import br.net.gvt.efika.mongo.model.entity.AbstractMongoEntity;
import br.net.gvt.efika.util.json.JacksonMapper;
import java.util.Calendar;
import model.log.AcaoAcsEnum;

/**
 *
 * @author G0034481
 */
public class LogEntity extends AbstractMongoEntity {

    private String entrada;

    private String saida;

    private String executor;

    private AcaoAcsEnum acao;

    private Calendar dataLog;

    public LogEntity() {
        dataLog = Calendar.getInstance();
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSaida() {
        return saida;
    }

    public void setSaida(Object saida) {
        try {
            this.saida = new JacksonMapper(Object.class).serialize(saida);
        } catch (Exception e) {
        }

    }

    public Calendar getDataLog() {
        return dataLog;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public AcaoAcsEnum getAcao() {
        return acao;
    }

    public void setAcao(AcaoAcsEnum acao) {
        this.acao = acao;
    }

}
