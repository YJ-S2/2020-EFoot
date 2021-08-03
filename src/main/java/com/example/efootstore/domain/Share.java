package com.example.efootstore.domain;

import java.io.Serializable;
import java.util.*;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("serial")
public class Share implements Serializable {

	private String shId;
	private String userId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deadLine;	
	@NotEmpty
	private String content; // ����
	@NotEmpty
	private String place; // ������ ���
	private int count; // ����
	@NotEmpty
	private String name; // ������
	
	private List<Account> shareApplyer;
	
	private Date timestamp; // �ۼ� ��¥
	private Item item; // �������� ����� �������� Item�� ������ֱ� ���ؼ� .
	private String itemId;
	
	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getShId() {
		return shId;
	}

	public void setShId(String shId) {
		this.shId = shId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Account> getShareApplyer() {
		return shareApplyer;
	}

	public void setShareApplyer(List<Account> shareApplyer) {
		this.shareApplyer = shareApplyer;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}