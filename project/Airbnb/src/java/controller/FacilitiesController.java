/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.FacilitiesDAOImpl;
import entities.Facilities;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author valia
 */
public class FacilitiesController implements Serializable {
     private int x = 0;
    
    private Facilities insertFacilities = new Facilities();
    private Facilities foundFacilities = null;
    private List<Facilities> foundList = null;
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    
    public String findOne() {
        int query_id =  x;
        
        FacilitiesDAOImpl dao = new FacilitiesDAOImpl();
        foundFacilities = dao.find(query_id);
        
        return null;
    }
    
    public String findAll() {
        FacilitiesDAOImpl dao = new FacilitiesDAOImpl();
        List<Facilities> list = dao.list();
        
        foundList = list;
        
        return null;
    }
    
    public Facilities getFoundFacilities() {
        return foundFacilities;
    }

    public void setFoundFacilities(Facilities foundFacilities) {
        this.foundFacilities = foundFacilities;
    }

    public List<Facilities> getFoundList() {
        return foundList;
    }

    public void setFoundList(List<Facilities> foundList) {
        this.foundList = foundList;
    }
    
     public Facilities getInsertBed() {
        return insertFacilities;
    }

    public void setInsertFacilities(Facilities insertFacilities) {
        this.insertFacilities = insertFacilities;
    }

    
}
