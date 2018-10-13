package controller;

import dao.RoomDAOImpl;
import dao.UserDAOImpl;
import entities.Room;
import entities.User;
import java.io.Serializable;
import java.util.List;


public class RoomController implements Serializable{
    
    private int x = 0;
    
    private Room insertRoom = new Room();
    private Room foundRoom = null;
    private List<Room> foundList = null;
    
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    
    public String findOne() {
        int query_id =  x;
        
        RoomDAOImpl dao = new RoomDAOImpl();
        foundRoom = dao.find(query_id);
        
        return null;
    }
    
    public String findAll() {
        RoomDAOImpl dao = new RoomDAOImpl();
        List<Room> list = dao.list();
        
        foundList = list;
        
        return null;
    }
    
    public Room getFoundRoom() {
        return foundRoom;
    }

    public void setFoundRoom(Room foundRoom) {
        this.foundRoom = foundRoom;
    }

    public List<Room> getFoundList() {
        return foundList;
    }

    public void setFoundList(List<Room> foundList) {
        this.foundList = foundList;
    }
    
     public Room getInsertRoom() {
        return insertRoom;
    }

    public void setInsertRoom(Room insertRoom) {
        this.insertRoom = insertRoom;
    }

}

