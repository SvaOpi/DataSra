package com.datasra.facade;

import com.datasra.entity.Person;
import com.datasra.servicio.PersonaServicio;

public class PersonaFachada extends Fachada{
     
    private PersonaServicio personaServicio;
    
    public PersonaFachada(){
        personaServicio = new PersonaServicio();
    }
    
    public String crearPersona(Person vo){
        String resultado = "";
        try{
            abrirConexion();
            if(personaServicio.buscarPorDocumento((int) vo.getCedule(), em)!= null){
                resultado = "Usuario ya registrado";
            }else{
                personaServicio.crearPersona(vo, em);
                resultado = "Creado";
                et.commit();
            }
        }catch(Exception e){
            e.printStackTrace();
            hacerRollback();
            resultado = "Error";
        }finally{
            cerrarConexion();
            return resultado;
        }
    }
    
    
    public String hacerLogin(int documento, String password){
        String resultado = "";
        try{
            abrirConexion();
            Person vo = personaServicio.buscarPorDocumento(documento, em);
            if(vo==null){
                et.commit();
                resultado="Usuario invalido";  
            }else{
                resultado = personaServicio.hacerLogin(password,vo.getPassword());
                et.commit();
            }            
        }catch(Exception e){
            hacerRollback();
            resultado ="Error";
        }finally{
            cerrarConexion();
            return resultado;
        }        
    } 
}