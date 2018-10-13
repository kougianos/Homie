package dao;

import entities.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import jpautils.EntityManagerHelper;

public class BedDAOImpl implements  BedDAO{

    @Override
    public List<Bed> list() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createNamedQuery("Bed.findAll");
        List<Bed> beds = query.getResultList();
        return beds;   
    }

    @Override
    public Bed find(int id) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Bed bed1 = em.find(Bed.class, id);
        return bed1;
    }

    public Bed find(String query_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
