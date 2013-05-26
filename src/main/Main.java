/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import entidad.Persona;
import fachada.PersonaFachada;
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
        Persona vo = new Persona();
        vo.setCorreo("correo");
        vo.setDireccion("direccion");
        vo.setDocumento("123");
        vo.setFechaMuerte(new Date(2000,10,10));
        vo.setFechaNacimiento(new Date());
        vo.setNombre("nombre");
        vo.setTipoDocumento("CC");
        String resultado = fachada.crearPersona(vo);
        System.out.println(resultado);
    }
}
