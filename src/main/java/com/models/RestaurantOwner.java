package com.models;


public class RestaurantOwner extends Staff {
    
    RestaurantOwner(){
        
        
    }
    
    public boolean resolveQuery(){
        
        return true;
    }
    
    public boolean viewStaff(){
        
        return true;
    }
    
    public void viewSummary(){
        
    }
    
    public  Report viewSales(int period)
    {
        Report r=new Report();
        return r;
    }
    
    public void RemoveStaff(String email){
        
        
    }
    
    public void viewStaffDetail(String name){
        
        
    }
    
    
    
    
}
