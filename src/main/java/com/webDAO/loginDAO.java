package com.webDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.models.Customer;
import com.models.Food;
public class loginDAO {
	@Autowired
	public DataSource datasource;
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	loginDAO(DataSource datasource){
		this.jdbcTemplate = new JdbcTemplate(datasource);
		
	}
	public void datasourceSet(DataSource datasource) {
		this.datasource = datasource;
	}
	
	public int registerCustomer(String fname,String lname,String email,String contact,String password,String userName) {
		// insert
	    String sql = "INSERT INTO customer (customer_fname, customer_lname, customer_username"
	    		+ ", customer_email, customer_password, customer_contactNo)"
	                + " VALUES (?, ?, ?,?,?,?)";
	    int rows;

	    try {
		    rows = jdbcTemplate.update(sql, fname, lname,userName,email,password,contact);
	    }
	    catch(Exception e){

		    rows = -1;
	    }
	    return rows;
	}
	
	public int registerSalesman(String fname,String lname,String email,String contact,String password,String userName) {
		// insert
	    String sql = "INSERT INTO salesman (customer_fname, customer_lname, customer_username"
	    		+ ", customer_email, customer_password, customer_contactNo)"
	                + " VALUES (?, ?, ?,?,?,?)";
	    int rows;


	    
	    try {
		    rows = jdbcTemplate.update(sql, fname, lname,userName,email,password,contact);
	    }
	    catch(Exception e){

		    rows = -1;
	    }
	    return rows;
	}

	//ForLogin_ check in db
	public String checkuser(String username, String password) {

		String sql = "";
		//return if customer
		sql = "SELECT count(*) FROM customer WHERE customer_username = ? and customer_password = ?";
		int count = jdbcTemplate.queryForObject(sql, new Object[] { username,password }, Integer.class);
		if(count>0) {
			return "customer";
		}
		//return if restaurant owner
		sql = "SELECT count(*) FROM restaurant_owner WHERE owner_username = ? and owner_password = ?";
		count = jdbcTemplate.queryForObject(sql, new Object[] { username,password }, Integer.class);
		if(count>0) {
			return "owner";
		}
		//return if salesman
		sql = "SELECT count(*) FROM salesman WHERE salesman_username = ? and salesman_password = ?";
		count = jdbcTemplate.queryForObject(sql, new Object[] { username,password }, Integer.class);
		if(count>0) {
			return "salesman";
		}
		//if none
		return "not found";
	}
	
	
	
	public int getID(String username, String permission) {
		int id=-1;
		
		if(permission=="customer") {
		    String sql = "SELECT customer_id FROM customer  WHERE customer_username = ?";

		    id = (int) jdbcTemplate.queryForObject(
		            sql, new Object[] { username }, Integer.class);
		}
		else if(permission=="salesman") {
		    String sql = "SELECT salesman_id FROM salesman  WHERE salesman_username = ?";

		    id = (int) jdbcTemplate.queryForObject(
		            sql, new Object[] { username }, Integer.class);
		}
		else if(permission=="owner") {
		    String sql = "SELECT owner_id FROM restaurant_owner  WHERE owner_username = ?";

		    id = (int) jdbcTemplate.queryForObject(
		            sql, new Object[] { username }, Integer.class);
		}
		return id;
	}

	
	public List<Customer> getCustomerList() {
	String sql = "SELECT * FROM customer";
		
		List<Customer> queries = jdbcTemplate.query(
			    sql,
			    new RowMapper<Customer>() {
			        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			        	Customer c = new Customer();
			        	c.setFirstName(rs.getString(2));
			        	c.setLastName(rs.getString(3));
			        	c.setEmail(rs.getString(4));
			        	c.setPassword(rs.getString(5));
			        	c.setUserName(rs.getString(6));
			        	c.setContactNo(rs.getString(7));
			            return c;
			        }
			    });
		
		return queries;
	}
}
