/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;


public class Food {
    
    private String FoodName;
    private int qty;
    private int originalPrice;
    private int retailPrice;
    
    public Food(){
        
        
    }
    
    public Food(String FoodName,int qty,int originalPrice,int retailPrice){
        
        this.FoodName=FoodName;
        this.qty=qty;
        this.originalPrice=originalPrice;
        this.retailPrice=retailPrice;
        
        
    }

    public boolean setFoodName(String FoodName) {
        this.FoodName = FoodName;
        return true;
    }

    public boolean setQty(int qty) {
        this.qty = qty;
        return true;
    }

    public boolean setOriginalPrice(int originalPrice) {
        this.originalPrice = originalPrice;
        return true;
    }

    public boolean setRetailPrice(int retailPrice) {
        this.retailPrice = retailPrice;
        return true;
    }

    public String getFoodName() {
        return FoodName;
    }

    public int getQty() {
        return qty;
    }

    public int getOriginalPrice() {
        return originalPrice;
    }

    public int getRetailPrice() {
        return retailPrice;
    }
    
    
    public int calcProfit(){
        
        return -1;
    }
    
    
            
    
    
}
