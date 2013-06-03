/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.datasra.entity.Person;
import com.datasra.facade.PersonaFachada;
import java.util.Date;

/**
 *
 * @author kmilo_000
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PersonaFachada fachada = new PersonaFachada();
        Person vo = new Person();
        vo.setMail("correo");
        vo.setAddress("direccion");
        vo.setCedule(123);
        vo.setDeath(new Date(2000,10,10));
        vo.setBirth(new Date());
        vo.setName("nombre");
        String resultado = fachada.crearPersona(vo);
        System.out.println(resultado);
    }
}
