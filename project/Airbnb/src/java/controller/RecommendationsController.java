/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RecommendedRoomsDAO;
import dao.RecommendedRoomsDAOImpl;
import dao.RoomDAO;
import dao.RoomDAOImpl;
import entities.Room;
import java.io.Serializable;
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

@ManagedBean(name = "recommendations")
@ViewScoped
public class RecommendationsController implements Serializable {
    @ManagedProperty(value = "#{sessionController}")
    private SessionController sessionController;

    private List<Room> roomList;
    
    @PostConstruct
    public void init() {
        String username = sessionController.getLoggedInUser().getUsername();
        
        RecommendedRoomsDAO dao = new RecommendedRoomsDAOImpl();
        roomList = dao.list(username);
        
        System.out.println("yo");
    }

    public SessionController getSessionController() {
        return sessionController;
    }

    public void setSessionController(SessionController sessionController) {
        this.sessionController = sessionController;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }
    
    
}
