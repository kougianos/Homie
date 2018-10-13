/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RoomDAO;
import dao.RoomDAOImpl;
import entities.Room;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "searchController")
@ViewScoped
public class SearchController implements Serializable {

    // search criteria
    private String location;
    private Date checkin;
    private Date checkout;
    private Integer numberofguests = -1;
    private boolean isEmpty;

    private List<Room> roomList = new ArrayList<Room>();
    private RoomDAO dao = new RoomDAOImpl();

    @PostConstruct
    public void init() {
//        roomList = dao.findRecommendedRooms();
    }

    public void search() {

        if (numberofguests != -1) {
            roomList = dao.search(location, checkin, checkout, numberofguests);
            if (roomList.isEmpty()) {
                isEmpty = true;
            }
            if (roomList.isEmpty() == false) {
                isEmpty = false;
            }
        } else {
            roomList = dao.search(location, checkin, checkout);
            if (roomList.isEmpty()) {
                isEmpty = true;
            }
            if (roomList.isEmpty() == false) {
                isEmpty = false;
            }
        }
        if (roomList.isEmpty() == false){
            
            roomList = dao.sort(roomList);
        }
    }

    public void filteredSearch() {
//        UserDAO dao = new UserDAOImpl();
//        userList = dao.list();
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getNumberofguests() {
        return numberofguests;
    }

    public void setNumberofguests(Integer numberofguests) {
        this.numberofguests = numberofguests;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public RoomDAO getDao() {
        return dao;
    }

    public void setDao(RoomDAO dao) {
        this.dao = dao;
    }

    public boolean isIsEmpty() {
        return isEmpty;
    }

    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

}
