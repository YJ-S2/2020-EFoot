package com.example.efootstore.domain;

import java.io.Serializable;
@SuppressWarnings("serial")
public class Cart implements Serializable {

	private String saleId;
	private String cateId;
	private String userId;
	private String itemName;
	private int price;
	
	public String getSaleId() {
		return saleId;
	}

	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}

	public String getCateId() {
		return cateId;
	}

	public void setCateId(String cateId) {
		this.cateId = cateId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
/*
	public void addItemToCart(Sales sale) {
		Sales item = itemMap.get(sale.getSaleId());
	    if (item == null) {
	    	item = new Sales();
	    	item = sale;
	    }
	    itemMap.put(item.getSaleId(), item);
	}
	
	public void removeItemById(String itemId) {
		/*
		 * Sales cartItem = itemMap.remove(itemId); Sales item = itemMap.get(itemId); if
		 * (item == null) { return null; } else { itemList.getSource().remove(cartItem);
		 * return cartItem.getItem(); }
		 */
	}
