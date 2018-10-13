/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package export.model;

import entities.Room;
import entities.User;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author valia
 */
public class UserRentsRoomModel {
       
    private Integer rate;    
    private Date rentFrom;    
    private Date rentTo;    
    private Date arrivalTime;   
    private Room idroom;   
    
    @XmlElement
    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    @XmlElement
    public Date getRentFrom() {
        return rentFrom;
    }

    public void setRentFrom(Date rentFrom) {
        this.rentFrom = rentFrom;
    }

    @XmlElement
    public Date getRentTo() {
        return rentTo;
    }

    public void setRentTo(Date rentTo) {
        this.rentTo = rentTo;
    }

    @XmlElement
    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    
    @XmlAttribute
    public Room getIdroom() {
        return idroom;
    }

    public void setIdroom(Room idroom) {
        this.idroom = idroom;
    }

   
    public UserRentsRoomModel() {
    }

    public UserRentsRoomModel(Integer idrent, Integer rate, Date rentFrom, Date rentTo, Date arrivalTime, Room idroom, User username) {
        
        this.rate = rate;
        this.rentFrom = rentFrom;
        this.rentTo = rentTo;
        this.arrivalTime = arrivalTime;
        this.idroom = idroom;
        
    }
    
    
}