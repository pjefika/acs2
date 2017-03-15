/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import model.entity.Log;

/**
 *
 * @author G0034481
 */
public class LogDAO extends AbstractDAO{

    public LogDAO() {
    }
    
    public List<Log> listarTodosLogs() {
        try {
            Query query = this.entityManager.createQuery("FROM Log l");
            return query.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();            
        }        
    }
    
    
}
