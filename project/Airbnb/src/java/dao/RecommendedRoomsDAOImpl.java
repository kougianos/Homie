package dao;

import entities.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import jpautils.EntityManagerHelper;
import recommendations.Matrix;
import recommendations.Pair;
import recommendations.Sorter;

public class RecommendedRoomsDAOImpl implements RecommendedRoomsDAO {

    @Override
    public List<Room> list(String target) {
        Sorter sorter = new Sorter();
        UserDAO userDao = new UserDAOImpl();
        RoomDAO roomDao = new RoomDAOImpl();
        UserRentsRoomDAO urrDao = new UserRentsRoomDAOImpl();
        UserVisitsRoomDAO uvrDao = new UserVisitsRoomDAOImpl();

        List<String> usernames = userDao.ids();
        List<Integer> room_ids = roomDao.ids();
        List<UserRentsRoom> rents = urrDao.list();

        int n = usernames.size(); // users
        int m = room_ids.size(); // rooms

        Matrix matrix = new Matrix(n, m);

              
        int id = -1; // id of user profiled
        
        // initialization  
        { 
            int i = 0;
            for (String username : usernames) {
                if (username.equals(target)) {
                    id = i;
                }

                int howmanyrates = 0;
                for (UserRentsRoom line : rents) {
                    if (line.getUsername().getUsername().equals(username)) {
                        int roomid = line.getIdroom().getIdroom();
                        int j = roomid - 1;
                        Integer rate = line.getRate();

                        matrix.getData()[i][j] = rate;
                        howmanyrates++;
                    }
                }

                if (howmanyrates == 0) {
                    List<UserVisitsRoom> visits = uvrDao.listwithusername(username);
                    
                    for (UserVisitsRoom line : visits) {
                        if (line.getUsername().equals(username)) {
                            int roomid = line.getRoomId();
                            int j = roomid - 1;
                            Integer v = line.getVisits();

                            if (v != null && v > 5) {
                                v = 5;
                            }
                            if (v == null || v == 0) {
                                v = 1;
                            }
                            matrix.getData()[i][j] = v;
                            howmanyrates++;
                        }
                    }
                }

                i++;
            }
        }

        // roomsToBeEstimated = { RA, RB, RC }
        HashSet<Integer> roomsToBeEstimated = matrix.getUnknownColumns(id);

        // normalize
        matrix.normalize();

        // calculate collaboration for each room
        ArrayList<Pair> pairs = new ArrayList<>();

        for (Integer column : roomsToBeEstimated) {            
            float rate = matrix.collaboration(id, column);
            int roomid = column + 1;

            Pair p = new Pair(roomid, rate);
            pairs.add(p);
        }

        // sort descending
        sorter.sort(pairs);

        // apply limit
        int limit = Math.min(pairs.size(), 5);

        List<Room> rooms = new ArrayList<>();
        RoomDAO dao = new RoomDAOImpl();

        for (int i = 0; i < limit; i++) {
            int roomid = pairs.get(i).getRoom_id();

            // retrieve data for each room in results
            Room temp = dao.find(roomid);
            rooms.add(temp);
        }

        return rooms;
    }

}
