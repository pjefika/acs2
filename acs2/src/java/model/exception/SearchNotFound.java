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
public class SearchNotFound extends Exception {

    public SearchNotFound() {
        super("Equipamento não encontrado.");
    }

    public SearchNotFound(String message) {
        super(message);
    }

}
