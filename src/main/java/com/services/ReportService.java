package com.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.models.Food;
import com.models.Report;
import com.models.Restaurant;
import com.webDAO.ReportDAO;

@Component
public class ReportService {

	@Autowired
	ReportDAO reportDB;
	@Autowired
	Restaurant rst;

	public void createReport(int id,String period) {
		int total_sales=0,net_profit=0,total_orders=0;
		
		if(period.equals("daily")) {
			total_sales=reportDB.totalSale(0);
			total_orders=reportDB.totalOrders(0);
			net_profit=reportDB.netProfit(0);
			
		}
		else if(period.equals("weekly")){
			total_sales=reportDB.totalSale(7);
			total_orders=reportDB.totalOrders(7);
			net_profit=reportDB.netProfit(7);
			
		}
		else if(period.equals("monthly")){
			total_sales=reportDB.totalSale(30);
			total_orders=reportDB.totalOrders(30);
			net_profit=reportDB.netProfit(30);
			
		}
		reportDB.add(total_sales,total_orders,net_profit,period,id);
		
	}

	public void setRstReport() {
		rst.setReports(reportDB.getReportList());
	}
	public Report getReport(String period) {
		return reportDB.getReport(period);
		
	}
}