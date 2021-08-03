package com.example.efootstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.efootstore.domain.PointHistory;
import com.example.efootstore.service.PointService;


@Controller
@SessionAttributes({"MyPointList", "point"})
public class MyPointHistoryController {

	private PointService pointSev;

	@Autowired
	public void setEfootStore(PointService pointSev) {
		this.pointSev = pointSev;
	}

	@RequestMapping("/shop/myPointHistory.do")
	public String handleRequest(@RequestParam("userId") String userId, ModelMap model) throws Exception {
		List<PointHistory> pointList = this.pointSev.getPointListByUserId(userId);
		int point = this.pointSev.getPoint(userId);
		model.put("MyPointList", pointList);
		model.put("point", point);		
		return "MyPointHistory";
	}
}
