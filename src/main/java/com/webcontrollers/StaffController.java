package com.webcontrollers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.services.StaffService;

@Controller
@RequestMapping("/staff")
public class StaffController {
	@Autowired
	StaffService staff_service;

	@RequestMapping(value="/",method = RequestMethod.GET)
	public ModelAndView listStaffGet() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("salesmen",staff_service.getSalesmen());
		mv.setViewName("staffList");
		return mv;
	}
	
	
	@RequestMapping(value="/add",method = RequestMethod.GET)
	public ModelAndView addStaffGet(@SessionAttribute("permission") String perm) {
			ModelAndView mv=new ModelAndView();
			mv.setViewName("addStaff");
			return mv;
	}
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public ModelAndView addStaffPost(@RequestParam("fname") String fname,@RequestParam("lname") String lname,
			@RequestParam("salary") int salary,@RequestParam("username") String username,
			@RequestParam("password") String password,@RequestParam("email") String email,
			@RequestParam("contact") String contact) 
	{

		ModelAndView mv=new ModelAndView();
		if(staff_service.create_staff(fname,lname,username,email,password,contact,salary)==false) {
			mv.addObject("msg","error");
			mv.setViewName("redirect: /FoodFamily/staff/add");
		}
		
		mv.setViewName("redirect: /FoodFamily/staff/");
		return mv;
	}
	
	@RequestMapping(value="/edit",method = RequestMethod.GET)
	public ModelAndView editStaffGet(@RequestParam("username") String userName) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("staff", staff_service.getStaff(userName));
		mv.setViewName("editStaff");
		return mv;
	}
	
	
	@RequestMapping(value="/edit",method = RequestMethod.POST)
	public ModelAndView editStaffPost(@RequestParam("fname") String fname,@RequestParam("lname") String lname,
			@RequestParam("salary") int salary,@RequestParam("email") String email,@RequestParam("contact") String contact) {
		staff_service.updateStaff(fname,lname,salary,email,contact);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("redirect: /FoodFamily/staff/");
		return mv;
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public ModelAndView deleteStaffget() {
		return new ModelAndView("redirect: /FoodFamily/staff/");
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public ModelAndView deleteStaff(@RequestParam("username") String username) {
		staff_service.removeStaff(username);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("redirect: /FoodFamily/staff/");
		return mv;
	}
}
