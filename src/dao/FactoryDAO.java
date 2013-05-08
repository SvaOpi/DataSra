package dao;

public final class FactoryDAO {
    
    private FactoryDAO(){}
    
    public static Dao crear(int tipo){
        if(tipo==Dao.PERSONA){
            return new PersonaDAO();
        }else if(tipo==Dao.ADMINISTRADOR){
            return new AdministradorDAO();
        }else if(tipo==Dao.USUARIO){
            return new UsuarioDAO();
        }else{
            return null;
        }
    }
    
}
