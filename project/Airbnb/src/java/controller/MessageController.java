package controller;

import dao.MessageDAOImpl;
import dao.UserDAOImpl;
import entities.Message;
import entities.User;
import java.io.Serializable;
import java.util.List;


public class MessageController implements Serializable{
    
    private int x = 0;
    
    private Message insertMessage = new Message();
    private Message foundMessage = null;
    private List<Message> foundList = null;
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    
    public String findOne() {
        int query_id =  x;
        
        MessageDAOImpl dao = new MessageDAOImpl();
        foundMessage = dao.find(query_id);
        
        return null;
    }
    
    public String findAll() {
        MessageDAOImpl dao = new MessageDAOImpl();
        List<Message> list = dao.list();
        
        foundList = list;
        
        return null;
    }
    
    public Message getFoundMessage() {
        return foundMessage;
    }

    public void setFoundMessage(Message foundMessage) {
        this.foundMessage = foundMessage;
    }

    public List<Message> getFoundList() {
        return foundList;
    }

    public void setFoundList(List<Message> foundList) {
        this.foundList = foundList;
    }
    
     public Message getInsertMessage() {
        return insertMessage;
    }

    public void setInsertMessage(Message insertMessage) {
        this.insertMessage = insertMessage;
    }

}

