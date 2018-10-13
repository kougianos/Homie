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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author valia
 */
@ManagedBean(name = "advancedSearch")
@ViewScoped
public class AdvancedSearchController implements Serializable {

    private String destination;
    private Date checkin;
    private Date checkout;
    private Integer guests;
    private Integer roomtype;
    private Integer maxcost;
    private Integer oven;
    private Integer aircondition;
    private Integer heating;
    private Integer wifi;
    private Integer tv;
    private Integer elevator;
    private Integer parking;

    private List<Room> roomList = new ArrayList<Room>();
    private RoomDAO dao = new RoomDAOImpl();
    private boolean isEmpty;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
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

    public Integer getGuests() {
        return guests;
    }

    public void setGuests(Integer guests) {
        this.guests = guests;
    }

    public Integer getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(Integer roomtype) {
        this.roomtype = roomtype;
    }

    public Integer getMaxcost() {
        return maxcost;
    }

    public void setMaxcost(Integer maxcost) {
        this.maxcost = maxcost;
    }

    public Integer getOven() {
        return oven;
    }

    public void setOven(Integer oven) {
        this.oven = oven;
    }

    public Integer getAircondition() {
        return aircondition;
    }

    public void setAircondition(Integer aircondition) {
        this.aircondition = aircondition;
    }

    public Integer getHeating() {
        return heating;
    }

    public void setHeating(Integer heating) {
        this.heating = heating;
    }

    public Integer getWifi() {
        return wifi;
    }

    public void setWifi(Integer wifi) {
        this.wifi = wifi;
    }

    public Integer getTv() {
        return tv;
    }

    public void setTv(Integer tv) {
        this.tv = tv;
    }

    public Integer getElevator() {
        return elevator;
    }

    public void setElevator(Integer elevator) {
        this.elevator = elevator;
    }

    public Integer getParking() {
        return parking;
    }

    public void setParking(Integer parking) {
        this.parking = parking;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
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

    public void search() {
        roomList = dao.advancedSearch(destination, checkin, checkout, guests, roomtype, maxcost, oven, aircondition, heating, wifi, tv, elevator, parking);
        if (roomList.isEmpty()) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }
        if (roomList.isEmpty() == false){
            
            roomList = dao.sort(roomList);
        }

    }
}
