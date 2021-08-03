package com.example.efootstore.controller;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.example.efootstore.domain.GroupBuying;
import com.example.efootstore.domain.PointHistory;
import com.example.efootstore.service.GroupBuyingFormValidator;
import com.example.efootstore.service.GroupBuyingService;
import com.example.efootstore.service.PointService;

@Controller
@RequestMapping("/shop/insertGB.do")
public class AddGroupBuyingController implements ApplicationContextAware {

	@Value("InsertGBForm")
	private String formViewName;

	@Value("GroupBuyingList")
	private String successViewName;

	@Autowired
	private GroupBuyingService groupBuyingService;

	@Autowired
	private PointService pService;
	
	private WebApplicationContext context;	
	private String uploadDir;

	@Override
	public void setApplicationContext(ApplicationContext appContext) throws BeansException {
		this.context = (WebApplicationContext) appContext;
		this.uploadDir = context.getServletContext().getRealPath("/upload/");
	}


	@ModelAttribute("GroupBuying")
	public GroupBuying formBackingObject(HttpServletRequest request) throws Exception {
		return new GroupBuying();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return formViewName;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@Valid @ModelAttribute("GroupBuying") GroupBuying groupBuying,
			 BindingResult result, 
			ModelMap model, 
			@RequestParam("userId") String userId) throws Exception {
		
		uploadFile(groupBuying.getImageFile());
		String filename = groupBuying.getImageFile().getOriginalFilename();
		groupBuying.setImage(filename);
		
		groupBuying.setUserId(userId);
		
		new GroupBuyingFormValidator().validate(groupBuying, result);
		
		if (result.hasErrors()) {
			return formViewName;
		}
		groupBuyingService.insertGroupBuying(groupBuying);
		
		List<GroupBuying> list = groupBuyingService.getGroupBuyingList();
		model.put("gbList", list);

		int point = 10;
	      pService.updatePlusPoint(userId, point);
	      
	      PointHistory ph = new PointHistory();
	      Date date = new Date();
	      
	      ph.setStatus(1);
	      ph.setAmount(point);
	      ph.setUserId(userId);
	      ph.setHistory("Add New Group buying!");
	      ph.setDate(date);
	      
	      pService.insertPointHistory(ph);
		
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
