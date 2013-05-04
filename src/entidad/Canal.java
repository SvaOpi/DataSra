package entidad;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "canal")
public class Canal extends Empresa{
    
    Collection<PuntoVenta> puntoList = new ArrayList<PuntoVenta>();
    
}
