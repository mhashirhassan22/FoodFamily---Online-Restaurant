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
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	loginservices login_services;

	@GetMapping	//To remove parameters from the url (static dependency on itself)
	public ModelAndView getindex() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	@PostMapping
	public ModelAndView subb(@RequestParam("fname") String fname,@RequestParam("lname") String lname,
			@RequestParam("email") String email,@RequestParam("contact") String contact,
			@RequestParam("password") String password, @RequestParam("username") String username,HttpSession session) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("home");
		if(login_services.signup(fname,lname,email,contact,password,username,"customer")>0) {
			session.setAttribute("username", username);
			session.setAttribute("permission", "customer");
			return new ModelAndView("redirect: /FoodFamily/home");
		}
		else {
			mv.setViewName("index");
			mv.addObject("result","Registration unsuccessful");
		}
		return mv;
	}
}
