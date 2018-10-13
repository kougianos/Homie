/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author valia
 */
@Entity
@Table(name = "rules")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rules.findAll", query = "SELECT r FROM Rules r")
    , @NamedQuery(name = "Rules.findByIdrules", query = "SELECT r FROM Rules r WHERE r.idrules = :idrules")
    , @NamedQuery(name = "Rules.findBySmoking", query = "SELECT r FROM Rules r WHERE r.smoking = :smoking")
    , @NamedQuery(name = "Rules.findByPets", query = "SELECT r FROM Rules r WHERE r.pets = :pets")
    , @NamedQuery(name = "Rules.findByEvents", query = "SELECT r FROM Rules r WHERE r.events = :events")
    , @NamedQuery(name = "Rules.findByMinDays", query = "SELECT r FROM Rules r WHERE r.minDays = :minDays")})
public class Rules implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrules")
    private Integer idrules;
    @Basic(optional = false)
    @Column(name = "smoking")
    private boolean smoking;
    @Basic(optional = false)
    @Column(name = "pets")
    private boolean pets;
    @Basic(optional = false)
    @Column(name = "events")
    private boolean events;
    @Basic(optional = false)
    @Column(name = "min_days")
    private String minDays;
    @ManyToMany(mappedBy = "rulesList")
    private List<Room> roomList;

    public Rules() {
    }

    public Rules(Integer idrules) {
        this.idrules = idrules;
    }

    public Rules(Integer idrules, boolean smoking, boolean pets, boolean events, String minDays) {
        this.idrules = idrules;
        this.smoking = smoking;
        this.pets = pets;
        this.events = events;
        this.minDays = minDays;
    }

    public Integer getIdrules() {
        return idrules;
    }

    public void setIdrules(Integer idrules) {
        this.idrules = idrules;
    }

    public boolean getSmoking() {
        return smoking;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    public boolean getPets() {
        return pets;
    }

    public void setPets(boolean pets) {
        this.pets = pets;
    }

    public boolean getEvents() {
        return events;
    }

    public void setEvents(boolean events) {
        this.events = events;
    }

    public String getMinDays() {
        return minDays;
    }

    public void setMinDays(String minDays) {
        this.minDays = minDays;
    }

    @XmlTransient
    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrules != null ? idrules.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rules)) {
            return false;
        }
        Rules other = (Rules) object;
        if ((this.idrules == null && other.idrules != null) || (this.idrules != null && !this.idrules.equals(other.idrules))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Rules[ idrules=" + idrules + " ]";
    }
    
}
