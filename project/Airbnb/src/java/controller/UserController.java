package controller;

import dao.UserDAO;
import dao.UserDAOImpl;
import entities.Role;
import entities.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

@ManagedBean(name = "UserController")
@ViewScoped
public class UserController implements Serializable {

    private String x = null;

    private User insertUser = new User();

    private User foundUser = null;
    private List<User> foundList = null;

    private String[] role_ids;
    
    private String username; // 1 property for each form field
    private String password;
    private String email;
    private String phone;
    private String photo;
    private String name;
    private String surname;
    private String role;
    private String active;
    
   
    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String findOne() {
        String query_username = x;

        UserDAOImpl dao = new UserDAOImpl();
        foundUser = dao.find(query_username);

        return null;
    }

    public String findAll() {
        UserDAOImpl dao = new UserDAOImpl();
        List<User> list = dao.list();

        foundList = list;

        return null;
    }

    public User getFoundUser() {
        return foundUser;
    }

    public void setFoundUser(User foundUser) {
        this.foundUser = foundUser;
    }

    public List<User> getFoundList() {
        return foundList;
    }

    public void setFoundList(List<User> foundList) {
        this.foundList = foundList;
    }

    public User getInsertUser() {
        return insertUser;
    }

    public void setInsertUser(User insertUser) {
        this.insertUser = insertUser;
    }

    public String[] getRole_ids() {
        return role_ids;
    }

    public void setRole_ids(String[] role_ids) {
        this.role_ids = role_ids;
    }

}
