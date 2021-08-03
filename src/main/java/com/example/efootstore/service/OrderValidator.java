package com.example.efootstore.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.efootstore.domain.Order;

@Component
public class OrderValidator implements Validator {

   @Override
   public boolean supports(Class<?> clazz) {
      return Order.class.isAssignableFrom(clazz);
   }

   @Override
   public void validate(Object target, Errors errors) {

   }
}