/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author valia
 */
@Entity
@Table(name = "roomtype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roomtype.findAll", query = "SELECT r FROM Roomtype r")
    , @NamedQuery(name = "Roomtype.findByIdroomtype", query = "SELECT r FROM Roomtype r WHERE r.idroomtype = :idroomtype")
    , @NamedQuery(name = "Roomtype.findByCategory", query = "SELECT r FROM Roomtype r WHERE r.category = :category")})
public class Roomtype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idroomtype")
    private Integer idroomtype;
    @Basic(optional = false)
    @Column(name = "category")
    private String category;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idroomtype")
    private List<Room> roomList;

    public Roomtype() {
    }

    public Roomtype(Integer idroomtype) {
        this.idroomtype = idroomtype;
    }

    public Roomtype(Integer idroomtype, String category) {
        this.idroomtype = idroomtype;
        this.category = category;
    }

    public Integer getIdroomtype() {
        return idroomtype;
    }

    public void setIdroomtype(Integer idroomtype) {
        this.idroomtype = idroomtype;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
        hash += (idroomtype != null ? idroomtype.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roomtype)) {
            return false;
        }
        Roomtype other = (Roomtype) object;
        if ((this.idroomtype == null && other.idroomtype != null) || (this.idroomtype != null && !this.idroomtype.equals(other.idroomtype))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Roomtype[ idroomtype=" + idroomtype + " ]";
    }
    
}
