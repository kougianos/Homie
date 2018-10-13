package entities;

import entities.Room;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-04T17:39:56")
@StaticMetamodel(Space.class)
public class Space_ { 

    public static volatile SingularAttribute<Space, Integer> idspace;
    public static volatile SingularAttribute<Space, Integer> livingRoom;
    public static volatile SingularAttribute<Space, Integer> kitchen;
    public static volatile SingularAttribute<Space, Integer> bedroom;
    public static volatile SingularAttribute<Space, Integer> bathroom;
    public static volatile ListAttribute<Space, Room> roomList;

}