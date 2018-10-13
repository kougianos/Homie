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
@Table(name = "space")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Space.findAll", query = "SELECT s FROM Space s")
    , @NamedQuery(name = "Space.findByIdspace", query = "SELECT s FROM Space s WHERE s.idspace = :idspace")
    , @NamedQuery(name = "Space.findByLivingRoom", query = "SELECT s FROM Space s WHERE s.livingRoom = :livingRoom")
    , @NamedQuery(name = "Space.findByBedroom", query = "SELECT s FROM Space s WHERE s.bedroom = :bedroom")
    , @NamedQuery(name = "Space.findByBathroom", query = "SELECT s FROM Space s WHERE s.bathroom = :bathroom")
    , @NamedQuery(name = "Space.findByKitchen", query = "SELECT s FROM Space s WHERE s.kitchen = :kitchen")})
public class Space implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idspace")
    private Integer idspace;
    @Basic(optional = false)
    @Column(name = "living_room")
    private int livingRoom;
    @Basic(optional = false)
    @Column(name = "bedroom")
    private int bedroom;
    @Basic(optional = false)
    @Column(name = "bathroom")
    private int bathroom;
    @Basic(optional = false)
    @Column(name = "kitchen")
    private int kitchen;
    @ManyToMany(mappedBy = "spaceList")
    private List<Room> roomList;

    public Space() {
    }

    public Space(Integer idspace) {
        this.idspace = idspace;
    }

    public Space(Integer idspace, int livingRoom, int bedroom, int bathroom, int kitchen) {
        this.idspace = idspace;
        this.livingRoom = livingRoom;
        this.bedroom = bedroom;
        this.bathroom = bathroom;
        this.kitchen = kitchen;
    }

    public Integer getIdspace() {
        return idspace;
    }

    public void setIdspace(Integer idspace) {
        this.idspace = idspace;
    }

    public int getLivingRoom() {
        return livingRoom;
    }

    public void setLivingRoom(int livingRoom) {
        this.livingRoom = livingRoom;
    }

    public int getBedroom() {
        return bedroom;
    }

    public void setBedroom(int bedroom) {
        this.bedroom = bedroom;
    }

    public int getBathroom() {
        return bathroom;
    }

    public void setBathroom(int bathroom) {
        this.bathroom = bathroom;
    }

    public int getKitchen() {
        return kitchen;
    }

    public void setKitchen(int kitchen) {
        this.kitchen = kitchen;
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
        hash += (idspace != null ? idspace.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Space)) {
            return false;
        }
        Space other = (Space) object;
        if ((this.idspace == null && other.idspace != null) || (this.idspace != null && !this.idspace.equals(other.idspace))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Space[ idspace=" + idspace + " ]";
    }
    
}
