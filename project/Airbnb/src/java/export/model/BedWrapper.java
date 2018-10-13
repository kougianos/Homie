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
public class BedWrapper {
    
    private BedModel[] beds;

    public BedWrapper() {
    }

    public BedWrapper(BedModel[] beds) {
        this.beds = beds;
    }

    @XmlElement(name="bed")
    public BedModel[] getBeds() {
        return beds;
    }

    public void setBeds(BedModel[] beds) {
        this.beds = beds;
    }
    
    
}