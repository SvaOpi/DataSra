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
@Table(name = "subDistribuidor")
public class SubDistribuidor extends Empresa implements Serializable{
    
    @ManyToOne
    private Distribuidor distribuidor;
    
    @OneToMany(cascade= CascadeType.ALL, mappedBy="subDistri", orphanRemoval=true)
    Collection<Canal> canalList = new ArrayList<Canal>();

    public Distribuidor getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(Distribuidor distribuidor) {
        this.distribuidor = distribuidor;
    }

    public Collection<Canal> getCanalList() {
        return canalList;
    }

    public void setCanalList(Collection<Canal> canalList) {
        this.canalList = canalList;
    }
    
}
