package ui;

import db.UserDAO;
import entities.User;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;



@ManagedBean(name="users")
@RequestScoped
public class UserListBean {

    private DataModel<UserBean> userList;
    
    @ManagedProperty(value="#{userDAO}")
    private UserDAO userDAO;
   
    
    public DataModel<UserBean> getList()
    {
        if (userList == null)
        {
            List<User> list = userDAO.getUsers();
            if (list !=null) {
                ArrayList<UserBean> uList = new ArrayList<UserBean>();

                for (User u: list)
                {
                    UserBean ub = new UserBean();
                    ub.setFirstName(u.getFirstname());
                    ub.setLastName(u.getLastname());
                    ub.setUserName(u.getUsername());
                    ub.setId(u.getId());
                    uList.add(ub);
                }
                userList = new ListDataModel<UserBean>(uList);
            }
        }
        return userList;
    }


	public UserDAO getUserDAO() {
		return userDAO;
	}


	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
    
    
}

