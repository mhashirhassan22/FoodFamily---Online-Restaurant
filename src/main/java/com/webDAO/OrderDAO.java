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
import com.models.Salesman;
public class OrderDAO {
	@Autowired
	public DataSource datasource;
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	OrderDAO(DataSource datasource){
		this.jdbcTemplate = new JdbcTemplate(datasource);
		
	}
	public void datasourceSet(DataSource datasource) {
		this.datasource = datasource;
	}


	public int checkOrder(Integer customer_id) {
		
	    String sql = "SELECT order_id FROM orders  WHERE order_customer = ?";

	    int id=0;
	    try {

		    id = (int) jdbcTemplate.queryForObject(
		            sql, new Object[] { customer_id }, Integer.class);
	    }
	    catch(Exception e) {
	    	System.out.println(e);
	    	id=0;
	    }
	   
		return id;
	}
	public boolean createOrder(Integer customer_id) {
	    String sql = "INSERT INTO orders (order_price,order_discount,order_is_ready,order_customer)"
	                + " VALUES (?, ?, ?,?)";
	    int rows=0;

	    rows = jdbcTemplate.update(sql, 0,0,0,customer_id);
		return rows>0;

		
	}
	public boolean addOrderItem(int item_id, int order_id, int isDeal) {

    int rows=0;

    if(isDeal==0) {
	    String sql = "INSERT INTO order_items (order_id, food_id)"
                + " VALUES (?, ?)";
        rows = jdbcTemplate.update(sql, order_id, item_id);
    }
	return rows>0;

	}
	public int getOrderPrice(int order_id) {
		int orderPrice = 0;
		String getprice = "Select order_price from orders where order_id=?";
		try {
			 orderPrice = (int) jdbcTemplate.queryForObject(
					 getprice, new Object[] { order_id }, Integer.class);
		}
		catch(Exception e) {
			System.out.println("exception in updatefoodprice:  "+e);
		}
		return orderPrice;
	}
	public int updateOrderPrice(int price, int order_id) {
		int orderPrice = getOrderPrice(order_id);
		price+=orderPrice;
	    String sql = "Update orders set order_price=? where order_id=?";

	    int rows=0;
	 	rows = jdbcTemplate.update(sql, price, order_id);
	    try {
	    }
	    catch(Exception e){

		    rows = -1;
	    }
	    return price;
		
	}
	
	 public static <T> Set<T> convertListToSet(List<T> list) 
	    { 
	        // create a set from the List 
	        return new HashSet<>(list); 
	    } 
	public List<Food> getOrderFood(int order_id) {
	String sql = "select * from food join order_items as OT on food.food_id=OT.food_id where order_id=?";
		
		List<Food> queries = jdbcTemplate.query(
			    sql,
			    new Object[] {order_id},
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
	public List<Order> getOrderList() {
	String sql = "select * from orders";
		
		List<Order> queries = jdbcTemplate.query(
			    sql,
			    new RowMapper<Order>() {
			        public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
			        	Order o = new Order();
			        	o.setoID(rs.getInt(1));
			        	o.setoPrice(rs.getInt(2));
			        	o.setDiscount(rs.getInt(3));
			        	int oo = rs.getInt(4);
			        	o.setIsReady(oo>0);
			            return o;
			        }
			    });
		return queries;
	}

	public boolean delete(int oid) {
		String sql = "DELETE FROM orders WHERE order_id=?";
	    int rows=0;

	    try {
		 	rows = jdbcTemplate.update(sql, oid);
	    }
	    catch(Exception e){

		    rows = -1;
	    }
	    return rows>0;
		
	}

}
