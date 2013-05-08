package entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "canal")
public class Canal extends Empresa implements Serializable{
    
    @ManyToOne
    private SubDistribuidor subDistri;
    
    @OneToMany(cascade= CascadeType.ALL, mappedBy="canal", orphanRemoval=true)
    Collection<PuntoVenta> puntoList = new ArrayList<PuntoVenta>();

    public SubDistribuidor getSubDistri() {
        return subDistri;
    }

    public void setSubDistri(SubDistribuidor subDistri) {
        this.subDistri = subDistri;
    }

    public Collection<PuntoVenta> getPuntoList() {
        return puntoList;
    }

    public void setPuntoList(Collection<PuntoVenta> puntoList) {
        this.puntoList = puntoList;
    }
    
}
