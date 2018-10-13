package jpautils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class EntityManagerHelper {

    private static final EntityManagerFactory emf;
    private static EntityManager em;
//    private static final ThreadLocal<EntityManager> threadLocal;
    

    static {
        emf = Persistence.createEntityManagerFactory("AirbnbPU");
//        threadLocal = new ThreadLocal<EntityManager>();
        em = emf.createEntityManager();
    }

    public static EntityManager getEntityManager() {
//        EntityManager em = threadLocal.get();

        if (em == null) {
            em = emf.createEntityManager();
//            threadLocal.set(em);
        }
        return em;
    }

    public static void closeEntityManager() {
//        EntityManager em = threadLocal.get();
        if (em != null) {
            em.close();
            em = null;
//            threadLocal.set(null);
        }
    }

    public static void closeEntityManagerFactory() {
        emf.close();
    }

    public static void beginTransaction() {
        getEntityManager().getTransaction().begin();
    }

    public static EntityTransaction getTransaction() {
        return getEntityManager().getTransaction();
    }

    public static void rollback() {
        getEntityManager().getTransaction().rollback();
    }

    public static void commit() {
        getEntityManager().getTransaction().commit();
    }

}
