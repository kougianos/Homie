/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.admin;

import entities.User;
import java.util.List;

/**
 *
 * @author valia
 */
public interface AdminDAO {
    public List<User> list();
    
    public List<User> listActive();
    
    public List<User> listInactive();
}
