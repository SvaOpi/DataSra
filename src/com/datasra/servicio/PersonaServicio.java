package com.datasra.servicio;

import com.datasra.dao.Dao;
import com.datasra.dao.FactoryDAO;
import com.datasra.dao.PersonaDAO;
import com.datasra.entity.Person;
import javax.persistence.EntityManager;

public class PersonaServicio {
    
    public String hacerLogin(String password1, String password2){
        String resultado = "Password Correcto";
        if(!password1.equals(password2)){
            resultado="Password invalido";
        }
        return resultado;
    }
    public Person buscarPorDocumento(int documento, EntityManager em){
        PersonaDAO dao = (PersonaDAO) FactoryDAO.crear(Dao.PERSONA); 
        Person entity = dao.buscarPorDocumento(documento, em);
        if (entity == null) {return null;}
        return entity;
    }   
    
    public void crearPersona(Person vo, EntityManager em) {
        Person persona = vo;
        Dao dao = FactoryDAO.crear(Dao.PERSONA);
        dao.persist(persona, em);
    }

    public void actualizarPersona(Person vo, EntityManager em) {
        Person persona = vo;
        Dao dao = FactoryDAO.crear(Dao.PERSONA);
        dao.update(persona, em);
    }

    public void eliminarPersona(Person vo, EntityManager em) {
        Person persona = vo;
        Dao dao = FactoryDAO.crear(Dao.PERSONA);
        dao.deleteSigleResult(persona, em);
    }

    public Person buscarPersonaPorCorreo(String correo, EntityManager em) {
        PersonaDAO dao = (PersonaDAO) FactoryDAO.crear(Dao.PERSONA);
        Person entity = dao.buscarPorCorreo(correo, em);
        if (entity == null) {
            return null;
        }
        return entity;
    }
}
