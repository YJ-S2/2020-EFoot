package com.example.efootstore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.efootstore.domain.GroupBuying;
import com.example.efootstore.service.GroupBuyingFormValidator;
import com.example.efootstore.service.GroupBuyingService;

@Controller
@RequestMapping("/shop/updateGB.do")
public class UpdateGroupBuyingContoller {

	@Value("InsertGBForm")
	private String formViewName;
	
	@Autowired
	private GroupBuyingService service;

	@ModelAttribute("GroupBuying")
	public GroupBuying formBackingObject(@RequestParam("gbId") String gbId) throws Exception {
		GroupBuying groupBuying = service.getGroupBuying(gbId);
		return groupBuying;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return formViewName;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@Valid @ModelAttribute("GroupBuying") GroupBuying groupBuying,
							BindingResult result, 
							@RequestParam("userId") String userId,
						RedirectAttributes redirect)
			throws Exception {
		groupBuying.setUserId(userId);
		

		new GroupBuyingFormValidator().validate(groupBuying, result);
		
		if (result.hasErrors()) {
			return formViewName;
		}
		
		service.updateGroupBuying(groupBuying);
		redirect.addAttribute("gbId", groupBuying.getGbId()); 
		
		 return "redirect:/shop/gbDetail.do";
	}

}
