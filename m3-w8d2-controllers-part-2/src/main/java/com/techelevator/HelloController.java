package com.techelevator;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.Review;
import com.techelevator.model.ReviewDao;

@Controller 
public class HelloController {
	
	@Autowired
	private ReviewDao reviewdao;

	@RequestMapping("/greeting")
	public String displayGreeting() {
		
		return "greeting";
	}
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showHomePage(HttpServletRequest request) {
		// Get Reviews from database
		List<Review> reviewList = reviewdao.getAllReviews();
		request.setAttribute("reviewList", reviewList);
		return "homePage";
	}
	
	@RequestMapping(path="/submitReview", method=RequestMethod.GET)
	public String showSubmitReview() {
		return "submitReview";
	}
	
	@RequestMapping(path="/submitReview", method=RequestMethod.POST)
	public String showSubmitReview(HttpServletRequest request) {
		String userName = request.getParameter("userName");
		String chooseRating = request.getParameter("chooseRating");
		String reviewTitle = request.getParameter("reviewTitle");
		String reviewText = request.getParameter("reviewText");
		Review review = new Review();
		review.setUsername(userName);
		review.setRating(Integer.valueOf(chooseRating));
		review.setTitle(reviewTitle);
		review.setText(reviewText);
		review.setDateSubmitted(LocalDateTime.now());
		reviewdao.save(review);
		
		
		
		return "submitReview";
	}
}
