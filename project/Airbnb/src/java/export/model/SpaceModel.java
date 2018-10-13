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
public class SpaceModel {
    private int livingRoom;
    private int bedroom;
    private int bathroom;
    private int kitchen;

    public SpaceModel() {
    }

    public SpaceModel(int livingRoom, int bedroom, int bathroom, int kitchen) {
        this.livingRoom = livingRoom;
        this.bedroom = bedroom;
        this.bathroom = bathroom;
        this.kitchen = kitchen;
    }

    @XmlElement
    public int getLivingRoom() {
        return livingRoom;
    }

    public void setLivingRoom(int livingRoom) {
        this.livingRoom = livingRoom;
    }

    @XmlElement
    public int getBedroom() {
        return bedroom;
    }

    public void setBedroom(int bedroom) {
        this.bedroom = bedroom;
    }

    @XmlElement
    public int getBathroom() {
        return bathroom;
    }

    public void setBathroom(int bathroom) {
        this.bathroom = bathroom;
    }

    @XmlElement
    public int getKitchen() {
        return kitchen;
    }

    public void setKitchen(int kitchen) {
        this.kitchen = kitchen;
    }
    
    
}