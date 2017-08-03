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
public class HdmException extends Exception {

    public HdmException() {
        super("Falha ao consultar a plataforma Motive.");
    }

    public HdmException(String message) {
        super(message);
    }

}
