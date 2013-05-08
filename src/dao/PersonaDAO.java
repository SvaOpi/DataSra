package dao;

import entidad.Persona;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class PersonaDAO extends Dao{
    public Persona buscarPorCedula(Long cedula,EntityManager em){
        try{
            Query q = (Query) em.createQuery("select p from Persona p where p.cedula = :cedula");
            q.setParameter("cedula", cedula);
            return (Persona) q.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }
}
