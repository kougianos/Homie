package dao;

import entities.*;
import java.util.List;

public interface MessageDAO {
    public List<Message> list();
    
    public List<Message> list_inbox(String username);
    
    public List<Message> list_outbox(String username);

    public Message find(int id);

    public void insert(String username_from, String username_to, Message insertMessage, int associated_room);
   
}
