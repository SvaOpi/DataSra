/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sugerencia")
public class Sugerencia {
    @Id
    private Long id;
 
    private String sugerncia;  

    public String getSugerncia() {
        return sugerncia;
    }

    public void setSugerncia(String sugerncia) {
        this.sugerncia = sugerncia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
