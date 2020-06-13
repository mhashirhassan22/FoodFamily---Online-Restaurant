package com.models;


public class Staff extends User {
    
    public Staff() {
		super();
	}

	public Staff(int id, String firstName, String lastName, String email, String password, String userName,
			String contactNo) {
		super(id, firstName, lastName, email, password, userName, contactNo);
	}
	
	public boolean viewCustomer(){
        return true;
    }
    
    public Staff displayStaffDetails(String name){
        
       Staff s=new Staff();
       return s;
    }

	public boolean create_staff(String fname, String lname, String username, String email, String password,
			String contact, int salary) {
		return false;
	}   
    public boolean removeStaff(String username){
        return false;
    }

}
