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
import com.models.Salesman;
public class StaffDAO {
	@Autowired
	public DataSource datasource;
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	StaffDAO(DataSource datasource){
		this.jdbcTemplate = new JdbcTemplate(datasource);
		
	}
	public void datasourceSet(DataSource datasource) {
		this.datasource = datasource;
	}

	public List<Salesman> getSalesmanList() {
	String sql = "SELECT * FROM salesman";
		
		List<Salesman> queries = jdbcTemplate.query(
			    sql,
			    new RowMapper<Salesman>() {
			        public Salesman mapRow(ResultSet rs, int rowNum) throws SQLException {
			        	Salesman s = new Salesman();
			        	s.setFirstName(rs.getString(2));
			        	s.setLastName(rs.getString(3));
			        	s.setEmail(rs.getString(4));
			        	s.setPassword(rs.getString(5));
			        	s.setUserName(rs.getString(6));
			        	s.setContactNo(rs.getString(7));
			        	s.setSalary(rs.getInt(8));
			            return s;
			        }
			    });
		
		return queries;
		
	}
	public int addStaff(String fname, String lname, String username, String email, String password, String contact,
			int salary) {
	    String sql = "INSERT INTO salesman (salesman_fname,salesman_lname,salesman_email"
	    		+ ",salesman_password,salesman_username,salesman_contactNo,salesman_salary)"
	                + " VALUES (?, ?, ?,?,?,?,?)";
	    int rows=0;

	 	   rows = jdbcTemplate.update(sql, fname,lname,email,password,username,contact,salary);
	    try {
	    }
	    catch(Exception e){

		    rows = -1;
	    }
	    return rows;
		
	}
	public boolean remove(String username) {
		String sql = "DELETE FROM salesman WHERE salesman_username=?";
	    int rows=0;

	 	rows = jdbcTemplate.update(sql, username);
	    try {
	    }
	    catch(Exception e){

		    rows = -1;
	    }
	    return rows>0;
		
	}
	public boolean update(String fname, String lname, int salary, String email, String contact) {
	    String sql = "Update salesman set salesman_fname=?,salesman_lname=?,salesman_email=?"
	    		+ ",salesman_contactNo=?,salesman_salary=? where salesman_email=?";

	    int rows=0;
	 	rows = jdbcTemplate.update(sql, fname,lname,email,contact,salary,email);
	    try {
	    }
	    catch(Exception e){

		    rows = -1;
	    }
	    return rows>0;
		
	}

}
