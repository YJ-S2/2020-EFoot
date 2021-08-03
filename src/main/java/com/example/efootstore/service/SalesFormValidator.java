package com.example.efootstore.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.efootstore.domain.Sales;

@Component
public class SalesFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Sales.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ItemName", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "item.price", "Min.item.price");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "required");
	}

}
