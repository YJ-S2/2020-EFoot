package com.example.efootstore.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class CartMap implements Serializable {

	private Map<String, Cart> cartMap = new HashMap<String, Cart>();

	public Map<String, Cart> getCartMap() {
		return cartMap;
	}

	public void setCartMap(Map<String, Cart> cartMap) {
		this.cartMap = cartMap;
	}
	
}
