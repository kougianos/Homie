/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package export;

import entities.User;
import export.model.MessageWrapper;
import export.model.RoomWrapper;
import export.model.UserModel;
import export.model.UserWrapper;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kougi
 */
@XmlRootElement
public class Root {
    
    private UserWrapper wrapper = new UserWrapper();
    private RoomWrapper roomWrapper = new RoomWrapper();
    

    public Root() {
    }

    @XmlElement(name="users")
    public UserWrapper getWrapper() {
        return wrapper;
    }

    public void setWrapper(UserWrapper wrapper) {
        this.wrapper = wrapper;
    }

    @XmlElement(name="rooms")
    public RoomWrapper getRoomWrapper() {
        return roomWrapper;
    }

    public void setRoomWrapper(RoomWrapper roomWrapper) {
        this.roomWrapper = roomWrapper;
    }

   
    
    
}