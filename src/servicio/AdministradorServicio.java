package servicio;

import dao.AdministradorDAO;
import dao.Dao;
import dao.FactoryDAO;
import entidad.Administrador;
import javax.persistence.EntityManager;

public class AdministradorServicio {
    public void crearAdministrador (Administrador vo, EntityManager em){
        Administrador administrador = vo;
        Dao dao = FactoryDAO.crear(Dao.ADMINISTRADOR);
        dao.persist(administrador, em);
    }
    public void actualizarAdministrador(Administrador vo, EntityManager em){
        Administrador administrador = vo;
        Dao dao = FactoryDAO.crear(Dao.ADMINISTRADOR);
        dao.update(administrador, em);
    }
    public void eliminarAdministrador(Administrador vo, EntityManager em){
        Administrador administrador = vo;
        Dao dao = FactoryDAO.crear(Dao.ADMINISTRADOR);
        dao.deleteSigleResult(administrador, em);
    }
    public Administrador buscarAdministradorPorId(long id, EntityManager em){
        AdministradorDAO dao = (AdministradorDAO) FactoryDAO.crear(Dao.ADMINISTRADOR);        
        Administrador entity = dao.buscarPorId(id, em);
        if (entity == null) {return null;}
        return entity;
    }
    public Administrador buscarAdministradorPorCorreo(String correo, EntityManager em){
        AdministradorDAO dao = (AdministradorDAO) FactoryDAO.crear(Dao.ADMINISTRADOR);        
        Administrador entity = dao.buscarPorCorreo(correo, em);
        if (entity == null) {return null;}
        return entity;
    }
}
