package entities;

import entities.MessagePK;
import entities.Room;
import entities.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-04T17:39:56")
@StaticMetamodel(Message.class)
public class Message_ { 

    public static volatile SingularAttribute<Message, Date> date;
    public static volatile SingularAttribute<Message, User> user1;
    public static volatile SingularAttribute<Message, Room> idroom;
    public static volatile SingularAttribute<Message, String> messagetext;
    public static volatile SingularAttribute<Message, MessagePK> messagePK;
    public static volatile SingularAttribute<Message, User> user;

}