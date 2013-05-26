package servicio;

import dao.Dao;
import dao.FactoryDAO;
import dao.PersonaDAO;
import entidad.Persona;
import javax.persistence.EntityManager;

public class PersonaServicio {
    
    public String hacerLogin(String password1, String password2){
        String resultado = "Password Correcto";
        if(!password1.equals(password2)){
            resultado="Password invalido";
        }
        return resultado;
    }
    public Persona buscarPorDocumento(String documento, EntityManager em){
        PersonaDAO dao = (PersonaDAO) FactoryDAO.crear(Dao.PERSONA); 
        Persona entity = dao.buscarPorDocumento(documento, em);
        if (entity == null) {return null;}
        return entity;
    }   
    
    public void crearPersona(Persona vo, EntityManager em) {
        Persona persona = vo;
        Dao dao = FactoryDAO.crear(Dao.PERSONA);
        dao.persist(persona, em);
    }

    public void actualizarPersona(Persona vo, EntityManager em) {
        Persona persona = vo;
        Dao dao = FactoryDAO.crear(Dao.PERSONA);
        dao.update(persona, em);
    }

    public void eliminarPersona(Persona vo, EntityManager em) {
        Persona persona = vo;
        Dao dao = FactoryDAO.crear(Dao.PERSONA);
        dao.deleteSigleResult(persona, em);
    }

    public Persona buscarPersonaPorCorreo(String correo, EntityManager em) {
        PersonaDAO dao = (PersonaDAO) FactoryDAO.crear(Dao.PERSONA);
        Persona entity = dao.buscarPorCorreo(correo, em);
        if (entity == null) {
            return null;
        }
        return entity;
    }
}
