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
public class UserRentsRoomWrapper {
    
    private UserRentsRoomModel[] userrentsroom;

    
    @XmlElement(name="rental")
    public UserRentsRoomModel[] getUserrentsroom() {
        return userrentsroom;
    }

    public void setUserrentsroom(UserRentsRoomModel[] userrentsroom) {
        this.userrentsroom = userrentsroom;
    }

    public UserRentsRoomWrapper() {
    }

    public UserRentsRoomWrapper(UserRentsRoomModel[] userrentsroom) {
        this.userrentsroom = userrentsroom;
    }
    
    
}