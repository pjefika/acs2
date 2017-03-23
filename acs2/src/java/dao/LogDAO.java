/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import model.entity.Log;

/**
 *
 * @author G0034481
 */
public class LogDAO extends AbstractDAO{

    public LogDAO() {
    }
    
    public List<Log> listarPorUsr(String usuario) {        
        try {
            Query query = this.entityManager.createQuery("FROM Log l WHERE l.login =:param");
            query.setParameter("param", usuario);
            return query.getResultList();
        } catch (Exception e) {            
            return new ArrayList<>();
        }        
    }
    
    
    public List<Log> listarPorParametro(String valor) {        
        try {            
            String abc = "FROM Log l WHERE l.equipamento LIKE '%"+valor+"%' ";
            //System.out.println(abc);            
            Query query = this.entityManager.createQuery(abc);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println(e);            
            return new ArrayList<>();
        }        
    }
    
}
