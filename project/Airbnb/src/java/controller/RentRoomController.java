/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RoomDAO;
import dao.RoomDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import dao.UserRentsRoomDAO;
import dao.UserRentsRoomDAOImpl;
import entities.Room;
import entities.User;
import entities.UserRentsRoom;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "rentroom")
@ViewScoped
public class RentRoomController implements Serializable {

    private Date rent_from;
    private Date rent_to;
    private int rate;
    private Date arrival_time;
    private String id;
    private int idroom;
    private Room room;
    private User userone;
    private String username;

    @PostConstruct
    public void init() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> m = fc.getExternalContext().getRequestParameterMap();
        Map<String, Object> user = fc.getExternalContext().getSessionMap();

        id = m.get("idroom");
        idroom = Integer.parseInt(id);

        RoomDAO dao = new RoomDAOImpl();
        room = dao.find(idroom);

        SessionController sc = (SessionController) user.get("sessionController");

        username = sc.getLoggedInUser().getUsername();

        UserDAO udao = new UserDAOImpl();
        userone = udao.find(username);
    }

    public Date getRent_from() {
        return rent_from;
    }

    public void setRent_from(Date rent_from) {
        this.rent_from = rent_from;
    }

    public Date getRent_to() {
        return rent_to;
    }

    public void setRent_to(Date rent_to) {
        this.rent_to = rent_to;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Date getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(Date arrival_time) {
        this.arrival_time = arrival_time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdroom() {
        return idroom;
    }

    public void setIdroom(int idroom) {
        this.idroom = idroom;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUserone() {
        return userone;
    }

    public void setUserone(User userone) {
        this.userone = userone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String rentRoom() {

        try {
            UserRentsRoom newrent = new UserRentsRoom();
            newrent.setRentFrom(rent_from);
            newrent.setRentTo(rent_to);
            newrent.setArrivalTime(arrival_time);
            newrent.setIdroom(room);
            newrent.setUsername(userone);
            newrent.setRate(3);

            if (rent_from.compareTo(room.getAvailableFrom()) < 0 || rent_to.compareTo(room.getAvailableTill()) > 0) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Please check the dates"));
                return null;
            }

            UserRentsRoomDAO dao = new UserRentsRoomDAOImpl();
            dao.insert(newrent);

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Rental completed successfully"));

//            idroom = newrent.getIdroom().getIdroom();
//            return "/room_profile.xhtml?faces-redirect=true&idroom=" + idroom;
            return "/userservices/rent_welcome";
        } catch (Exception ex) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(ex.toString()));
            return null;
        }

    }

}
