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
public class RoomWrapper {

    private RoomModel[] rooms;

    public RoomWrapper(RoomModel[] rooms) {
        this.rooms = rooms;
    }

    public RoomWrapper() {
    }

    @XmlElement(name = "room")
    public RoomModel[] getRooms() {
        return rooms;
    }

    public void setRooms(RoomModel[] rooms) {
        this.rooms = rooms;
    }

}