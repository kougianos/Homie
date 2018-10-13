package controller;

import dao.UserRentsRoomDAOImpl;
import dao.UserDAOImpl;
import entities.UserRentsRoom;
import entities.User;
import java.io.Serializable;
import java.util.List;


public class UserRentsRoomController implements Serializable{
    
    private int x = 0;
    
    private UserRentsRoom insertUserRentsRoom = new UserRentsRoom();
    private UserRentsRoom foundUserRentsRoom = null;
    private List<UserRentsRoom> foundList = null;
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    
    public String findOne() {
        int query_id =  x;
        
        UserRentsRoomDAOImpl dao = new UserRentsRoomDAOImpl();
        foundUserRentsRoom = dao.find(query_id);
        
        return null;
    }
    
    public String findAll() {
        UserRentsRoomDAOImpl dao = new UserRentsRoomDAOImpl();
        List<UserRentsRoom> list = dao.list();
        
        foundList = list;
        
        return null;
    }
    
    public UserRentsRoom getFoundUserRentsRoom() {
        return foundUserRentsRoom;
    }

    public void setFoundUserRentsRoom(UserRentsRoom foundUserRentsRoom) {
        this.foundUserRentsRoom = foundUserRentsRoom;
    }

    public List<UserRentsRoom> getFoundList() {
        return foundList;
    }

    public void setFoundList(List<UserRentsRoom> foundList) {
        this.foundList = foundList;
    }
    
     public UserRentsRoom getInsertUserRentsRoom() {
        return insertUserRentsRoom;
    }

    public void setInsertUserRentsRoom(UserRentsRoom insertUserRentsRoom) {
        this.insertUserRentsRoom = insertUserRentsRoom;
    }

}

