package entities;

import entities.Room;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-04T17:39:56")
@StaticMetamodel(Rules.class)
public class Rules_ { 

    public static volatile SingularAttribute<Rules, Boolean> pets;
    public static volatile SingularAttribute<Rules, Boolean> smoking;
    public static volatile SingularAttribute<Rules, String> minDays;
    public static volatile SingularAttribute<Rules, Integer> idrules;
    public static volatile SingularAttribute<Rules, Boolean> events;
    public static volatile ListAttribute<Rules, Room> roomList;

}