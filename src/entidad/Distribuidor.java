package entidad;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "distribuidor")
public class Distribuidor extends Empresa{
    
    Collection<SubDistribuidor> subDistriList = new ArrayList<SubDistribuidor>();
    
}
