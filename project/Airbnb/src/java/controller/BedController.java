package controller;

import dao.BedDAOImpl;
import dao.UserDAOImpl;
import entities.Bed;
import entities.User;
import java.io.Serializable;
import java.util.List;


public class BedController implements Serializable{
    
    private int x = 0;
    
    private Bed insertBed = new Bed();
    private Bed foundBed = null;
    private List<Bed> foundList = null;
   
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    
    public String findOne() {
        int query_id =  x;
        
        BedDAOImpl dao = new BedDAOImpl();
        foundBed = dao.find(query_id);
        
        return null;
    }
    
    public String findAll() {
        BedDAOImpl dao = new BedDAOImpl();
        List<Bed> list = dao.list();
        
        foundList = list;
        
        return null;
    }
    
    public Bed getFoundBed() {
        return foundBed;
    }

    public void setFoundBed(Bed foundBed) {
        this.foundBed = foundBed;
    }

    public List<Bed> getFoundList() {
        return foundList;
    }

    public void setFoundList(List<Bed> foundList) {
        this.foundList = foundList;
    }
    
     public Bed getInsertBed() {
        return insertBed;
    }

    public void setInsertBed(Bed insertBed) {
        this.insertBed = insertBed;
    }

}

