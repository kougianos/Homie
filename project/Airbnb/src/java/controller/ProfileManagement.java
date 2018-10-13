package controller;

import dao.UserDAO;
import dao.UserDAOImpl;
import dao.UserRentsRoomDAO;
import dao.UserRentsRoomDAOImpl;
import entities.Room;
import entities.User;
import entities.UserRentsRoom;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "profileManagementController")
@ViewScoped
public class ProfileManagement {

    private String username;
    private User user;
    private double userRating;
    private double avgUserRating;
    private List<UserRentsRoom> rentalList = null;
    private List<Room> userHasRoomList = null;

    @PostConstruct
    public void init() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> m = fc.getExternalContext().getRequestParameterMap();

        username = m.get("username");

        UserDAO dao = new UserDAOImpl();
        user = dao.find(username);
        userRating = calculateUserRating();
        avgUserRating = calculateAvgRating();
    }

    public double getUserRating() {
        return userRating;
    }

    public void setUserRating(double userRating) {
        this.userRating = userRating;
    }

    public double getAvgUserRating() {
        return avgUserRating;
    }

    public void setAvgUserRating(double avgUserRating) {
        this.avgUserRating = avgUserRating;
    }

    public List<UserRentsRoom> getRentalList() {
        return rentalList;
    }

    public void setRentalList(List<UserRentsRoom> rentalList) {
        this.rentalList = rentalList;
    }

    public List<Room> getUserHasRoomList() {
        return userHasRoomList;
    }

    public void setUserHasRoomList(List<Room> userHasRoomList) {
        this.userHasRoomList = userHasRoomList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void activate() {
        UserDAO dao = new UserDAOImpl();
        boolean done = dao.activate(username);

        FacesContext context = FacesContext.getCurrentInstance();

        if (done) {
            context.addMessage(null, new FacesMessage("User activated successfully"));

            user.setActive(true);
        } else {
            context.addMessage(null, new FacesMessage("User activation failed"));
        }
    }

    public void deactivate() {
        UserDAO dao = new UserDAOImpl();
        boolean done = dao.deactivate(username);

        FacesContext context = FacesContext.getCurrentInstance();

        if (done) {
            context.addMessage(null, new FacesMessage("User deactivated successfully"));

            user.setActive(false);
        } else {
            context.addMessage(null, new FacesMessage("User deactivation failed"));
        }
    }

    public double calculateUserRating() {
        double rating = 0;
        int rates_number = 0;

        UserRentsRoomDAO urrdao = new UserRentsRoomDAOImpl();
        rentalList = urrdao.listwithusername(user);
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
        return rating;
    }

    public double calculateAvgRating() {
        double rating = 0;
        double final_rating = 0;
        int rates_number = 0;
        int rooms = 0;
        List<UserRentsRoom> rList = null;

        userHasRoomList = user.getRoomList();
        for (Room room : userHasRoomList) {
            UserRentsRoomDAO dao = new UserRentsRoomDAOImpl();
            rList = dao.findallbyidroom(room);
            for (UserRentsRoom rent : rList) {
                if (rList.size() == 0) {
                    continue;
                }
                if (rent.getRate() == null || rent.getRate() == 0) {
                    continue;
                }
                rating += rent.getRate();
            }
            rates_number = rList.size();
            if (rates_number > 0) {
                rating = rating / rates_number;
                rooms++;
            } else {
                rating = 0;
            }
            final_rating += rating;
            rates_number = 0;
            rating = 0;
        }
        final_rating /= rooms;
        return final_rating;
    }

}
