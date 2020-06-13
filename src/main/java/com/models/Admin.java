package com.models;
class Admin extends User {
    
    public Admin(){
        
        
    }
    
    
    public Admin(int id, String firstName, String lastName, String email, String password, String userName,
			String contactNo) {
		super(id, firstName, lastName, email, password, userName, contactNo);
	}


	public boolean addOwner(String fname,String lname,String password,String userName,String contactNo){
        return true;
    }
    
    public boolean delete_owner(){
        
        return true;
    }
    
    public boolean edit_owner(){
        
        return true;
    }
    
    public boolean resolve_query(){
        
        return true;
    }
    
    public boolean addRestaurent(int id,String name,String address){
        
        return true;
    }
   
    public boolean editRestaurent(int id,String name,String address){
        
        return true;
    }
   
    public boolean delete_restaurent(int id){
        
        return true;
        
    }

}
