package controller;

import dao.RoomDAO;
import dao.RoomDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import entities.Room;
import entities.User;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "roomManagementController")
@ViewScoped
public class RoomManagementController {

    @ManagedProperty(value = "#{sessionController}")
    private SessionController sessionController;

    private List<Room> roomList;

    @PostConstruct
    public void init() {
        String username = sessionController.getLoggedInUser().getUsername();
        
        RoomDAO dao = new RoomDAOImpl();
        roomList = dao.list(username);
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public SessionController getSessionController() {
        return sessionController;
    }

    public void setSessionController(SessionController sessionController) {
        this.sessionController = sessionController;
    }

    
    

}
