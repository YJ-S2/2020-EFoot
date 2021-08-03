package com.example.efootstore.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.efootstore.service.GroupBuyingService;

@Controller
public class ViewGroupBuyingController {
	@Autowired
	private GroupBuyingService gbService;
	
	@RequestMapping("/shop/gbDetail.do")
	public String viewGroupBuying(@RequestParam("gbId") String gbId,
									ModelMap model) {
		 model.put("gb", gbService.getGroupBuying(gbId));
		 return "GroupBuyingDetail";
	}
	
	@RequestMapping("/shop/gblist.do")
	public String viewGroupBuyingList(ModelMap model) {
		model.put("gbList", gbService.getGroupBuyingList());
		return "GroupBuyingList";
	}
	
	@RequestMapping("/shop/gbByHeader.do") //����ڰ� �����ϴ� �������� ��� 
	public String viewGroupBuyingListByHeader(@RequestParam("userId") String userId,
										ModelMap model) { 
		model.put("gbListByHeader", gbService.getGroupBuyingListByHeader(userId));
		return "GroupBuyingListByHeader";
	}
	
	@RequestMapping("/shop/myGB.do") //����ڰ� ��û�� �������� ���
	public String viewMyGroupBuyingList(@RequestParam("userId") String userId,
											ModelMap model) {
		model.put("myGBList", gbService.getMyGroupBuying(userId));
		return "MyGroupBuyingList";
	}
	
}
