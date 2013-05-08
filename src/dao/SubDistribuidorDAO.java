/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidad.SubDistribuidor;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Usuario2
 */
public class SubDistribuidorDAO extends Dao{
    
    public SubDistribuidor buscarPorNit(Long nit,EntityManager em){
        try{
            Query q = (Query) em.createQuery("select p from SubDistribuidor p where p.nit = :nit");
            q.setParameter("nit", nit);
            return (SubDistribuidor) q.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }
    
}
