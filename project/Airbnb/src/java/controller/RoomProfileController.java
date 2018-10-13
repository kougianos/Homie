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
import dao.UserVisitsRoomDAO;
import dao.UserVisitsRoomDAOImpl;
import entities.Bed;
import entities.Facilities;
import entities.Room;
import entities.Roomtype;
import entities.Rules;
import entities.Space;
import entities.UserRentsRoom;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author valia
 */
@ManagedBean(name = "roomProfileController")
@ViewScoped
public class RoomProfileController implements Serializable {

    private int idroom;
    private String id;
    private Room room;
    private Facilities facility = null;
    private Rules rule = null;
    private Space space = null;
    private List<Bed> bedList = null;
    private Roomtype roomtype = null;
    private double rating = 0;
    private int rates_number = 0;
    private List<UserRentsRoom> rentalList = null;

    @PostConstruct
    public void init() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> m = fc.getExternalContext().getRequestParameterMap();

        id = m.get("idroom");
        idroom = Integer.parseInt(id);

        RoomDAO dao = new RoomDAOImpl();
        room = dao.find(idroom);
        facility = room.getFacilitiesList().get(0);
        rule = room.getRulesList().get(0);
        space = room.getSpaceList().get(0);
        bedList = room.getBedList();

        UserRentsRoomDAO urrdao = new UserRentsRoomDAOImpl();
        rentalList = urrdao.findallbyidroom(room);
        for (UserRentsRoom rent : rentalList) {
            if (rent.getRate() == null) {
                continue;
            }
            rating += rent.getRate();
        }
        rates_number = rentalList.size();
        if (rates_number > 0) {
            rating = rating / rates_number;
        } else {
            rating = 0;
        }

        try {
            String ownerusername = room.getUserList().get(0).getUsername();

            Map<String, Object> m2 = fc.getExternalContext().getSessionMap();

            SessionController sc = (SessionController) m2.get("sessionController");

            String username = sc.getLoggedInUser().getUsername();
            
            if (!username.equals(ownerusername)) {
                UserVisitsRoomDAO dao1800 = new UserVisitsRoomDAOImpl();
                dao1800.visit(username, idroom);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int getIdroom() {
        return idroom;
    }

    public void setIdroom(int idroom) {
        this.idroom = idroom;
    }

    public int getRates_number() {
        return rates_number;
    }

    public void setRates_number(int rates_number) {
        this.rates_number = rates_number;
    }

    public List<UserRentsRoom> getRentalList() {
        return rentalList;
    }

    public void setRentalList(List<UserRentsRoom> rentalList) {
        this.rentalList = rentalList;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Facilities getFacility() {
        return facility;
    }

    public void setFacility(Facilities facility) {
        this.facility = facility;
    }

    public Rules getRule() {
        return rule;
    }

    public void setRule(Rules rule) {
        this.rule = rule;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public List<Bed> getBedList() {
        return bedList;
    }

    public void setBedList(List<Bed> bedList) {
        this.bedList = bedList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Roomtype getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(Roomtype roomtype) {
        this.roomtype = roomtype;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String save() {
        RoomDAO dao = new RoomDAOImpl();

        dao.update(this.room);

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Changes saved successfully"));

        return null;

    }
}
