/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package export.model;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author kougi
 */
public class RoleWrapper {
    
    private RoleModel[] roles;

    public RoleWrapper() {
    }

    public RoleWrapper(RoleModel[] roles) {
        this.roles = roles;
    }

    @XmlElement(name="role")
    public RoleModel[] getRoles() {
        return roles;
    }

    public void setRoles(RoleModel[] roles) {
        this.roles = roles;
    }
}