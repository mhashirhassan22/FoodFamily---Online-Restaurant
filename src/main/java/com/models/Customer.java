package com.models;
import java.util.*;

public class Customer extends User {
    
    private ArrayList<Order> orderlist;
    LoyaltyProgram reward;
 


    public ArrayList<Order> getOrderlist() {
		return orderlist;
	}
	public void setOrderlist(ArrayList<Order> orderlist) {
		this.orderlist = orderlist;
	}
	public LoyaltyProgram getReward() {
		if(reward==null)
			reward=new LoyaltyProgram();
		return reward;
	}
	public void setReward(LoyaltyProgram reward) {
		this.reward = reward;
	}
	public Customer(int id, String firstName, String lastName, String email, String password, String userName,
			String contactNo, ArrayList<Order> orderlist, LoyaltyProgram reward) {
		super(id, firstName, lastName, email, password, userName, contactNo);
		this.orderlist = orderlist;
		this.reward = reward;
	}
	public Customer(ArrayList<Order> orderlist) {
		super();
		this.orderlist = orderlist;
	}
    public Customer() {
		super();
		orderlist = new ArrayList<Order>();
		reward = new LoyaltyProgram();
	}
	public boolean dispCust(){
        
        return true;
    }
    
    public ArrayList<Order> getOrderHistory() {
		return orderlist;
	}

	public void setOrderHistory(ArrayList<Order> orderHistory) {
		this.orderlist = orderHistory;
	}

	public boolean place_Order(){
        
        return true;
    }
    
    public boolean cancelOrder(int OrderID){
        
        return true;
    }
    

	public boolean updateOrder(){
        
        return true;
    }
    
    public boolean submitQuery(String description,String toWhom){
        
        return true;
    }
    
    public boolean viewProfile(){
        
        return true;
    }
    
    public void selectItems(){
        
    } 
}
