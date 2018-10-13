package controller;

import dao.RoomtypeDAOImpl;
import dao.UserDAOImpl;
import entities.Roomtype;
import entities.User;
import java.io.Serializable;
import java.util.List;


public class RoomtypeController implements Serializable{
    
    private int x = 0;
    
    private Roomtype insertRoomtype = new Roomtype();
    private Roomtype foundRoomtype = null;
    private List<Roomtype> foundList = null;
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    
    public String findOne() {
        int query_id =  x;
        
        RoomtypeDAOImpl dao = new RoomtypeDAOImpl();
        foundRoomtype = dao.find(query_id);
        
        return null;
    }
    
    public String findAll() {
        RoomtypeDAOImpl dao = new RoomtypeDAOImpl();
        List<Roomtype> list = dao.list();
        
        foundList = list;
        
        return null;
    }
    
    public Roomtype getFoundRoomtype() {
        return foundRoomtype;
    }

    public void setFoundRoomtype(Roomtype foundRoomtype) {
        this.foundRoomtype = foundRoomtype;
    }

    public List<Roomtype> getFoundList() {
        return foundList;
    }

    public void setFoundList(List<Roomtype> foundList) {
        this.foundList = foundList;
    }
    
     public Roomtype getInsertRoomtype() {
        return insertRoomtype;
    }

    public void setInsertRoomtype(Roomtype insertRoomtype) {
        this.insertRoomtype = insertRoomtype;
    }

}

