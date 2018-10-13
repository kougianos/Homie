package db;

import entities.User;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;


public class UserDB {

    
    @SuppressWarnings("unchecked")
	public List<User> getUsers()
    {
        List<User> users = null;
        EntityManager em = JPAResource.factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        //Query q = em.createQuery("Select u from User u");
        Query q = em.createNamedQuery("User.findAll");
        users =  q.getResultList();
		
        tx.commit();
        em.close();
        return users;
    }
    
    public User find(String username, String password)
    {
        User user = null;
        
        EntityManager em = JPAResource.factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        Query q = em.createQuery("Select u from User u where u.username = :username and u.password = :password");
        q.setParameter("username", username);
        q.setParameter("password", password);
        List users =  q.getResultList();
        tx.commit();
        em.close();
        
        if (users != null && users.size() == 1)
        {
            user = (User) users.get(0);
        }

        return user;
        
    }
    
    public int insertUser(User user)
    {
        int id = -1;
        EntityManager em = JPAResource.factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try 
        {
            em.persist(user);
            em.flush();
            id = user.getId();
            tx.commit();
            return id;
        }
        catch (PersistenceException e)
        {
            if (tx.isActive()) tx.rollback();
            return id;
        }
        finally 
        {
            em.close();
        }
    }
    
    public User getById(int id)
    {
        User user = null;
        
        EntityManager em = JPAResource.factory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        user =em.find(User.class, id);
	
        tx.commit();
        em.close();
        
        
        return user;
        
    }
    
}
