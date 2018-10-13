package controller;

import dao.SpaceDAOImpl;
import dao.UserDAOImpl;
import entities.Space;
import entities.User;
import java.io.Serializable;
import java.util.List;


public class SpaceController implements Serializable{
    
    private int x = 0;
    
    private Space insertSpace = new Space();
    private Space foundSpace = null;
    private List<Space> foundList = null;
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    
    public String findOne() {
        int query_id =  x;
        
        SpaceDAOImpl dao = new SpaceDAOImpl();
        foundSpace = dao.find(query_id);
        
        return null;
    }
    
    public String findAll() {
        SpaceDAOImpl dao = new SpaceDAOImpl();
        List<Space> list = dao.list();
        
        foundList = list;
        
        return null;
    }
    
    public Space getFoundSpace() {
        return foundSpace;
    }

    public void setFoundSpace(Space foundSpace) {
        this.foundSpace = foundSpace;
    }

    public List<Space> getFoundList() {
        return foundList;
    }

    public void setFoundList(List<Space> foundList) {
        this.foundList = foundList;
    }
    
     public Space getInsertSpace() {
        return insertSpace;
    }

    public void setInsertSpace(Space insertSpace) {
        this.insertSpace = insertSpace;
    }

}

