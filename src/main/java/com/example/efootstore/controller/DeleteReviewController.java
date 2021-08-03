package com.example.efootstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.efootstore.domain.Review;
import com.example.efootstore.service.ReviewService;

@Controller
public class DeleteReviewController {
	
	@Autowired
	private ReviewService reviewService;
	public void setReview(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	@RequestMapping("/shop/deleteReview.do")
	public String handleRequest(@RequestParam("revId") String revId, ModelMap model) {
		reviewService.deleteReview(revId);
		
		List<Review> list = this.reviewService.getReviewList();

		model.put("reviewList", list);

		return "ReviewList";
	}
}
