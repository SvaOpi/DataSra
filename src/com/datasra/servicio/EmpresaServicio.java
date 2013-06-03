package com.datasra.servicio;

import com.datasra.dao.Dao;
import com.datasra.dao.FactoryDAO;
import com.datasra.dao.EmpresaDAO;
import com.datasra.entity.Company;
import javax.persistence.EntityManager;

public class EmpresaServicio {

    public void crearEmpresa(Company vo, EntityManager em) {
        Company empresa = vo;
        Dao dao = FactoryDAO.crear(Dao.EMPRESA);
        dao.persist(empresa, em);
    }

    public void actualizarEmpresa(Company vo, EntityManager em) {
        Company usuario = vo;
        Dao dao = FactoryDAO.crear(Dao.EMPRESA);
        dao.update(usuario, em);
    }

    public void eliminarEmpresa(Company vo, EntityManager em) {
        Company usuario = vo;
        Dao dao = FactoryDAO.crear(Dao.EMPRESA);
        dao.deleteSigleResult(usuario, em);
    }

    public Company buscarEmpresaPorId(long id, EntityManager em) {
        EmpresaDAO dao = (EmpresaDAO) FactoryDAO.crear(Dao.EMPRESA);
        Company entity = dao.buscarPorId(id, em);
        if (entity == null) {
            return null;
        }
        return entity;
    }
}
