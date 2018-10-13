package controller;

import dao.UserDAO;
import dao.UserDAOImpl;
import entities.User;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "userManagementController")
@ViewScoped
public class UserManagementController {

    private List<User> userList;

    @PostConstruct
    public void init() {
        UserDAO dao = new UserDAOImpl();
        userList = dao.list();
    }

    public void all() {
        UserDAO dao = new UserDAOImpl();
        userList = dao.list();
    }

    public void active() {
        UserDAO dao = new UserDAOImpl();
        userList = dao.listActive();
    }

    public void inactive() {
        UserDAO dao = new UserDAOImpl();
        userList = dao.listInactive();
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

}
