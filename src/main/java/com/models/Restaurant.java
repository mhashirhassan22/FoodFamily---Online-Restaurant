/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    
    private int ID;
    private String name;
    private String address;
    private Inventory inventory=new Inventory();
    private List<Customer> customersList;
    private List<Review> reviews;
    private List<RestaurantOwner> restaurantOwners;
    private List<Salesman> salesmen;
    private List<Report> reports;
    

	public Restaurant(int iD, String name, String address, Inventory inventory, List<Customer> customersList,
			List<Review> reviews, List<RestaurantOwner> restaurantOwners, List<Salesman> salesmen,
			List<Report> reports) {
		super();
		ID = iD;
		this.name = name;
		this.address = address;
		this.inventory = inventory;
		this.customersList = customersList;
		this.reviews = reviews;
		this.restaurantOwners = restaurantOwners;
		this.salesmen = salesmen;
		this.reports = reports;
	}
	public Restaurant() {
		super();
		salesmen=new ArrayList<Salesman>();
		customersList=new ArrayList<Customer>();
		restaurantOwners=new ArrayList<RestaurantOwner>();
		reports= new ArrayList<Report>();
		reviews=new ArrayList<Review>();
	}
	//Getters and Setters
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Inventory getInventory() {
		return inventory;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	public List<Customer> getCustomersList() {
		return customersList;
	}
	public void setCustomersList(List<Customer> customersList) {
		this.customersList = customersList;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	public List<RestaurantOwner> getRestaurantOwners() {
		return restaurantOwners;
	}
	public void setRestaurantOwners(List<RestaurantOwner> restaurantOwners) {
		this.restaurantOwners = restaurantOwners;
	}
	public List<Salesman> getSalesmen() {
		return salesmen;
	}
	public void setSalesmen(List<Salesman> salesmen) {
		this.salesmen = salesmen;
	}
	public List<Report> getReports() {
		return reports;
	}
	public void setReports(List<Report> reports) {
		this.reports = reports;
	}
	public void addReview(Review review) {
		reviews.add(review);
		
	}

    
}
