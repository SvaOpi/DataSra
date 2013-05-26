package fachada;

import entidad.Persona;
import servicio.PersonaServicio;

public class PersonaFachada extends Fachada{
     
    private PersonaServicio personaServicio;
    
    public PersonaFachada(){
        personaServicio = new PersonaServicio();
    }
    
    public String crearPersona(Persona vo){
        String resultado = "";
        try{
            abrirConexion();
            if(personaServicio.buscarPorDocumento(vo.getDocumento(), em)!= null){
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
    
    
    public String hacerLogin(String documento, String password){
        String resultado = "";
        try{
            abrirConexion();
            Persona vo = personaServicio.buscarPorDocumento(documento, em);
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