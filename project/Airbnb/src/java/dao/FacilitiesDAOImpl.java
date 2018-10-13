package dao;

import entities.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import jpautils.EntityManagerHelper;

public class FacilitiesDAOImpl implements FacilitiesDAO{

    @Override
    public List<Facilities> list() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createNamedQuery("Facilities.findAll");
        List<Facilities> facilities = query.getResultList();
        return facilities; 
    }

    @Override
    public Facilities find(int id) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Facilities facility1 = em.find(Facilities.class, id);
        return facility1;
    }
    
    
}
