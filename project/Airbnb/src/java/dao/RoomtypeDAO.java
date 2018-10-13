package dao;

import entities.*;
import java.util.List;

public interface RoomtypeDAO {
    public List<Roomtype> list();

    public Roomtype find(int id);
}
