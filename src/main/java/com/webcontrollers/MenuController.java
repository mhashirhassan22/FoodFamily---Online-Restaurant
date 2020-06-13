package com.webcontrollers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.services.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {
	@Autowired
	MenuService menu_service;

	@RequestMapping(value="/",method = RequestMethod.GET)
	public ModelAndView menuGet() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("menufood", menu_service.getMenuFood());
		mv.addObject("deallist",menu_service.getDealList()); 
		mv.setViewName("menuList");
		return mv;
	}
	
	
	@RequestMapping(value="/add",method = RequestMethod.GET)
	public ModelAndView addMenuGet() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("addMenu");
		return mv;
	}
	
	@RequestMapping(value="/add",method = RequestMethod.POST)
	public ModelAndView addMenuPost(@RequestParam("name") String name, @RequestParam("price") int price,
			@RequestParam("qty") int qty,@RequestParam("cost") int cost) {
		boolean f = menu_service.addFood(name,qty,price,cost);
		
		return new ModelAndView("redirect: /FoodFamily/menu/");
	}
	
	@RequestMapping(value="/addDeal",method = RequestMethod.GET)
	public ModelAndView addDealGet() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("food",menu_service.getMenuFood());
		mv.setViewName("addDeal");
		return mv;
	}
	
	@RequestMapping(value="/addDeal",method = RequestMethod.POST)
	@ResponseBody
	public String ajaxGet(@SessionAttribute("permission") String perm,@RequestParam String food_name, @RequestParam String name,
			@RequestParam int price,@RequestParam int qty, Model model) {
		boolean isPresent = menu_service.checkDeal(name);
		if(isPresent==false) {
			menu_service.addDeal(name, price);
		}
		for(int i=0;i<qty;i++)
			menu_service.addDealItem(food_name,name);
		return "Success";
	}

	@RequestMapping(value="/edit",method = RequestMethod.GET)
	public ModelAndView editMenuGet(@RequestParam("foodname") String food) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("food",menu_service.getFoodItem(food));
		mv.setViewName("editMenu");
		return mv;
	}
	
	@RequestMapping(value="/edit",method = RequestMethod.POST)
	public ModelAndView editMenuPost(@RequestParam("name") String name, @RequestParam("price") int price,
			@RequestParam("qty") int qty,@RequestParam("cost") int cost) {
		menu_service.editMenu(name,price,qty,cost);
		return new ModelAndView("redirect: /FoodFamily/menu/");
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public ModelAndView deleteMenuget() {
		return new ModelAndView("redirect: /FoodFamily/menu/"); 
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public ModelAndView deleteMenupost(@RequestParam("foodname") String food) {
		menu_service.removeMenu(food);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("redirect: /FoodFamily/menu/");
		return mv;
	}
	
	@RequestMapping(value="/deleteDeal",method=RequestMethod.POST)
	public ModelAndView deleteDealpost(@RequestParam("dealnamee") String deal) {
		menu_service.removeDeal(deal);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("redirect: /FoodFamily/menu/");
		return mv;
	}
}
