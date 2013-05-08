/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidad.PuntoVenta;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Usuario2
 */
public class PuntoVentaDAO {
    
    public PuntoVenta buscarPorNit(Long nit,EntityManager em){
        try{
            Query q = (Query) em.createQuery("select p from PuntoVenta p where p.nit = :nit");
            q.setParameter("nit", nit);
            return (PuntoVenta) q.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }
    
}
