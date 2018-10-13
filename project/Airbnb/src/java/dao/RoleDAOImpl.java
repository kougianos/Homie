package dao;

import entities.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import jpautils.EntityManagerHelper;

public class RoleDAOImpl implements RoleDAO{

    @Override
    public List<Role> list() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createNamedQuery("Role.findAll");
        List<Role> roles = query.getResultList();
        return roles; 
    }

    @Override
    public Role find(int id) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Role role1 = em.find(Role.class, id);
        return role1;
    }
    
}
