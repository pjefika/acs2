/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.device.log;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import parser.device.DeviceLogDeserializer;

/**
 *
 * @author G0042204
 */
@JsonDeserialize(using = DeviceLogDeserializer.class)
public class DeviceLog {

    private String mensagem;

    public DeviceLog() {
    }

    public DeviceLog(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
