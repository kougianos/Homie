package entities;

import entities.Room;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-04T17:39:56")
@StaticMetamodel(Bed.class)
public class Bed_ { 

    public static volatile SingularAttribute<Bed, Integer> idbed;
    public static volatile SingularAttribute<Bed, Integer> number;
    public static volatile SingularAttribute<Bed, String> type;
    public static volatile ListAttribute<Bed, Room> roomList;

}