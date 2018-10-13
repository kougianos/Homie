package controller;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;
import dao.MessageDAO;
import dao.MessageDAOImpl;
import entities.Message;
import entities.MessagePK;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "messageManagementController")
@ViewScoped
public class MessageManagementController {

    @ManagedProperty(value = "#{sessionController}")
    private SessionController sessionController;
    
    private List<Message> inbox;
    private List<Message> outbox;

    @PostConstruct
    public void init() {
        String username = sessionController.getLoggedInUser().getUsername();

        MessageDAO dao = new MessageDAOImpl();
        inbox = dao.list_inbox(username);
        outbox = dao.list_outbox(username);
    }

    public List<Message> getInbox() {
        return inbox;
    }

    public void setInbox(List<Message> inbox) {
        this.inbox = inbox;
    }

    public List<Message> getOutbox() {
        return outbox;
    }

    public void setOutbox(List<Message> outbox) {
        this.outbox = outbox;
    }


    public SessionController getSessionController() {
        return sessionController;
    }

    public void setSessionController(SessionController sessionController) {
        this.sessionController = sessionController;
    }

}
