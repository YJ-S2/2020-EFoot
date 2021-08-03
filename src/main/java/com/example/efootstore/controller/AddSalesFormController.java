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
import com.example.efootstore.domain.Sales;
import com.example.efootstore.service.PointService;
import com.example.efootstore.service.SalesService;

@Controller
@RequestMapping("sales/addSalesForm.do")
public class AddSalesFormController implements ApplicationContextAware {

	@Value("AddSales")
	private String formViewName;
	@Value("SalesDetail")
	private String successViewName;
	@Autowired
	private SalesService Service;
	@Autowired
	private PointService pService;
	
	private WebApplicationContext context;	
	private String uploadDir;

	@Autowired
	public void setReview(SalesService Service) {
		this.Service = Service;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext appContext) throws BeansException {
		this.context = (WebApplicationContext) appContext;
		this.uploadDir = context.getServletContext().getRealPath("/upload/");
	}

	@ModelAttribute("sales")
	public Sales formBackingObject(HttpServletRequest request) throws Exception {
		return new Sales();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String insertSalesForm() {
		return formViewName;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String handleRequest(@Valid @ModelAttribute("sales") Sales sales, 
			BindingResult result, ModelMap model, HttpServletRequest request) throws Exception {

		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
		sales.setUserId(userSession.getAccount().getUserId());
		
		uploadFile(sales.getImageFile());
		String filename = sales.getImageFile().getOriginalFilename();
		sales.setImage(filename);
		
		if (result.hasErrors()) { 
			return formViewName; 
		}
		 
		Service.insertSales(sales);

		Sales salesDetail = this.Service.getSales(sales.getSaleId());
		model.put("salesDetail", salesDetail);

		int point = 10;
		pService.updatePlusPoint(sales.getUserId(), point);

		PointHistory ph = new PointHistory();
		Date date = new Date();

		ph.setStatus(1);
		ph.setAmount(point);
		ph.setUserId(sales.getUserId());
		ph.setHistory("Add New Sales!");
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