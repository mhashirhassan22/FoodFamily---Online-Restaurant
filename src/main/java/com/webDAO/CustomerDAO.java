package com.webDAO;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.models.Customer;
import com.models.LoyaltyProgram;

public class CustomerDAO {
	@Autowired
	public DataSource datasource;
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	CustomerDAO(DataSource datasource){
		this.jdbcTemplate = new JdbcTemplate(datasource);
		
	}
	public void datasourceSet(DataSource datasource) {
		this.datasource = datasource;
	}

	public List<Customer> getCustomerList() {
	String sql = "SELECT * FROM customer";
		
		List<Customer> queries = jdbcTemplate.query(
			    sql,
			    new RowMapper<Customer>() {
			        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			        	Customer s = new Customer();
			        	s.setFirstName(rs.getString(2));
			        	s.setLastName(rs.getString(3));
			        	s.setEmail(rs.getString(4));
			        	s.setPassword(rs.getString(5));
			        	s.setUserName(rs.getString(6));
			        	s.setContactNo(rs.getString(7));
			            return s;
			        }
			    });
		
		return queries;
		
	}
	
	public int getCustID(String userName) {
		int id = 0;
		String sql = "Select customer_id from customer where customer_username=?";
		try {
			 id = (int) jdbcTemplate.queryForObject(
					 sql, new Object[] { userName }, Integer.class);
		}
		catch(Exception e) {
			System.out.println("exception in loyaltyprogram cust id:  "+e);
		}
		return id;
	}
	public boolean create(int customer_id) {
	    String sql = "INSERT INTO LoyaltyProgram (customer_id,points)"
	                + " VALUES (?, ?)";
	    int rows=0;

	    try {
		 	   rows = jdbcTemplate.update(sql, customer_id,5);
	    }
	    catch(Exception e){

		    rows = -1;
	    }
	    return rows>0;
	}
	
	public int addLP(String userName) {
		
		int customer_id = getCustID(userName);
		
		int points=0;
		String sql = "Select points from LoyaltyProgram where customerid=?";
		try {
			points = (int) jdbcTemplate.queryForObject(
					 sql, new Object[] { customer_id }, Integer.class);
		}
		catch(Exception e) {
			System.out.println("exception in loyaltyprogram:  "+e);
			return 0;
		}
		return points;
	}
}