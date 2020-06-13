package com.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.models.Deal;
import com.models.Food;
import com.models.Inventory;
import com.webDAO.MenuDAO;


@Component
public class MenuService extends Inventory {

	@Autowired
	MenuDAO menuDB;

	public MenuService(List<Food> foods, List<Deal> deals) {
		super(foods, deals);
	}
	public void removeMenu(String food) {
		menuDB.delete(food);
    	setFood_list(menuDB.getFoodList());
		
	}

    public Set<Food> getMenuFood() {
    	setFood_list(menuDB.getFoodList());
    	System.out.println(" FOOD "+getFood_list());
    	return new HashSet<>(getFood_list());
	}
	@Override
	public boolean addFood(String name, int qty, int price,int cost) {
		boolean result=menuDB.add(name,qty,price,cost);
    	setFood_list(menuDB.getFoodList());
		return result;
	}
	
	
	
	@Override
	public boolean addDeal(String name, int price) {
		Deal deal=new Deal(price,name);
		deal_items.add(deal);
		menuDB.createDeal(name,price);
		return true;
	}
	public Food getFoodItem(String food) {

		for(Food f: getFood_list()) {
			if(f.getFoodName().equals(food)==true)
				return f;
		}
		return null;
		
	}
	public void editMenu(String name, int price, int qty, int cost) {
		menuDB.editFood(name,price,qty,cost);
		
	}
	public void setDeallist() {
		deal_items = menuDB.getDealList();
		System.out.println("SET DEAL LIST");
		for(Deal d: deal_items) {
			int id = menuDB.getDealID(d.getName());
			System.out.println("DEAL ID is "+ id);
			if(id>0) {
				List<Food> items = menuDB.getDealFood(id);
				System.out.println("DEAL FOOD LIST "+ items);
				for(Food f: items) {
					System.out.println("Daskdjhf");
					food_list.add(f);
				}
			}
		}
		
	}
	public boolean checkDeal(String name) {

		setDeallist();
		for(Deal d : deal_items) {
			if(d.getName().equals(name)) {
				return true;
			}
		}
		
		return false;
	}
	public void addDealItem(String food_name, String name) {
		int food_id = menuDB.getFoodID(food_name);
		int deal_id = menuDB.getDealID(name);
		menuDB.createDealItem(food_id,deal_id);
		for(Deal d: deal_items) {
			if(d.getName().equals(name)){

				for(Food f: food_list) {
					if(f.getFoodName().equals(food_name)) {
						d.getFoodList().add(f);
					}
				}
			}
		}
		
	}
	public List<Deal> getDealList() {
		setDeallist();
		return deal_items;
	}
	public void removeDeal(String deal) {
		menuDB.deleteDeal(deal);
		setDeallist();
    	
		
	}

}

