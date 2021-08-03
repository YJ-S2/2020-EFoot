package com.example.efootstore.service;





import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.efootstore.domain.Auction;


@Component
public class AuctionFormValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return Auction.class.isAssignableFrom(clazz);
	}
	@Override
	public void validate(Object obj, Errors errors) {
		Auction auction = (Auction) obj;
		
		if(auction.getStartPrice() < 0)
			errors.rejectValue("startPrice", "min", "0보다 작을 수 없습니다.");
		
	}

}
