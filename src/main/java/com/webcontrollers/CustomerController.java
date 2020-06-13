package com.webcontrollers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.services.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	CustomerService customer_service;

	@GetMapping
	public ModelAndView listStaffGet() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("customers",customer_service.getCustomerList());
		mv.setViewName("Customers");
		return mv;
	}
	
}
