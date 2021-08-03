package com.example.efootstore.domain;

import java.io.Serializable;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@SuppressWarnings("serial")
public class Sales implements Serializable {
	/* Private Fields */
	private String saleId;
	private String cateId; 
	private String userId;
	@NotEmpty
	private String ItemName;
	@NotEmpty
	private String content;
	@Valid
	private Item item;
	private String image;
	private MultipartFile imageFile;

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
		return ItemName;
	}


	public void setItemName(String itemName) {
		this.ItemName = itemName;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Sales [saleId=" + saleId + ", cateId=" + cateId + ", userId=" + userId + ", ItemName=" + ItemName
				+ ", content=" + content + ", item=" + item + "]";
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
