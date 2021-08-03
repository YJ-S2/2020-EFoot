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
public class ViewShareController {
	private ShareService shareService;

	@Autowired
	public void setPetStore(ShareService shareService) {
		this.shareService = shareService;
	}

	@RequestMapping("/shop/viewShare.do")
	public String handleRequest(ModelMap model) throws Exception {
		List<Share> shareList = this.shareService.getShareList();
		model.put("shareList", shareList);
		return "ShareList";
	}

	@RequestMapping("/shop/shareDetail.do")
	public String viewShareDetail(@RequestParam("shId") String shId, ModelMap model) throws Exception {
		Share share = this.shareService.getShare(shId);
		model.put("shareDetail", share);
		return "ShareDetail";
	}

	@RequestMapping("/shop/myShareList.do")
	public String viewMyShareList(@RequestParam("userId") String userId, ModelMap model) {
		model.put("myShare", shareService.getMyShare(userId));
		return "MyShareList";
	}	
}