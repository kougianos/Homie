/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package export.model;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author valia
 */
public class RoomModel {
    private Integer idroom;   
    private Date availableFrom;   
    private Date availableTill;   
    private Integer price;
    private String location;   
    private String area;   
    private String photo;   
    private Integer peopleNumber;   
    private String description;    
    private String plusPersonPrice;    
    private Date arrivalTime;  
    private Double mapLatitude;    
    private Double mapLongitude;
    
    private UserModel owner;
    private UserWrapper renters = new UserWrapper();            
    
    private FacilitiesModel facilities;
    private RulesModel rules;
    private SpaceModel space;
    
    private BedWrapper bedWrapper = new BedWrapper();
    
    public RoomModel() {
    }

    public RoomModel(Integer idroom, Date availableFrom, Date availableTill, Integer price, String location, String area, String photo, Integer peopleNumber, String description, String plusPersonPrice, Date arrivalTime, Double mapLatitude, Double mapLongitude) {
        this.idroom = idroom;
        this.availableFrom = availableFrom;
        this.availableTill = availableTill;
        this.price = price;
        this.location = location;
        this.area = area;
        this.photo = photo;
        this.peopleNumber = peopleNumber;
        this.description = description;
        this.plusPersonPrice = plusPersonPrice;
        this.arrivalTime = arrivalTime;
        this.mapLatitude = mapLatitude;
        this.mapLongitude = mapLongitude;
    }
    
    @XmlAttribute
    public Integer getIdroom() {
        return idroom;
    }

    public void setIdroom(Integer idroom) {
        this.idroom = idroom;
    }
    
    @XmlElement
    public Date getAvailableFrom() {
        return availableFrom;
    }

    public void setAvailableFrom(Date availableFrom) {
        this.availableFrom = availableFrom;
    }

    @XmlElement    
    public Date getAvailableTill() {
        return availableTill;
    }

    public void setAvailableTill(Date availableTill) {
        this.availableTill = availableTill;
    }

    @XmlElement
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @XmlElement
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @XmlElement
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @XmlElement
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @XmlElement
    public Integer getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(Integer peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    @XmlElement
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement
    public String getPlusPersonPrice() {
        return plusPersonPrice;
    }

    public void setPlusPersonPrice(String plusPersonPrice) {
        this.plusPersonPrice = plusPersonPrice;
    }
    
    @XmlElement
    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @XmlElement
    public Double getMapLatitude() {
        return mapLatitude;
    }

    public void setMapLatitude(Double mapLatitude) {
        this.mapLatitude = mapLatitude;
    }

    @XmlElement
    public Double getMapLongitude() {
        return mapLongitude;
    }
    
    public void setMapLongitude(Double mapLongitude) {
        this.mapLongitude = mapLongitude;
    }

    @XmlElement
    public UserModel getOwner() {
        return owner;
    }

    public void setOwner(UserModel owner) {
        this.owner = owner;
    }

    @XmlElement
    public UserWrapper getRenters() {
        return renters;
    }

    public void setRenters(UserWrapper renters) {
        this.renters = renters;
    }
    
    @XmlElement
    public FacilitiesModel getFacilities() {
        return facilities;
    }

    public void setFacilities(FacilitiesModel facilities) {
        this.facilities = facilities;
    }
    
    @XmlElement
    public RulesModel getRules() {
        return rules;
    }

    public void setRules(RulesModel rules) {
        this.rules = rules;
    }
    
    @XmlElement
    public SpaceModel getSpace() {
        return space;
    }

    public void setSpace(SpaceModel space) {
        this.space = space;
    }

    @XmlElement(name="beds")
    public BedWrapper getBedWrapper() {
        return bedWrapper;
    }

    public void setBedWrapper(BedWrapper bedWrapper) {
        this.bedWrapper = bedWrapper;
    }
   

}