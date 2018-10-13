package entities;

import entities.Room;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-04T17:39:56")
@StaticMetamodel(Facilities.class)
public class Facilities_ { 

    public static volatile SingularAttribute<Facilities, Boolean> parking;
    public static volatile SingularAttribute<Facilities, Boolean> wifi;
    public static volatile SingularAttribute<Facilities, Boolean> tv;
    public static volatile SingularAttribute<Facilities, Integer> idfacilities;
    public static volatile SingularAttribute<Facilities, Boolean> elevator;
    public static volatile SingularAttribute<Facilities, Boolean> oven;
    public static volatile SingularAttribute<Facilities, Boolean> heating;
    public static volatile SingularAttribute<Facilities, Boolean> airCondition;
    public static volatile ListAttribute<Facilities, Room> roomList;

}