package com.models;

import java.util.List;

public class Contact {
    
	private int customer_id;
    private String message;
    private boolean forSupport;
    private boolean isResolved;
    
    public Contact(){
        
    }
    
    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isForSupport() {
		return forSupport;
	}

	public void setForSupport(int forSupport) {
		this.forSupport = forSupport!=0; //if equals to 0 means meant for support i.e true
	}

	public boolean isResolved() {
		return isResolved;
	}

	public void setResolved(int isResolved) {
		this.isResolved = isResolved==1; //true if resolved is 1
	}

	public Contact(String message,String toWhom)
    {
        
    }
    
    public boolean dispContact(){
        
        return true;
    }
	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
      
    //below functions are defined in ContactService
    public List<Contact> getQueries(){ return null; }
    public boolean resolveQuery(String msg, String cid) {return false;}
	public boolean sendcomplaint(String to,String msg,int sender_id) {return false;}
	public List<Contact> getQueries(String perm) {return null;}

   
    
}
