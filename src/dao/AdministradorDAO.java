package dao;

import entidad.Administrador;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class AdministradorDAO extends Dao{
    
    public Administrador buscarPorId(long id, EntityManager em){
        try{
            Query q = (Query) em.createQuery("select a from Administrador a where a.id = :idAdmin");
            q.setParameter("idAdmin", id);
            return (Administrador) q.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }
    
    public Administrador buscarPorCedula(Long cedula, EntityManager em){
        try{
            Query q = (Query) em.createQuery("select a from Administrador a where a.cedula = :cedula");
            q.setParameter("cedula", cedula);
            Administrador a =(Administrador) q.getSingleResult();
            return a;
        }catch(NoResultException e){
            return null;
        }
    }
    
}
