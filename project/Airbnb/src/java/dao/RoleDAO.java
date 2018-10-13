package dao;

import entities.*;
import java.util.List;

public interface RoleDAO {
    public List<Role> list();

    public Role find(int id);
}
