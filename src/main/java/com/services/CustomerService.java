package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.models.Restaurant;
import com.models.RestaurantOwner;
import com.webDAO.CustomerDAO;
import com.models.Customer;
@Component
public class CustomerService extends Customer{
	
	@Autowired
	CustomerDAO customerDB;
	@Autowired
	Restaurant rst;
	
	public List<Customer> getCustomerList(){
		rst.setCustomersList(customerDB.getCustomerList());
		System.out.println("Customers LIst:   "+customerDB.getCustomerList());
		for(Customer c: rst.getCustomersList()) {
			c.getReward().setPoints(customerDB.addLP(c.getUserName()));
		}
		return rst.getCustomersList();
	}

}
