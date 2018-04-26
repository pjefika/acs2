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
public class UnsupportedException extends Exception {

    public UnsupportedException() {
        super("O Equipamento não suporta o(s) parâmetro(s) solicitados.");
    }

    public UnsupportedException(String message) {
        super(message);
    }

}
