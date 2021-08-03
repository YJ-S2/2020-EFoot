package com.example.efootstore.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

import com.example.efootstore.domain.Sales;
import com.example.efootstore.service.SalesService;

@Controller
@RequestMapping({ "/shop/updateSales.do" })
public class UpdateSalesController implements ApplicationContextAware {

	@Value("SalesForm")
	private String formViewName;
	
	@Value("SalesDetail")
	private String successViewName;

	@Autowired
	private SalesService salesSev;
	
	private WebApplicationContext context;
	private String uploadDir;

	public void setSales(SalesService salesSev) {
		this.salesSev = salesSev;
	}
	
	public void setApplicationContext(ApplicationContext appContext) throws BeansException {
		this.context = (WebApplicationContext) appContext;
		this.uploadDir = context.getServletContext().getRealPath("/upload/");
	}

	@ModelAttribute("sales")
	public Sales formBackingObject(@RequestParam("saleId") String salesId) throws Exception {
		Sales sales = salesSev.getSales(salesId);
		int price = sales.getItem().getPrice();
		sales.getItem().setPrice(price);
		return sales;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showSales() {
		return formViewName;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest request, HttpSession session, @Valid @ModelAttribute("sales") Sales sales, BindingResult result, ModelMap model)
			throws Exception {
		
		if (result.hasErrors())
			return formViewName;
		
		uploadFile(sales.getImageFile());
		sales.setImage(sales.getImageFile().getOriginalFilename());
		salesSev.updateSales(sales);
		
		model.put("salesDetail", sales);
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
