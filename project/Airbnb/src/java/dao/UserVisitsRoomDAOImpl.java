package dao;

import entities.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import jpautils.EntityManagerHelper;

public class UserVisitsRoomDAOImpl implements UserVisitsRoomDAO {

    @Override
    public List<UserVisitsRoom> list() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createNamedQuery("UserVisitsRoom.findAll");
        List<UserVisitsRoom> user_room = query.getResultList();
        return user_room;
    }

    @Override
    public List<UserVisitsRoom> listwithusername(String username) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createNamedQuery("UserVisitsRoom.findByUsername").setParameter("username", username);
        List<UserVisitsRoom> user_room = query.getResultList();
        return user_room;
    }

    @Override
    public UserVisitsRoom find(int id) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        UserVisitsRoom user_room = em.find(UserVisitsRoom.class, id);
        return user_room;
    }

    @Override
    public UserVisitsRoom findbyusername(String username) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        UserVisitsRoom rooms = em.find(UserVisitsRoom.class, username);
        return rooms;
    }

    @Override
    public UserVisitsRoom findbyidroom(Room idroom) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createNamedQuery("UserVisitsRoom.findByIdroom").setParameter("idroom", idroom);
        List<UserVisitsRoom> user_room = query.getResultList();

        UserVisitsRoom room = user_room.get(0);
        return room;
    }

    @Override
    public void insert(UserVisitsRoom newrent) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        em.persist(newrent);

        EntityManagerHelper.commit();
    }

    @Override
    public void update(UserVisitsRoom urr, int visits) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        int idrent = urr.getId();
        UserVisitsRoom ratingRoom = em.find(UserVisitsRoom.class, idrent);

        ratingRoom.setVisits(visits);

        EntityManagerHelper.commit();
    }

    @Override
    public void visit(String username, int idroom) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("UserVisitsRoom.findByUsernameAndRoomID").setParameter("username", username).setParameter("roomId", idroom);
        
        List<UserVisitsRoom> user_room = query.getResultList();
        
        if (user_room.size() >0 ) {
            for (UserVisitsRoom r : user_room) {
                r.setVisits(r.getVisits() + 1);
            }
        } else {
            UserVisitsRoom r = new UserVisitsRoom();
            r.setRoomId(idroom);
            r.setUsername(username);
            r.setVisits(1);
            
            em.persist(r);
        }
        EntityManagerHelper.commit();
    }

}
