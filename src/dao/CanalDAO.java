/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidad.Canal;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Usuario2
 */
public class CanalDAO {
    
    public Canal buscarPorNit(Long nit,EntityManager em){
        try{
            Query q = (Query) em.createQuery("select p from Canal p where p.nit = :nit");
            q.setParameter("nit", nit);
            return (Canal) q.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }
    
}
