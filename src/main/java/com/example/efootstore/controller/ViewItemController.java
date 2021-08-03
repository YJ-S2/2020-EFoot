package com.example.efootstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.efootstore.domain.Item;
import com.example.efootstore.service.PetStoreFacade;

@Controller
public class ViewItemController { //�ʿ� ������..?

	private PetStoreFacade petStore;

	@Autowired
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}

	@RequestMapping("/shop/viewItem.do")
	public String handleRequest(@RequestParam("itemId") String itemId, ModelMap model) throws Exception {
		Item item = this.petStore.getItem(itemId);
		model.put("item", item);
		model.put("product", item.getName());
		return "Item";
	}

}
