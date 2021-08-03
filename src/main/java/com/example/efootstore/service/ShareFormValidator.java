package com.example.efootstore.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.efootstore.domain.Share;


@Component
public class ShareFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Share.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Share share = (Share)obj;
		
		if(share.getCount() < 1) {
			errors.rejectValue("count", "count_required", "0보다 큰 수를 입력하세요.");
		}
	}
}
