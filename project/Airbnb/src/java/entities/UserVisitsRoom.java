/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kougi
 */
@Entity
@Table(name = "user_visits_room")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserVisitsRoom.findAll", query = "SELECT u FROM UserVisitsRoom u")
    , @NamedQuery(name = "UserVisitsRoom.findByUsernameAndRoomID", query = "SELECT u FROM UserVisitsRoom u WHERE u.username = :username and u.roomId = :roomId")
    , @NamedQuery(name = "UserVisitsRoom.findByUsername", query = "SELECT u FROM UserVisitsRoom u WHERE u.username = :username")
    , @NamedQuery(name = "UserVisitsRoom.findByRoomId", query = "SELECT u FROM UserVisitsRoom u WHERE u.roomId = :roomId")
    , @NamedQuery(name = "UserVisitsRoom.findByVisits", query = "SELECT u FROM UserVisitsRoom u WHERE u.visits = :visits")
    , @NamedQuery(name = "UserVisitsRoom.findById", query = "SELECT u FROM UserVisitsRoom u WHERE u.id = :id")})
public class UserVisitsRoom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "room_id")
    private int roomId;
    @Column(name = "visits")
    private Integer visits;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public UserVisitsRoom() {
    }

    public UserVisitsRoom(Integer id) {
        this.id = id;
    }

    public UserVisitsRoom(Integer id, String username, int roomId) {
        this.id = id;
        this.username = username;
        this.roomId = roomId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Integer getVisits() {
        return visits;
    }

    public void setVisits(Integer visits) {
        this.visits = visits;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserVisitsRoom)) {
            return false;
        }
        UserVisitsRoom other = (UserVisitsRoom) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserVisitsRoom[ id=" + id + " ]";
    }
    
}
