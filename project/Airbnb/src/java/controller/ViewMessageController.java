package controller;

import dao.MessageDAO;
import dao.MessageDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import entities.Message;
import entities.MessagePK;
import entities.User;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "viewMessageController")
@ViewScoped
public class ViewMessageController {

    private String param;
    private int room_id;
    private Message message;

    @PostConstruct
    public void init() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> m = fc.getExternalContext().getRequestParameterMap();

        param = m.get("messageID");
        room_id = Integer.parseInt(param);

        MessageDAO dao = new MessageDAOImpl();
        message = dao.find(room_id);
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

}
