package controller;

import dao.UserDAO;
import dao.UserDAOImpl;
import dao.UserRentsRoomDAO;
import dao.UserRentsRoomDAOImpl;
import entities.Role;
import entities.Room;
import entities.User;
import entities.UserRentsRoom;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class SessionController implements Serializable {

    private String username;
    private String password;
    private String new_password;
    private String new_password_check;
    private boolean can_offer = false;
    private boolean can_rent = false;
    private boolean can_administer = false;
    private double userRating;
    private double avgUserRating;
    private List<UserRentsRoom> rentalList = null;
    private List<Room> userHasRoomList = null;
    private User loggedInUser = null;

    
    
    public List getUserHasRoomList() {
        return userHasRoomList;
    }

    public void setUserHasRoomList(List userHasRoomList) {
        this.userHasRoomList = userHasRoomList;
    }

    public double getAvgUserRating() {
        return avgUserRating;
    }

    public void setAvgUserRating(double avgUserRating) {
        this.avgUserRating = avgUserRating;
    }

    
    public double getUserRating() {
        return userRating;
    }

    public void setUserRating(double userRating) {
        this.userRating = userRating;
    }

    public String getNew_password() {
        return new_password;
    }

    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }

    public List<UserRentsRoom> getRentalList() {
        return rentalList;
    }

    public void setRentalList(List<UserRentsRoom> rentalList) {
        this.rentalList = rentalList;
    }

    public String getNew_password_check() {
        return new_password_check;
    }

    public void setNew_password_check(String new_password_check) {
        this.new_password_check = new_password_check;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        loggedInUser = loggedInUser;
    }

    public String login() {
        UserDAO userDao = new UserDAOImpl();

        User cacheUser = userDao.find(username);

        if (cacheUser == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("This username doesn't exist"));

            return null;
        }

        if (cacheUser != null && cacheUser.getUsername().equals(username)
                && cacheUser.getPassword().equals(password)) {
            loggedInUser = cacheUser;

            can_administer = false;
            can_offer = false;
            can_rent = false;

            for (Role r : loggedInUser.getRoleList()) {
                if (r.getIdrole() == 1) {
                    can_administer = true;
                }
                if (r.getIdrole() == 2) {
                    can_offer = true;
                }
                if (can_offer == false) {
                    can_rent = true;
                }
            }
            userRating = calculateUserRating();
            avgUserRating = calculateAvgRating();
            return "/userservices/login_welcome";
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Invalid credentials"));

            return null;
        }
    }

    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().invalidateSession();

        loggedInUser = null;

        return "/index";
    }

    public String saveChanges() {
        UserDAO dao = new UserDAOImpl();

        dao.update(this.loggedInUser);

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Changes saved successfully"));

        return null;
    }

    public String changePassword() {
        UserDAO dao = new UserDAOImpl();

        if (new_password != null && new_password_check != null && new_password.equals(new_password_check)) {
            boolean done = dao.update_password(loggedInUser.getUsername(), password, new_password);          //den kanei tipota pros to paron

            if (done) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Changes saved successfully"));
                password = new_password;

                loggedInUser.setPassword(new_password);

                return "/userservices/editprofile";
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Change failed"));
                return null;
            }
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Passwords do not match"));
            return null;
        }
    }

    public boolean isCan_offer() {
        return can_offer;
    }

    public void setCan_offer(boolean can_offer) {
        this.can_offer = can_offer;
    }

    public boolean isCan_rent() {
        return can_rent;
    }

    public void setCan_rent(boolean can_rent) {
        this.can_rent = can_rent;
    }

    public boolean isCan_administer() {
        return can_administer;
    }

    public void setCan_administer(boolean can_administer) {
        this.can_administer = can_administer;
    }

    public double calculateUserRating() {
        double rating = 0;
        int rates_number = 0;

        UserRentsRoomDAO urrdao = new UserRentsRoomDAOImpl();
        rentalList = urrdao.listwithusername(loggedInUser);
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

        userHasRoomList = loggedInUser.getRoomList();
        for (Room room : userHasRoomList) {
            UserRentsRoomDAO dao = new UserRentsRoomDAOImpl();
            rList = dao.findallbyidroom(room);
            for (UserRentsRoom rent : rList) {
                if(rList.size() == 0) continue;
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
