package dao;

import java.util.List;

import entities.*;

public interface UserDAO {
    
    public List<String> ids();
    
    public List<User> list();

    public List<User> listActive();

    public List<User> listInactive();

    public User find(String username);

    public void insert(User user);

    public void update(User user);

    public boolean activate(String username);

    public boolean deactivate(String username);

    public List<User> export();

    public boolean update_password(String username, String old_password,  String new_password);
}
