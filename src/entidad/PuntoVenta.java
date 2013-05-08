package entidad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "puntoVenta")
public class PuntoVenta extends Empresa implements Serializable{
    
    @ManyToOne
    private Canal canal;

    public Canal getCanal() {
        return canal;
    }

    public void setCanal(Canal canal) {
        this.canal = canal;
    }
    
    
}
