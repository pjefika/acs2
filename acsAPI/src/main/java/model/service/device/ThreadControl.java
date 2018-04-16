/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service.device;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author G0042204
 */
public class ThreadControl {
    
    public static void sleep(){
        try {
            Thread.sleep(7500);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
