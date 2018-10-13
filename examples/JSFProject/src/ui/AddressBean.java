package ui;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="address")
@RequestScoped
public class AddressBean {
    
    private final String address = "Panepistimiou 30, Athens";

    public String getAddress() {
        return address;
    }     
}