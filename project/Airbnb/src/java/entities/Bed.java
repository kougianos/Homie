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
@Table(name = "bed")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bed.findAll", query = "SELECT b FROM Bed b")
    , @NamedQuery(name = "Bed.findByIdbed", query = "SELECT b FROM Bed b WHERE b.idbed = :idbed")
    , @NamedQuery(name = "Bed.findByType", query = "SELECT b FROM Bed b WHERE b.type = :type")
    , @NamedQuery(name = "Bed.findByNumber", query = "SELECT b FROM Bed b WHERE b.number = :number")})
public class Bed implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbed")
    private Integer idbed;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "number")
    private int number;
    @JoinTable(name = "room_has_bed", joinColumns = {
        @JoinColumn(name = "idbed", referencedColumnName = "idbed")}, inverseJoinColumns = {
        @JoinColumn(name = "idroom", referencedColumnName = "idroom")})
    @ManyToMany
    private List<Room> roomList;

    public Bed() {
    }

    public Bed(Integer idbed) {
        this.idbed = idbed;
    }

    public Bed(Integer idbed, String type, int number) {
        this.idbed = idbed;
        this.type = type;
        this.number = number;
    }

    public Integer getIdbed() {
        return idbed;
    }

    public void setIdbed(Integer idbed) {
        this.idbed = idbed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
        hash += (idbed != null ? idbed.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bed)) {
            return false;
        }
        Bed other = (Bed) object;
        if ((this.idbed == null && other.idbed != null) || (this.idbed != null && !this.idbed.equals(other.idbed))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Bed[ idbed=" + idbed + " ]";
    }
    
}
