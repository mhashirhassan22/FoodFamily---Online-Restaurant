package com.webcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.services.ReviewService;

@Controller
@RequestMapping("review")
public class ReviewController {

	@Autowired
	ReviewService review_service;
	
	@GetMapping
	public ModelAndView addReviewget() {
		
		
		return new ModelAndView("redirect: /FoodFamily/order");
	}
	
	
	@PostMapping
	public ModelAndView addReview(@RequestParam("stars") double star, @RequestParam("msg") String msg,
			@SessionAttribute("id") int customer_id) {
		review_service.addReview(star,msg,customer_id);
		return new ModelAndView("redirect: /FoodFamily/order/add");
	}
}
