package com.models;


public class Review {
    
    private double star;
    private String description;
    
    public Review(){
        
    }
    
    public Review(String description,double star){
    
        this.description=description;
        this.star=star;
    }

    public void setStar(double star) {
        this.star = star;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getStar() {
        return star;
    }

    public String getDescription() {
        return description;
    }
    
    
    public void dispReview(){
        
    }
}
