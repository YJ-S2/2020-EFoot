package com.example.efootstore.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.efootstore.domain.GroupBuying;
import com.example.efootstore.domain.Sales;

@Component
public class GroupBuyingFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Sales.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		
		GroupBuying groupBuying = (GroupBuying) obj;
		
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gbName", "required");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "place", "required");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "item.price", "Min.item.price");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "item.name", "required");
		

		if(groupBuying.getCount() < 1) {
			errors.rejectValue("count", "count_required", "0이상의 숫자여야 합니다.");
		}
		if(groupBuying.getItem().getPrice() < 1) {
			errors.rejectValue("item.price", "price_required", "0이상의 숫자여야 합니다.");
		}
	}

}
