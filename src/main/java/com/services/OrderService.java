package com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.models.Customer;
import com.models.Deal;
import com.models.Food;
import com.models.Inventory;
import com.models.Order;
import com.models.Restaurant;
import com.webDAO.CustomerDAO;
import com.webDAO.MenuDAO;
import com.webDAO.OrderDAO;

@Component
public class OrderService {

	@Autowired
	OrderDAO orderDB;
	@Autowired
	MenuDAO menuDB;
	@Autowired
	Restaurant rst;
	@Autowired
	CustomerDAO customer;
	@Autowired
	Inventory inventory;
	@Autowired
	MenuService menu_service;

	public void getFoodList() {
		// TODO Auto-generated method stub
		
	}

	public int createOrder(Integer customer_id, String food_name) {
		

		System.out.println("attempting checkorder foodname:    "+food_name);
		
		int order_id = orderDB.checkOrder(customer_id);
		System.out.println("attempting checkorder 2");
		System.out.println("createdorder");
		if(order_id==0) {
			orderDB.createOrder(customer_id);	//if order is not present then create a new one and then get id
			order_id = orderDB.checkOrder(customer_id);
		}
		System.out.println("attempting getfoodid where orderID is:"+order_id);
		int food_id = menuDB.getFoodID(food_name);
		System.out.println("attempting to add order item:   "+food_id);
		if(food_id==0)
			return 0;
		orderDB.addOrderItem(food_id,order_id,0);
		System.out.println("attempting to update food qty");
		menuDB.useFood(food_id);
		System.out.println("attempting to get food price");
		int price = menuDB.getFoodPrice(food_id);
		System.out.println("attempting to update food price");
		return orderDB.updateOrderPrice(price,order_id);
	}

	public int getOrderPrice(int customer_id) {
		
		int order_id=orderDB.checkOrder(customer_id);
		return orderDB.getOrderPrice(order_id);
	}
	public List<Food> getOrderList(int customer_id) {
		System.out.println("entering getOrderFood ");
		int order_id = orderDB.checkOrder(customer_id);
		return orderDB.getOrderFood(order_id);
	}

	public List<Order> getAllOrders() {
		List<Order> orderList = orderDB.getOrderList();
		for(int i=0;i<orderList.size();i++) {
			orderList.get(i).setFoodItems(orderDB.getOrderFood(orderList.get(i).getoID()));
			System.out.println("GET FOOD LIST "+orderList.get(i).getFoodItems());
		}
		return orderList;   
		
	}

	//this delete order function serves that.. as per iour dcd
	public boolean deleteOrder(int oid) {
		orderDB.delete(oid);
		return false;
	}

	public int createOrderDeal(int customer_id, String deal_name) {
		

		System.out.println("attempting checkorder foodname:    "+deal_name);
		
		int order_id = orderDB.checkOrder(customer_id);
		System.out.println("attempting checkorder 2");
		System.out.println("createdorder");
		if(order_id==0) {
			orderDB.createOrder(customer_id);	//if order is not present then create a new one and then get id
			order_id = orderDB.checkOrder(customer_id);
		}
		System.out.println("attempting getDeallist");
		List<Food> food_list=new ArrayList<Food>();
		System.out.println("attempting deal loop: "+menu_service.getDealList());
		for(Deal d: menu_service.getDealList()) {
			System.out.println("DEALS: "+d.getName());
			if(d.getName().equals(deal_name)) {
				System.out.println("FOOD LIST OF DEAL: "+d.getName()+"AND THE "+d.getFoodList());
				food_list=d.getFoodList();
				break;
			}
		}
		
		
		
		for(Food f: food_list) {
			System.out.println("attempting getfoodid where food is:"+f.getFoodName());
			int food_id = menuDB.getFoodID(f.getFoodName());
			System.out.println("attempting to add order item:   "+food_id);
			if(food_id==0)
				return 0;
			orderDB.addOrderItem(food_id,order_id,0);
		}
		int price = menuDB.getDealPrice(deal_name);
		System.out.println("attempting to update food price");
		return orderDB.updateOrderPrice(price,order_id);
		
	}

}
