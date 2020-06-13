/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;
import java.util.*;
public class Order {
    
    public boolean isReady() {
		return isReady;
	}

	public void setReady(boolean isReady) {
		this.isReady = isReady;
	}

	public List<Deal> getDeals() {
		return deals;
	}

	public void setDeals(ArrayList<Deal> deals) {
		this.deals = deals;
	}

	public List<Food> getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(List<Food> foodItems) {
		this.foodItems = foodItems;
	}

	private int oID;
    private int oPrice;
    private int discount;
    private boolean isReady;
    private List<Deal> deals;
    private List<Food> foodItems;
    
 

    public Order() {
		super();
	}

	public Order(int oID, int oPrice, int discount, boolean isReady, List<Deal> deals, List<Food> foodItems) {
		super();
		this.oID = oID;
		this.oPrice = oPrice;
		this.discount = discount;
		this.isReady = isReady;
		this.deals = deals;
		this.foodItems = foodItems;
	}

	public boolean setoID(int oID) {
        this.oID = oID;
        return true;
    }

    public boolean setoPrice(int oPrice) {
        this.oPrice = oPrice;
        return true;
    }

    public boolean setDiscount(int discount) {
        this.discount = discount;
        return true;
    }
    

    public boolean setIsReady(boolean isReady) {
        this.isReady = isReady;
        return true;
    }

    public int getoID() {
        return oID;
    }

    public int getoPrice() {
        return oPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public boolean isIsReady() {
        return isReady;
    }
    
    public boolean createReview(){
        
        return true;
    }
    
    public boolean deleteOrder(int Order){
        
        return true;
    }
    
    public ArrayList<Food> displayItemFromInventory(){
        
        return null;
        
    }
    
    
    
    
}
