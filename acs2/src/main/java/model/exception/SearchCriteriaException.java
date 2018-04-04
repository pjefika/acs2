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
public class SearchCriteriaException extends Exception {

    public SearchCriteriaException() {
        super("Critério de busca não infomado.");
    }

    public SearchCriteriaException(String message) {
        super(message);
    }

}
