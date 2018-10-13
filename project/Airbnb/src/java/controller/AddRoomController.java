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
import entities.Bed;
import entities.Facilities;
import entities.Room;
import entities.Roomtype;
import entities.Rules;
import entities.Space;
import entities.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author valia
 */
@ManagedBean(name = "add_room")
@ViewScoped
public class AddRoomController implements Serializable {

    private String location;
    private String area;
    private int price;
    private int people_number;
    private Date available_from;
    private Date available_till;
    private Date arrival_time;
    private String plus_person_price;
    private Double map_latitude;
    private Double map_longitude;
    private String description;
    private String photo;
    private String min_days;
    private int bedroom;
    private int kitchen;
    private int living_room;
    private int bathroom;
    private String category;
    private int sofa;
    private int king_size;
    private int single;
    private int doubles;
    private boolean oven =false;
    private boolean aircondition =false;
    private boolean heating =true;
    private boolean wifi =false;
    private boolean tv =false;
    private boolean elevator =false;
    private boolean parking =false;
    private boolean smoking =false;
    private boolean pets =false;
    private boolean events =false;
    private int idroom;
    

    private String username;

    @PostConstruct
    public void init() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, Object> m = fc.getExternalContext().getSessionMap();

        SessionController sc = (SessionController) m.get("sessionController");
        
        username = sc.getLoggedInUser().getUsername();

        UserDAO dao = new UserDAOImpl();
    }
    
    public String addroom() {

        try {
            Room insertroom = new Room();

            insertroom.setArea(area);
            insertroom.setArrivalTime(arrival_time);
            insertroom.setAvailableFrom(available_from);
            insertroom.setAvailableTill(available_till);
            insertroom.setDescription(description);
            insertroom.setLocation(location);
            insertroom.setMapLatitude(map_latitude);
            insertroom.setMapLongitude(map_longitude);
            insertroom.setPeopleNumber(people_number);
            insertroom.setPhoto(photo);
            insertroom.setPlusPersonPrice(plus_person_price);
            insertroom.setPrice(price);

            List<Facilities> facilityList = new ArrayList<>();
            
            Facilities facility = new Facilities();
            facility.setAirCondition(aircondition);
            facility.setHeating(heating);
            facility.setWifi(wifi);
            facility.setParking(parking);
            facility.setTv(tv);
            facility.setElevator(elevator);
            facility.setOven(oven);
            facilityList.add(facility);
            
            insertroom.setFacilitiesList(facilityList);
            
            List<Rules> rulesList = new ArrayList<>();
            
            Rules rule = new Rules();
            rule.setEvents(events);
            rule.setPets(pets);
            rule.setSmoking(smoking);
            rule.setMinDays(min_days);
            rulesList.add(rule);
            
            insertroom.setRulesList(rulesList);

            List<Space> spaceList = new ArrayList<>();
            
            Space space = new Space();
            space.setBathroom(bathroom);
            space.setBedroom(bedroom);
            space.setKitchen(kitchen);
            space.setLivingRoom(living_room);
            spaceList.add(space);
                    
                    
            insertroom.setSpaceList(spaceList);

            List<Bed> bedList = new ArrayList<>();
            
            Bed beddouble = new Bed();
            beddouble.setNumber(doubles);
            beddouble.setType("doubles");
            bedList.add(beddouble);
            
            Bed bedsingle = new Bed();
            bedsingle.setNumber(single);
            bedsingle.setType("single");
            bedList.add(bedsingle);
            
            Bed bedking = new Bed();
            bedking.setNumber(king_size);
            bedking.setType("king_size");
            bedList.add(bedking);
            
            Bed bedsofa = new Bed();
            bedsofa.setNumber(sofa);
            bedsofa.setType("sofa"); 
            bedList.add(bedsofa);
            
            insertroom.setBedList(bedList);


            RoomDAO dao = new RoomDAOImpl();

            dao.insert(username, category, insertroom);

            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Added successfully"));
            
            idroom = insertroom.getIdroom();
                                    
            return "/room_profile.xhtml?faces-redirect=true&idroom=" + idroom;
        } catch (Exception ex) {
            FacesContext context = FacesContext.getCurrentInstance();
//            context.addMessage(null, new FacesMessage(ex.toString()));
            context.addMessage(null, new FacesMessage("Something went wrong, please try again"));
            return null;
        }

    }

    public int getSofa() {
        return sofa;
    }

    public void setSofa(int sofa) {
        this.sofa = sofa;
    }

    public int getKing_size() {
        return king_size;
    }

    public void setKing_size(int king_size) {
        this.king_size = king_size;
    }

    public int getSingle() {
        return single;
    }

    public void setSingle(int single) {
        this.single = single;
    }

    public int getDoubles() {
        return doubles;
    }

    public void setDoubles(int doubles) {
        this.doubles = doubles;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getBedroom() {
        return bedroom;
    }

    public void setBedroom(int bedroom) {
        this.bedroom = bedroom;
    }

    public int getKitchen() {
        return kitchen;
    }

    public void setKitchen(int kitchen) {
        this.kitchen = kitchen;
    }

    public int getLiving_room() {
        return living_room;
    }

    public void setLiving_room(int living_room) {
        this.living_room = living_room;
    }

    public int getBathroom() {
        return bathroom;
    }

    public void setBathroom(int bathroom) {
        this.bathroom = bathroom;
    }

    public String getMin_days() {
        return min_days;
    }

    public void setMin_days(String min_days) {
        this.min_days = min_days;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPeople_number() {
        return people_number;
    }

    public void setPeople_number(int people_number) {
        this.people_number = people_number;
    }

    public Date getAvailable_from() {
        return available_from;
    }

    public void setAvailable_from(Date available_from) {
        this.available_from = available_from;
    }

    public Date getAvailable_till() {
        return available_till;
    }

    public void setAvailable_till(Date available_till) {
        this.available_till = available_till;
    }

    public String getPlus_person_price() {
        return plus_person_price;
    }

    public void setPlus_person_price(String plus_person_price) {
        this.plus_person_price = plus_person_price;
    }

    public Double getMap_latitude() {
        return map_latitude;
    }

    public void setMap_latitude(Double map_latitude) {
        this.map_latitude = map_latitude;
    }

    public Double getMap_longitude() {
        return map_longitude;
    }

    public void setMap_longitude(Double map_longitude) {
        this.map_longitude = map_longitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isOven() {
        return oven;
    }

    public void setOven(boolean oven) {
        this.oven = oven;
    }

    public boolean isAircondition() {
        return aircondition;
    }

    public void setAircondition(boolean aircondition) {
        this.aircondition = aircondition;
    }

    public boolean isHeating() {
        return heating;
    }

    public void setHeating(boolean heating) {
        this.heating = heating;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean isElevator() {
        return elevator;
    }

    public void setElevator(boolean elevator) {
        this.elevator = elevator;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public boolean isSmoking() {
        return smoking;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    public boolean isPets() {
        return pets;
    }

    public void setPets(boolean pets) {
        this.pets = pets;
    }

    public boolean isEvents() {
        return events;
    }

    public void setEvents(boolean events) {
        this.events = events;
    }


    public Date getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(Date arrival_time) {
        this.arrival_time = arrival_time;
    }

    public int getIdroom() {
        return idroom;
    }

    public void setIdroom(int idroom) {
        this.idroom = idroom;
    }

   
    
}
