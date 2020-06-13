package com.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.models.Contact;
import com.webDAO.ComplaintDAO;

@Component
public class ComplaintService extends Contact {
	@Autowired
	ComplaintDAO complaintDAO;
	
	public boolean sendcomplaint(String to,String msg,int sender_id) {
		if(complaintDAO.toadmin(msg, 0, sender_id)>0)
			return true;
		
		return false;
	}
	
	public List<Contact> getQueries(String perm) {
		System.out.println("askfjsld  "+complaintDAO.getOwnerQueries());
		if(perm.equals("owner"))
			return complaintDAO.getOwnerQueries();
		else if(perm.equals("admin"))
			return complaintDAO.getAdminQueries();
		System.out.println("askfjsld  "+complaintDAO.getOwnerQueries());
		return complaintDAO.getOwnerQueries();
		
	}

	public boolean resolveQuery(String msg, String cid) {
		int customer_id = Integer.parseInt(cid);
		complaintDAO.resolve(msg,customer_id);
		
		return false;
	}

}
