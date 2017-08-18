/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.exception;

/**
 *
 * @author G0041775
 */
public class JsonUtilException extends Exception {

    public JsonUtilException() {
        super("Falha ao montar Json.");
    }

    public JsonUtilException(String message) {
        super(message);
    }

}
