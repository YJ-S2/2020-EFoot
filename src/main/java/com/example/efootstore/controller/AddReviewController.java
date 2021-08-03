package com.example.efootstore.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.example.efootstore.domain.PointHistory;
import com.example.efootstore.domain.Review;
import com.example.efootstore.service.ReviewService;

@Controller
@RequestMapping({ "/shop/addReview.do" })
public class AddReviewController implements ApplicationContextAware {

	@Value("AddReview")
	private String formViewName;
	@Value("ReviewDetail")
	private String successViewName;

	private WebApplicationContext context;
	private String uploadDir;

	private ReviewService reviewService;

	@Autowired
	public void setReview(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	@Override
	public void setApplicationContext(ApplicationContext appContext) throws BeansException {
		this.context = (WebApplicationContext) appContext;
		this.uploadDir = context.getServletContext().getRealPath("/upload/");
	}

	@ModelAttribute("review")
	public Review formBackingObject(HttpServletRequest request) throws Exception {
		Review review = new Review();

		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
		review.setUserId(userSession.getAccount().getUserId());

		return review;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return formViewName;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String handleRequest(ModelMap model,
			@Valid @ModelAttribute("review") Review review, BindingResult result)
			throws DataAccessException, Exception {

		if (result.hasErrors())
			return formViewName;

		uploadFile(review.getImageFile());
		review.setImage(review.getImageFile().getOriginalFilename());

		PointHistory ph = new PointHistory();
		Date date = new Date();

		ph.setHistory("리뷰 등록 / 포인트 적립");
		ph.setAmount(50);
		ph.setStatus(1);
		ph.setDate(date);
		ph.setUserId(review.getUserId());
		reviewService.insertReview(review, ph);
		
		Review r = this.reviewService.getReview(review.getRevId());
		model.put("review", r);
		
		return successViewName;
	}

	private void uploadFile(MultipartFile image) {
		System.out.println(image.getOriginalFilename());
		File file = new File(this.uploadDir + image.getOriginalFilename());
		try {
			image.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	}

}
