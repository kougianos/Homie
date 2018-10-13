package dao;

import entities.*;
import java.util.List;

public interface UserRentsRoomDAO {
    public List<UserRentsRoom> list();

    public UserRentsRoom find(int id);
    
    public List<UserRentsRoom> findbyusername(User username);
    
    public void insert(UserRentsRoom newrent);
    
    public List<UserRentsRoom> listwithusername(User username);
    
    public void update(UserRentsRoom urr, int rating);
    
    public UserRentsRoom findbyidroom(Room idroom);
    
    public List<UserRentsRoom> findallbyidroom(Room idroom);
}
