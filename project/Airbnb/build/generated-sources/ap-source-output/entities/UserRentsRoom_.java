package entities;

import entities.Room;
import entities.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-04T17:39:56")
@StaticMetamodel(UserRentsRoom.class)
public class UserRentsRoom_ { 

    public static volatile SingularAttribute<UserRentsRoom, Integer> rate;
    public static volatile SingularAttribute<UserRentsRoom, Room> idroom;
    public static volatile SingularAttribute<UserRentsRoom, Date> arrivalTime;
    public static volatile SingularAttribute<UserRentsRoom, Integer> idrent;
    public static volatile SingularAttribute<UserRentsRoom, Date> rentFrom;
    public static volatile SingularAttribute<UserRentsRoom, Date> rentTo;
    public static volatile SingularAttribute<UserRentsRoom, User> username;

}