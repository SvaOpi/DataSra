package servicio;

import dao.Dao;
import dao.FactoryDAO;
import dao.EmpresaDAO;
import entidad.Empresa;
import javax.persistence.EntityManager;

public class EmpresaServicio {

    public void crearEmpresa(Empresa vo, EntityManager em) {
        Empresa empresa = vo;
        Dao dao = FactoryDAO.crear(Dao.EMPRESA);
        dao.persist(empresa, em);
    }

    public void actualizarEmpresa(Empresa vo, EntityManager em) {
        Empresa usuario = vo;
        Dao dao = FactoryDAO.crear(Dao.EMPRESA);
        dao.update(usuario, em);
    }

    public void eliminarEmpresa(Empresa vo, EntityManager em) {
        Empresa usuario = vo;
        Dao dao = FactoryDAO.crear(Dao.EMPRESA);
        dao.deleteSigleResult(usuario, em);
    }

    public Empresa buscarEmpresaPorId(long id, EntityManager em) {
        EmpresaDAO dao = (EmpresaDAO) FactoryDAO.crear(Dao.EMPRESA);
        Empresa entity = dao.buscarPorId(id, em);
        if (entity == null) {
            return null;
        }
        return entity;
    }
}
