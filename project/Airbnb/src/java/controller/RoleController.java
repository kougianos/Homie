package controller;

import dao.RoleDAOImpl;
import dao.UserDAOImpl;
import entities.Role;
import entities.User;
import java.io.Serializable;
import java.util.List;


public class RoleController implements Serializable{
    
    private int x = 0;
    
    private Role insertRole = new Role();
    private Role foundRole = null;
    private List<Role> foundList = null;
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    
    public String findOne() {
        int query_id =  x;
        
        RoleDAOImpl dao = new RoleDAOImpl();
        foundRole = dao.find(query_id);
        
        return null;
    }
    
    public String findAll() {
        RoleDAOImpl dao = new RoleDAOImpl();
        List<Role> list = dao.list();
        
        foundList = list;
        
        return null;
    }
    
    public Role getFoundRole() {
        return foundRole;
    }

    public void setFoundRole(Role foundRole) {
        this.foundRole = foundRole;
    }

    public List<Role> getFoundList() {
        return foundList;
    }

    public void setFoundList(List<Role> foundList) {
        this.foundList = foundList;
    }
    
     public Role getInsertRole() {
        return insertRole;
    }

    public void setInsertRole(Role insertRole) {
        this.insertRole = insertRole;
    }

}

