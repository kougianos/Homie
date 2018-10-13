/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserConstants;
import dao.UserDAO;
import dao.UserDAOImpl;
import entities.Role;
import entities.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author valia
 */
@ManagedBean(name = "registerUser")
@ViewScoped
public class RegisterController implements Serializable {

    private String username; // 1 property for each form field
    private String password;
    private String passwordConfirm;
    private String email;
    private String phone;
    private String photo;
    private String name;
    private String surname;
    private String role;

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String register() {

        try {
            if (password.equals(passwordConfirm)) {
                User insertUser = new User();

                insertUser.setUsername(username);
                insertUser.setPassword(password);
                insertUser.setName(name);
                insertUser.setSurname(surname);
                insertUser.setEmail(email);
                insertUser.setPhone(phone);
                insertUser.setPhoto(photo);
                insertUser.setActive(false);

                List<Role> roleList = new ArrayList<>();
                roleList.add(new Role(UserConstants.VISITOR));
                if (role.equals("renter")) {
                    roleList.add(new Role(UserConstants.RENTER));
                }
                insertUser.setRoleList(roleList);

                UserDAO dao = new UserDAOImpl();

                dao.insert(insertUser);

//            FacesContext context = FacesContext.getCurrentInstance();
//            context.addMessage(null, new FacesMessage("Registered successfully"));
              if(insertUser.getRoleList().size() == 2){
                  return "/userservices/welcome_register";
              }
                return "/userservices/welcome";
            } else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Passwords don't match"));
                return null;
            }

        } catch (Exception ex) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("That username is already taken"));
            return null;
        }

    }
}
