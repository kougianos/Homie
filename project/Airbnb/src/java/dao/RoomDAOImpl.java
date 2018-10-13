package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entities.*;
import java.util.Date;
import javax.persistence.EntityTransaction;
import jpautils.EntityManagerHelper;

public class RoomDAOImpl implements RoomDAO {

    @Override
    public List<Integer> ids() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createNamedQuery("Room.ids");
        List<Integer> ids = query.getResultList();
        return ids;
    }

    @Override
    public List<Room> list() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createNamedQuery("Room.findAll");
        List<Room> rooms = query.getResultList();
        return rooms;
    }

    @Override
    public List<Room> list(String username) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createNamedQuery("Room.findAllbyUsername").setParameter("who", username);
        List<Room> rooms = query.getResultList();
        return rooms;
    }

    @Override
    public Room find(int id) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Room room1 = em.find(Room.class, id);
        return room1;
    }

    public List<Room> export() {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createNamedQuery("Room.findAllWithOwners");
        List<Room> rooms = query.getResultList();
        return rooms;
    }

    public void insert(Room insertRoom) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        em.persist(insertRoom);

        EntityManagerHelper.commit();
    }

    @Override
    public List<Room> search(String location, Date checkin, Date checkout, Integer nog) {

        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createNamedQuery("Room.searchWithNog").setParameter("from", checkin).setParameter("to", checkout).setParameter("keyword", "%" + location + "%").setParameter("nog", nog);
        List<Room> rooms = query.getResultList();
        return rooms;
    }

    @Override
    public List<Room> search(String location, Date checkin, Date checkout) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        Query query = em.createNamedQuery("Room.search").setParameter("from", checkin).setParameter("to", checkout).setParameter("keyword", "%" + location + "%");
        List<Room> rooms = query.getResultList();
        return rooms;
    }

    @Override
    public void update(Room clickedRoom) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        int idroom = clickedRoom.getIdroom();

        Facilities clickedFacilities = clickedRoom.getFacilitiesList().get(0);
        Rules clickedRules = clickedRoom.getRulesList().get(0);
        Space clickedSpaces = clickedRoom.getSpaceList().get(0);
        List<Bed> clickedBeds = clickedRoom.getBedList();
        Roomtype clickedRoomtype = clickedRoom.getIdroomtype();

        Room cacheRoom = em.find(Room.class, idroom);

        cacheRoom.setLocation(clickedRoom.getLocation());
        cacheRoom.setArea(clickedRoom.getArea());
        cacheRoom.setAvailableFrom(clickedRoom.getAvailableFrom());
        cacheRoom.setAvailableTill(clickedRoom.getAvailableTill());
        cacheRoom.setArrivalTime(clickedRoom.getArrivalTime());
        cacheRoom.setPrice(clickedRoom.getPrice());
        cacheRoom.setPeopleNumber(clickedRoom.getPeopleNumber());
        cacheRoom.setDescription(clickedRoom.getDescription());
        cacheRoom.setPhoto(clickedRoom.getPhoto());
        cacheRoom.setPlusPersonPrice(clickedRoom.getPlusPersonPrice());
        cacheRoom.setMapLatitude(clickedRoom.getMapLatitude());
        cacheRoom.setMapLongitude(clickedRoom.getMapLongitude());

        //update Facilities
        Facilities cacheFacility = em.find(Facilities.class, clickedFacilities.getIdfacilities());
        cacheFacility.setAirCondition(clickedFacilities.getAirCondition());
        cacheFacility.setHeating(clickedFacilities.getHeating());
        cacheFacility.setElevator(clickedFacilities.getElevator());
        cacheFacility.setOven(clickedFacilities.getOven());
        cacheFacility.setWifi(clickedFacilities.getWifi());
        cacheFacility.setParking(clickedFacilities.getParking());
        cacheFacility.setTv(clickedFacilities.getTv());

        //update Rules
        Rules cacheRule = em.find(Rules.class, clickedRules.getIdrules());
        cacheRule.setEvents(clickedRules.getEvents());
        cacheRule.setPets(clickedRules.getPets());
        cacheRule.setSmoking(clickedRules.getSmoking());
        cacheRule.setMinDays(clickedRules.getMinDays());

        //update Spaces
        Space cacheSpace = em.find(Space.class, clickedSpaces.getIdspace());
        cacheSpace.setBathroom(clickedSpaces.getBathroom());
        cacheSpace.setBedroom(clickedSpaces.getBedroom());
        cacheSpace.setKitchen(clickedSpaces.getKitchen());
        cacheSpace.setLivingRoom(clickedSpaces.getLivingRoom());

        //update Roomtype
        Roomtype cacheRoomtype = em.find(Roomtype.class, clickedRoomtype.getIdroomtype());
        cacheRoomtype.setCategory(clickedRoomtype.getCategory());

