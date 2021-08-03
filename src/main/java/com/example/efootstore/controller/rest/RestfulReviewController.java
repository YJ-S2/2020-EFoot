package com.example.efootstore.controller.rest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.efootstore.domain.Review;
import com.example.efootstore.service.ReviewService;

@Controller
public class RestfulReviewController {
	
	private ReviewService reviewService;
	
	@Autowired
	public void setReviewService(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	@RequestMapping(value="/review/{revId}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Review getReviewList(@PathVariable("revId") String revId, HttpServletResponse response) throws Exception {
		Review list = reviewService.getMyReviewDetail(revId);
		
		if (list == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		
		return list;
	}
}
