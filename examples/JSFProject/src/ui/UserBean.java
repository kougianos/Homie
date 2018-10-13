package ui;

import db.UserDAO;
import entities.User;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="user")
@SessionScoped
public class UserBean {

    
    private int id;
    private String firstName;
    private String lastName;
    private String password;
    private String userName;
    private User current;

    @ManagedProperty(value="#{userDAO}")
    private UserDAO userDAO;
    
    public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public String registerUser()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        
        User user = new User();
        user.setFirstname(firstName);
        user.setLastname(lastName);
        user.setPassword(password);
        user.setUsername(userName);
        String message = userDAO.insertUser(user);
        if (!message.equals("ok"))
        {
            context.addMessage(null, new FacesMessage(message));
        }
        if (context.getMessageList().size() > 0)
            return null;
        else 
            return "userlist";
    }
    
    public String login() {
    	
         current = userDAO.find(userName, password);

         if (current == null) { 
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Unknown login, try again"));
            return userName = password = null;
         } 
         else {
            return "restricted/register_user";
        }
    }
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/login?faces-redirect=true";
    }
    
    public boolean isLoggedIn() {
        return current != null;
    } 
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
       
}