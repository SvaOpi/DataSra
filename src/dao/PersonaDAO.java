package dao;

import entidad.Persona;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class PersonaDAO extends Dao{
    
    public Persona buscarPorDocumento(String documento,EntityManager em){
        try{
            Query q = (Query) em.createQuery("select p from Persona p where p.documento = :documento");
            q.setParameter("documento", documento);
            return (Persona) q.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }

    public Persona buscarPorCorreo(String correo, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
