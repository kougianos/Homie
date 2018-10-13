package entities;

import entities.Bed;
import entities.Facilities;
import entities.Message;
import entities.Roomtype;
import entities.Rules;
import entities.Space;
import entities.User;
import entities.UserRentsRoom;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-04T17:39:56")
@StaticMetamodel(Room.class)
public class Room_ { 

    public static volatile SingularAttribute<Room, String> area;
    public static volatile SingularAttribute<Room, Double> mapLatitude;
    public static volatile ListAttribute<Room, Rules> rulesList;
    public static volatile SingularAttribute<Room, Roomtype> idroomtype;
    public static volatile ListAttribute<Room, Space> spaceList;
    public static volatile ListAttribute<Room, Facilities> facilitiesList;
    public static volatile SingularAttribute<Room, String> photo;
    public static volatile SingularAttribute<Room, String> description;
    public static volatile SingularAttribute<Room, String> plusPersonPrice;
    public static volatile SingularAttribute<Room, Date> availableFrom;
    public static volatile ListAttribute<Room, UserRentsRoom> userRentsRoomList;
    public static volatile ListAttribute<Room, User> userList;
    public static volatile ListAttribute<Room, Message> messageList;
    public static volatile SingularAttribute<Room, Integer> idroom;
    public static volatile SingularAttribute<Room, Integer> peopleNumber;
    public static volatile SingularAttribute<Room, Integer> price;
    public static volatile SingularAttribute<Room, Date> arrivalTime;
    public static volatile SingularAttribute<Room, Date> availableTill;
    public static volatile SingularAttribute<Room, String> location;
    public static volatile SingularAttribute<Room, Double> mapLongitude;
    public static volatile ListAttribute<Room, Bed> bedList;

}