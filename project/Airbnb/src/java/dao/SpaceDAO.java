package dao;

import entities.*;
import java.util.List;

public interface SpaceDAO {
     public List<Space> list();

    public Space find(int id);
}
