package com.datasra.dao;

public final class FactoryDAO {
    
    private FactoryDAO(){}
    
    public static Dao crear(int tipo){
        if(tipo==Dao.PERSONA){
            return new PersonaDAO();
        }else if(tipo==Dao.EMPRESA){
            return new EmpresaDAO();
        }else{
            return null;
        }
    }
    
}
