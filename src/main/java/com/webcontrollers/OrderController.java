package com.webcontrollers;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.models.Food;
import com.services.MenuService;
import com.services.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService order_service;
	@Autowired
	MenuService menu_service;

	@RequestMapping(value="/",method = RequestMethod.GET)
	public ModelAndView listOrderGet() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("orders",order_service.getAllOrders());
		mv.setViewName("orderList");
		return mv;
	}
	
	
	@RequestMapping(value="/add",method = RequestMethod.GET)
	public ModelAndView addOrderGet(@SessionAttribute("id") int customer_id) {
		ModelAndView mv=new ModelAndView();
		Food f=new Food();
		mv.addObject("fooditem",f);
		List<Food> orderlist= order_service.getOrderList(customer_id);
		mv.addObject("orderlist",orderlist);
		mv.addObject("orderprice",order_service.getOrderPrice(customer_id));
		mv.addObject("food",menu_service.getMenuFood());
		mv.addObject("deallist",menu_service.getDealList());
		mv.setViewName("addOrder");
		return mv;
	}

	@RequestMapping(value="/edit",method = RequestMethod.GET)
	public ModelAndView editOrderGet() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("editOrder");
		return mv;
	}

	@RequestMapping(value="/delete",method = RequestMethod.POST)
	public ModelAndView deleteOrderPost(@RequestParam("orderID") int oid) {
		System.out.println("Attempting to delete service order");
		order_service.deleteOrder(oid);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("redirect: /FoodFamily/order/");
		return mv;
	}
	
	@RequestMapping(value="/ajax",method = RequestMethod.POST)
	@ResponseBody
	public String ajaxGet(@SessionAttribute("id") int customer_id,@RequestParam String food_name,@RequestParam int qty, Model model) {
		int price = 0;
		System.out.println("QUANTITY is  "+qty);
		for(int i=0;i<qty;i++)
			order_service.createOrder(customer_id,food_name);
		price=order_service.getOrderPrice(customer_id);
		System.out.println("ID IS:   "+ price);
		return Integer.toString(price);
	}	
	@RequestMapping(value="/ajaxdeal",method = RequestMethod.POST)
	@ResponseBody
	public String ajaxdeal(@SessionAttribute("id") int customer_id,@RequestParam String deal_name,@RequestParam int qty, Model model) {
		int price = 0;
		System.out.println("QUANTITY is  "+qty);
		for(int i=0;i<qty;i++)
			order_service.createOrderDeal(customer_id,deal_name);
		price=order_service.getOrderPrice(customer_id);
		System.out.println("ID IS:   "+ price);
		return Integer.toString(price);
	}
}
