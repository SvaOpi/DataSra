package fachada;

public final class FactoryFachada {
    
    private FactoryFachada(){}
    public static Fachada crear(int tipo){
        if(tipo==Fachada.ADMINISTRADOR){
            return new AdministradorFachada();
        }else if(tipo==Fachada.USUARIO){
            return new UsuarioFachada();
        }else if(tipo==Fachada.PERSONA){
            return new PersonaFachada();
        }
        return null; 
    }
}
