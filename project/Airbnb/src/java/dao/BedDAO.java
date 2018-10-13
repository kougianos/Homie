package dao;

import entities.*;
import java.util.List;


public interface BedDAO {
    public List<Bed> list();

    public Bed find(int id);
}
