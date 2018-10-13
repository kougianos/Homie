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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "facilities")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facilities.findAll", query = "SELECT f FROM Facilities f")
    , @NamedQuery(name = "Facilities.findByIdfacilities", query = "SELECT f FROM Facilities f WHERE f.idfacilities = :idfacilities")
    , @NamedQuery(name = "Facilities.findByHeating", query = "SELECT f FROM Facilities f WHERE f.heating = :heating")
    , @NamedQuery(name = "Facilities.findByAirCondition", query = "SELECT f FROM Facilities f WHERE f.airCondition = :airCondition")
    , @NamedQuery(name = "Facilities.findByWifi", query = "SELECT f FROM Facilities f WHERE f.wifi = :wifi")
    , @NamedQuery(name = "Facilities.findByParking", query = "SELECT f FROM Facilities f WHERE f.parking = :parking")
    , @NamedQuery(name = "Facilities.findByTv", query = "SELECT f FROM Facilities f WHERE f.tv = :tv")
    , @NamedQuery(name = "Facilities.findByElevator", query = "SELECT f FROM Facilities f WHERE f.elevator = :elevator")
    , @NamedQuery(name = "Facilities.findByOven", query = "SELECT f FROM Facilities f WHERE f.oven = :oven")})
public class Facilities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfacilities")
    private Integer idfacilities;
    @Basic(optional = false)
    @Column(name = "heating")
    private boolean heating;
    @Basic(optional = false)
    @Column(name = "air_condition")
    private boolean airCondition;
    @Basic(optional = false)
    @Column(name = "wifi")
    private boolean wifi;
    @Basic(optional = false)
    @Column(name = "parking")
    private boolean parking;
    @Basic(optional = false)
    @Column(name = "tv")
    private boolean tv;
    @Basic(optional = false)
    @Column(name = "elevator")
    private boolean elevator;
    @Basic(optional = false)
    @Column(name = "oven")
    private boolean oven;
    @JoinTable(name = "room_has_facilities", joinColumns = {
        @JoinColumn(name = "idfacilities", referencedColumnName = "idfacilities")}, inverseJoinColumns = {
        @JoinColumn(name = "idroom", referencedColumnName = "idroom")})
    @ManyToMany
    private List<Room> roomList;

    public Facilities() {
    }

    public Facilities(Integer idfacilities) {
        this.idfacilities = idfacilities;
    }

    public Facilities(Integer idfacilities, boolean heating, boolean airCondition, boolean wifi, boolean parking, boolean tv, boolean elevator, boolean oven) {
        this.idfacilities = idfacilities;
        this.heating = heating;
        this.airCondition = airCondition;
        this.wifi = wifi;
        this.parking = parking;
        this.tv = tv;
        this.elevator = elevator;
        this.oven = oven;
    }

    public Integer getIdfacilities() {
        return idfacilities;
    }

    public void setIdfacilities(Integer idfacilities) {
        this.idfacilities = idfacilities;
    }

    public boolean getHeating() {
        return heating;
    }

    public void setHeating(boolean heating) {
        this.heating = heating;
    }

    public boolean getAirCondition() {
        return airCondition;
    }

    public void setAirCondition(boolean airCondition) {
        this.airCondition = airCondition;
    }

    public boolean getWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean getParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public boolean getTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean getElevator() {
        return elevator;
    }

    public void setElevator(boolean elevator) {
        this.elevator = elevator;
    }

    public boolean getOven() {
        return oven;
    }

    public void setOven(boolean oven) {
        this.oven = oven;
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
        hash += (idfacilities != null ? idfacilities.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facilities)) {
            return false;
        }
        Facilities other = (Facilities) object;
        if ((this.idfacilities == null && other.idfacilities != null) || (this.idfacilities != null && !this.idfacilities.equals(other.idfacilities))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Facilities[ idfacilities=" + idfacilities + " ]";
    }
    
}
