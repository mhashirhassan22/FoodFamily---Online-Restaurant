package com.webcontrollers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.services.ComplaintService;

@Controller
public class ComplaintController {
	@Autowired
	ComplaintService complaint_service;

	@RequestMapping(value="/contact",method = RequestMethod.GET)
	public ModelAndView getContact() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("complaint");
		return mv;
	}
	@RequestMapping(value="/contact",method = RequestMethod.POST)
	public ModelAndView postContact(@RequestParam("sendto") String receiver,
			@RequestParam("msg") String msg,@SessionAttribute("id") String uid) {
		System.out.println("CUSTOMER COMPLAINT: "+uid);
		int sender = Integer.parseInt(uid);
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("complaint");
		if(complaint_service.sendcomplaint(receiver, msg, sender)==true) {
			mv.addObject("msg","success");
		}
		else {
			mv.addObject("msg","error");
		}
			
		return mv;
	}
	
	@RequestMapping(value="/contact/list",method = RequestMethod.GET)
	public ModelAndView getListContact(@SessionAttribute("permission") String perm) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("queries",complaint_service.getQueries(perm));
		mv.setViewName("complaintList");
		return mv;
	}
	@RequestMapping(value="/contact/list",method = RequestMethod.POST)
	public ModelAndView postListContact() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("complaintList");
		return mv;
	}
	@RequestMapping(value="/contact/resolvequery")
	public ModelAndView resolveQuery(@RequestParam("msg") String msg, @RequestParam("cid") String cid) {
		complaint_service.resolveQuery(msg,cid);
		return new ModelAndView("redirect: /FoodFamily/contact/list");
	}
	
}
