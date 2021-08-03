package com.example.efootstore.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

import com.example.efootstore.domain.PointHistory;
import com.example.efootstore.domain.Review;
import com.example.efootstore.service.PointService;
import com.example.efootstore.service.ReviewService;

@Controller
public class ViewReviewController {
	
	private ReviewService reviewService;
	private PointService pointService;
	
	@Autowired
	public void setReview(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	@Autowired
	public void setPointService(PointService pointService) {
		this.pointService = pointService;
	}


	@RequestMapping("/shop/viewReview.do")
	public String handleRequest(@RequestParam("revId") String revId, ModelMap model, HttpServletRequest request) throws DataAccessException, Exception {
		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
		String userId = userSession.getAccount().getUserId();
		model.put("login", 1);
		
		Review r = new Review();
		r.setUserId(userId);
		r.setRevId(revId);
		String id = reviewService.getMyReview(r);
		System.out.println(userId);
		System.out.println(id);
		if (userId.equals(id)) {
			Review review = this.reviewService.getReview(revId);
			model.put("review", review);
			
			return "ReviewDetail";
		}
		
		int point = this.pointService.getPoint(userId);
		if (point < 10) {
			model.put("noPoint", -1);
			model.put("point", point);
			return "ReviewList";
		}
		
		PointHistory ph = new PointHistory();
		Date date = new Date();
		
		ph.setHistory("리뷰 열람 / 포인트 차감");
		ph.setAmount(10);
		ph.setStatus(0);
		ph.setDate(date);
		ph.setUserId(userSession.getAccount().getUserId());
		Review review = this.reviewService.getReview(revId, ph);
		model.put("review", review);
		
		return "ReviewDetail";
	}
	
	@RequestMapping("/shop/myReview.do")
	public String handleRequest2(ModelMap model, HttpServletRequest request) {
		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
		String userId = userSession.getAccount().getUserId();
		
		List<Review> reviewList = this.reviewService.getMyReviewList(userId);
		
		model.put("myReview", reviewList);
		
		return "MyReview";
	}

}
