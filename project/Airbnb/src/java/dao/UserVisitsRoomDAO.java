package dao;

import entities.*;
import java.util.List;

public interface UserVisitsRoomDAO {
    public List<UserVisitsRoom> list();

    public UserVisitsRoom find(int id);
    
    public UserVisitsRoom findbyusername(String username);
    
    public void insert(UserVisitsRoom newrent);
    
    public List<UserVisitsRoom> listwithusername(String username);
    
    public void update(UserVisitsRoom urr, int rating);
    
    public UserVisitsRoom findbyidroom(Room idroom);
    
    public void visit(String username, int id);

    
}
