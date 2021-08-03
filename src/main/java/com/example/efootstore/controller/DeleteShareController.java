package com.example.efootstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.efootstore.domain.Share;
import com.example.efootstore.service.ShareService;

@Controller
public class DeleteShareController {

	@Autowired
	private ShareService shareService;
	public void setShare(ShareService shareService) {
		this.shareService = shareService;
	}
	
	@RequestMapping("/shop/deleteShare.do")
	public String handleRequest(@RequestParam("shId") String shId, ModelMap model) {
		shareService.deleteShare(shId);
		
		List<Share> list = this.shareService.getShareList();

		model.put("shareList", list);

		return "ShareList";
	}
}
