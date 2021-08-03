package com.example.efootstore.controller;

import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.example.efootstore.domain.Review;
import com.example.efootstore.service.ReviewService;

@Controller
@RequestMapping({ "/shop/updateReview.do" })
public class UpdateReviewController implements ApplicationContextAware{

	@Value("ReviewForm")
	private String formViewName;
	@Value("ReviewDetail")
	private String successViewName;

	private WebApplicationContext context;
	private String uploadDir;
	
	@Autowired
	private ReviewService reviewService;

	public void setReview(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	public void setApplicationContext(ApplicationContext appContext) throws BeansException {
		this.context = (WebApplicationContext) appContext;
		this.uploadDir = context.getServletContext().getRealPath("/upload/");
	}

	@ModelAttribute("review")
	public Review formBackingObject(@RequestParam("revId") String revId) throws Exception {
		Review review = reviewService.getReview(revId);

		return review;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showReview() {
		return formViewName;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@Valid @ModelAttribute("review") Review review, BindingResult result)
			throws Exception {
		
		if (result.hasErrors())
			return formViewName;
		
		uploadFile(review.getImageFile());
		review.setImage(review.getImageFile().getOriginalFilename());
		
		reviewService.updateReview(review);
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
