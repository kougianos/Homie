package dao;

import java.util.List;
import entities.*;
import java.util.Date;

public interface RecommendedRoomsDAO {

    public List<Room> list(String username);

}
