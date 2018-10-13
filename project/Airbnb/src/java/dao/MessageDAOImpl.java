package dao;

import entities.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import jpautils.EntityManagerHelper;

public class MessageDAOImpl implements MessageDAO {

    @Override
    public List<Message> list() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createNamedQuery("Message.findAll");
        List<Message> message = query.getResultList();
        return message;
    }

    @Override
    public List<Message> list_inbox(String username) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createNamedQuery("Message.findByReaderUsername").setParameter("readerUsername", username);
        List<Message> messages = query.getResultList();
        return messages;
    }

    @Override
    public List<Message> list_outbox(String username) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createNamedQuery("Message.findByWriterUsername").setParameter("writerUsername", username);
        List<Message> messages = query.getResultList();
        return messages;
    }

    @Override
    public Message find(int id) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createNamedQuery("Message.findByIdmessage").setParameter("idmessage", id);
//        Message message1 = em.find(Message.class, id);
        List<Message> message = query.getResultList();
        return message.get(0);
    }

    @Override
    public void insert(String username_from, String username_to, Message insertMessage, int associated_room) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

//        em.persist(insertMessage);
        Room associatedroom = em.find(Room.class, associated_room);
//        User from = em.find(User.class, username_from);
//        User to = em.find(User.class, username_to);

//        from.getMessageList().add(insertMessage);
//        to.getMessageList1().add(insertMessage);

        insertMessage.setIdroom(associatedroom);

        MessagePK pk = new MessagePK();
        pk.setReaderUsername(username_to);
        pk.setWriterUsername(username_from);

        insertMessage.setMessagePK(pk);

//        insertMessage.setUser(from);
//        insertMessage.setUser1(to);
        em.persist(insertMessage);

        EntityManagerHelper.commit();
    }

}
