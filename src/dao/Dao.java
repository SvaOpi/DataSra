package dao;

import javax.persistence.EntityManager;

public abstract class Dao {
    public static final int PERSONA = 1;
    public static final int ADMINISTRADOR = 2;
    public static final int USUARIO = 3;
     
    public static void persist(Object entity, EntityManager em){        
        em.persist(entity);
    }
    
    public static void deleteSigleResult(Object o, EntityManager em){
        Object o1 = em.merge(o);
        em.remove(o1);
    }
    
    public static void update(Object o, EntityManager em ){
        em.merge(o);
    }
}
