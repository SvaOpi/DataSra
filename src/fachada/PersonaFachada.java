package fachada;

import entidad.Persona;
import servicio.PersonaServicio;

public class PersonaFachada extends Fachada{
     
    private PersonaServicio personaServicio;
    
    public PersonaFachada(){
        personaServicio = new PersonaServicio();
    }
    
    public String hacerLogin(Long cedula, String password){
        String resultado = "";
        try{
            abrirConexion();
            Persona vo = personaServicio.buscarPorCedula(cedula, em);
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