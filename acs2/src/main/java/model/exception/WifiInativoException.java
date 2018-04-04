/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.exception;

/**
 *
 * @author G0042204
 */
public class WifiInativoException extends Exception {

    public WifiInativoException() {
        super("Nenhuma interface WiFi se encontra habilitada.");
    }

}
