/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.admin;

import entities.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import jpautils.EntityManagerHelper;

/**
 *
 * @author valia
 */
public class AdminDAOImpl implements AdminDAO {

    @Override
    public List<User> list() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createNamedQuery("User.findAll");
        List<User> users = query.getResultList();
        return users;
    }

    @Override
    public List<User> listActive() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createNamedQuery("User.findByActive");
        query.setParameter("active", true);
        
        List<User> users = query.getResultList();
        return users;
    }

    @Override
    public List<User> listInactive() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createNamedQuery("User.findByActive");
        query.setParameter("active", false);
        List<User> users = query.getResultList();
        return users;
    }    
}
