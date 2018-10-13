package entities;

import entities.Message;
import entities.Role;
import entities.Room;
import entities.UserRentsRoom;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-04T17:39:56")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> photo;
    public static volatile SingularAttribute<User, Boolean> active;
    public static volatile ListAttribute<User, Message> messageList1;
    public static volatile ListAttribute<User, Role> roleList;
    public static volatile ListAttribute<User, UserRentsRoom> userRentsRoomList;
    public static volatile SingularAttribute<User, String> password;
    public static volatile ListAttribute<User, Message> messageList;
    public static volatile SingularAttribute<User, String> phone;
    public static volatile SingularAttribute<User, String> surname;
    public static volatile SingularAttribute<User, String> name;
    public static volatile SingularAttribute<User, String> email;
    public static volatile ListAttribute<User, Room> roomList;
    public static volatile SingularAttribute<User, String> username;

}