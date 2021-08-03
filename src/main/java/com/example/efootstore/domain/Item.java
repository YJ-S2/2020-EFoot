package com.example.efootstore.domain;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
public class Item implements Serializable {
	/* Private Fields */
	private String itemId;
	private String name;
	@NotNull @Min(0)
	private int price;
	private String gbId;
	private String shId;
	private String aucId;
	private String saleId;
	
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getGbId() {
		return gbId;
	}
	public void setGbId(String gbId) {
		this.gbId = gbId;
	}
	public String getShId() {
		return shId;
	}
	public void setShId(String shId) {
		this.shId = shId;
	}
	public String getAucId() {
		return aucId;
	}
	public void setAucId(String aucId) {
		this.aucId = aucId;
	}
	public String getSaleId() {
		return saleId;
	}
	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}
	

}