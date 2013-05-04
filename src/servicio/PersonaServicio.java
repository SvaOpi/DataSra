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
    public Persona buscarPorCedula(Long cedula, EntityManager em){
        PersonaDAO dao = (PersonaDAO) FactoryDAO.crear(Dao.PERSONA); 
        Persona entity = dao.buscarPorCorreo(cedula, em);
        if (entity == null) {return null;}
        return entity;
    }
}
