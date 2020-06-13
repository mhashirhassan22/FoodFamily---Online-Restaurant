package com.webcontrollers;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.services.HomeService;

@Controller
public class HomeController {
	@Autowired
	HomeService home_service;

	@RequestMapping(value="/home",method = RequestMethod.GET)
	public ModelAndView gethome(@SessionAttribute("username") String username
			,@SessionAttribute("permission") String perm, HttpSession session) {
		session.setAttribute("id", home_service.getID(username,perm));
		System.out.println("CUSTOMER ID AT WELCOME:  "+home_service.getID(username,perm));
		home_service.setCustomerList();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping(value="/aboutus",method = RequestMethod.GET)
	public ModelAndView addMenuGet() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("aboutUs");
		return mv;
	}
	
}
