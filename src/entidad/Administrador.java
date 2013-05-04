package entidad;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "administrador")
public class Administrador extends Persona{     
    public Administrador(){}
    public Administrador(Administrador entity){
        this.setId(entity.getId());
        this.setCorreo(entity.getCorreo());
        this.setNombre(entity.getNombre());
        this.setPassword(entity.getPassword());
    }    
}
