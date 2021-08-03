package com.example.efootstore.controller;

import java.util.Date;
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
import org.springframework.web.util.WebUtils;

import com.example.efootstore.domain.PointHistory;
import com.example.efootstore.domain.Share;
import com.example.efootstore.service.PointService;
import com.example.efootstore.service.ShareFormValidator;
import com.example.efootstore.service.ShareService;

@Controller
@RequestMapping({ "/shop/addItemToShare.do" })
public class AddShareController {

	@Value("AddShare")
	private String formViewName;
	@Value("ShareList")
	private String successViewName;

	private ShareService shareService;

	@Autowired
	private PointService pService;

	@Autowired
	public void setShare(ShareService shareService) {
		this.shareService = shareService;
	}

	@ModelAttribute("share")
	public Share formBackingObject(HttpServletRequest request) throws Exception {
		Share share = new Share();
		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
		share.setUserId(userSession.getAccount().getUserId());

		return share;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return formViewName;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String handleRequest(@Valid @ModelAttribute("share") Share share, BindingResult result,
			@RequestParam("userId") String userId, ModelMap model, HttpSession session) throws Exception {

		new ShareFormValidator().validate(share, result);

		if (result.hasErrors())
			return formViewName;

		share.setUserId(userId);
		shareService.insertShare(share);

		List<Share> list = this.shareService.getShareList();
		model.put("shareList", list);

		int point = 30;
		pService.updatePlusPoint(userId, point);

		PointHistory ph = new PointHistory();
		Date date = new Date();
		ph.setHistory("나눔 등록 / 포인트 적립");

		ph.setStatus(1);
		ph.setAmount(point);
		ph.setUserId(userId);
		ph.setHistory("Add New SHARE!");
		ph.setDate(date);

		pService.insertPointHistory(ph);
		return successViewName;
	}
}