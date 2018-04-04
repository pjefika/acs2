/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.log;

import model.entity.LogEntity;

/**
 *
 * @author G0042204
 */
public class FactoryLog {
    
    public static LogEntity create(){
        return new LogEntity();
    }
    
}
