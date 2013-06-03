/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datasra.dao;

import com.datasra.entity.Company;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Usuario2
 */
public class EmpresaDAO extends Dao{
    
    public Company buscarPorNit(Long nit,EntityManager em){
        try{
            Query q = (Query) em.createQuery("select p from Empresa p where p.nit = :nit");
            q.setParameter("nit", nit);
            return (Company) q.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }

    public Company buscarPorId(long id, EntityManager em) {
        try{
            Query q = (Query) em.createQuery("select p from Empresa p where p.id = :id");
            q.setParameter("id", id);
            return (Company) q.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }
    
}
