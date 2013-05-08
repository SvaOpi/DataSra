package dao;

import entidad.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class UsuarioDAO extends Dao{
    
    public Usuario buscarPorId(long id,EntityManager em){
        try{
            Query q = (Query) em.createQuery("select u from Usuario u where u.id = :idUsuario");
            q.setParameter("idUsuario", id);
            return (Usuario) q.getSingleResult();
        }catch(NoResultException e){
            return null;
        }
    }
    
    public Usuario buscarPorCorreo(String correo,EntityManager em){
        try{
            Query q = (Query) em.createQuery("select u from Usuario u where u.correo = :correo");
            q.setParameter("correo", correo);
            Usuario u = (Usuario) q.getSingleResult();
            return u;
        }catch(NoResultException e){
            return null;
        }
    }
    
    public Usuario buscarPorCedula(Long cedula,EntityManager em){
        try{
            Query q = (Query) em.createQuery("select u from Usuario u where u.cedula = :cedula");
            q.setParameter("cedula", cedula);
            Usuario u = (Usuario) q.getSingleResult();
            return u;
        }catch(NoResultException e){
            return null;
        }
    }
    
    public Usuario buscarPorRol(String rol,EntityManager em){
        try{
            Query q = (Query) em.createQuery("select u from Usuario u where u.rol = :rol");
            q.setParameter("rol", rol);
            Usuario u = (Usuario) q.getSingleResult();
            return u;
        }catch(NoResultException e){
            return null;
        }
    }
}
