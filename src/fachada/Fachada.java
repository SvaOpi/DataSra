package fachada;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public abstract class Fachada {
    
    protected static final int PERSONA = 1;
    protected static final int EMPRESA = 2;
    protected static final String PU="ggpPU";
    protected EntityManagerFactory emf=null;
    protected EntityManager em=null;
    protected EntityTransaction et=null;
    
    public void cerrarConexion(){
        if (em != null) {
            em.clear();
            em.close();
        }
    }
    
    public void hacerRollback(){
        if(em != null && et != null){
            et.rollback();
        }
    }
    
    public void abrirConexion(){
        emf = Persistence.createEntityManagerFactory(PU);
        em = emf.createEntityManager();
        et = em.getTransaction();
        et.begin();
    }
}
