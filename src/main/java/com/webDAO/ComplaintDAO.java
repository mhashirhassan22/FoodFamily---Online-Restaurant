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

import com.models.Contact;
public class ComplaintDAO {
	@Autowired
	public DataSource datasource;
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	ComplaintDAO(DataSource datasource){
		this.jdbcTemplate = new JdbcTemplate(datasource);
		
	}
	public void datasourceSet(DataSource datasource) {
		this.datasource = datasource;
	}
	
	public int toadmin(String msg, int forSupport, int sender_id) {
		// insert
	    String sql = "INSERT INTO contact (customer_id,msg,for_support,is_resolved)"
	                + " VALUES (?, ?, ?,?)";
	    int rows=0;

	 	   rows = jdbcTemplate.update(sql, sender_id, msg,forSupport,0);
	    try {
	    }
	    catch(Exception e){

		    rows = -1;
	    }
	    return rows;
	}
	public List<Contact> getOwnerQueries() {

		String sql = "SELECT * FROM contact where for_support=? and is_resolved=?";
		
		List<Contact> queries = jdbcTemplate.query(
			    sql,
			    new Object[] {0,0},
			    new RowMapper<Contact>() {
			        public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
			        	Contact c = new Contact();
			        	c.setCustomer_id(rs.getInt(1));
			        	c.setMessage(rs.getString(2));
			        	c.setForSupport(rs.getInt(3));
			            c.setResolved(rs.getInt(4));
			            return c;
			        }
			    });
		
		return queries;
		
	}
	public List<Contact> getAdminQueries() {
	String sql = "SELECT * FROM contact where for_support=? and is_resolved=?";
		
		List<Contact> queries = jdbcTemplate.query(
			    sql,
			    new Object[] {1,0},
			    new RowMapper<Contact>() {
			        public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
			        	Contact c = new Contact();
			        	c.setCustomer_id(rs.getInt(1));
			        	c.setMessage(rs.getString(2));
			        	c.setForSupport(rs.getInt(3));
			            c.setResolved(rs.getInt(4));
			            return c;
			        }
			    });
		
		return queries;
		
	}
	
	public boolean resolve(String msg, int customer_id) {
		String sql = "UPDATE contact SET is_resolved = ? WHERE customer_id = ? and msg = ?";
	    int rows=0;

	 	   rows = jdbcTemplate.update(sql, 1,customer_id, msg);
	    try {
	    }
	    catch(Exception e){

		    rows = -1;
	    }
		
		return rows>0;
	}

	
	
	
	
	
	
}
