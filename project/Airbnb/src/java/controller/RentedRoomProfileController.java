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
import entities.Bed;
import entities.Facilities;
import entities.Room;
import entities.Roomtype;
import entities.Rules;
import entities.Space;
import entities.UserRentsRoom;
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

@ManagedBean(name = "rentedroom")
@ViewScoped
public class RentedRoomProfileController {
    private int idrent;
    private String id;
    private Room room;
    private Facilities facility = null;
    private Rules rule = null;
    private Space space = null;
    private List<Bed> bedList = null;
    private Roomtype roomtype = null;
    private int rating;
    private UserRentsRoom urroom;

    public UserRentsRoom getUrroom() {
        return urroom;
    }

    public void setUrroom(UserRentsRoom urroom) {
        this.urroom = urroom;
    }
    
    @PostConstruct
    public void init() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> m = fc.getExternalContext().getRequestParameterMap();

        id = m.get("idrent");
        idrent = Integer.parseInt(id);

        UserRentsRoomDAO urrdao = new UserRentsRoomDAOImpl();
//        RoomDAO dao = new RoomDAOImpl();
//        room = dao.find(idroom);
//        facility = room.getFacilitiesList().get(0);
//        rule = room.getRulesList().get(0);
//        space = room.getSpaceList().get(0);
//        bedList = room.getBedList();
        
        

        urroom = urrdao.find(idrent);
        RoomDAO dao = new RoomDAOImpl();
        room = dao.find(urroom.getIdroom().getIdroom());
        facility = room.getFacilitiesList().get(0);
        rule = room.getRulesList().get(0);
        space = room.getSpaceList().get(0);
        bedList = room.getBedList();
        
        if (urroom.getRate()!= null){
            rating = urroom.getRate();
        }
    }

    public int getIdrent() {
        return idrent;
    }

    public void setIdrent(int idrent) {
        this.idrent = idrent;
    }
    
//    public int getIdroom() {
//        return idroom;
//    }
//
//    public void setIdroom(int idroom) {
//        this.idroom = idroom;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Roomtype getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(Roomtype roomtype) {
        this.roomtype = roomtype;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
    public void saverating(){
         UserRentsRoomDAO urrdao = new UserRentsRoomDAOImpl();
         
         urrdao.update(this.urroom, rating);

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Rating saved successfully"));

    }
    
}