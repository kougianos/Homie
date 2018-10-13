/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MessageDAO;
import dao.MessageDAOImpl;
import dao.RoomDAO;
import dao.RoomDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import entities.Message;
import entities.Room;
import java.util.Date;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "composeMessage")
@ViewScoped
public class ComposeMessageController {

    private String username_from; // 1 property for each form field
    private String username_to;
    private int associated_room;
    private String room_title;
    private String messagetext;

    @PostConstruct
    public void init() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, Object> m = fc.getExternalContext().getSessionMap();
        Map<String, String> request_map = fc.getExternalContext().getRequestParameterMap();

        SessionController sc = (SessionController) m.get("sessionController");
        
        username_from = sc.getLoggedInUser().getUsername();
        
        String id = request_map.get("idroom");
        associated_room = Integer.parseInt(id);
        
        RoomDAO dao = new RoomDAOImpl();
        Room room = dao.find(associated_room);
        username_to = room.getUserList().get(0).getUsername();

        room_title = room.getDescription();
    }
    
    
    public String send() {

        try {
            Message insertMessage = new Message();
            insertMessage.setDate(new Date());
            insertMessage.setMessagetext(messagetext);
//            insertMessage.getMessagePK().setIdmessage(associated_room);

            MessageDAO dao = new MessageDAOImpl();

            dao.insert(username_from, username_to, insertMessage, associated_room);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Message sent successfully!"));
            return ("/messages/messages");

        } catch (Exception ex) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Message could not be sent"));
            return null;
        }
    }

    public String getUsername_from() {
        return username_from;
    }

    public void setUsername_from(String username_from) {
        this.username_from = username_from;
    }

    public String getUsername_to() {
        return username_to;
    }

    public void setUsername_to(String username_to) {
        this.username_to = username_to;
    }

    public int getAssociated_room() {
        return associated_room;
    }

    public void setAssociated_room(int associated_room) {
        this.associated_room = associated_room;
    }

    public String getMessagetext() {
        return messagetext;
    }

    public void setMessagetext(String messagetext) {
        this.messagetext = messagetext;
    }

    public String getRoom_title() {
        return room_title;
    }

    public void setRoom_title(String room_title) {
        this.room_title = room_title;
    }

    
    
}
