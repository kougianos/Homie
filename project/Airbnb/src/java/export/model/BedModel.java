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
public class BedModel {
     
    private String type;    
    private int number;

    public BedModel() {
    }

    public BedModel(String type, int number) {
        this.type = type;
        this.number = number;
    }

    @XmlElement
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlElement
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
    
}