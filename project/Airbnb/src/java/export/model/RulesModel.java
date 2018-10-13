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
public class RulesModel {
    private boolean smoking;   
    private boolean pets;   
    private boolean events;    
    private String minDays;

    public RulesModel() {
    }

    public RulesModel(boolean smoking, boolean pets, boolean events, String minDays) {
        this.smoking = smoking;
        this.pets = pets;
        this.events = events;
        this.minDays = minDays;
    }
    
    @XmlElement
    public boolean isSmoking() {
        return smoking;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    @XmlElement
    public boolean isPets() {
        return pets;
    }

    public void setPets(boolean pets) {
        this.pets = pets;
    }

    @XmlElement
    public boolean isEvents() {
        return events;
    }

    public void setEvents(boolean events) {
        this.events = events;
    }

    @XmlElement
    public String getMinDays() {
        return minDays;
    }

    public void setMinDays(String minDays) {
        this.minDays = minDays;
    }
    
    
}