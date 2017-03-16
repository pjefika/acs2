/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author G0034481
 */
@Stateless
public class AbstractDAO {
    
    @PersistenceContext
    protected EntityManager entityManager;
    
    @Transactional
    public void cadastrar(Object object) {
        this.entityManager.persist(object);
    }
    
    @Transactional
    public void editar(Object object) {
        this.entityManager.merge(object);
    }
    
    @Transactional
    public void excluir(Object object) {
        this.entityManager.remove(this.entityManager.merge(object));
    }
    
}
