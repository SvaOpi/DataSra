/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidad.Distribuidor;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Usuario2
 */
public class DistribuidorDAO extends Dao{
    
    public Distribuidor buscarPorNit(Long nit,EntityManager em){
        try{
            Query q = (Query) em.createQuery("select p from Distribuidor p where p.nit = :nit");
            q.setParameter("nit", nit);
            return (Distribuidor) q.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }
    
}
