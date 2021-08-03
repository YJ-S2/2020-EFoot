package com.example.efootstore.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

@SuppressWarnings("serial")
public class GroupBuying implements Serializable {
	private String gbId;
	private String userId;

	private int count;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deadLine;
	@NotEmpty
	private String place;
	@NotEmpty
	private String content;
	@NotEmpty
	private String gbName;
	private List<Account> gbApplyer;
	private Item item;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date timestamp;
	private String image;
	private MultipartFile imageFile;
	
	public String getGbId() {
		return gbId;
	}
	public void setGbId(String gbId) {
		this.gbId = gbId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Date getDeadLine() {
		return deadLine;
	}
	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getGbName() {
		return gbName;
	}
	public void setGbName(String gbName) {
		this.gbName = gbName;
	}
	public List<Account> getGbApplyer() {
		return gbApplyer;
	}
	public void setGbApplyer(List<Account> gbApplyer) {
		this.gbApplyer = gbApplyer;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public MultipartFile getImageFile() {
		return imageFile;
	}
	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}
	

	
}
