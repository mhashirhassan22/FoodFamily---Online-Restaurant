package com.webcontrollers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.services.loginservices;



@Controller
@RequestMapping("/loginform")
public class LoginController {
	@Autowired
	loginservices login_services;
	
	@GetMapping
	public ModelAndView check(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	
	@PostMapping
	public ModelAndView logincontroller(@RequestParam("username") String userName,@RequestParam("password") String password,HttpSession session) {
		
		
		String user_status=login_services.login(userName, password);
		
		if(user_status=="customer") {
			//add customer in CustomerList in restaurant class if already not present
			//setting session attributes for global use
			session.setAttribute("username", userName);
			session.setAttribute("permission", "customer");
		}
		else if(user_status=="salesman") {
			session.setAttribute("username", userName);
			session.setAttribute("permission", "salesman");
		}
		else if(user_status=="owner") {
			session.setAttribute("username", userName);
			session.setAttribute("permission", "owner");
		}
		else {
			ModelAndView mv=new ModelAndView();
			mv.setViewName("login");
			mv.addObject("msg","error");
			return mv;
			}
		return new ModelAndView("redirect: /FoodFamily/home");
	}

	
}
