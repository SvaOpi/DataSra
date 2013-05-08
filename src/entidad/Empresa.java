package entidad;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "empresa")

public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    
    @Column(unique=true)
    private Long nit;
    
    @OneToMany(cascade= CascadeType.ALL, mappedBy="empresa", orphanRemoval=true)
    private Collection<Usuario> usuarios = new ArrayList<Usuario>();

    public Collection<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Collection<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getNit() {
        return nit;
    }

    public void setNit(Long nit) {
        this.nit = nit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
