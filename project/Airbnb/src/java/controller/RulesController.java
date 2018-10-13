package controller;

import dao.RulesDAOImpl;
import dao.UserDAOImpl;
import entities.Rules;
import entities.User;
import java.io.Serializable;
import java.util.List;


public class RulesController implements Serializable{
    
    private int x = 0;
    
    private Rules insertRules = new Rules();
    private Rules foundRules = null;
    private List<Rules> foundList = null;
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    
    public String findOne() {
        int query_id =  x;
        
        RulesDAOImpl dao = new RulesDAOImpl();
        foundRules = dao.find(query_id);
        
        return null;
    }
    
    public String findAll() {
        RulesDAOImpl dao = new RulesDAOImpl();
        List<Rules> list = dao.list();
        
        foundList = list;
        
        return null;
    }
    
    public Rules getFoundRules() {
        return foundRules;
    }

    public void setFoundRules(Rules foundRules) {
        this.foundRules = foundRules;
    }

    public List<Rules> getFoundList() {
        return foundList;
    }

    public void setFoundList(List<Rules> foundList) {
        this.foundList = foundList;
    }
    
     public Rules getInsertRules() {
        return insertRules;
    }

    public void setInsertRules(Rules insertRules) {
        this.insertRules = insertRules;
    }

}

