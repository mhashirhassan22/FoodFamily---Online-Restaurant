package com.webDAO;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.models.Food;
import com.models.Order;
import com.models.Report;
import com.models.Salesman;
public class ReviewDAO {
	@Autowired
	public DataSource datasource;
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	ReviewDAO(DataSource datasource){
		this.jdbcTemplate = new JdbcTemplate(datasource);
		
	}
	public void datasourceSet(DataSource datasource) {
		this.datasource = datasource;
	}
	
	public boolean addReview(Double star, String msg,int customer_id) {
	    String sql = "INSERT INTO Review (stars,review_desc,customer_id)"
                + " VALUES (?, ?, ?)";
    int rows=0;

    rows = jdbcTemplate.update(sql, star,msg,customer_id);
	return rows>0;

	}
	public double avgRating() {
	    String sql = "select AVG(review.stars) FROM review";
    double rows=0;

    rows = jdbcTemplate.update(sql);
	return rows;
	}


	
}