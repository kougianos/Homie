package dao;

import entities.*;
import java.util.List;

public interface RulesDAO {
     public List<Rules> list();

    public Rules find(int id);
}
