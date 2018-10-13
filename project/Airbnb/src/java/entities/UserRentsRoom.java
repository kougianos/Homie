/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author valia
 */
@Entity
@Table(name = "user_rents_room")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserRentsRoom.findAll", query = "SELECT u FROM UserRentsRoom u")
    , @NamedQuery(name = "UserRentsRoom.findByIdrent", query = "SELECT u FROM UserRentsRoom u WHERE u.idrent = :idrent")
    , @NamedQuery(name = "UserRentsRoom.findByRate", query = "SELECT u FROM UserRentsRoom u WHERE u.rate = :rate")
    , @NamedQuery(name = "UserRentsRoom.findByRentFrom", query = "SELECT u FROM UserRentsRoom u WHERE u.rentFrom = :rentFrom")
    , @NamedQuery(name = "UserRentsRoom.findByRentTo", query = "SELECT u FROM UserRentsRoom u WHERE u.rentTo = :rentTo")
    , @NamedQuery(name = "UserRentsRoom.findByArrivalTime", query = "SELECT u FROM UserRentsRoom u WHERE u.arrivalTime = :arrivalTime")
    , @NamedQuery(name = "UserRentsRoom.findWithUsername", query = "SELECT u FROM UserRentsRoom u WHERE u.username = :username")
    , @NamedQuery(name = "UserRentsRoom.findByIdroom", query = "SELECT u FROM UserRentsRoom u WHERE u.idroom = :idroom")
    , @NamedQuery(name = "UserRentsRoom.findByIdroomAndUsername", query = "SELECT u FROM UserRentsRoom u WHERE u.idroom = :idroom AND u.username = :username")
})
public class UserRentsRoom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrent")
    private Integer idrent;
    @Column(name = "rate")
    private Integer rate;
    @Column(name = "rent_from")
    @Temporal(TemporalType.DATE)
    private Date rentFrom;
    @Column(name = "rent_to")
    @Temporal(TemporalType.DATE)
    private Date rentTo;
    @Column(name = "arrival_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalTime;
    @JoinColumn(name = "idroom", referencedColumnName = "idroom")
    @ManyToOne(optional = false)
    private Room idroom;
    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private User username;

    public UserRentsRoom() {
    }

    public UserRentsRoom(Integer idrent) {
        this.idrent = idrent;
    }

    public Integer getIdrent() {
        return idrent;
    }

    public void setIdrent(Integer idrent) {
        this.idrent = idrent;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Date getRentFrom() {
        return rentFrom;
    }

    public void setRentFrom(Date rentFrom) {
        this.rentFrom = rentFrom;
    }

    public Date getRentTo() {
        return rentTo;
    }

    public void setRentTo(Date rentTo) {
        this.rentTo = rentTo;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Room getIdroom() {
        return idroom;
    }

    public void setIdroom(Room idroom) {
        this.idroom = idroom;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrent != null ? idrent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRentsRoom)) {
            return false;
        }
        UserRentsRoom other = (UserRentsRoom) object;
        if ((this.idrent == null && other.idrent != null) || (this.idrent != null && !this.idrent.equals(other.idrent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserRentsRoom[ idrent=" + idrent + " ]";
    }
    
}
