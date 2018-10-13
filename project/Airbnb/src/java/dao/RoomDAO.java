package dao;

import java.util.List;
import entities.*;
import java.io.Serializable;
import java.util.Date;

public interface RoomDAO extends Serializable {

    public List<Integer> ids();

    public List<Room> list();

    public List<Room> export();

    public Room find(int id);

    public void insert(Room insertRoom);

    public List<Room> list(String username);

    public List<Room> search(String location, Date checkin, Date checkout, Integer nog);

    public List<Room> search(String location, Date checkin, Date checkout);

    public void update(Room clickedRoom);

    public void insert(String username, String category, Room insertroom);

    public List<Room> advancedSearch(String destination, Date checkin, Date checkout, Integer guests, Integer roomtype, Integer maxcost, Integer oven, Integer aircondition, Integer heating, Integer wifi, Integer tv, Integer elevator, Integer parking);

    public List<Room> sort(List<Room> roomlist);

    
}
