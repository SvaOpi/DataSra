package com.datasra.dao;

import com.datasra.entity.Person;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class PersonaDAO extends Dao{
    
    public Person buscarPorDocumento(int documento,EntityManager em){
        try{
            Query q = (Query) em.createQuery("select p from Person p where p.cedule = :documento");
            q.setParameter("documento", documento);
            return (Person) q.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }

    public Person buscarPorCorreo(String correo, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
