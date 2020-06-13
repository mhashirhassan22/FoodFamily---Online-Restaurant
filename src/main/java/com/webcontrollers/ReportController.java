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

import com.services.ReportService;
import com.services.ReviewService;

@Controller
@RequestMapping("/report")
public class ReportController {

	@Autowired
	ReportService report_service;
	@Autowired
	ReviewService review_service;
	@GetMapping
	public ModelAndView getreport() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("report");
		return mv;
	}
	
	@PostMapping
	public ModelAndView postreport(@RequestParam("period") String period,@SessionAttribute("id") int id
			,@SessionAttribute("permission") String perm) {
		report_service.createReport(id,period);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("report");
		return mv;
	}
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	public ModelAndView gettreport(@RequestParam("period") String period) {
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("report",report_service.getReport(period));
		mv.setViewName("report");
		return mv;
	}
}
