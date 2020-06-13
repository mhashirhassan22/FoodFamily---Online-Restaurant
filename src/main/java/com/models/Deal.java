package com.models;
import java.util.*;


public class Deal {
    
    private List<Food> foodList;
    private int price;
    private String name;
    


    public Deal() {
		super();
		foodList=new ArrayList<Food>();
	}

	public Deal(int price, String name) {
		super();
		foodList=new ArrayList<Food>();
		this.price = price;
		this.name = name;
	}

	public boolean setPrice(int price) {
        this.price = price;
        return true;
    }

    public boolean setName(String name) {
        this.name = name;
        return true;
    }

	public List<Food> getFoodList() {
		return foodList;
	}

	public void setFoodList(List<Food> foodList) {
		this.foodList = foodList;
	}

	public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
    
    public  boolean dispDeal(){
        
        return true;
    } 
}
