package dao;

import entities.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import jpautils.EntityManagerHelper;

public class RoomtypeDAOImpl implements RoomtypeDAO{

    @Override
    public List<Roomtype> list() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createNamedQuery("Roomtype.findAll");
        List<Roomtype> roomtypes = query.getResultList();
        return roomtypes;  
    }

    @Override
    public Roomtype find(int id) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Roomtype roomtype1 = em.find(Roomtype.class, id);
        return roomtype1;
    }
    
}
