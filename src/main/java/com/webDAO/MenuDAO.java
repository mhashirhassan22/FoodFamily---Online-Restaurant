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

import com.models.Deal;
import com.models.Food;

public class MenuDAO {
	@Autowired
	public DataSource datasource;
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	MenuDAO(DataSource datasource){
		this.jdbcTemplate = new JdbcTemplate(datasource);
		
	}
	public void datasourceSet(DataSource datasource) {
		this.datasource = datasource;
	}

	public boolean add(String name, int qty, int price, int cost) {
	    String sql = "INSERT INTO food (food_name,food_quantity,food_cost,food_price)"
	                + " VALUES (?, ?, ?,?)";
	    int rows=0;

	 	   rows = jdbcTemplate.update(sql, name,qty,cost,price);
	    try {
	    }
	    catch(Exception e){

		    rows = -1;
	    }
	    return rows>0;
		
	}
	public int getFoodID(String food_name) {
		String sql = "Select food_id FROM food WHERE food_name=?";
		int id=0;
		System.out.println("foodname:   "+food_name);
		try {
			  id = (int) jdbcTemplate.queryForObject(
			            sql, new Object[] { food_name }, Integer.class);
		}
		catch(Exception e) {
			System.out.println("exception in getfoodid() "+e);
			id=0;
		}
	 	return id;
	}
	public int getFoodPrice(int food_id) {
		String sql = "Select food_price FROM food WHERE food_id=?";
		   int price = (int) jdbcTemplate.queryForObject(
		            sql, new Object[] { food_id }, Integer.class);
	 	return price;
	}
	public List<Food> getFoodList() {
	String sql = "SELECT * FROM food";
		
		List<Food> queries = jdbcTemplate.query(
			    sql,
			    new RowMapper<Food>() {
			        public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
			        	Food f = new Food();
			        	f.setFoodName(rs.getString(2));
			        	f.setQty(rs.getInt(3));
			        	f.setOriginalPrice(rs.getInt(4));
			        	f.setRetailPrice(rs.getInt(5));
			            return f;
			        }
			    });
		
		return queries;
		
	}
	public boolean delete(String food) {
		String sql = "DELETE FROM food WHERE food_name=?";
	    int rows=0;

	    try {
		 	rows = jdbcTemplate.update(sql, food);
	    }
	    catch(Exception e){

		    rows = -1;
	    }
	    return rows>0;
		
	}
	public boolean editFood(String name, int price, int qty, int cost) {
	    String sql = "Update food set food_name=?,food_quantity=?,food_price=?,food_cost=? where food_name=?";

	    int rows=0;
	    try {
		 	rows = jdbcTemplate.update(sql, name,qty,price,cost,name);
	    }
	    catch(Exception e){

		    rows = -1;
	    }
	    return rows>0;
		
		
	}
	public int getQtyFood(int food_id) {
		String sql = "Select food_quantity FROM food WHERE food_id=?";
		   int qty = (int) jdbcTemplate.queryForObject(
		            sql, new Object[] { food_id }, Integer.class);
	 	return qty;
	}
	public boolean useFood(int food_id) {
		
		int qty = getQtyFood(food_id) - 1;
	    String sql = "Update food set food_quantity=? where food_id=?";

	    int rows=0;
	 	rows = jdbcTemplate.update(sql, qty, food_id);
	    try {
	    }
	    catch(Exception e){

		    rows = -1;
	    }
	    return rows>0;
		
	}
	public List<Deal> getDealList() {
	String sql = "SELECT * FROM Deal";
		
		List<Deal> queries = jdbcTemplate.query(
			    sql,
			    new RowMapper<Deal>() {
			        public Deal mapRow(ResultSet rs, int rowNum) throws SQLException {
			        	Deal d = new Deal();
			        	d.setName(rs.getString(2));
			        	d.setPrice(rs.getInt(3));
			            return d;
			        }
			    });
		
		return queries;
		
	}
	public int getDealID(String name) {
		String sql = "Select deal_id FROM Deal WHERE deal_name=?";
		int id=0;
		System.out.println("dealname:   "+name);
		try {
			  id = (int) jdbcTemplate.queryForObject(
			            sql, new Object[] { name }, Integer.class);
		}
		catch(Exception e) {
			System.out.println("exception in getdealid() "+e);
			id=0;
		}
	 	return id;
	}
	

	public List<Food> getDealFood(int deal_id) {
	String sql = "select * from food join deal_items as DT on food.food_id=DT.deal_id where deal_id=?";
		
		List<Food> queries = jdbcTemplate.query(
			    sql,
			    new Object[] {deal_id},
			    new RowMapper<Food>() {
			        public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
			        	Food f = new Food();
			        	f.setFoodName(rs.getString(2));
			        	f.setQty(rs.getInt(3));
			        	f.setOriginalPrice(rs.getInt(4));
			        	f.setRetailPrice(rs.getInt(5));
			            return f;
			        }
			    });
		return queries;
		
	}
	public boolean createDeal(String name, int price) {
	    String sql = "INSERT INTO Deal(deal_name,deal_price)"
                + " VALUES (?, ?)";
    int rows=0;

    try {
  	   rows = jdbcTemplate.update(sql, name,price);
    }
    catch(Exception e){

	    rows = -1;
    }
    return rows>0;
		
	}
	public boolean createDealItem(int food_id, int deal_id) {
	    String sql = "INSERT INTO deal_items (deal_id,food_id)"
                + " VALUES (?, ?)";
    int rows=0;

    try {
  	   rows = jdbcTemplate.update(sql, deal_id,food_id);
    }
    catch(Exception e){

	    rows = -1;
    }
    return rows>0;
		
		
	}
	public int getDealPrice(String name) {
		String sql = "Select deal_price FROM Deal WHERE deal_name=?";
		int price=0;
		System.out.println("dealname:   "+name);
		try {
			  price = (int) jdbcTemplate.queryForObject(
			            sql, new Object[] { name }, Integer.class);
		}
		catch(Exception e) {
			System.out.println("exception in getdealid() "+e);
			price=0;
		}
	 	return price;
	}
	public boolean deleteDeal(String deal) {
		String sql = "DELETE FROM deal WHERE deal_name=?";
	    int rows=0;

	    try {
		 	rows = jdbcTemplate.update(sql, deal);
	    }
	    catch(Exception e){

		    rows = -1;
	    }
	    return rows>0;
		
		
	}


}
