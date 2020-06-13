package com.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.models.Restaurant;
import com.models.Review;
import com.webDAO.ReviewDAO;

@Component
public class ReviewService {

	@Autowired
	ReviewDAO reviewDB;
	@Autowired
	Restaurant rst;
	public void addReview(double star, String msg, int customer_id) {
		Review review = new Review(msg,star);
		rst.addReview(review);
		reviewDB.addReview(star, msg,customer_id);
		
		
	}
	public double getRating() {
		// TODO Auto-generated method stub
		return reviewDB.avgRating();
	}
}
