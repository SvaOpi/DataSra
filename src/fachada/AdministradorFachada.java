package fachada;

import entidad.Administrador;
import servicio.AdministradorServicio;

public class AdministradorFachada extends Fachada{
    private AdministradorServicio administradorServicio;
    
    public AdministradorFachada(){
        administradorServicio = new AdministradorServicio();
    }
    
    public String crearAdministrador(Administrador vo){
        String resultado = "";
        try{
            abrirConexion();
            if(administradorServicio.buscarAdministradorPorCorreo(vo.getCorreo(), em)!=null){
                et.commit();
                resultado ="Correo ya registrado";
            }else{
                administradorServicio.crearAdministrador(vo, em);
                resultado ="Creado";
                et.commit();
            }
        }catch(Exception e){
            //e.printStackTrace();
            hacerRollback();
            resultado ="Error";
        }finally{
            cerrarConexion();
            return resultado;
        }
        
    }
    
    public Administrador buscarAdministradorPorCorreo(String correo){
        Administrador administradorVO = null;
        try{
            abrirConexion();
            administradorVO = administradorServicio.buscarAdministradorPorCorreo(correo, em);
            et.commit();
        }catch(Exception e){
            hacerRollback();
        }finally{
            cerrarConexion();
            return administradorVO;
        }        
    }    
    
    public String actualizarAdministrador(Administrador vo){
        String resultado = "";
        try{
            abrirConexion();
            if(administradorServicio.buscarAdministradorPorCorreo(vo.getCorreo(), em)==null){
                et.commit();
                resultado ="Administrador no encontrado";  
            }else{
                administradorServicio.actualizarAdministrador(vo, em);
                et.commit();
                resultado ="Actualizado";
            }
        }catch(Exception e){
            hacerRollback();
            resultado ="Error";
        }finally{
            cerrarConexion();
            return resultado;
        }
    }
    
    public String eliminarAdministrador(Administrador vo){
        String resultado = "";
        try{
            abrirConexion();
            if(administradorServicio.buscarAdministradorPorCorreo(vo.getCorreo(), em)==null){
                et.commit();
                resultado ="Administrador no encontrado"; 
            }
            administradorServicio.eliminarAdministrador(vo, em);
            et.commit(); 
            resultado ="Eliminado";
        }catch(Exception e){
            
            hacerRollback();
            resultado ="Error";
        }finally{
            cerrarConexion();
            return resultado;
        }
    }
    
}
