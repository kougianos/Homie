/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package export.model;

import entities.Message;
import entities.Role;
import entities.Room;
import entities.UserRentsRoom;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author kougi
 */
public class UserWrapper {

    private UserModel[] users;

    @XmlElement(name="user")
    public UserModel[] getUsers() {
        return users;
    }

    public void setUsers(UserModel[] users) {
        this.users = users;
    }

}