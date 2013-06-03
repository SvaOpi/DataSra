package com.datasra.facade;

public final class FactoryFachada {
    
    private FactoryFachada(){}
    public static Fachada crear(int tipo){
        if(tipo==Fachada.EMPRESA){
            return new EmpresaFachada();
        }else if(tipo==Fachada.PERSONA){
            return new PersonaFachada();
        }
        return null; 
    }
}
