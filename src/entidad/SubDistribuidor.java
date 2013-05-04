package entidad;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "subDistribuidor")
public class SubDistribuidor extends Empresa{
    
    Collection<Canal> canalList = new ArrayList<Canal>();
    
}
