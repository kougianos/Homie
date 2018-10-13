package dao;

import entities.*;
import java.util.List;

public interface FacilitiesDAO {
    public List<Facilities> list();

    public Facilities find(int id);
}
