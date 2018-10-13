/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package export.model;


import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author valia
 */
public class FacilitiesModel {
 
    private boolean heating;   
    private boolean airCondition;    
    private boolean wifi;   
    private boolean parking;   
    private boolean tv;   
    private boolean elevator;    
    private boolean oven;

    public FacilitiesModel() {
    }

    public FacilitiesModel(boolean heating, boolean airCondition, boolean wifi, boolean parking, boolean tv, boolean elevator, boolean oven) {
        this.heating = heating;
        this.airCondition = airCondition;
        this.wifi = wifi;
        this.parking = parking;
        this.tv = tv;
        this.elevator = elevator;
        this.oven = oven;
    }

    @XmlElement
    public boolean isHeating() {
        return heating;
    }

    public void setHeating(boolean heating) {
        this.heating = heating;
    }

    @XmlElement
    public boolean isAirCondition() {
        return airCondition;
    }

    public void setAirCondition(boolean airCondition) {
        this.airCondition = airCondition;
    }

    @XmlElement
    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    @XmlElement
    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    @XmlElement
    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    @XmlElement
    public boolean isElevator() {
        return elevator;
    }

    public void setElevator(boolean elevator) {
        this.elevator = elevator;
    }

    @XmlElement
    public boolean isOven() {
        return oven;
    }

    public void setOven(boolean oven) {
        this.oven = oven;
    }
    
    
}