package servicio;

import dao.Dao;
import dao.FactoryDAO;
import dao.UsuarioDAO;
import entidad.Usuario;
import javax.persistence.EntityManager;

public class UsuarioServicio {

    public void crearUsuario(Usuario vo, EntityManager em) {
        Usuario usuario = vo;
        Dao dao = FactoryDAO.crear(Dao.USUARIO);
        dao.persist(usuario, em);
    }

    public void actualizarUsuario(Usuario vo, EntityManager em) {
        Usuario usuario = vo;
        Dao dao = FactoryDAO.crear(Dao.USUARIO);
        dao.update(usuario, em);
    }

    public void eliminarUsuario(Usuario vo, EntityManager em) {
        Usuario usuario = vo;
        Dao dao = FactoryDAO.crear(Dao.USUARIO);
        dao.deleteSigleResult(usuario, em);
    }

    public Usuario buscarUsuarioPorId(long id, EntityManager em) {
        UsuarioDAO dao = (UsuarioDAO) FactoryDAO.crear(Dao.USUARIO);
        Usuario entity = dao.buscarPorId(id, em);
        if (entity == null) {
            return null;
        }
        return entity;
    }

    public Usuario buscarUsuarioPorCorreo(String correo, EntityManager em) {
        UsuarioDAO dao = (UsuarioDAO) FactoryDAO.crear(Dao.USUARIO);
        Usuario entity = dao.buscarPorCorreo(correo, em);
        if (entity == null) {
            return null;
        }
        return entity;
    }

}
