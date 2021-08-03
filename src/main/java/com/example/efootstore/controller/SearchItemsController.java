package com.example.efootstore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.efootstore.domain.Item;
import com.example.efootstore.service.PetStoreFacade;

@Controller
public class SearchItemsController { 

	private PetStoreFacade petStore;

	@Autowired
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}

	@RequestMapping("/shop/searchItems.do")
	public ModelAndView handleRequest(HttpServletRequest request,
			@RequestParam(value="keyword", required=false) String keyword,
			@RequestParam(value="page", required=false) String page, ModelMap model
			) throws Exception {
		if (keyword != null) {
			if (!StringUtils.hasLength(keyword)) {
				return new ModelAndView("Error", "message", "Please enter a keyword to search for, then press the search button.");
			}
			List<Item> itemList = this.petStore.searchItemList(keyword.toLowerCase());
			for(int i = 0; i < itemList.size(); i++) {
				if (itemList.get(i).getAucId() != null) {
					List<Item> aucItem = new ArrayList<Item>();
					aucItem.add(itemList.get(i));
					model.put("Auction", aucItem);
				} else if (itemList.get(i).getGbId() != null) {
					List<Item> GBItem = new ArrayList<Item>();
					GBItem.add(itemList.get(i));
					model.put("GB", GBItem);
				} else if (itemList.get(i).getSaleId() != null) {
					List<Item> salesItem = new ArrayList<Item>();
					salesItem.add(itemList.get(i));
					model.put("Sales", salesItem);
				}
			}
			request.getSession().setAttribute("SearchItemsController_itemList", itemList);
			return new ModelAndView("SearchItems", "itemList", itemList);
		}
		else {
			@SuppressWarnings("unchecked")
			List<Item> itemList = (List<Item>) request.getSession().getAttribute("SearchItemsController_itemList");
			if (itemList == null) {
				return new ModelAndView("Error", "message", "Your session has timed out. Please start over again.");
			}
			
			return new ModelAndView("SearchItems", "itemList", itemList);
		}
	}
}
