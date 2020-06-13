package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.models.Restaurant;
import com.models.RestaurantOwner;
import com.models.Salesman;
import com.models.Staff;
import com.webDAO.StaffDAO;
@Component
public class StaffService extends Staff{
	
	@Autowired
	StaffDAO staffDB;
	@Autowired
	Restaurant rst;
	
	@Override
	public boolean create_staff(String fname, String lname, String username, String email,
			String password, String contact, int salary){
		boolean result = staffDB.addStaff(fname,lname,username,email,password,contact,salary)>0;
		rst.setSalesmen(staffDB.getSalesmanList());	//update the list
		return result;
        
    }
	@Override
	public boolean removeStaff(String username) {
		for(Salesman s: getSalesmen()) {
			if(s.getUserName()==username) {
				rst.getSalesmen().remove(s);
				break;
			}
		}
		return staffDB.remove(username);
	}
	public List<Salesman> getSalesmen(){
		rst.setSalesmen(staffDB.getSalesmanList());
		return rst.getSalesmen();
	}
	public Salesman getStaff(String username) {	
		for(Salesman s: getSalesmen()) {

			if(s.getUserName().equals(username)) {
				return s;
			}
		}
		return null;
	}
	public void updateStaff(String fname, String lname, int salary, String email, String contact) {
		staffDB.update(fname,lname,salary,email,contact);
	}
	

}
