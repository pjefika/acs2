/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.factory;

import dao.NbiDAO;
import dao.NbiDAO_Impl;

/**
 *
 * @author G0042204
 */
public class FactoryDAO {
    
    public static NbiDAO createNBI(){
        return new NbiDAO_Impl();
    }
    
}
