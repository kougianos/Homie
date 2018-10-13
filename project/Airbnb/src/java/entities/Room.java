/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author valia
 */
@Entity
@Table(name = "room")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r")
    , @NamedQuery(name = "Room.ids", query = "SELECT r.idroom FROM Room r")
    , @NamedQuery(name = "Room.search", query = "SELECT r from Room r where r.availableFrom <= :from and r.availableTill >= :to and r.location like :keyword and not exists(select u from r.userRentsRoomList u where u.rentFrom <= :from and u.rentTo >= :to )")
    , @NamedQuery(name = "Room.searchWithNog", query = "SELECT r from Room r where r.availableFrom <= :from and r.availableTill >= :to and r.location like :keyword and not exists(select u from r.userRentsRoomList u where u.rentFrom <= :from and u.rentTo >= :to ) and r.peopleNumber >= :nog")
    , @NamedQuery(name = "Room.findAllbyUsername", query = "SELECT r FROM Room r inner join fetch r.userList ru where ru.username = :who")
    , @NamedQuery(name = "Room.findAllWithOwners", query = "SELECT r FROM Room r inner join fetch r.userList o")
    , @NamedQuery(name = "Room.findByIdroom", query = "SELECT r FROM Room r WHERE r.idroom = :idroom")
    , @NamedQuery(name = "Room.findByAvailableFrom", query = "SELECT r FROM Room r WHERE r.availableFrom = :availableFrom")
    , @NamedQuery(name = "Room.findByAvailableTill", query = "SELECT r FROM Room r WHERE r.availableTill = :availableTill")
    , @NamedQuery(name = "Room.findByPrice", query = "SELECT r FROM Room r WHERE r.price = :price")
    , @NamedQuery(name = "Room.findByLocation", query = "SELECT r FROM Room r WHERE r.location = :location")
    , @NamedQuery(name = "Room.findByArea", query = "SELECT r FROM Room r WHERE r.area = :area")
    , @NamedQuery(name = "Room.findByPhoto", query = "SELECT r FROM Room r WHERE r.photo = :photo")
    , @NamedQuery(name = "Room.findByPeopleNumber", query = "SELECT r FROM Room r WHERE r.peopleNumber = :peopleNumber")
    , @NamedQuery(name = "Room.findByPlusPersonPrice", query = "SELECT r FROM Room r WHERE r.plusPersonPrice = :plusPersonPrice")
    , @NamedQuery(name = "Room.findByArrivalTime", query = "SELECT r FROM Room r WHERE r.arrivalTime = :arrivalTime")
    , @NamedQuery(name = "Room.findByMapLatitude", query = "SELECT r FROM Room r WHERE r.mapLatitude = :mapLatitude")
    , @NamedQuery(name = "Room.findByMapLongitude", query = "SELECT r FROM Room r WHERE r.mapLongitude = :mapLongitude")})
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idroom")
    private Integer idroom;
    @Basic(optional = false)
    @Column(name = "available_from")
    @Temporal(TemporalType.DATE)
    private Date availableFrom;
    @Basic(optional = false)
    @Column(name = "available_till")
    @Temporal(TemporalType.DATE)
    private Date availableTill;
    @Basic(optional = false)
    @Column(name = "price")
    private Integer price;
    @Basic(optional = false)
    @Column(name = "location")
    private String location;
    @Basic(optional = false)
    @Column(name = "area")
    private String area;
    @Basic(optional = false)
    @Column(name = "photo")
    private String photo;
    @Basic(optional = false)
    @Column(name = "people_number")
    private Integer peopleNumber;
    @Lob
    @Column(name = "description")
    private String description;
    @Column(name = "plus_person_price")
    private String plusPersonPrice;
    @Column(name = "arrival_time")
    @Temporal(TemporalType.TIME)
    private Date arrivalTime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "map_latitude")
    private Double mapLatitude;
    @Column(name = "map_longitude")
    private Double mapLongitude;
    @ManyToMany(mappedBy = "roomList")
    private List<Bed> bedList;
    @JoinTable(name = "room_has_rules", joinColumns = {
        @JoinColumn(name = "idroom", referencedColumnName = "idroom")}, inverseJoinColumns = {
        @JoinColumn(name = "idrules", referencedColumnName = "idrules")})
    @ManyToMany
    private List<Rules> rulesList;
    @JoinTable(name = "room_has_space", joinColumns = {
        @JoinColumn(name = "idroom", referencedColumnName = "idroom")}, inverseJoinColumns = {
        @JoinColumn(name = "idspace", referencedColumnName = "idspace")})
    @ManyToMany
    private List<Space> spaceList;
    @JoinTable(name = "user_has_room", joinColumns = {
        @JoinColumn(name = "idroom", referencedColumnName = "idroom")}, inverseJoinColumns = {
        @JoinColumn(name = "username", referencedColumnName = "username")})
    @ManyToMany
    private List<User> userList;
    @ManyToMany(mappedBy = "roomList")
    private List<Facilities> facilitiesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idroom")
    private List<Message> messageList;
    @JoinColumn(name = "idroomtype", referencedColumnName = "idroomtype")
    @ManyToOne(optional = false)
    private Roomtype idroomtype;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idroom")
    private List<UserRentsRoom> userRentsRoomList;

    public Room() {
    }

    public Room(Integer idroom) {
        this.idroom = idroom;
    }

    public Room(Integer idroom, Date availableFrom, Date availableTill, Integer price, String location, String area, String photo, Integer peopleNumber) {
        this.idroom = idroom;
        this.availableFrom = availableFrom;
        this.availableTill = availableTill;
        this.price = price;
        this.location = location;
        this.area = area;
        this.photo = photo;
        this.peopleNumber = peopleNumber;
    }

    public Integer getIdroom() {
        return idroom;
    }

    public void setIdroom(Integer idroom) {
        this.idroom = idroom;
    }

    public Date getAvailableFrom() {
        return availableFrom;
    }

    public void setAvailableFrom(Date availableFrom) {
        this.availableFrom = availableFrom;
    }

    public Date getAvailableTill() {
        return availableTill;
    }

    public void setAvailableTill(Date availableTill) {
        this.availableTill = availableTill;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(Integer peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlusPersonPrice() {
        return plusPersonPrice;
    }

    public void setPlusPersonPrice(String plusPersonPrice) {
        this.plusPersonPrice = plusPersonPrice;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Double getMapLatitude() {
        return mapLatitude;
    }

    public void setMapLatitude(Double mapLatitude) {
        this.mapLatitude = mapLatitude;
    }

    public Double getMapLongitude() {
        return mapLongitude;
    }

    public void setMapLongitude(Double mapLongitude) {
        this.mapLongitude = mapLongitude;
    }

    @XmlTransient
    public List<Bed> getBedList() {
        return bedList;
    }

    public void setBedList(List<Bed> bedList) {
        this.bedList = bedList;
    }

    @XmlTransient
    public List<Rules> getRulesList() {
        return rulesList;
    }

    public void setRulesList(List<Rules> rulesList) {
        this.rulesList = rulesList;
    }

    @XmlTransient
    public List<Space> getSpaceList() {
        return spaceList;
    }

    public void setSpaceList(List<Space> spaceList) {
        this.spaceList = spaceList;
    }

    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @XmlTransient
    public List<Facilities> getFacilitiesList() {
        return facilitiesList;
    }

    public void setFacilitiesList(List<Facilities> facilitiesList) {
        this.facilitiesList = facilitiesList;
    }

    @XmlTransient
    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public Roomtype getIdroomtype() {
        return idroomtype;
    }

    public void setIdroomtype(Roomtype idroomtype) {
        this.idroomtype = idroomtype;
    }

    @XmlTransient
    public List<UserRentsRoom> getUserRentsRoomList() {
        return userRentsRoomList;
    }

    public void setUserRentsRoomList(List<UserRentsRoom> userRentsRoomList) {
        this.userRentsRoomList = userRentsRoomList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idroom != null ? idroom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Room)) {
            return false;
        }
        Room other = (Room) object;
        if ((this.idroom == null && other.idroom != null) || (this.idroom != null && !this.idroom.equals(other.idroom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Room[ idroom=" + idroom + " ]";
    }
    
}
