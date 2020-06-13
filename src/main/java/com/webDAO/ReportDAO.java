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
public class ReportDAO {
	@Autowired
	public DataSource datasource;
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	ReportDAO(DataSource datasource){
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
	public int totalSale(int period) {
		String sql = "select sum(order_price) as Total_sale from orders where DATEDIFF ( day , orders.date_created, getdate() ) <= ?";
		int sales=0;
		System.out.println("report time:   "+period);
		try {
			sales = (int) jdbcTemplate.queryForObject(
			            sql, new Object[] { period}, Integer.class);
		}
		catch(Exception e) {
			System.out.println("exception in report() "+e);
			sales=0;
		}
	 	return sales;
	}
	public int totalOrders(int period) {
		String sql = "select count(order_id) as No_of_sales from orders where DATEDIFF ( day , orders.date_created, getdate() ) <= ?";
		int noOfOrders=0;
		System.out.println("report time:   "+period);
		try {
			noOfOrders= (int) jdbcTemplate.queryForObject(
			            sql, new Object[] { period}, Integer.class);
		}
		catch(Exception e) {
			System.out.println("exception in report() "+e);
			noOfOrders=0;
		}
	 	return noOfOrders;
	}
	
	

	public int netProfit(int period) {
		String sql = "	select (sum(food.food_price) -  sum(food.food_cost)) from order_items \r\n" + 
				"	join food on food.food_id = order_items.food_id join orders on orders.order_id = order_items.order_id \r\n" + 
				"	where DATEDIFF ( day , orders.date_created, getdate() ) <= ?";
		int profit=0;
		System.out.println("report time:   "+period);
		try {
			profit = (int) jdbcTemplate.queryForObject(
			            sql, new Object[] { period}, Integer.class);
		}
		catch(Exception e) {
			System.out.println("exception in report() "+e);
			profit=0;
		}
	 	return profit;
	}
	public boolean add(int total_sales, int total_orders, int net_profit, String period, int id) {
	    String sql = "INSERT INTO report (salesman_id,report_period,total_sale,net_profit,no_of_sales)"
                + " VALUES (?, ?, ?,?,?)";
    int rows=0;

    try {
        rows = jdbcTemplate.update(sql, id,period,total_sales,net_profit,total_orders);
    }
    catch(Exception e) {
    	System.out.println("Report already exists");
    }
	return rows>0;

	}
	public Report getReport(String period) {
	String sql = "select * from report where report_period=?";
		
		List<Report> queries = jdbcTemplate.query(
			    sql,
			    new Object[] {period},
			    new RowMapper<Report>() {
			        public Report mapRow(ResultSet rs, int rowNum) throws SQLException {
			        	Report r = new Report();
			        	r.setNoOfOrders(rs.getInt(6));
			        	r.setSales(rs.getInt(3));
			        	r.setNetProfit(rs.getInt(5));
			            return r;
			        }
			    });
		return queries.get(0);
	}
	public List<Report> getReportList() {
	String sql = "select * from report";
		
		List<Report> queries = jdbcTemplate.query(
			    sql,
			    new Object[] {},
			    new RowMapper<Report>() {
			        public Report mapRow(ResultSet rs, int rowNum) throws SQLException {
			        	Report r = new Report();
			        	r.setNoOfOrders(rs.getInt(6));
			        	r.setSales(rs.getInt(3));
			        	r.setNetProfit(rs.getInt(5));
			            return r;
			        }
			    });
		return queries;
		
	}
	
}