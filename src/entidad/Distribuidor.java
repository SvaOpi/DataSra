package entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "distribuidor")
public class Distribuidor extends Empresa implements Serializable{
    
    @OneToMany(cascade= CascadeType.ALL, mappedBy="distribuidor", orphanRemoval=true)
    Collection<SubDistribuidor> subDistriList = new ArrayList<SubDistribuidor>();

    public Collection<SubDistribuidor> getSubDistriList() {
        return subDistriList;
    }

    public void setSubDistriList(Collection<SubDistribuidor> subDistriList) {
        this.subDistriList = subDistriList;
    }
    
}
