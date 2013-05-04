package entidad;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario extends Persona{
    
    private String rol;    
    
    @ManyToOne
    private Empresa empresa;     
    
    public Usuario(){}
    public Usuario(Usuario entity){
        this.setId(entity.getId());
        this.setNombre(entity.getNombre());
        this.setPassword(entity.getPassword());
        this.setCorreo(entity.getCorreo());
        rol=entity.getRol();
        empresa=entity.getEmpresa();       
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
