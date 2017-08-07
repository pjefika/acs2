/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.db;

import model.entity.LogEntity;

public class LogDAOImpl extends AbstractHibernateDAO implements InterfaceDAO<LogEntity> {
    
    @Override
    public void cadastrar(LogEntity l) throws Exception {
        persist(l);
    }
    
}
