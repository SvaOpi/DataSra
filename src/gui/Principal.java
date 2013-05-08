/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entidad.Usuario;
import fachada.UsuarioFachada;

/**
 *
 * @author Usuario2
 */
public class Principal extends javax.swing.JFrame {

    Login login;
    
    public int estado=0;
    
    
    public Principal() {
        initComponents();
        login = new Login();
        login.padre=this;

        
        this.agregarPanel(login);
        
        
    }
    public void siguiente(int resultado){
        switch(estado){
            case 0://estado 0 es cuando esta en la ventana de login
                if (resultado==1){// La respuesta determina a donde vas
                    this.remove(login);
                    RegistroUsuario r= new RegistroUsuario();
                    this.agregarPanel(r);
                }
                estado=1;
                break;
            case 1:
                break;
        }
    }
    public void agregarPanel(javax.swing.JPanel p){
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(0, Short.MAX_VALUE)
                .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(0, Short.MAX_VALUE))
        );
  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 337, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Usuario admin = new Usuario();
                admin.setCorreo("sacastanedaa@advancedtech.com");
                admin.setCedula(Long.parseLong("123"));
                admin.setNombre("Sergio Alejandro Castañeda Astaiza");
                admin.setPassword("admin");           

                UsuarioFachada fachada = new UsuarioFachada();
                String resultado = fachada.crearUsuario(admin);
                if(resultado.equals("Creado")){
                    System.out.println("admin creado");
                }else{
                    System.out.println("admin no creado");
                }
                new Principal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
