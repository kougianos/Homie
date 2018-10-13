package dao;

import entities.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import jpautils.EntityManagerHelper;

public class SpaceDAOImpl implements SpaceDAO{

    @Override
    public List<Space> list() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createNamedQuery("Space.findAll");
        List<Space> space = query.getResultList();
        return space;
    }

    @Override
    public Space find(int id) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Space space1 = em.find(Space.class, id);
        return space1;
    }
    
}
