package dao;

import entities.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import jpautils.EntityManagerHelper;

public class RulesDAOImpl implements RulesDAO{

    @Override
    public List<Rules> list() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createNamedQuery("Rules.findAll");
        List<Rules> rules = query.getResultList();
        return rules;
    }

    @Override
    public Rules find(int id) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Rules rule1 = em.find(Rules.class, id);
        return rule1;
    }
    
}
