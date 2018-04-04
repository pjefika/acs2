/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.factory;

/**
 *
 * @author G0042204
 */
public enum EndpointEnum {

    PROD("10.113.64.1", "7025"), LAB("200.168.104.216", "7015");

    String ip, porta;

    private EndpointEnum(String ip, String porta) {
        this.ip = ip;
        this.porta = porta;
    }

}
