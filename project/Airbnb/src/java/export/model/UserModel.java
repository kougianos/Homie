/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package export.model;

import entities.Role;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author kougi
 */

public class UserModel {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String photo;
    private boolean active;
    private RoleWrapper roleWrapper = new RoleWrapper();
    private MessageWrapper messageWrapper = new MessageWrapper();

    public UserModel() {
    }

    public UserModel(String username, String password, String name, String surname, String email, String phone, String photo, boolean active) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.photo = photo;
        this.active = active;
    }

    @XmlAttribute
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @XmlElement
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @XmlElement
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlElement
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @XmlElement
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @XmlElement
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @XmlElement(name="roles")
    public RoleWrapper getRoleWrapper() {
        return roleWrapper;
    }

    public void setRoleWrapper(RoleWrapper roleWrapper) {
        this.roleWrapper = roleWrapper;
    }

    @XmlElement(name="messages")
    public MessageWrapper getMessageWrapper() {
        return messageWrapper;
    }

    public void setMessageWrapper(MessageWrapper messageWrapper) {
        this.messageWrapper = messageWrapper;
    }

   
    
}