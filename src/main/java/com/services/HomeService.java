package com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.models.Restaurant;
import com.webDAO.loginDAO;

@Component
public class HomeService {
	
	@Autowired
	loginDAO home_dao; //to save user id in the session attributes
	@Autowired
	Restaurant rst;
	
	public int getID(String username, String permission){
		int id=home_dao.getID(username,permission);
		return id;
	}

	public void setCustomerList() {
		rst.setCustomersList(home_dao.getCustomerList());
		System.out.println("SET REST CUSTOMER LIST:   "+ rst.getCustomersList());
	}
	

}
