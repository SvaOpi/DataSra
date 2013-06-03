/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datasra.facade;

import com.datasra.entity.Company;
import com.datasra.servicio.EmpresaServicio;

/**
 *
 * @author kmilo_000
 */
class EmpresaFachada extends Fachada {

     private EmpresaServicio personaServicio;
    
    public EmpresaFachada(){
        personaServicio = new EmpresaServicio();
    }
    
    public String crearEmpresa(Long cedula, String password){
        String resultado = "";
        try{
            abrirConexion();
        }catch(Exception e){
            hacerRollback();
            resultado ="Error";
        }finally{
            cerrarConexion();
            return resultado;
        }        
    } 
    
}
