package dao;

import entities.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import jpautils.EntityManagerHelper;

public class UserRentsRoomDAOImpl implements UserRentsRoomDAO {

    @Override
    public List<UserRentsRoom> list() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createNamedQuery("UserRentsRoom.findAll");
        List<UserRentsRoom> user_room = query.getResultList();
        return user_room;
    }

    @Override
    public List<UserRentsRoom> listwithusername(User username) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createNamedQuery("UserRentsRoom.findWithUsername").setParameter("username", username);
        List<UserRentsRoom> user_room = query.getResultList();
        return user_room;
    }

    @Override
    public UserRentsRoom find(int id) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        UserRentsRoom user_room = em.find(UserRentsRoom.class, id);
        return user_room;
    }

    @Override
    public List<UserRentsRoom> findbyusername(User username) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createNamedQuery("UserRentsRoom.findWithUsername").setParameter("username", username);
        List<UserRentsRoom> user_room = query.getResultList();
        return user_room;
    }

    @Override
    public UserRentsRoom findbyidroom(Room idroom) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createNamedQuery("UserRentsRoom.findByIdroom").setParameter("idroom", idroom);
        List<UserRentsRoom> user_room = query.getResultList();

        UserRentsRoom room = user_room.get(0);
        return room;
    }

    @Override
    public List<UserRentsRoom> findallbyidroom(Room idroom) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createNamedQuery("UserRentsRoom.findByIdroom").setParameter("idroom", idroom);
        List<UserRentsRoom> user_room = query.getResultList();

        return user_room;
    }

    @Override
    public void insert(UserRentsRoom newrent) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        em.persist(newrent);

        EntityManagerHelper.commit();
    }

    @Override
    public void update(UserRentsRoom urr, int rating) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        int idrent = urr.getIdrent();
        UserRentsRoom ratingRoom = em.find(UserRentsRoom.class, idrent);

        ratingRoom.setRate(rating);

        EntityManagerHelper.commit();
    }
}
