package com.example.efootstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.util.WebUtils;

import com.example.efootstore.domain.Review;
import com.example.efootstore.service.PointService;
import com.example.efootstore.service.ReviewService;

@Controller
@SessionAttributes({ "reviewList" })
public class ReviewListController {

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

	@RequestMapping("/shop/review.do")
	public String handleRequest(ModelMap model, HttpServletRequest request) throws Exception {
		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
		if (userSession != null) {
			String userId = userSession.getAccount().getUserId();
			
			int point = this.pointService.getPoint(userId);
			if (point < 10) {
				model.put("noPoint", -1);
			}
			model.put("login", 1);
			model.put("point", point);
		}
		List<Review> list = this.reviewService.getReviewList();

		model.put("reviewList", list);

		return "ReviewList";
	}

}
