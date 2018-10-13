package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entities.*;
import javax.persistence.EntityTransaction;
import jpautils.EntityManagerHelper;

public class UserDAOImpl implements UserDAO {


    @Override
    public User find(String username) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        User user1 = em.find(User.class, username);
        if (user1 != null) {
            user1.getRoleList();
        }
        return user1;
    }

    @Override
    public List<User> list() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createNamedQuery("User.findAll");
        List<User> users = query.getResultList();
        return users;
    }

    @Override
    public List<User> export() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createNamedQuery("User.findAll");
        List<User> users = query.getResultList();
        return users;

    }

    @Override
    public List<User> listActive() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createNamedQuery("User.findByActive").setParameter("active", true);
        List<User> users = query.getResultList();
        return users;
    }

    @Override
    public List<User> listInactive() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createNamedQuery("User.findByActive").setParameter("active", false);
        List<User> users = query.getResultList();
        return users;
    }

    @Override
    public void insert(User insertUser) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        em.persist(insertUser);

        boolean isRenter = false;
        for (Role r : insertUser.getRoleList()) {
            if (r.getIdrole() == UserConstants.RENTER) {
                isRenter = true;
            }
        }

        Role visitorRole = em.find(Role.class, UserConstants.VISITOR);

        insertUser.getRoleList().clear();
        insertUser.getRoleList().add(visitorRole);
        visitorRole.getUserList().add(insertUser);

        if (isRenter) {
            Role roleRenter = em.find(Role.class, UserConstants.RENTER);
            roleRenter.getUserList().add(insertUser);
            insertUser.getRoleList().add(roleRenter);
        }

        EntityManagerHelper.commit();
    }

    @Override
    public void update(User updateUser) {

        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        String username = updateUser.getUsername();
        User cacheUser = em.find(User.class, username);

        cacheUser.setName(updateUser.getName());
        cacheUser.setSurname(updateUser.getSurname());
        cacheUser.setEmail(updateUser.getEmail());
        cacheUser.setPhone(updateUser.getPhone());
        cacheUser.setPhoto(updateUser.getPhoto());

        EntityManagerHelper.commit();
    }

    @Override
    public boolean activate(String username) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        User cacheUser = em.find(User.class, username);
        if (cacheUser != null) {
            cacheUser.setActive(true);
            EntityManagerHelper.commit();
            return true;
        } else {
            EntityManagerHelper.commit();
            return false;
        }

    }

    public boolean deactivate(String username) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        User cacheUser = em.find(User.class, username);
        if (cacheUser != null) {
            cacheUser.setActive(false);
            EntityManagerHelper.commit();
            return true;
        } else {
            EntityManagerHelper.commit();
            return false;
        }
    }

    @Override
    public boolean update_password(String username, String old_password, String new_password) {

        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        User cacheUser = em.find(User.class, username);

        if (cacheUser.getPassword().equals(old_password)) {
            cacheUser.setPassword(new_password);
            EntityManagerHelper.commit();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<String> ids() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createNamedQuery("User.findUsernames");
        List<String> usernames = query.getResultList();
        return usernames;
    }

}
