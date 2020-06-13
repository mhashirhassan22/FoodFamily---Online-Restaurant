package com.services;
import com.models.User;
import com.models.Customer;
import com.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import com.webDAO.loginDAO;

public class loginservices extends User{

	@Autowired
	loginDAO loginDB;
	
	
	public String login(String userName,String password) {
		return loginDB.checkuser(userName, password);
	};

	public int signup(String fname,String lname,String email,String contact,String password,String userName,String permission) {
		if(permission=="customer") {
			return loginDB.registerCustomer(fname, lname, email, contact, password, userName);
		}
		else if(permission=="salesman") {
			return loginDB.registerSalesman(fname, lname, email, contact, password, userName);
		}
		return -1;	//only customer and salesman are allowed to get register
	};
}
