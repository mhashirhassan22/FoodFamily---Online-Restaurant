package com.models;


public abstract class User {
    
    protected int id;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;
    protected String userName;
    protected String contactNo;
	
   
    
    public User(int id, String firstName, String lastName, String email, String password, String userName,
			String contactNo) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.userName = userName;
		this.contactNo = contactNo;
	}

	public User() {
		super();
	}

	//Getters || Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	//Service Functions
	public String login(String userName,String password) {
		//implementation override in services package layer 
		return null;
	};
    
    public void verifyUser(String username,String password)
    {
        
    }
}
