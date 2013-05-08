/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidad.Empresa;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Usuario2
 */
public class EmpresaDAO extends Dao{
    
    public Empresa buscarPorNit(Long nit,EntityManager em){
        try{
            Query q = (Query) em.createQuery("select p from Empresa p where p.nit = :nit");
            q.setParameter("nit", nit);
            return (Empresa) q.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }
    
}
