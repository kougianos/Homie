/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RoomDAO;
import dao.RoomDAOImpl;
import dao.UserRentsRoomDAO;
import dao.UserRentsRoomDAOImpl;
import entities.Room;
import entities.User;
import entities.UserRentsRoom;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author valia
 */

@ManagedBean(name = "rentedRoomController")
@ViewScoped
public class RentedRoomsController {
    
    @ManagedProperty(value = "#{sessionController}")
    private SessionController sessionController;

    private List<UserRentsRoom> urrList;
    private List<Room> roomList = new ArrayList<Room>();
  
    
    @PostConstruct
    public void init() {
        //String username = sessionController.getLoggedInUser().getUsername();
        
        User username = sessionController.getLoggedInUser();
        UserRentsRoomDAO dao = new UserRentsRoomDAOImpl();
        RoomDAO roomdao = new RoomDAOImpl();
        urrList = dao.listwithusername(username);
        for(UserRentsRoom urr : urrList){
            roomList.add(urr.getIdroom());
        }
    }

    public SessionController getSessionController() {
        return sessionController;
    }

    public void setSessionController(SessionController sessionController) {
        this.sessionController = sessionController;
    }

    public List<UserRentsRoom> getUrrList() {
        return urrList;
    }

    public void setUrrList(List<UserRentsRoom> urrList) {
        this.urrList = urrList;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

  
    
    
}