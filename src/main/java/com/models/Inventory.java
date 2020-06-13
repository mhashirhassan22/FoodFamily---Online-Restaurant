package com.models;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    protected List<Food> food_list;
    protected List<Deal> deal_items;
    
    public Inventory(List<Food> foods, List<Deal> deals) {
		super();
		this.food_list = new ArrayList<Food>();
		this.deal_items = new ArrayList<Deal>();
	}
	public Inventory() {

		this.food_list = new ArrayList<Food>();
		this.deal_items = new ArrayList<Deal>();
	}
	public boolean addFood(String name, int qty, int price,int cost) {
		return false;
	}
	public List<Food> getFood_list() {
		return food_list;
	}
	public void setFood_list(List<Food> food_list) {
		this.food_list = food_list;
	}
	public List<Deal> getDeal_items() {
		return deal_items;
	}
	public void setDeal_items(List<Deal> deal_items) {
		this.deal_items = deal_items;
	}
	public boolean editFood(){
        
        return true;
    }
    
    public boolean deleteFood(){
        
        return true;
    }
    
    public boolean addDeal(String name, int price) {
        
        return true;
    }
    
    public boolean editDeal(){
        
        return true;
    }
    
    public boolean deleteDeal(){
        
        return true;
    }
    
    public void displayInventory(){
        
    }
    
    public void updateInventory(){
        
        
    }
    
}