//        for (Bed clickedBed : clickedBeds) {
//            Bed cacheBed = em.find(Bed.class, clickedBed.getNumber());
//            cacheBed.setNumber(clickedBed.getNumber());            
//        }
        EntityManagerHelper.commit();
    }

    @Override
    public void insert(String username, String category, Room insertroom) {
        EntityManager em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        // connect with room type        
        int categoryid = Integer.parseInt(category);
        RoomtypeDAO rtDao = new RoomtypeDAOImpl();
        Roomtype roomType = rtDao.find(categoryid);

        insertroom.setIdroomtype(roomType);

        // connect with owner
        UserDAO uDao = new UserDAOImpl();
        User owner = uDao.find(username);

        // insert room
        em.persist(insertroom);

        List<User> userList = new ArrayList<>();
        userList.add(owner);
        insertroom.setUserList(userList);

        // connect room with owner
        owner.getRoomList().add(insertroom);

        // create facilities
        for (Facilities facility : insertroom.getFacilitiesList()) {
            List<Room> roomList = new ArrayList<Room>();
            roomList.add(insertroom);
            facility.setRoomList(roomList);

            em.persist(facility);
        }

        // create rules
        for (Rules rules : insertroom.getRulesList()) {
            List<Room> roomList = new ArrayList<Room>();
            roomList.add(insertroom);
            rules.setRoomList(roomList);

            em.persist(rules);
        }

        // create spaces
        for (Space space : insertroom.getSpaceList()) {
            List<Room> roomList = new ArrayList<Room>();
            roomList.add(insertroom);
            space.setRoomList(roomList);

            em.persist(space);
        }

        // create beds
        for (Bed bed : insertroom.getBedList()) {
            List<Room> roomList = new ArrayList<Room>();
            roomList.add(insertroom);
            bed.setRoomList(roomList);

            em.persist(bed);
        }

        // commit transaction
        EntityManagerHelper.commit();
    }

    @Override
    public List<Room> advancedSearch(String destination, Date checkin, Date checkout, Integer guests, Integer roomtype, Integer maxcost, Integer oven, Integer aircondition, Integer heating, Integer wifi, Integer tv, Integer elevator, Integer parking) {
        EntityManager em = EntityManagerHelper.getEntityManager();

        if (destination != ""){
             destination = "%" + destination + "%";
        }else{
            destination = null;
        }
       

        // prepare query
        String hpsql = "SELECT r from Room r inner join fetch r.facilitiesList f inner join fetch r.idroomtype rt where r.availableFrom <= :from and r.availableTill >= :to and not exists(select u from r.userRentsRoomList u where u.rentFrom <= :from and u.rentTo >= :to )";

        if (guests != null && guests != -1) {
            hpsql += " and r.peopleNumber >= :guests";
        }

        if (aircondition != null && aircondition != -1) {
            hpsql += " and f.airCondition = :aircondition";
        }

        if (oven != null && oven != -1) {
            hpsql += " and f.oven = :oven";
        }

        if (heating != null && heating != -1) {
            hpsql += " and f.heating = :heating";
        }

        if (wifi != null && wifi != -1) {
            hpsql += " and f.wifi = :wifi";
        }

        if (tv != null && tv != -1) {
            hpsql += " and f.tv = :tv";
        }

        if (elevator != null && elevator != -1) {
            hpsql += " and f.elevator = :elevator";
        }

        if (parking != null && parking != -1) {
            hpsql += " and f.parking = :parking";
        }
        
        if (destination != null) {
            hpsql += " and r.location like :destination";
        }

        if (maxcost != null) {
            hpsql += " and r.price <= :maxcost";
        }

        if (roomtype != null && roomtype != -1) {
            hpsql += " and rt.idroomtype = :roomtype";
        }

        // fill query
        Query query = em.createQuery(hpsql);
        query.setParameter("from", checkin);
        query.setParameter("to", checkout);
        //query.setParameter("destination", destination);

        if (guests != null && guests != -1) {

            query.setParameter("guests", guests);
        }

        if (oven != null && oven != -1) {
            Boolean q = (oven == 1);
            query.setParameter("oven", q);
        }

        if (aircondition != null && aircondition != -1) {                   
            Boolean q = (aircondition == 1);
            query.setParameter("aircondition", q);
        }
        
         if (destination != null) {                   
            
            query.setParameter("destination", destination);
        }

        if (heating != null && heating != -1) {                            
            Boolean q = (heating == 1);
            query.setParameter("heating", q);
        }

        if (wifi != null && wifi != -1) {
            Boolean q = (wifi == 1);
            query.setParameter("wifi", q);
        }

        if (tv != null && tv != -1) {                                      
            Boolean q = (tv == 1);
            query.setParameter("tv", q);
        }

        if (elevator != null && elevator != -1) {
            Boolean q = (elevator == 1);
            query.setParameter("elevator", q);
        }

        if (parking != null && parking != -1) {
            Boolean q = (parking == 1);
            query.setParameter("parking", q);
        }

        if (maxcost != null) {

            query.setParameter("maxcost", maxcost);
        }

        if (roomtype != null && roomtype != -1) {

            query.setParameter("roomtype", roomtype);
        }

        List<Room> rooms = query.getResultList();
        return rooms;
    }
    
    public List<Room> sort(List<Room> roomlist){
        int n = roomlist.size();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {

                if (roomlist.get(j - 1).getPrice() > roomlist.get(j).getPrice()) {
                    Room temp = roomlist.get(j - 1);
                    roomlist.set(j - 1, roomlist.get(j));
                    roomlist.set(j, temp);
                }
            }
        }
        return roomlist; 
    }

}
