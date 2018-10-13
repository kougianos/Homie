/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import dao.RoomDAO;
import dao.RoomDAOImpl;
import entities.Room;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author valia
 */
@ManagedBean(name = "portfolioController")
@ViewScoped
public class PortfolioController {

    private List<Room> roomList = new ArrayList<>();
    private int rooms_per_page = 10;
    private int page = 0;
    private int total_rooms = 0;
    private int maxpages = 0;
    private List<Room> all;

    @PostConstruct
    public void init() {
        RoomDAO dao = new RoomDAOImpl();
        
        all = dao.list();
        total_rooms = all.size();
        if(total_rooms <=10){
            rooms_per_page = total_rooms;
        }
        
        maxpages = total_rooms / rooms_per_page;
        
//        if (all != null){
//                   
//            all = dao.sort(all);
//        }
        update();

    }

    public void update() {
        int min = page * rooms_per_page;
        int max = (page + 1) * rooms_per_page - 1;
        if(total_rooms - ((page + 1) * rooms_per_page - 1) <= 0){
            max = (page * rooms_per_page + total_rooms % rooms_per_page) - 1;
        }
        roomList.clear();
        
        for (int i = min; i <= max; i++) {
            Room r = all.get(i);
            roomList.add(r);
        }
        
    }

    public void nextPage() {
        if (page < maxpages) {
            page++;
        }
        update();
    }

    public void previousPage() {
        if (page > 0) {
            page--;
        }
        update();
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public int getRooms_per_page() {
        return rooms_per_page;
    }

    public void setRooms_per_page(int rooms_per_page) {
        this.rooms_per_page = rooms_per_page;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_rooms() {
        return total_rooms;
    }

    public void setTotal_rooms(int total_rooms) {
        this.total_rooms = total_rooms;
    }

    public int getMaxpages() {
        return maxpages;
    }

    public void setMaxpages(int maxpages) {
        this.maxpages = maxpages;
    }

    public List<Room> getAll() {
        return all;
    }

    public void setAll(List<Room> all) {
        this.all = all;
    }

     
}
