package com.example.efootstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.efootstore.domain.Share;
import com.example.efootstore.service.ShareFormValidator;
import com.example.efootstore.service.ShareService;

@Controller
@RequestMapping({"/shop/updateShare.do"})
public class UpdateShareController {

	
	@Value("UpdateShare")
	private String formViewName;
	@Value("ShareList")
	private String successViewName;
	
	@Autowired
	private ShareService shareService;
	
	public void setShare(ShareService shareService) {
		this.shareService = shareService;
	}
	
	@ModelAttribute("share")
	public Share formBackingObject(@RequestParam("shId") String shId) throws Exception {
		Share review = shareService.getShare(shId);

		return review;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showShare() {
		return formViewName;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@Valid@ModelAttribute("share") Share share, BindingResult result, HttpServletRequest request, HttpSession session, ModelMap model)
			throws Exception {
		
        new ShareFormValidator().validate(share, result);

		if (result.hasErrors())
			return formViewName;
		
		shareService.updateShare(share);
		
		List<Share> list = this.shareService.getShareList();
		model.put("shareList", list);
		return successViewName;
	}
	
}
