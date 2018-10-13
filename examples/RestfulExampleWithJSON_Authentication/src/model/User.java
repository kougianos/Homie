package model;


public class User {
    
    @Override
	public String toString() {
		return "User [username=" + username + ", id=" + id + ", firstName="
				+ firstName + ", lastName=" + lastName + ", password="
				+ password + "]";
	}

	private String username;
    
    private Integer id;
    
    private String firstName;
    
    private String lastName;
    
    private String password;

    public User() {
    }
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}