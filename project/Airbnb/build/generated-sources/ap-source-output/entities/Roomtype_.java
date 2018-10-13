package entities;

import entities.Room;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-04T17:39:56")
@StaticMetamodel(Roomtype.class)
public class Roomtype_ { 

    public static volatile SingularAttribute<Roomtype, Integer> idroomtype;
    public static volatile SingularAttribute<Roomtype, String> category;
    public static volatile ListAttribute<Roomtype, Room> roomList;

}